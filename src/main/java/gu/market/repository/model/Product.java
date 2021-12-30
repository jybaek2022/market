package gu.market.repository.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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

	public static List<Product> jsonToProductList(String jsonString){
		System.out.println("뽑기에서 json출력 : "+ jsonString);
		List<Product> list = new ArrayList<Product>();
		
		JSONArray jArray = new JSONArray(jsonString);
		for (int i = 0; i < jArray.length(); i++)//배열
		{
			JSONObject obj = (JSONObject) jArray.get(i);
			Product product = new Product();
			product.setProductNo(obj.getInt("productNo"));
			product.setProductName(obj.getString("productName"));
			product.setProductPrice(obj.getInt("productPrice"));
			product.setProductDetail(obj.getString("productDetail"));
			
			list.add(product);
		}		
		System.out.println("list출력 : "+ list.toString());
		return list;
	}
	
	public static String arrayToJson(List<Product> list) {
		
		JSONArray jArray = new JSONArray();//배열이 필요할때
		for (int i = 0; i < list.size(); i++)//배열
		{
			JSONObject sObject = new JSONObject();//배열 내에 들어갈 json
			sObject.put("productNo", list.get(i).getProductNo());
			sObject.put("productName", list.get(i).getProductName());
			sObject.put("productPrice", list.get(i).getProductPrice());
			sObject.put("productDetail", list.get(i).getProductDetail());
			jArray.put(sObject);
		}

		System.out.println("넣기에서 json출력 : "+ jArray.toString());
	
		return jArray.toString();
	}
}
