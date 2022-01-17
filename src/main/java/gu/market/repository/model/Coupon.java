package gu.market.repository.model;

public class Coupon {

    private int couponCode, discountRate;
    private String couponName;

    public Coupon() {}
    public Coupon(int couponCode, int discountRate, String couponName) {
    	this.couponCode = couponCode;
    	this.discountRate = discountRate;
    	this.couponName = couponName;
    }
	public int getCouponCode() {
		return couponCode;
	}
	public int getDiscountRate() {
		return discountRate;
	}
	public String getCouponName() {
		return couponName;
	}
	public void setCouponCode(int couponCode) {
		this.couponCode = couponCode;
	}
	public void setDiscountRate(int discountRate) {
		this.discountRate = discountRate;
	}
	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}
	
	
}