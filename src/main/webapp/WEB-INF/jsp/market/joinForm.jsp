<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%
String path = application.getContextPath();
%>    

<div align="center">
<h1>회원가입</h1>
	<hr width="700" color="black" size="3"/>
	<br>
	<form method="post" action="join" enctype="multipart/form-data">
		<table>
			<tr height="50">
				<td width="150"><b>아이디</b></td>
				<td width="300" align="center"><input type="text" name="id" placeholder="id입력" style="width:300px; height:30px"></td>
			</tr>
			<tr height="50">
				<td width="150"><b>비밀번호</b></td>
				<td width="300" align="center"><input type="password" name="pw" placeholder="pw입력" style="width:300px; height:30px"></td>
			</tr>
			<tr height="50">
				<td width="150"><b>이름</b></td>
				<td width="300" align="center"><input type="text" name="name" placeholder="이름 입력" style="width:300px; height:40px"></td>
			</tr>
			<tr height="50">
				<td width="150"><b>전화번호</b></td>
				<td width="300" align="center"><input type="text" name="phone" placeholder="전화번호 입력" style="width:300px; height:40px"></td>
			</tr>
			<tr height="50">
				<td width="150"><b>주소(시도)</b></td>
				<td width="300" align="center"><input type="text" name="address1" placeholder="주소 입력" style="width:300px; height:40px"></td>
			</tr>
			<tr height="50">
				<td width="150"><b>상세주소</b></td>
				<td width="300" align="center"><input type="text" name="address2" placeholder="상세주소 입력" style="width:300px; height:40px"></td>
			</tr>
			<tr height="50">
				<td width="150"><b>성별</b></td>
				<td width="300" align="center"><input type="text" name="gender" placeholder="성별 입력" style="width:300px; height:40px"></td>
			</tr>
			<tr height="50">
				<td width="150"><b>생년월일</b></td>
				<td width="300" align="center"><input type="text" name="birthDate" placeholder="생년월일 입력(yyyy-mm-dd)" style="width:300px; height:40px"></td>
			</tr>
		</table>
	
		<table>
			<tr height="50">
				<td colspan="2" align="center"><br>
					<button type="submit">회원가입</button>
				</td>
			</tr>
		</table>
	</form>
</div>