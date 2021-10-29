package gu.market.repository.model;

public class Category {
	private String catCode;
	private String catName;
	
	public Category(String catCode, String catName) {
		this.catCode = catCode;
		this.catName = catName;
	}
	public String getCatCode() {
		return catCode;
	}
	public String getCatName() {
		return catName;
	}
}
