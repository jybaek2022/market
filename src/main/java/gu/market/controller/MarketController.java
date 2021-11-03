package gu.market.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import gu.market.repository.model.Product;
import gu.market.error.MarketException;
import gu.market.repository.model.Member;
import gu.market.service.MarketService;
import gu.market.session.SessionManager;

@Controller
@RequestMapping(value = "/market")
public class MarketController {
	private SessionManager sessionManager = new SessionManager();

	@Autowired
	private MarketService marketSvc;

	// 메인을 top 으로
	@RequestMapping(value = "/top")
	public ModelAndView top(HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView("/market/top");
		mv.addObject("name", sessionManager.getName(session));
		return mv;
	}

	@RequestMapping(value = "/home")
	public String home() throws Exception {
		// 최상단 그림눌렀을때 홈으로 돌아가기
		return "redirect:/top";
	}

	// 전체상품 dummy에서 받아오는 방법 - 안씀
//    @RequestMapping(value = "/allProduct")
//   	public ModelAndView allProduct() throws Exception {
//    	Dummy dummy = new Dummy();
//    
//    	ModelAndView mv = new ModelAndView("market/allProductPage");
//    	mv.addObject("product_list", dummy.getProductList());
//		
//        return mv;
//    }

	// 전체상품 db에서 받아오는 방법
	@RequestMapping(value = "/allProduct")
	public String allProductList(ModelMap modelMap) throws Exception {
		List<?> productview = marketSvc.allProduct();

		modelMap.addAttribute("productview", productview);
		return "market/allProductPage";
	}

	// 회원가입
//    @RequestMapping(value = "/memberJoin")
//   	public String memberJoin(@ModelAttribute MarketVO member) throws Exception {
//    	//MarketSvc.memberJoin(member); 뭔가 해보려다 실패
//        //return "redirect:/marketList";
//    	return "market/memberJoin";
//    }
//    //회원가입실행
//    @RequestMapping(value = "/memberJoinPro")
//   	public String memberJoinPro(@ModelAttribute MarketVO member) throws Exception {
//    	
//    	return "market/memberJoinPro";
//    } 
	
	//회원가입
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String getJoin(HttpSession session) throws Exception {
		return "market/joinForm";
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String postJoin(HttpServletRequest request) throws MarketException {
		if (sessionManager.isLogin(request.getSession()))
			return "redirect:/market/top";

		// 로그인 상태가 아닐 경우
		String id = request.getParameter("id");
		String pwd = request.getParameter("pw");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		String gender = request.getParameter("gender");
		String birthDate = request.getParameter("birthDate");

		marketSvc.join(id, pwd, name, phone, address1, address2, gender, birthDate);
		//sessionManager.login(request.getSession(), name);
		return "redirect:/market/top";
	}
	
	// 로그인 페이지
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLogin(HttpSession session) throws Exception {
		if (sessionManager.isLogin(session))
			return "redirect:/market/top";

		return "market/loginForm";
	}
	
	// 로그인 프로세스
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request) throws Exception {
		// 이미 로그인 상태일 경우
		if (sessionManager.isLogin(request.getSession()))
			return "redirect:/market/top";

		// 로그인 상태가 아닐 경우
		String id = request.getParameter("id");
		String pwd = request.getParameter("pw");
		System.out.println("id:" + id + ", pw:" + pwd);

		String[] value = marketSvc.memberlogin(id, pwd);
		sessionManager.login(request.getSession(), value);
		return "redirect:/market/top";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		if (!sessionManager.isLogin(session)) {
			return "market/error";
		}

		session.invalidate();
		return "redirect:/market/top";
	}

	// 한품목 선택했을때 읽기
	@RequestMapping(value = "/selectedProduct")
	public ModelAndView selectedProduct(HttpServletRequest request) throws Exception {
		String productNo = request.getParameter("productNo");
		Product productInfo = marketSvc.selectProductOne(productNo);

		ModelAndView mv = new ModelAndView("market/selectedproductPage");
		mv.addObject("product_info", productInfo);

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

	@RequestMapping(value = "/allMember")
	public String allMember() throws Exception {
		return "market/allMemberPage";
	}

	@RequestMapping(value = "/selectedMember")
	public ModelAndView selectedMember(HttpServletRequest request) throws Exception {
		String memberNo = request.getParameter("memberNo");
		Member memberInfo = marketSvc.selectMemberOne(memberNo);

		ModelAndView mv = new ModelAndView("market/selectedMemberPage");
		mv.addObject("member_info", memberInfo);

		return mv;
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
	// 구매하기 ( 재고 및 정보전달 후 구매완료페이지로만 넘어가게. 나중에 결제 추가)
	@RequestMapping(value = "/purchase", method = {RequestMethod.GET, RequestMethod.POST})
	public String purchase(HttpServletRequest request) throws Exception {
		String memberId = request.getParameter("memberId");
		int productNo = Integer.parseInt(request.getParameter("productNo"));
		int salesCount = Integer.parseInt(request.getParameter("salesCount"));
		int productPrice = Integer.parseInt(request.getParameter("productPrice"));
		
		marketSvc.purchase(memberId, productNo, salesCount, productPrice);
		return "market/purchaseF";
	}
	
	//admin contoller로 이동시켜야할것들
	//관리자메인페이지
	@RequestMapping(value="/adminMain", method = RequestMethod.GET) 
	public String adminMain() {
		return "market/admin_main_temp";   
	} 
	
	//상품등록
	
	@RequestMapping(value = "/addProduct", method = RequestMethod.GET)
	public String getAddProduct(HttpSession session) throws Exception {
		return "market/addProductPage";
	}
	
	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public String postAddProduct(HttpServletRequest request) throws MarketException {
		String pName = request.getParameter("pName");
		int pCCode = Integer.parseInt(request.getParameter("pCCode"));
		String pDetail = request.getParameter("pDetail");
		int pPrice = Integer.parseInt(request.getParameter("pPrice"));
		int pStock = Integer.parseInt(request.getParameter("pStock"));
		String pStatus = request.getParameter("pStatus");
		String pImgSrc = request.getParameter("pImgSrc");

		marketSvc.addProduct(pName, pCCode, pDetail, pPrice, pStock, pStatus, pImgSrc);
		return "redirect:/market/adminMain";
	}
}
