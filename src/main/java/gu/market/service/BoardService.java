package gu.market.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gu.market.dto.Page;
import gu.market.repository.model.Board;

@Service
public class BoardService {

	@Autowired
	@Resource(name = "sqlSessionTemplate2")
	private SqlSessionTemplate sqlSession2;	
		
//    public List<?> selectBoardList() throws Exception {
//		return sqlSession2.selectList("selectBoardList");
//    }
    
    public void insertBoard(Board param) throws Exception {
		sqlSession2.insert("insertBoard", param);
    }
    public void updateBoard(Board param) throws Exception {
		sqlSession2.insert("updateBoard", param);
    }
 
    public Board selectBoardOne(String param) throws Exception {
		return sqlSession2.selectOne("selectBoardOne", param);
    }
    
    public void deleteBoardOne(String param) throws Exception {
		sqlSession2.delete("deleteBoardOne", param);
    }
    
    public int countBoardList() {
    	return sqlSession2.selectOne("countBoard");
    }
    
    public List<Board> selectBoardList(Page vo) {
    	int start = vo.getStart();
    	int end = vo.getEnd();
    	Map<String, Integer> input = new HashMap<String, Integer>();
    	input.put("start", start);
    	input.put("end", end);
    	return sqlSession2.selectList("selectBoardList", input);
    }
}