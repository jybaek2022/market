<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>


<hr size = "1" color="black" width="max"><br>

<h1>��ü ȸ��</h1>

<table>
	<tr>
		<td><a href = "selectedMember?memberNo=1">���1</a></td>
		<td><a href = "selectedMember?memberNo=2">���2</a></td>
		<td><a href = "selectedMember?memberNo=3">���3</a></td>
	</tr>
	<tr>
	</tr>
</table>

<c:forEach var="member" items="${member_list}" varStatus="status">
   		<p>${status.count} : <c:out value="${member.getMemberName()}" /></p>
</c:forEach>