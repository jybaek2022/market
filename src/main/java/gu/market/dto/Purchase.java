package gu.market.dto;

//이거 지금 안쓰는거지???????

public class Purchase {
	private String id;
	private int productNo;
	private int salesCount;
	private int productPrice;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getproductNo() {
		return productNo;
	}
	public void setproductNo(int productNo) {
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
}
