<%@page import="javax.websocket.SendResult"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%String memberNo = request.getParameter("memberNo"); %>

ȸ������������
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