package gu.market.repository.model;

public class Product {
	private int productNo;
	private int productCatCode;
	private String productName;
	private String productDetail;
	private int productPrice;
	private int productCount;
	
	public Product() {}
	public Product(int productNo, int productCatCode, String productName, String productDetail, int productPrice, int productCount) {
		this.productNo = productNo;
		this.productCatCode = productCatCode;
		this.productName = productName;
		this.productDetail = productDetail;
		this.productPrice = productPrice;
		this.productCount = productCount;
	}
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	public int getProductCatCode() {
		return productCatCode;
	}
	public void setProductCatCode(int productCatCode) {
		this.productCatCode = productCatCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDetail() {
		return productDetail;
	}
	public void setProductDetail(String productDetail) {
		this.productDetail = productDetail;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public int getProductCount() {
		return productCount;
	}
	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}
}
