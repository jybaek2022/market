package gu.market.service;

import java.time.LocalDate;
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
	public String[] memberlogin(String id, String pw) throws MarketException {
		Member member = new Member();
		member.setMemberId(id);
		member.setMemberPw(pw);
		
		Member loginedMember = sqlSession2.selectOne("login", member);
		if (loginedMember == null) {
			throw new MarketException(ErrorCode.InvaliddateUserErrCode);
		}else {//이부분 배열 -> list로 변환필요
			String[] value = new String[3];
			value[0] = loginedMember.getMemberName();
			value[1] = loginedMember.getMemberCheck();
			value[2] = loginedMember.getMemberId();
			return value;
		}
	}
	
	// 회원가입
	public void join(String id, String pw, String name, String phone, 
			String address1, String address2, String gender, LocalDate birthDate)
					throws MarketException {
		Member member = new Member();
		member.setMemberId(id);
		member.setMemberPw(pw);
		member.setMemberName(name);
		member.setMemberPhone(phone);
		member.setMemberAddress1(address1);
		member.setMemberAddress2(address2);
		member.setMemberGender(gender);
		member.setMemberBirthDate(birthDate);
		
		try {
			sqlSession2.insert("joinMember", member);
		} catch (DuplicateKeyException e) {
			throw new MarketException(ErrorCode.DuplicatedAccountErrCode, e);
		}
	}
	//멤버선택
	public Member myInfo(String memberId) throws Exception {
		return sqlSession2.selectOne("selectMemberOne", memberId);
	}
	// 정보수정
	public void modifiedMemberInfo(String memberId, String memberName, String memberPhone, String memberGender, String memberAddress1, String memberAddress2, LocalDate memberBirthDate, LocalDate memberJoinDate) throws Exception {
		Member member = new Member();
		member.setMemberId(memberId);
		member.setMemberName(memberName);
		member.setMemberPhone(memberPhone);
		member.setMemberGender(memberGender);
		member.setMemberAddress1(memberAddress1);
		member.setMemberAddress2(memberAddress2);
		member.setMemberBirthDate(memberBirthDate);
		member.setMemberJoinDate(memberJoinDate);
		sqlSession2.update("modifyMember", member);
	}
	// 구매목록
	public List<?> purchaseList(String memberId) throws Exception {
		return sqlSession2.selectList("purchaseList", memberId);
	}
	
}