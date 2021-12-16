package gu.market.service;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gu.market.repository.model.Review;

@Service
public class ReviewService {

	@Autowired
	@Resource(name = "sqlSessionTemplate2")
	private SqlSessionTemplate sqlSession2;	
		
    public List<Review> selectReviewList(int productNo) throws Exception {
		return sqlSession2.selectList("selectReviewList", productNo);
    }
    public List<?> selectClaimList() throws Exception {
		return sqlSession2.selectList("selectClaimList");
    }
    public void insertReview(Review param) throws Exception {
		sqlSession2.insert("insertReview", param);
    }
    public void updateReview(Review param) throws Exception {
		sqlSession2.insert("updateReview", param);
    }
 
    public Review selectReviewOne(String param) throws Exception {
		return sqlSession2.selectOne("selectReviewOne", param);
    }
    
    public void deleteReviewOne(String param) throws Exception {
		sqlSession2.delete("deleteReviewOne", param);
    }
}