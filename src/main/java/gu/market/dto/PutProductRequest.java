package gu.market.dto;

public class PutProductRequest {
	private int productNo;
	private int productCatCode;
	private String productName;
	private String productDetail;
	private int productPrice;
	private int productStock;
	private String productStatus;

	public int getProductNo() {
		return productNo;
	}

	public int getProductCatCode() {
		return productCatCode;
	}

	public String getProductName() {
		return productName;
	}

	public String getProductDetail() {
		return productDetail;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public int getProductStock() {
		return productStock;
	}

	public String getProductStatus() {
		return productStatus;
	}
}
