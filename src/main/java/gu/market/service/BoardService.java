package gu.market.service;
import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gu.market.repository.model.Board;

@Service
public class BoardService {

	@Autowired
	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;	
		
    public List<?> selectBoardList() throws Exception {
		return sqlSession.selectList("selectBoard1List");
    }
    
    public void insertBoard(Board param) throws Exception {
		sqlSession.insert("insertBoard1", param);
    }
    public void updateBoard(Board param) throws Exception {
		sqlSession.insert("updateBoard1", param);
    }
 
    public Board selectBoardOne(String param) throws Exception {
		return sqlSession.selectOne("selectBoard1One", param);
    }
    
    public void deleteBoardOne(String param) throws Exception {
		sqlSession.delete("deleteBoard1One", param);
    }
    
}