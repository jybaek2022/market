package gu.market.service;

import java.time.LocalDate;
import java.util.List;


import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gu.market.repository.model.Member;

@Service
public class AccountService {
	@Autowired
	@Resource(name = "sqlSessionTemplate2")
	private SqlSessionTemplate sqlSession2;

	// 전체회원
	public List<?> allMember() {
		return sqlSession2.selectList("allMember");
	}
	//멤버선택
	public Member selectMemberOne(String memberId) throws Exception {
		return sqlSession2.selectOne("selectMemberOne", memberId);
	}
	
	// 관리자권한제거
	public void deleteAdmin(String memberId) throws Exception {
		sqlSession2.update("deleteAdmin", memberId);
	}
	// 관리자권한추가
	public void addAdmin(String memberId) throws Exception {
		sqlSession2.update("addAdmin", memberId);
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