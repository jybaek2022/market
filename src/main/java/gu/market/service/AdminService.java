package gu.market.service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import gu.market.dto.PutProductRequest;
import gu.market.error.ErrorCode;
import gu.market.error.MarketException;
import gu.market.repository.model.*;

@Service
public class AdminService {

	@Autowired
	@Resource(name = "sqlSessionTemplate2")
	private SqlSessionTemplate sqlSession2;
	
	// 전체회원
	public List<?> allMember() {
		return sqlSession2.selectList("allMember");
	}
	//멤버선택
	public Member selectMemberOne(String memberId) throws Exception {
		return sqlSession2.selectOne("selectMemberOne", memberId);
	}
	
	// 관리자권한제거
	public void deleteAdmin(String memberId) throws Exception {
		sqlSession2.update("deleteAdmin", memberId);
	}
	// 관리자권한추가
	public void addAdmin(String memberId) throws Exception {
		sqlSession2.update("addAdmin", memberId);
	}
	//관리자 --- 품목추가
	public void addProduct(String pName, int pCCode, String pDetail, int pPrice,
			int pStock, String pStatus, String pImgSrc) throws MarketException {
		Product product = new Product();
		product.setProductName(pName);
		product.setProductCatCode(pCCode);
		product.setProductDetail(pDetail);
		product.setProductPrice(pPrice);
		product.setProductStock(pStock);
		product.setProductStatus(pStatus);
		product.setProductImgSrc(pImgSrc);
		
		try {
			sqlSession2.insert("addProduct", product);
		} catch (DuplicateKeyException e) {
			throw new MarketException(ErrorCode.DuplicatedAccountErrCode, e);
		}
	}
	// 전체상품
	public List<?> adminProduct() throws Exception {
		return sqlSession2.selectList("adminProduct");
	}
	//한품목선택
	public Product selectProductOne(String productNo) throws Exception {
		return sqlSession2.selectOne("selectProductOne", productNo);
	}
	// 품목정보수정
	public void modifiedProductInfo(PutProductRequest productInfo) throws Exception {
		Product product = new Product();
		product.setProductNo(productInfo.getProductNo());
		product.setProductCatCode(productInfo.getProductCatCode());
		product.setProductName(productInfo.getProductName());
		product.setProductDetail(productInfo.getProductDetail());
		product.setProductPrice(productInfo.getProductPrice());
		product.setProductStock(productInfo.getProductStock());
		product.setProductStatus(productInfo.getProductStatus());
		sqlSession2.update("modifyProduct", product);
	}
//	// 품목정보수정
//	public void modifiedProductInfo(int productNo, int productCatCode, String productName, String productDetail, 
//			int productPrice, int productStock, String productStatus) throws Exception {
//		Product product = new Product();
//		product.setProductNo(productNo);
//		product.setProductCatCode(productCatCode);
//		product.setProductName(productName);
//		product.setProductDetail(productDetail);
//		product.setProductPrice(productPrice);
//		product.setProductStock(productStock);
//		product.setProductStatus(productStatus);
//		sqlSession2.update("modifyProduct", product);
//	}
	
	public void deleteProduct(int productNo, String productStatus) {
		Product product = new Product();
		product.setProductNo(productNo);
		product.setProductStatus(productStatus);
		sqlSession2.update("deleteProduct", product);
	}
	//상품별매출
	public List<?> productSales() {
		return sqlSession2.selectList("productSales");
	}
	//회원별매출
	public List<?> memberSales() {
		return sqlSession2.selectList("memberSales");
	}
	
}