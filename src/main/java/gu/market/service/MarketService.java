package gu.market.service;

import java.time.LocalDate;
import java.util.List;

import javax.annotation.Resource;
import javax.ws.rs.core.Response;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import gu.market.error.ErrorCode;
import gu.market.error.MarketException;
import gu.market.repository.model.*;

@Service
public class MarketService {

	@Autowired
	@Resource(name = "sqlSessionTemplate2")
	private SqlSessionTemplate sqlSession2;

	// 전체상품
	public List<?> allProduct() throws Exception {
		return sqlSession2.selectList("allProduct");
	}

	// 상품검색
	public List<?> searchProduct(String productName) throws Exception {
		return sqlSession2.selectList("searchProduct", productName);
	}
	// 추천상품(특정카테고리)
	public List<?> recommandProduct() throws Exception {
		return sqlSession2.selectList("recommandProduct");
	}
	
	// 신상품(3개만)
	public List<?> newProduct() throws Exception {
		return sqlSession2.selectList("newProduct");
	}

	//한품목선택
	public Product selectProductOne(String productNo) throws Exception {
		return sqlSession2.selectOne("selectProductOne", productNo);
	}
	
	//구매 - 재고 빼기
	public void minusCount(int productNo, int salesCount) throws MarketException {
		Sales sales = new Sales();
		sales.setProductNo(productNo);
		sales.setSalesCount(salesCount);
		//재고부족할때 오류페이지로 나가게되는 과정
		Product productinfo = new Product();
		productinfo = sqlSession2.selectOne("selectProductOne", productNo);
		
		if(productinfo.getProductStock()<sales.getSalesCount()) {
			throw new MarketException(ErrorCode.ShortStock);
		}else {
			sqlSession2.update("minusCount", sales);
		}
	}
	//구매 - sales db 등록
	public void purchase(String memberId, int productNo, int salesCount) throws MarketException {
		Sales sales = new Sales();
		sales.setMemberId(memberId);
		sales.setProductNo(productNo);
		sales.setSalesCount(salesCount);
		
		sqlSession2.insert("purchase", sales);
	}
	public void deleteFcart(int cartNo) {
		sqlSession2.delete("deleteFcart", cartNo);
	}
	
	// 장바구니보기
	public List<?> allCart(String id) throws Exception {
		
		return sqlSession2.selectList("allCart", id);
	}
	//장바구니추가
	public void addCart(String memberId, int productNo, int salesCount) throws MarketException {
		Cart cart = new Cart();
		cart.setMemberId(memberId);
		cart.setProductNo(productNo);
		cart.setSalesCount(salesCount);
		
		sqlSession2.insert("addCart", cart);
	}
	
}