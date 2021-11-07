package gu.market.repository.model;

import java.time.LocalDate;

public class Member {
	private int memberNo;
	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberPhone;
	private String memberAddress1;
	private String memberAddress2;
	private LocalDate memberJoinDate;
	private LocalDate memberBirthDate;
	private String memberGender;
	private String memberCheck;
	
	
	public Member() {}
	public Member(int memberNo, String memberId, 
			String memberPw, String memberName, String memberPhone, 
			String memberAddress1, String memberAddress2, LocalDate memberJoinDate, 
			LocalDate memberBirthDate, String memberGender, String memberCheck) {
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberPhone = memberPhone;
		this.memberAddress1 = memberAddress1;
		this.memberAddress2 = memberAddress2;
		this.memberJoinDate = memberJoinDate;
		this.memberBirthDate = memberBirthDate;
		this.memberGender = memberGender;
		this.memberCheck = memberCheck;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getMemberAddress1() {
		return memberAddress1;
	}

	public void setMemberAddress1(String memberAddress1) {
		this.memberAddress1 = memberAddress1;
	}

	public String getMemberAddress2() {
		return memberAddress2;
	}

	public void setMemberAddress2(String memberAddress2) {
		this.memberAddress2 = memberAddress2;
	}
	
	public LocalDate getMemberJoinDate() {
		return memberJoinDate;
	}
	public void setMemberJoinDate(LocalDate memberJoinDate) {
		this.memberJoinDate = memberJoinDate;
	}
	public LocalDate getMemberBirthDate() {
		return memberBirthDate;
	}
	public void setMemberBirthDate(LocalDate memberBirthDate) {
		this.memberBirthDate = memberBirthDate;
	}
	public String getMemberGender() {
		return memberGender;
	}
	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}
	public String getMemberCheck() {
		return memberCheck;
	}
	public void setMemberCheck(String memberCheck) {
		this.memberCheck = memberCheck;
	}
}
