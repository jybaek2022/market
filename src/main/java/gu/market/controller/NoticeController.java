package gu.market.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import gu.market.service.NoticeService;
import gu.market.session.SessionManager;
import gu.market.repository.model.Board;

@Controller
@RequestMapping(value = "/notice")
public class NoticeController {

	private SessionManager sessionManager = new SessionManager();
	
    @Autowired
    private NoticeService noticeSvc;
    
    // 공지사항 리스트
    @RequestMapping(value = "/noticeList")
   	public String noticeList(ModelMap modelMap) throws Exception {
    	List<?> listview = noticeSvc.selectNoticeList();
        
    	modelMap.addAttribute("listview", listview);
        return "notice/noticeList";
    }
    
    // 공지사항 쓰기 
    @RequestMapping(value = "/noticeForm")
   	public String noticeForm(HttpServletRequest request) throws Exception {
    	if (sessionManager.isLogin(request.getSession())) {
    		return "notice/noticeForm";
    	}else
    	{
    		return "error/unloginedError";
    	}
    }
    //글저장
    @RequestMapping(value = "/noticeSave")
   	public String noticeSave(@ModelAttribute Board boardInfo) throws Exception {
    
    	noticeSvc.insertNotice(boardInfo);
    	
        return "redirect:/notice/noticeList";
    }

    // 공지사항 글수정
    @RequestMapping(value = "/noticeUpdate")
   	public String noticeUpdate(HttpServletRequest request, ModelMap modelMap) throws Exception {
    	
    	String brdno = request.getParameter("brdno");
    	
    	Board boardInfo = noticeSvc.selectNoticeOne(brdno);
        
    	modelMap.addAttribute("boardInfo", boardInfo);
    	
        return "notice/noticeUpdate";
    }
    //공지사항 수정글저장
    @RequestMapping(value = "/noticeUpdateSave")
   	public String noticeUpdateSave(@ModelAttribute Board boardInfo) throws Exception {
    	
    	noticeSvc.updateNotice(boardInfo);
    	
        return "redirect:/notice/noticeList";
    }    

    // 공지사항 글 읽기
    @RequestMapping(value = "/noticeRead")
   	public String noticeRead(HttpSession session, HttpServletRequest request, ModelMap modelMap) throws Exception {
    	
		String brdno = request.getParameter("brdno");
    	
    	Board boardInfo = noticeSvc.selectNoticeOne(brdno);
        
    	modelMap.addAttribute("boardInfo", boardInfo);
    	
    	//작성자와 로그인아이디가 일치하면 checkId 값에 true 전달. 로그인이 안되었거나, 다르면 false
    	String id = (String)session.getAttribute("id");
    	if(id != null) {
			request.setAttribute("checkId", id.equals(boardInfo.getBrdwriter()));
    	}
    	else {
    		request.setAttribute("checkId", false);
    	}
    	
        return "notice/noticeRead";
    }
    
    // 공지사항 글 삭제
    @RequestMapping(value = "/noticeDelete")
   	public String noticeDelete(HttpServletRequest request) throws Exception {
    	
    	String brdno = request.getParameter("brdno");
    	
    	noticeSvc.deleteNoticeOne(brdno);
        
        return "redirect:/notice/noticeList";
    }

}