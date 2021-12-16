<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import= "java.util.ArrayList"%>

<%request.setCharacterEncoding("UTF-8"); %>
<jsp:include page="/WEB-INF/jsp/admin/admin_top.jsp"/>
<hr size = "1" color="black" width="max"><br>

<h1>전체 상품</h1>

<table>	
<tr>
<td>카테고리코드</td><td>품목명</td><td>품목상세</td><td>단가</td><td>재고</td><td>품목상태</td>
</tr>
	<c:forEach var="productview" items="${productview}" varStatus="status">
		<c:url var="link" value="selectedProduct">
			<c:param name="productNo" value="${productview.productNo}" />
		</c:url>							  				
			<tr>
				<td><a href="${link}"><c:out value="${productview.productCatCode}"/></a></td>
				<td><a href="${link}"><c:out value="${productview.productName}"/></a></td>
				<td><a href="${link}"><c:out value="${productview.productDetail}"/></a></td>
				<td><a href="${link}"><c:out value="${productview.productPrice}"/></a></td>
				<td><a href="${link}"><c:out value="${productview.productStock}"/></a></td>
				<td><a href="${link}"><c:out value="${productview.productStatus}"/></a></td>
			</tr>
	</c:forEach>
</table>