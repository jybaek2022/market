package gu.market.repository.model;

public class Cart {
	private int cartNo;
	private String memberId;
	private int productNo;
	private String productName;
	private int salesCount;
	private int productPrice;
	private String cartAddDate;
	private String purchaseStatus;
	
	public Cart() {}
	public Cart(int cartNo, String memberId, int productNo, 
			String productName, int salesCount, int productPrice,
			String cartAddDate, String purchaseStatus) {
		this.cartNo = cartNo;
		this.memberId = memberId;
		this.productNo = productNo;
		this.productName = productName;
		this.salesCount = salesCount;
		this.productPrice = productPrice;
		this.cartAddDate = cartAddDate;
		this.purchaseStatus = purchaseStatus;
	}
	public int getCartNo() {
		return cartNo;
	}
	public void setCartNo(int cartNo) {
		this.cartNo = cartNo;
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
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCartAddDate() {
		return cartAddDate;
	}
	public void setCartAddDate(String cartAddDate) {
		this.cartAddDate = cartAddDate;
	}
	public String getPurchaseStatus() {
		return purchaseStatus;
	}
	public void setPurchaseStatus(String purchaseStatus) {
		this.purchaseStatus = purchaseStatus;
	}
}