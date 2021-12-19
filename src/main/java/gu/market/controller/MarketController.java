package gu.market.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
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
import org.springframework.web.servlet.ModelAndView;

import gu.market.error.MarketException;
import gu.market.repository.model.*;
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

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() throws Exception {
		// 최상단 그림눌렀을때 홈으로 돌아가기
		return "market/home";
	}
	
	@RequestMapping(value = "/top")
	public ModelAndView top(HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView("/market/top");
		mv.addObject("name", sessionManager.getName(session));
		return mv;
	}
	
	//검색
	@RequestMapping(value = "/search")
	public String search(ModelMap modelMap, HttpServletRequest request) throws Exception {
		String productName = request.getParameter("productName");
		List<?> productview = marketSvc.searchProduct(productName);

		modelMap.addAttribute("productview", productview);
		return "market/allProductPage";
	}

	// 전체상품 db에서 받아오는 방법
	@RequestMapping(value = "/allProduct")
	public String allProductList(ModelMap modelMap) throws Exception {
		List<?> productview = marketSvc.allProduct();

		modelMap.addAttribute("productview", productview);
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
	
	//연결
	@RequestMapping(value = "/connectionFNC", method = RequestMethod.POST)
	public String connectionFNC(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String btn = request.getParameter("button");
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
		
		int cartNo = Integer.parseInt(request.getParameter("cartNo"));
		int productNo = Integer.parseInt(request.getParameter("productNo"));
		int salesCount = Integer.parseInt(request.getParameter("salesCount"));
		
		marketSvc.minusCount(productNo, salesCount);
		marketSvc.purchase(memberId, productNo, salesCount);
		//장바구니에서 넘어온경우 장바구니에서 삭제
		if(request.getParameter("cartNo") != null) {
			cartNo = Integer.parseInt(request.getParameter("cartNo"));
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
	//장바구니추가
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
}