<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/jsp/market/admin_main_temp.jsp"/>

<hr size = "1" color="black" width="max"><br>

<h1>전체 회원</h1>

<table>	
	<c:forEach var="memberview" items="${memberview}" varStatus="status">	
		<c:url var="link" value="selectedMember">
			<c:param name="memberId" value="${memberview.memberId}" /> <!-- value값의 변수명 vo에서 그대로 가져와야함 -->
		</c:url>							  				
			<td><a href="${link}">
			<c:out value="${memberview.memberId}"/>
			<br><c:out value="${memberview.memberName}"/>
			<br><c:out value="${memberview.memberPhone}"/>
			<br><c:out value="${memberview.memberGender}"/>
			<br><c:out value="${memberview.memberAddress1}"/>
			<br><c:out value="${memberview.memberAddress2}"/>
			</a>
			</td>
			<br>
	</c:forEach>
</table>

<c:forEach var="member" items="${member_list}" varStatus="status">
   		<p>${status.count} : <c:out value="${member.getMemberName()}" /></p>
</c:forEach>