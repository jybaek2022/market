<%@page import="javax.websocket.SendResult"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/jsp/admin/admin_top.jsp"/>
<div align = "center">

<h1>상품수정페이지</h1>

<form action = "modifiedProductInfo" method = "POST">   
<table>
	<tr>
		<td>카테고리</td><td><input type ="text" name ="productCatCode" value="${product_info.getProductCatCode()}"></td>
	</tr>
	<tr>
		<td>상품명</td><td><input type ="text" name ="productName" value="${product_info.getProductName()}"></td>
	</tr>
	<tr>
		<td>상품설명</td><td><input type ="text" name ="productDetail" value="${product_info.getProductDetail()}"></td>
	</tr>	
	<tr>
		<td>단가</td><td><input type ="text" name ="productPrice" value="${product_info.getProductPrice()}"></td>
	</tr>	
	<tr>
		<td>재고</td><td><input type ="text" name ="productStock" value="${product_info.getProductStock()}"></td>
	</tr>	
	<tr>
		<td>상품상태</td><td><input type ="text" name ="productStatus" value="${product_info.getProductStatus()}"></td>
	</tr>
	<tr align = "center">
		<td><button type = "submit" name = "button" value = "modifiedProductInfo">수정</button></td>
		
	</tr>
</table>
	<input type = "hidden" name = "productNo" value="${product_info.getProductNo()}">	
</form>
<button onclick = "location.href='https://localhost:8443/admin/deleteProduct?productNo=${product_info.getProductNo()}&productStatus=N'">상품진열삭제</button>
</div>