<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import= "java.util.ArrayList"%>
<jsp:include page="/WEB-INF/jsp/market/top.jsp"/>
<h1>결제</h1>
<!-- 품목정보+수량을 sales에담아서 보여주기/ 쿠폰정보검색(비동기 js써보기)-->

<form action = "payment" method = "POST">
	<table>

		<tr>
			<td>수      량 : ${sales_info.getSalesCount()}</td>
		</tr>
		<tr>
			<td>총      액 : ${sales_info.getSalesCount()*sales_info.getProductPrice()}</td>
		</tr>
		<tr>
			<td>
				<table border = "1">
					<tr>
						<td colspan= "3">
						사용가능쿠폰
						</td>
					</tr>
					<tr>
					<td>쿠폰명</td><td>할인율</td><td>쿠폰적용</td>
					<c:forEach var="couponList" items="${couponList}" varStatus="status">							  				
						<tr>
							<td align="center"><c:out value="${couponList.couponName}"/></td>
							<td align="center"><c:out value="${couponList.discountRate}"/>%</td>
							<td><input type="checkbox" name="couponCode" value="${couponList.couponCode}"></td>
						</tr>
					</c:forEach>
				</table>
			</td>
		</tr>
		<tr>
			<td align ="right"><button type = "submit" name = "button" value = "payment">결제하기</button></td>
		</tr>
	</table>
	<input type = "hidden" name = "productNo" value="${sales_info.getProductNo()}">	
	<input type = "hidden" name = "salesCount" value="${sales_info.getSalesCount()}">	
	<input type = "hidden" name = "totalAmount" value="${sales_info.getSalesCount()*sales_info.getProductPrice()}">	
</form>
