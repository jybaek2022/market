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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import gu.market.error.MarketException;
import gu.market.repository.model.Member;
import gu.market.service.*;
import gu.market.session.SessionManager;

@Controller
@RequestMapping(value = "/mypage")
public class MyPageController {
	
	private SessionManager sessionManager = new SessionManager();
	
	@Autowired
	private AccountService actSvc;
	
	//회원가입
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String getJoin(HttpSession session) throws Exception {
		return "mypage/joinForm";
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String postJoin(HttpServletRequest request) throws MarketException {
		if (sessionManager.isLogin(request.getSession()))
			return "redirect:/market/home";

		// 로그인 상태가 아닐 경우
		Member member = new Member();
		member.setMemberId(request.getParameter("id"));
		String pwd = request.getParameter("pw");
		member.setMemberPw(Sha256.encrypt(pwd));
		member.setMemberName(request.getParameter("name"));
		member.setMemberPhone(request.getParameter("phone"));
		member.setMemberAddress1(request.getParameter("address1"));
		member.setMemberAddress2(request.getParameter("address2"));
		member.setMemberGender(request.getParameter("gender"));		
		String birthdate = request.getParameter("birthDate");
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		member.setMemberBirthDate(LocalDate.parse(birthdate, format));

		actSvc.join(member);
		//sessionManager.login(request.getSession(), name);
		return "redirect:/market/home";
	}
	
	// 로그인 페이지
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLogin(HttpSession session) throws Exception {
		if (sessionManager.isLogin(session))
			return "redirect:/market/home";

		return "mypage/loginForm";
	}
	
	// 로그인 프로세스
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request) throws Exception {
		// 이미 로그인 상태일 경우
		if (sessionManager.isLogin(request.getSession()))
			return "redirect:/market/home";

		// 로그인 상태가 아닐 경우
		String id = request.getParameter("id");
		String pwd = request.getParameter("pw");
		String encryPW = Sha256.encrypt(pwd); // 암호화된 비밀번호
		Member member = actSvc.memberlogin(id, encryPW);
		sessionManager.login(request.getSession(), member);
		return "redirect:/market/home";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		if (!sessionManager.isLogin(session)) {
			return "error/unloginedError";
		}

		session.invalidate();
		return "redirect:/market/home";
	}
	
	//내정보보기
	@RequestMapping(value = "/myinfo")
	public ModelAndView selectedMember(HttpSession session, HttpServletRequest request) throws Exception {
		String memberId = (String) session.getAttribute("id");
		if(memberId == null) {
			ModelAndView mv = new ModelAndView("null");
			return mv;
		}	
		Member myInfo = actSvc.myInfo(memberId);

		ModelAndView mv = new ModelAndView("mypage/myinfo");
		mv.addObject("my_info", myInfo);

		return mv;
	}
	//정보수정 ->>>>>한꺼번에 받을수있을것같은데?
	@RequestMapping(value = "/modifiedMemberInfo")
	public String modifiedMemberInfo(HttpServletRequest request, HttpSession session, Member member) {
		member = new Member();
		member.setMemberId((String)session.getAttribute("id"));
		member.setMemberName(request.getParameter("name"));
		member.setMemberPhone(request.getParameter("phone"));
		member.setMemberGender(request.getParameter("gender"));
		member.setMemberAddress1(request.getParameter("address1"));
		member.setMemberAddress2(request.getParameter("address2"));
		member.setMemberBirthDate(LocalDate.parse(request.getParameter("birth")));
		member.setMemberJoinDate(LocalDate.parse(request.getParameter("joindate")));

		boolean isSuccess = actSvc.modifiedMemberInfo(member);
		if(isSuccess) {
			return "market/home";
		} else {
			return "market/error";
		}
		
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