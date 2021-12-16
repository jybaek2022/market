<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>리뷰페이지</title>
</head>
<body>
<%
int productNo = 0;
if(request.getParameter("productNo")!=null){
	productNo = Integer.parseInt(request.getParameter("productNo"));
}else{%>
	<jsp:include page="/WEB-INF/jsp/admin/admin_top.jsp"/>
<%}
%>
<div align = "center">
					
	<table border="1" style="width:600px">
		<caption>리뷰</caption>
		<colgroup>
			<col width='*%' />
			<col width='15%' />
			<col width='15%' />
		</colgroup>
		<thead>
			<tr>
				<th>제목</th>
				<th>등록자</th>
				<th>등록일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="listview" items="${listview}" varStatus="status">	
				<c:url var="link" value="http://localhost:8080/review/reviewRead">
					<c:param name="rvno" value="${listview.rvno}" />
				</c:url>		
				<tr>
					<td><a href="${link}"><c:out value="${listview.rvtitle}"/></a></td>
					<td><c:out value="${listview.rvwriter}"/></td>
					<td><c:out value="${listview.rvdate}"/></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
<%if(productNo != 0){ %>
	<a href="http://localhost:8080/review/reviewForm?productNo=<%=productNo%>">리뷰쓰기</a>
<%}else{
	request.setAttribute("productNo", 0);
}
%>
</div>    
</body>
</html>