package gu.market.repository.model;

public class Product {
	private int productNo;
	private int productCatCode;
	private String productName;
	private String productDetail;
	private int productPrice;
	private int productStock;
	private String productAddDate;
	private String productStatus;
	private String productEndDate;
	private String productImgSrc;
	
	public Product() {}
	public Product(int productNo, int productCatCode, String productName, 
			String productDetail, int productPrice, int productStock,
			String productAddDate, String productStatus, String productEndDate, String productImgSrc){
		this.productNo = productNo;
		this.productCatCode = productCatCode;
		this.productName = productName;
		this.productDetail = productDetail;
		this.productPrice = productPrice;
		this.productStock = productStock;
		this.productAddDate = productAddDate;
		this.productStatus = productStatus;
		this.productEndDate = productEndDate;
		this.productImgSrc = productImgSrc;
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
	public int getProductStock() {
		return productStock;
	}
	public void setProductStock(int productStock) {
		this.productStock = productStock;
	}
	public String getProductAddDate() {
		return productAddDate;
	}
	public void setProductAddDate(String productAddDate) {
		this.productAddDate = productAddDate;
	}
	public String getProductStatus() {
		return productStatus;
	}
	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}
	public String getProductEndDate() {
		return productEndDate;
	}
	public void setProductEndDate(String productEndDate) {
		this.productEndDate = productEndDate;
	}
	public String getProductImgSrc() {
		return productImgSrc;
	}
	public void setProductImgSrc(String productImgSrc) {
		this.productImgSrc = productImgSrc;
	}
}
