<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>board1</title>
</head>
<body>
<%
if(request.getParameter("productNo")==null){%>
	<jsp:include page="/WEB-INF/jsp/admin/admin_top.jsp"/>
<%
}else{%>
	<jsp:include page="/WEB-INF/jsp/market/top.jsp"/>
<%}%>
<div align = "center">
		<table border="1" style="width:600px">
			<caption>게시판</caption>
			<colgroup>
				<col width='15%' />
				<col width='*%' />
			</colgroup>
			<tbody>
				<tr>
					<td>작성자</td> 
					<td><c:out value="${reviewInfo.rvwriter}"/></td> 
				</tr>
				<tr>
					<td>제목</td> 
					<td><c:out value="${reviewInfo.rvtitle}"/></td> 
				</tr>
				<tr>
					<td>내용</td> 
					<td><c:out value="${reviewInfo.rvmemo}"/></td> 
				</tr>
			</tbody>
		</table>    
		<a href="#" onclick="history.back(-1)">돌아가기</a>
		<%
		boolean checkId = (boolean)request.getAttribute("checkId");
		if(checkId == true){ %>
		<a href="reviewDelete?rvno=<c:out value="${reviewInfo.rvno}"/>">삭제</a>
		<a href="reviewUpdate?rvno=<c:out value="${reviewInfo.rvno}"/>">수정</a>
		<%} %>
</div>
</body>
</html>