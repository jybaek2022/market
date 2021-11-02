<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import= "java.util.ArrayList"%>

<hr size = "1" color="black" width="max"><br>

<h1>전체 상품</h1>

<table>	
	<c:forEach var="productview" items="${productview}" varStatus="status">	
		<c:url var="link" value="selectedProduct">
			<c:param name="productNo" value="${productview.productNo}" /> <!-- value값의 변수명 vo에서 그대로 가져와야함 -->
		</c:url>							  				
			<td><a href="${link}">
			<img height = "500" width ="300" src = "../img/${productview.productNo}.jpg">
			<c:out value="${productview.productCatCode}"/>
			<br><c:out value="${productview.productName}"/>
			<br><c:out value="${productview.productDetail}"/>
			<br><c:out value="${productview.productPrice}"/>
			</a>
			</td>
	</c:forEach>
</table>