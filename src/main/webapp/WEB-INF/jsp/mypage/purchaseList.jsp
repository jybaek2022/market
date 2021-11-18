<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import= "java.util.ArrayList"%>

<%request.setCharacterEncoding("UTF-8"); %>
<jsp:include page="/WEB-INF/jsp/market/top.jsp"/>
<hr size = "1" color="black" width="max"><br>

<h1>주문 조회</h1>

<table>
	<tr>
		<td width="180" align="center">품목명</td>
		<td width="180" align="center">수량</td>
		<td width="180" align="center">단가</td>
		<td width="180" align="center">금액</td>
		<td width="180" align="center">구매일자</td>
	</tr>
	<c:forEach var="purchaseview" items="${purchaseview}" varStatus="status">
		<tr>							  				
			<!--  <a href="${link}">-->
			<td align="center"><c:out value="${purchaseview.productName}"/></td>
			<td align="center"><c:out value="${purchaseview.salesCount}"/></td>
			<td align="center"><c:out value="${purchaseview.productPrice}"/></td>
			<td align="right"><c:out value="${purchaseview.productPrice*purchaseview.salesCount}"/></td>
			<td align="center"><c:out value="${purchaseview.salesDate}"/></td>
			<!--</a>-->
		</tr>
	</c:forEach>
</table>