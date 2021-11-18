<%@page import="javax.websocket.SendResult"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/jsp/admin/admin_top.jsp"/>
<div align = "center">
<h1>품목별 매출</h1>
<table>
<tr>
<td align="center">품목명<td align="center">판매량<td align="center">매출
</tr>	
	<c:forEach var="pSview" items="${pSview}" varStatus="status">
	<tr>	
		<td align="center"><c:out value="${pSview.productName}"/></td>
		<td align="center"><c:out value="${pSview.salesCount}"/></td>
		<td align="right"><c:out value="${pSview.sum}"/></td>
	</tr>
	</c:forEach>
</table>
</div>