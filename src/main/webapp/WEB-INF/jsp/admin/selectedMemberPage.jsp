<%@page import="javax.websocket.SendResult"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%String memberNo = request.getParameter("memberNo"); %>

회원정보페이지
<table>
	<tr>
		<td>${member_info.getMemberName()}</td>
	</tr>
	<tr>
		<td>${member_info.getMemberId()}</td>
	</tr>
	<tr>
		<td>${member_info.getMemberPw()}</td>
	</tr>	
</table>