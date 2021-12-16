package gu.market.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import gu.market.service.ReviewService;
import gu.market.session.SessionManager;
import gu.market.repository.model.Review;

@Controller
@RequestMapping(value = "/review")
public class ReviewController {

	private SessionManager sessionManager = new SessionManager();
	
    @Autowired
    private ReviewService reviewSvc;
    
//    @RequestMapping(value = "/reviewList")
//   	public void reviewList(ModelMap modelMap, int productNo) throws Exception {
//    	List<?> listview = reviewSvc.selectReviewList(productNo);
//        
//    	modelMap.addAttribute("listview", listview);
//        //return "review/reviewList";
//    }
    //리뷰쓰기 
    @RequestMapping(value = "/reviewForm")
   	public String reviewForm(HttpServletRequest request) throws Exception {
    	if (sessionManager.isLogin(request.getSession())) {
    		int pNo = Integer.parseInt(request.getParameter("productNo"));
    		request.setAttribute("productNo", pNo);
    		return "review/reviewForm";
    	}else
    	{
    		return "error/unloginedError";
    	}
    }
    //리뷰저장
    @RequestMapping(value = "/reviewSave")
   	public String reviewSave(@ModelAttribute Review reviewInfo, HttpServletRequest request) throws Exception {
    	reviewSvc.insertReview(reviewInfo);
        return "redirect:/market/selectedProduct?productNo="+reviewInfo.getProductNo();
    }

    // 리뷰수정
    @RequestMapping(value = "/reviewUpdate")
   	public String reviewUpdate(HttpServletRequest request, ModelMap modelMap) throws Exception {
    	
    	String rvno = request.getParameter("RVNO");
    	
    	Review reviewInfo = reviewSvc.selectReviewOne(rvno);
        
    	modelMap.addAttribute("reviewInfo", reviewInfo);
    	
        return "review/reviewUpdate";
    }
    //리뷰수정저장
    @RequestMapping(value = "/reviewUpdateSave")
   	public String reviewUpdateSave(@ModelAttribute Review reviewInfo) throws Exception {
    	
    	reviewSvc.updateReview(reviewInfo);
    	
        return "redirect:/review/reviewList";
    }    

    // 리뷰 읽기
    @RequestMapping(value = "/reviewRead")
   	public String reviewRead(HttpSession session, HttpServletRequest request, ModelMap modelMap) throws Exception {
    	
		String rvno = request.getParameter("rvno");
    	
    	Review reviewInfo = reviewSvc.selectReviewOne(rvno);
        
    	modelMap.addAttribute("reviewInfo", reviewInfo);
    	
    	//작성자와 로그인아이디가 일치하면 checkId 값에 true 전달. 로그인이 안되었거나, 다르면 false
    	String id = (String)session.getAttribute("id");
    	if(id != null) {
			request.setAttribute("checkId", id.equals(reviewInfo.getRvwriter()));
    	}
    	else {
    		request.setAttribute("checkId", false);
    	}
    	
        return "review/reviewRead";
    }
    
    // 리뷰 삭제
    @RequestMapping(value = "/reviewDelete")
   	public String reviewDelete(HttpServletRequest request) throws Exception {
    	
    	String rvno = request.getParameter("rvno");
    	
    	reviewSvc.deleteReviewOne(rvno);
        
        return "redirect:/review/reviewList";
    }
}