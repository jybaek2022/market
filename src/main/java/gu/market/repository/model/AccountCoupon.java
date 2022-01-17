package gu.market.repository.model;

public class AccountCoupon {

    private int couponCode, usingStatus;
    private String memberId;

    public AccountCoupon() {}
    public AccountCoupon(int couponCode, int usingStatus, String memberId) {
    	this.couponCode = couponCode;
    	this.usingStatus = usingStatus;
    	this.memberId = memberId;
    }
	public int getCouponCode() {
		return couponCode;
	}
	public int getUsingStatus() {
		return usingStatus;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setCouponCode(int couponCode) {
		this.couponCode = couponCode;
	}
	public void setUsingStatus(int usingStatus) {
		this.usingStatus = usingStatus;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
}