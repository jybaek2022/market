package gu.market.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import gu.market.error.MarketException;
import gu.market.repository.model.Member;
import gu.market.service.*;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	
	@Autowired
	private MarketService marketSvc;
	@Autowired
	private AccountService actSvc;
	
	@RequestMapping(value="/adminMain", method = RequestMethod.GET) 
	public String adminMain() {
		return "admin/admin_home";
	} 
	//전체멤버
	@RequestMapping(value = "/allMember")
	public String allMember(ModelMap modelMap) throws Exception {
		List<?> memberview = actSvc.allMember();

		modelMap.addAttribute("memberview", memberview);
		return "admin/allMemberPage";
	}
	//멤버선택
	@RequestMapping(value = "/selectedMember")
	public ModelAndView selectedMember(HttpServletRequest request) throws Exception {
		String memberId = request.getParameter("memberId");
		Member memberInfo = actSvc.selectMemberOne(memberId);

		ModelAndView mv = new ModelAndView("admin/selectedMemberPage");
		mv.addObject("member_info", memberInfo);

		return mv;
	}
	
	//상품등록get
	@RequestMapping(value = "/addProduct", method = RequestMethod.GET)
	public String getAddProduct(HttpSession session) throws Exception {
		return "admin/addProductPage";
	}
	//상품등록post
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
		return "redirect:/admin/adminMain";
	}
	//관리자 권한주기
	@RequestMapping(value = "/checkAdmin", method = RequestMethod.POST)
	public String checkAdmin(HttpServletRequest request) throws MarketException {
		String memberId = request.getParameter("memberId");
		String check = request.getParameter("memberCheck");
		if(check!=null) {
			try {
				actSvc.deleteAdmin(memberId);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			try {
				actSvc.addAdmin(memberId);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "redirect:/admin/adminMain";
	}
	//품목별 매출
	@RequestMapping(value = "/productSales", method = RequestMethod.GET)
	public String productSales(ModelMap modelMap) {
		List<?> pSview = marketSvc.productSales();
		modelMap.addAttribute("pSview", pSview);
		return "/admin/productSales";
	}
}
