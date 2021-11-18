<%@page import="javax.websocket.SendResult"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/jsp/admin/admin_top.jsp"/>
<%String memberId = request.getParameter("memberId"); %>
<h1>회원정보페이지</h1>
<form action = "checkAdmin" method = "POST">
<table>
	<tr>
		<td>${member_info.getMemberName()}</td>
	</tr>
	<tr>
		<td>${member_info.getMemberId()}</td>
	</tr>
	<tr>
		<td>${member_info.getMemberPhone()}</td>
	</tr>	
	<tr>
		<td>${member_info.getMemberGender()}</td>
	</tr>	
	<tr>
		<td>${member_info.getMemberAddress1()}</td>
	</tr>	
	<tr>
		<td>${member_info.getMemberAddress2()}</td>
	</tr>	
	<tr>
		<td>${member_info.getMemberJoinDate()}</td>
	</tr>
	<tr>
		<td>${member_info.getMemberBirthDate()}</td>
	</tr>
	<tr>
		<td>${member_info.getMemberCheck()}</td>
	</tr>
	<tr>
		<td><button type="submit" name="button" value="checkbutton">관리자권한변경</button></td>
	</tr>
</table>
<input type="hidden" name="memberId" value=<%=memberId%>>
<input type="hidden" name="memberCheck" value="check">
</form>