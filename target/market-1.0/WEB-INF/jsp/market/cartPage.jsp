<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import= "java.util.ArrayList"%>
<jsp:include page="/WEB-INF/jsp/market/top.jsp"/>
<hr size = "1" color="black" width="max"><br>

<h1>장바구니</h1>
<table>	
	<c:forEach var="cartview" items="${cartview}" varStatus="status">	
		<c:url var="link" value="purchase">
			<c:param name="productNo" value="${cartview.productNo}" /> <!-- value값의 변수명 vo에서 그대로 가져와야함 -->
			<c:param name="salesCount" value="${cartview.salesCount}" />
			<c:param name="productPrice" value="${cartview.productPrice}" />
		</c:url>							  				
			<td><a href="${link}">
			<c:out value="${cartview.productName}"/>
			<br><c:out value="${cartview.salesCount}"/>
			<br><c:out value="${cartview.productPrice}"/>
			</a>
			</td>
			<br>
	</c:forEach>
</table>
<button onclick = "location.href='top'">홈으로</button>