package gu.market.service;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gu.market.repository.model.Board;

@Service
public class NoticeService {

	@Autowired
	@Resource(name = "sqlSessionTemplate2")
	private SqlSessionTemplate sqlSession2;	
		
    public List<?> selectNoticeList() throws Exception {
		return sqlSession2.selectList("selectNoticeList");
    }
    
    public void insertNotice(Board param) throws Exception {
		sqlSession2.insert("insertNotice", param);
    }
    public void updateNotice(Board param) throws Exception {
		sqlSession2.insert("updateNotice", param);
    }
 
    public Board selectNoticeOne(String param) throws Exception {
		return sqlSession2.selectOne("selectNoticeOne", param);
    }
    
    public void deleteNoticeOne(String param) throws Exception {
		sqlSession2.delete("deleteNoticeOne", param);
    }
    
}