<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%
	String path = application.getContextPath();
	System.out.print(path);
%>

<form method="post" action="login" enctype="multipart/form-data">
<table>
	<tr>
		<td width="300" align="center">
			<h2>로그인</h2>
		</td>
	</tr>
	<tr height="50">
		<td width="300" align="center">
			<input type="text" name="id" placeholder="아이디를 입력하세요" style="width:300px; height:30px">
		</td>
	</tr>
	
	<tr height="50">
		<td width="300" align="center">
			<input type="text" name="pw" placeholder="패스워드를 입력하세요" style="width:300px; height:30px">
		</td>
	</tr>
	
	<tr height="50">
		<td width="300" align="right">
			<font size="2" color="gray"><a  style="text-decoration:none">아이디찾기</a></font>
			<img alt="" src="<%=path %>/market/img/top1.jpg">
			<font size="2" color="gray"><a  style="text-decoration:none">비밀번호찾기</a></font>
		</td>
	</tr>
	
	<tr height="50">
		<td width="300">
			<!-- input type="image" src="img/login.PNG" name="submit" value="로그인" style="width:320px" -->
			<button type="submit">로그인</button>
		</td>
	</tr>
	
	<tr height = "50">
		<td width="300">
			<img alt="회원가입" src="" onclick="location.href='top'"
				style="height:50px; width:320px; cursor:pointer">
			</td>
		</tr>
	</table>
</form>
 
