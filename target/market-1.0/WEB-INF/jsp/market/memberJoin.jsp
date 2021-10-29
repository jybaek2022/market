<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

    <%
	String path = application.getContextPath();

	%>    
    

<div align="center">
	<h1>회원가입</h1>
	<hr width="700" color="black" size="3"/>
	<br>
	<form method="post" action="memberJoinPro" >
		<table>
		<tr height="50">
				<td width="150"><b>순번</b></td>
				<td width="300" align="center"><input type="number" name="no" placeholder="순번, 나중에 자동으로 +1" style="width:300px; height:40px"></td>
			</tr>
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
				<td width="300" align="center"><input type="text" name="phone" placeholder="전호번호 입력" style="width:300px; height:40px"></td>
			</tr>
			<tr height="50">
				<td width="150"><b>주소1</b></td>
				<td width="300" align="center"><input type="text" name="address1" placeholder="주소1 입력" style="width:300px; height:40px"></td>
			</tr>
			<tr height="50">
				<td width="150"><b>주소2</b></td>
				<td width="300" align="center"><input type="text" name="address2" placeholder="주소2 입력" style="width:300px; height:40px"></td>
			</tr>

		</table>
	
		<table>
			<tr height="50">
				<td colspan="2" align="center"><br>
					<input type="image" src="<%=path %>/market/img/logo.PNG" name="submit" value="submit" style="height:50px;">
				</td>
			</tr>
		</table>
	</form>
	</div>
    
    
    