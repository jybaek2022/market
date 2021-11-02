package gu.market.service;

import java.util.List;

import javax.annotation.Resource;

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

	//멤버선택
	public Member selectMemberOne(String memberNo) throws Exception {
		return sqlSession2.selectOne("selectMemberOne", memberNo);
	}
	
	//로그인
	public String[] memberlogin(String id, String pw) throws MarketException {
		Member member = new Member();
		member.setMemberId(id);
		member.setMemberPw(pw);
		
		Member loginedMember = sqlSession2.selectOne("login", member);
		if (loginedMember == null) {
			throw new MarketException(ErrorCode.InvaliddateUserErrCode);
		}else {//이부분 list로 받아서 list로 전달하고싶었으나 안됨. 주소만가져오는건지... 그냥 배열로 넣음.
			String[] value = new String[3];
			value[0] = loginedMember.getMemberName();
			value[1] = loginedMember.getMemberCheck();
			value[2] = loginedMember.getMemberId();
			return value;
		}
	}
	
	// 회원가입
	public void join(String id, String pw, String name) throws MarketException {
		Member member = new Member();
		member.setMemberId(id);
		member.setMemberPw(pw);
		member.setMemberName(name);
		
		try {
			sqlSession2.insert("joinMember", member);
		} catch (DuplicateKeyException e) {
			throw new MarketException(ErrorCode.DuplicatedAccountErrCode, e);
		}
	}
	
	//구매
	public void purchase(String memberId, int productNo, int salesCount, int productPrice) throws MarketException {
		Sales sales = new Sales();
		sales.setMemberId(memberId);
		sales.setProductNo(productNo);
		sales.setSalesCount(salesCount);
		sales.setProductPrice(productPrice);
		
		sqlSession2.insert("purchase", sales);
	}
}