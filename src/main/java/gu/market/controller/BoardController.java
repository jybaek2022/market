package gu.market.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import gu.market.service.BoardService;
import gu.market.repository.model.Board;

@Controller
@RequestMapping(value = "/board")
public class BoardController {

    @Autowired
    private BoardService boardSvc;
    
    // 리스트
    @RequestMapping(value = "/board1List")
   	public String boardList(ModelMap modelMap) throws Exception {
    	List<?> listview = boardSvc.selectBoardList();
        
    	modelMap.addAttribute("listview", listview);
        return "board/boardList";
    }
    
    // 글 쓰기 
    @RequestMapping(value = "/board1Form")
   	public String boardForm() throws Exception {
        return "board/boardForm";
    }
    
    @RequestMapping(value = "/board1Save")
   	public String boardSave(@ModelAttribute Board boardInfo) throws Exception {
    	
    	boardSvc.insertBoard(boardInfo);
    	
        return "redirect:/board/board1List";
    }

    // 글 수정
    @RequestMapping(value = "/board1Update")
   	public String boardUpdate(HttpServletRequest request, ModelMap modelMap) throws Exception {
    	
    	String brdno = request.getParameter("brdno");
    	
    	Board boardInfo = boardSvc.selectBoardOne(brdno);
        
    	modelMap.addAttribute("boardInfo", boardInfo);
    	
        return "board/boardUpdate";
    }
    
    @RequestMapping(value = "/board1UpdateSave")
   	public String board1UpdateSave(@ModelAttribute Board boardInfo) throws Exception {
    	
    	boardSvc.updateBoard(boardInfo);
    	
        return "redirect:/board/board1List";
    }    

    // 글 읽기
    @RequestMapping(value = "/board1Read")
   	public String boardRead(HttpServletRequest request, ModelMap modelMap) throws Exception {
    	
    	String brdno = request.getParameter("brdno");
    	
    	Board boardInfo = boardSvc.selectBoardOne(brdno);
        
    	modelMap.addAttribute("boardInfo", boardInfo);
    	
        return "board/boardRead";
    }
    
    // 글 삭제
    @RequestMapping(value = "/board1Delete")
   	public String boardDelete(HttpServletRequest request) throws Exception {
    	
    	String brdno = request.getParameter("brdno");
    	
    	boardSvc.deleteBoardOne(brdno);
        
        return "redirect:/board/board1List";
    }

}