<%@page import="javax.websocket.SendResult"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%//String productNo = request.getParameter("productNo"); %>

<table>
	<tr>
	<td rowspan = 4> 
		<c:catch var="e" >
	  		<c:import url="img/${product_info.getProductNo()}.jpg" var="imgSrc"/>
	  	</c:catch>
	  	<c:choose>
	  		<c:when test="${!empty e}">
	  	  		<img src="img/${product_info.getProductNo()}.jpg">
	  		</c:when>
	  		<c:otherwise>
	    		<img src="img/${product_info.getProductNo()}.jpg">
	  		</c:otherwise>
	  	</c:choose>
	  	</td>
	</tr>	
	<tr>
		<td>품  목  명 : ${product_info.getProductName()}</td>
	</tr>
	<tr>
		<td>카 테 고 리 : ${product_info.getProductName()}</td>
	</tr>
	<tr>
		<td>품 목 상 세 : ${product_info.getProductDetail()}</td>
	</tr>
	<tr>
		<td>단      가 : ${product_info.getProductPrice()}</td>
	</tr>
	
</table>
<form action = "">
	수량 <input type = "number" name = "pCount" value =" 구매수량">
</form>
<button>구매하기</button>
<br>상품리뷰보여주기