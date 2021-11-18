<%@page import="javax.websocket.SendResult"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/jsp/market/top.jsp"/>
<div align = "center">
<h1>회원정보수정</h1>
<form action = "modifiedMemberInfo" method="POST">
<table>
<tr>
</tr>
	<tr>
		<td>이름</td><td><input type ="text" name ="name" value="${my_info.getMemberName()}"></td>
	</tr>
	<tr>
		<td>ID</td><td>${my_info.getMemberId()}</td>
	</tr>
	<tr>
		<td>전화번호</td><td><input type ="text" name ="phone" value="${my_info.getMemberPhone()}"></td>
	</tr>	
	<tr>
		<td>성별</td><td><input type ="text" name ="gender" value="${my_info.getMemberGender()}"></td>
	</tr>	
	<tr>
		<td>주소1</td><td><input type ="text" name ="address1" value="${my_info.getMemberAddress1()}"></td>
	</tr>	
	<tr>
		<td>주소2</td><td><input type ="text" name ="address2" value="${my_info.getMemberAddress2()}"></td>
	</tr>	
	<tr>
		<td>생일</td><td><input type ="text" name ="birth" value="${my_info.getMemberBirthDate()}"></td>
	</tr>
	<tr>
		<td>가입일자</td><td><input type ="text" name ="joindate" value="${my_info.getMemberJoinDate()}"></td>
	</tr>
</table>
<button type ="submit" value = "save">수정 내용 저장</button>
</form>
</div>
비밀번호변경은 암호화? 적용해서
<br>
<button onclick ="location.href='purchaseList'">구매내역보기</button>