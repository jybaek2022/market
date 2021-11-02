package gu.market.repository.model;

public class Sales {
	private String memberId;
	private int productNo;
	private int salesCount;
	private int productPrice;
	private String salesDate;
	
	public Sales() {}
	public Sales(String memberId, int productNo, int salesCount, int productPrice, String salesDate) {
		this.memberId = memberId;
		this.productNo = productNo;
		this.salesCount = salesCount;
		this.productPrice = productPrice;
		this.salesDate = salesDate;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	public int getSalesCount() {
		return salesCount;
	}
	public void setSalesCount(int salesCount) {
		this.salesCount = salesCount;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public String getSalesDate() {
		return salesDate;
	}
	public void setSalesDate(String salesDate) {
		this.salesDate = salesDate;
	}
}