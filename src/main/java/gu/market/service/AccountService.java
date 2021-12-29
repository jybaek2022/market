package gu.market.service;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import gu.market.error.ErrorCode;
import gu.market.error.MarketException;
import gu.market.repository.model.Member;

@Service
public class AccountService {
	@Autowired
	@Resource(name = "sqlSessionTemplate2")
	private SqlSessionTemplate sqlSession2;

	//로그인
	public Member memberlogin(String id, String pw) throws MarketException {
		Member member = new Member();
		member.setMemberId(id);
		member.setMemberPw(pw);
		
		Member loginedMember = sqlSession2.selectOne("login", member);
		if (loginedMember == null) {
			throw new MarketException(ErrorCode.InvaliddateUserErrCode);
		}else {
			return loginedMember;
		}
	}
	
	// 회원가입
	public void join(Member member)
					throws MarketException {		
		try {
			sqlSession2.insert("joinMember", member);
		} catch (DuplicateKeyException e) {
			throw new MarketException(ErrorCode.DuplicatedAccountErrCode, e);
		}
	}
	public void joinOnNaver(Member member) {
		sqlSession2.insert("joinMember", member);
	}
	//멤버선택
	public Member myInfo(String memberId) throws Exception {
		return sqlSession2.selectOne("selectMemberOne", memberId);
	}
	
	// 정보수정
	public boolean modifiedMemberInfo(Member member) {
		try {
			sqlSession2.update("modifyMember", member);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	// 구매목록
	public List<?> purchaseList(String memberId) throws Exception {
		return sqlSession2.selectList("purchaseList", memberId);
	}	
}