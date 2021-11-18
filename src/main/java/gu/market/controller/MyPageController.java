package gu.market.controller;

import java.time.LocalDate;
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
@RequestMapping(value = "/mypage")
public class MyPageController {
	
	@Autowired
	private AccountService actSvc;
	
	//내정보보기
	@RequestMapping(value = "/myinfo")
	public ModelAndView selectedMember(HttpSession session) throws Exception {
		String memberId = (String) session.getAttribute("id");
		Member myInfo = actSvc.selectMemberOne(memberId);

		ModelAndView mv = new ModelAndView("mypage/myinfo");
		mv.addObject("my_info", myInfo);

		return mv;
	}
	//정보수정 ->>>>>한꺼번에 받을수있을것같은데?
	@RequestMapping(value = "/modifiedMemberInfo")
	public String modifiedMemberInfo(HttpServletRequest request, HttpSession session, Member member) throws MarketException {
		String memberId = (String)session.getAttribute("id");
		String memberName = request.getParameter("name");
		String memberPhone = request.getParameter("phone");
		String memberGender = request.getParameter("gender");
		String memberAddress1 = request.getParameter("address1");
		String memberAddress2 = request.getParameter("address2");
		LocalDate memberBirthDate = LocalDate.parse(request.getParameter("birth"));
		LocalDate memberJoinDate = LocalDate.parse(request.getParameter("joindate"));
		try {
			actSvc.modifiedMemberInfo(memberId, memberName, memberPhone, memberGender, memberAddress1, memberAddress2, memberBirthDate, memberJoinDate);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "market/home";
	}
	//구매내역
	@RequestMapping(value = "/purchaseList")
	public String purchaseList(ModelMap modelMap, HttpSession session) throws Exception {
		String memberId = (String) session.getAttribute("id");
		List<?> purchaseview = actSvc.purchaseList(memberId);

		modelMap.addAttribute("purchaseview", purchaseview);
		return "mypage/purchaseList";
	}
}