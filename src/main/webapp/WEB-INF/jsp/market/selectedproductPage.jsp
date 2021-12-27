<%@page import="javax.websocket.SendResult"%>
<%@page import="org.springframework.web.servlet.ModelAndView"%>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/jsp/market/top.jsp"/>   

<form action = "connectionFNC" method = "POST">
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
		<td><button type = "submit" name = "button" value = "purchase">바로구매하기</button></td>
		<td><button type = "submit" name = "button" value = "addCart">장바구니담기</button></td>
	</tr>
</table>
	<input type = "hidden" name = "productNo" value="${product_info.getProductNo()}">	
</form>

<jsp:include page="/WEB-INF/jsp/review/reviewList.jsp"/>