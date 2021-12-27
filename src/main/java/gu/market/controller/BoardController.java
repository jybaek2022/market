package gu.market.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import gu.market.service.BoardService;
import gu.market.session.SessionManager;
import gu.market.dto.Page;
import gu.market.repository.model.Board;

@Controller
@RequestMapping(value = "/board")
public class BoardController {

	private SessionManager sessionManager = new SessionManager();
	
    @Autowired
    private BoardService boardSvc;
    
//    // 커뮤니티리스트
//    @RequestMapping(value = "/boardList")
//   	public String boardList(ModelMap modelMap) throws Exception {
//    	List<?> listview = boardSvc.selectBoardList();
//        
//    	modelMap.addAttribute("listview", listview);
//        return "board/boardList";
//    }
  // 페이징 커뮤니티 리스트
    @RequestMapping(value = "/boardList")
 	public String boardList(ModelMap modelMap,
 			@RequestParam(value="nowPage", required=false, defaultValue="1")int nowPage,
 			@RequestParam(value="cntPerPage", required=false, defaultValue="10")int cntPerPage) throws Exception {
    	//Page vo = new Page(10, 1, 4);//하드코딩 수정
    	
    	int total = boardSvc.countBoardList();
    	System.out.println(total);
		Page vo = new Page(total, nowPage, cntPerPage);//하드코딩 수정    	
		
		System.out.println(vo.getTotal());
		
		List<Board> listview = boardSvc.selectBoardList(vo);
  		modelMap.addAttribute("listview", listview);
  		modelMap.addAttribute("paging", vo);
  		return "board/boardList";
    }
    
    
    // 커뮤니티글쓰기 
    @RequestMapping(value = "/boardForm")
   	public String boardForm(HttpServletRequest request) throws Exception {
    	if (sessionManager.isLogin(request.getSession())) {
    		return "board/boardForm";
    	}else
    	{
    		return "error/unloginedError";
    	}
    }
    //글 저장
    @RequestMapping(value = "/boardSave")
   	public String boardSave(@ModelAttribute Board boardInfo) throws Exception {
    
    	boardSvc.insertBoard(boardInfo);
    	
        return "redirect:/board/boardList";
    }

    // 커뮤니티 글수정
    @RequestMapping(value = "/boardUpdate")
   	public String boardUpdate(HttpServletRequest request, ModelMap modelMap) throws Exception {
    	
    	String brdno = request.getParameter("brdno");
    	
    	Board boardInfo = boardSvc.selectBoardOne(brdno);
        
    	modelMap.addAttribute("boardInfo", boardInfo);
    	
        return "board/boardUpdate";
    }
    //커뮤니티 수정글저장
    @RequestMapping(value = "/boardUpdateSave")
   	public String boardUpdateSave(@ModelAttribute Board boardInfo) throws Exception {
    	
    	boardSvc.updateBoard(boardInfo);
    	
        return "redirect:/board/boardList";
    }    

    // 커뮤니티 글 읽기
    @RequestMapping(value = "/boardRead")
   	public String boardRead(HttpSession session, HttpServletRequest request, ModelMap modelMap) throws Exception {
    	
		String brdno = request.getParameter("brdno");
    	
    	Board boardInfo = boardSvc.selectBoardOne(brdno);
        
    	modelMap.addAttribute("boardInfo", boardInfo);
    	
    	//작성자와 로그인아이디가 일치하면 checkId 값에 true 전달. 로그인이 안되었거나, 다르면 false
    	String id = (String)session.getAttribute("id");
    	if(id != null) {
			request.setAttribute("checkId", id.equals(boardInfo.getBrdwriter()));
    	}
    	else {
    		request.setAttribute("checkId", false);
    	}
    	
        return "board/boardRead";
    }
    
    // 커뮤니티 글 삭제
    @RequestMapping(value = "/boardDelete")
   	public String boardDelete(HttpServletRequest request) throws Exception {
    	
    	String brdno = request.getParameter("brdno");
    	
    	boardSvc.deleteBoardOne(brdno);
        
        return "redirect:/board/boardList";
    }

}