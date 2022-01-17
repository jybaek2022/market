<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유기동물찾기</title>
</head>
<body>
<h1>유기동물찾기</h1>
<table>	
		<td>보호소<td>주소<td>종류<td>성별<td>사진
	
	<c:forEach begin="0" end="9" var="list" items="${list}" varStatus="status">
	<tr>								  				
		<td><c:out value="${list.careNm}"/>
		<td><c:out value="${list.careAddr}"/>
		<td><c:out value="${list.kindCd}"/>
		<td><c:out value="${list.sexCd}"/>
		<td><img height = "100" width ="200" src = "${list.popfile}">
	</tr>
	</c:forEach>
</table>
<c:if test="${pageNo>=1&&pageNo<=5}">
	<c:forEach begin="1" end="5" var="p">
		<c:choose>
			<c:when test="${p==pageNo}">
				<b>${p}</b>
			</c:when>
			<c:when test="${p!=pageNo}">
				<a href="https://localhost:8443/market/getMissingPet?pageNo=${p}">${p}</a>
			</c:when>
		</c:choose>
	</c:forEach>
	<a href="https://localhost:8443/market/getMissingPet?pageNo=${((p+1)/5)+6}">next</a>
</c:if>
<br>

<fmt:parseNumber var= "pageNoDiv" integerOnly= "true" value= "${(pageNo-1)/5}" />

<c:if test="${pageNo>=6}">
	<c:forEach begin="${1+5*pageNoDiv}" end="${1+5*pageNoDiv+4}" var="p" >
		<c:choose>
			<c:when test="${p==pageNo}">
				<b>${p}</b>
			</c:when>
			<c:when test="${p!=pageNo}">
				<a href="https://localhost:8443/market/getMissingPet?pageNo=${p}">${p}</a>
			</c:when>
		</c:choose>
	</c:forEach>
	<a href="https://localhost:8443/market/getMissingPet?pageNo=${1+5*pageNoDiv+5}">next</a>
</c:if>
</body>
</html>