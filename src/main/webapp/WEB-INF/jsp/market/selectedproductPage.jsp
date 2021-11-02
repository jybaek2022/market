<%@page import="javax.websocket.SendResult"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
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
		<td>카 테 고 리 : ${product_info.getProductName()}</td>
	</tr>
	<tr>
		<td>품 목 상 세 : ${product_info.getProductDetail()}</td>
	</tr>
	<tr>
		<td>단      가 : ${product_info.getProductPrice()}</td>
	</tr>
	<tr>
		<td>수      량 : <input type = "number" name = "pCount" value ="구매수량"><td>
	</tr>
	<tr>
		<td><button type = "submit" onClick="location.href='cart'">구매하기</button></td>
		<td><button type = "submit" onClick="location.href='cart'">장바구니담고 계속 쇼핑하기</button></td>
	</tr>
</table>
</form>


<br>상품리뷰보여주기