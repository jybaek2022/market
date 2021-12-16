package gu.market.service;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gu.market.repository.model.Board;

@Service
public class BoardService {

	@Autowired
	@Resource(name = "sqlSessionTemplate2")
	private SqlSessionTemplate sqlSession2;	
		
    public List<?> selectBoardList() throws Exception {
		return sqlSession2.selectList("selectBoardList");
    }
    
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
    
}