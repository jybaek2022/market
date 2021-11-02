<%@page import="javax.websocket.SendResult"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%Object id = session.getAttribute("id");
String memberId = (String) id;%>

<form action = "purchase">
<table>
	<tr>
	<td rowspan = 8> 
		<c:catch var="e" >
	  		<c:import url="../img/${product_info.getProductNo()}.jpg" var="imgSrc"/>
	  	</c:catch>
	  	<c:choose>
	  		<c:when test="${empty e}">
	  	  		<img height = "600" src="../img/${product_info.getProductNo()}.jpg">
	  		</c:when>
	  		<c:otherwise>
	    		<img src="../img/logo.png">
	  		</c:otherwise>
	  	</c:choose>
	  	</td>
	</tr>	
	<tr>
		<td>품  목  명 : ${product_info.getProductName()}</td>
	</tr>
	<tr>
		<td>카 테 고 리 : ${product_info.getProductCatCode()}</td>
	</tr>
	<tr>
		<td>품 목 상 세 : ${product_info.getProductDetail()}</td>
	</tr>
	<tr>
		<td>단      가 : ${product_info.getProductPrice()}</td>
	</tr>
	<tr>
		<td>수      량 : <input type = "number" name = "salesCount" value ="구매수량"><td>
	</tr>
	<tr>
		<td><button type = "submit">구매하기</button></td>
		<td><button type = "submit">장바구니담고 계속 쇼핑하기</button></td>
	</tr>
</table>
	<input type = "hidden" name = "memberId" value=<%=memberId%>>
	<input type = "hidden" name = "productNo" value="${product_info.getProductNo()}">
	<input type = "hidden" name = "productPrice" value="${product_info.getProductPrice()}">	
</form>

<br>상품리뷰보여주기