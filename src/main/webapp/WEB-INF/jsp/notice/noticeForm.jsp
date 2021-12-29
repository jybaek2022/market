<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/WEB-INF/jsp/market/top.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>board1</title>
</head>
<body>
<%String id = (String)session.getAttribute("id"); %>
<%String name = (String)session.getAttribute("name"); %>
<div align = "center">
	<form name="form1" action="noticeSave">
		<table border="1" style="width:600px">
			<caption>게시판</caption>
			<colgroup>
				<col width='15%' />
				<col width='*%' />
			</colgroup>
			<tbody>
				<tr>
					<td>작성자</td> 
					<td><%=name%><input type="hidden" name="brdwriter" value ="<%=id%>"></td>
				</tr>
				<tr>
					<td>제목</td> 
					<td><input type="text" name="brdtitle" size="70" maxlength="250"></td> 
				</tr>
				<tr>
					<td>내용</td> 
					<td><textarea name="brdmemo" rows="5" cols="60"></textarea></td> 
				</tr>
			</tbody>
		</table>    
		<a href="#" onclick="form1.submit()">저장</a>
	</form>	
	</div>
</body>
</html>