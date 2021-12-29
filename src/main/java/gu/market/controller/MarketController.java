package gu.market.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import gu.market.dto.Page;
import gu.market.error.MarketException;
import gu.market.repository.model.*;
import gu.market.service.AccountService;
import gu.market.service.MarketService;
import gu.market.service.ReviewService;
import gu.market.session.SessionManager;

@Controller
@RequestMapping(value = "/market")
public class MarketController {
	
	private SessionManager sessionManager = new SessionManager();

	@Autowired
	private MarketService marketSvc;
	@Autowired
	private ReviewService reviewSvc;
	@Autowired
	private AccountService actSvc;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(HttpServletRequest request) throws Exception {
		
		return "market/home";
	}
	
	@RequestMapping(value = "/auth", method = RequestMethod.GET)
	public String auth(HttpServletRequest request) throws Exception {
		String code = request.getParameter("code");
	    String state = request.getParameter("state");

		// 네이버 인증
		String accessToken = marketSvc.authWithNaver(code, state);
		sessionManager.setAccessToken(request.getSession(), accessToken);
		Member idCheck = marketSvc.getPersonalInfo(accessToken);
		if(idCheck == null) {
			return "mypage/joinAgree";
		}else {
			sessionManager.login(request.getSession(), idCheck);
			return "market/home";
		}
	}
	@RequestMapping(value = "/getInfo", method = RequestMethod.GET)
	public String getInfo(HttpServletRequest request) throws Exception { // 정보접근 허용시 회원가입+로그인
		// 네이버 개인정보 가져오기
		String accessToken = sessionManager.getAccessToken(request.getSession());
		Member member = marketSvc.getInfo(accessToken); //있으면 로그인 없으면 회원가입
		actSvc.join(member);
		sessionManager.login(request.getSession(), member);
		return "market/home";
	}
		
	@RequestMapping(value = "/top")
	public ModelAndView top(HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView("/market/top");
		mv.addObject("name", sessionManager.getName(session));
		return mv;
	}
	
	/**
	 * 검색
	 * @param modelMap
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/search")
	public String search(ModelMap modelMap, HttpServletRequest request) throws Exception {
		String productName = request.getParameter("productName");
		List<?> productview = marketSvc.searchProduct(productName);

		modelMap.addAttribute("productview", productview);
		return "market/allProductPage";
	}

	// 전체상품 db에서 받아오는 방법
//	@RequestMapping(value = "/allProduct")
//	public String allProductList(ModelMap modelMap) throws Exception {
//		List<?> productview = marketSvc.allProduct();
//
//		modelMap.addAttribute("productview", productview);
//		return "market/allProductPage";
//	}

	@RequestMapping(value = "/allProduct")
	public String allProductList(ModelMap modelMap,
			@RequestParam(value = "nowPage", required = false, defaultValue = "1") int nowPage,
			@RequestParam(value = "cntPerPage", required = false, defaultValue = "10") int cntPerPage)
			throws Exception {

		int total = marketSvc.countProductList();
		Page vo = new Page(total, nowPage, cntPerPage);

		System.out.println(vo.getTotal());

		List<Product> productview = marketSvc.selectProductList(vo);
		modelMap.addAttribute("productview", productview);
		modelMap.addAttribute("paging", vo);
		return "market/allProductPage";
	}
	// 한품목 선택했을때 읽기
	@RequestMapping(value = "/selectedProduct")
	public ModelAndView selectedProduct(HttpServletRequest request, ModelMap modelMap) throws Exception {
		String productNo = request.getParameter("productNo");
		Product productInfo = marketSvc.selectProductOne(productNo);
		
		ModelAndView mv = new ModelAndView("market/selectedproductPage");
		mv.addObject("product_info", productInfo);
		request.setAttribute("productNo", productNo);
//		리뷰같은페이지에 불러오기위해 -->스프링의 기본틀에서 벗어남
//		Controller를 일반 class처럼 써보려고 했는데 오류발생 (원인 : reviewSvc is null)
//		ReviewController rvc = new ReviewController();
//		rvc.reviewList(modelMap, productInfo.getProductNo());
		//컨트롤러간 대신 하나에 합쳐서 씀
		List<?> listview = reviewSvc.selectReviewList(productInfo.getProductNo());
		modelMap.addAttribute("listview", listview);
		
		return mv;
	}
	
	// 추천상품
	@RequestMapping(value = "/recommandProduct")
	public String recomandProduct(ModelMap modelMap) throws Exception {
		List<?> productview = marketSvc.recommandProduct();

		modelMap.addAttribute("productview", productview);
		return "market/allProductPage";
	}
	
	// 신상품
	@RequestMapping(value = "/newProduct")
	public String newProduct(ModelMap modelMap) throws Exception {
		List<?> productview = marketSvc.newProduct();

		modelMap.addAttribute("productview", productview);
		return "market/allProductPage";
	}
	
	//연결
	@RequestMapping(value = "/connectionFNC", method = RequestMethod.POST)
	public String connectionFNC(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String btn = request.getParameter("button");
		System.out.println(btn);
		if (btn.equals("purchase"))
			return "forward:/market/purchase";
		else
			return "forward:/market/addCart";
		}
	// 구매하기 ( 재고 및 정보전달 후 구매완료페이지로만 넘어가게. 나중에 결제 추가)
	@RequestMapping(value = "/purchase", method = {RequestMethod.GET, RequestMethod.POST})
	public String purchase(HttpServletRequest request, HttpSession session) throws Exception {
		String memberId = sessionManager.getId(session);
		if(memberId==null) {
			return "error/unloginedError";
		}
		
		int productNo = Integer.parseInt(request.getParameter("productNo"));
		int salesCount = Integer.parseInt(request.getParameter("salesCount"));
		
		marketSvc.minusCount(productNo, salesCount);
		marketSvc.purchase(memberId, productNo, salesCount);
		//장바구니에서 넘어온경우 장바구니에서 삭제
		
		if(request.getParameter("cartNo") != null) {
			int cartNo = Integer.parseInt(request.getParameter("cartNo"));
			marketSvc.deleteFcart(cartNo);
		}
		
		return "market/purchaseF";
	}
	//장바구니보기
	@RequestMapping(value = "/allCart")
	public String allCart(ModelMap modelMap, HttpSession session) throws Exception {

		String id = sessionManager.getId(session);
		
		if(id==null) {
			return "error/unloginedError";
		}
		
		List<?> cartview = marketSvc.allCart(id);
		if(cartview==null) { // 이거 안들어가는듯??
			return "error/emptyList";
		}
		modelMap.addAttribute("cartview", cartview);
		return "mypage/cartPage";
	}
	
	/**
	 * 장바구니 추가
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/addCart", method = {RequestMethod.GET, RequestMethod.POST})
	public String addCart(HttpServletRequest request, HttpSession session) throws Exception {
		String memberId = sessionManager.getId(session);
		if(memberId==null) {
			return "error/unloginedError";
		}
		int productNo = Integer.parseInt(request.getParameter("productNo"));
		int salesCount = Integer.parseInt(request.getParameter("salesCount"));
		
		marketSvc.addCart(memberId, productNo, salesCount);
		return "forward:/market/allCart";
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllException(Exception e) {
		if(e instanceof MarketException) {
			System.out.println("market error : " + e.toString());
		} else {
			System.out.println(e.toString());
		}
		
		ModelAndView mv = new ModelAndView("market/error");
		mv.addObject("error_info", e);
		return mv;
	}
}