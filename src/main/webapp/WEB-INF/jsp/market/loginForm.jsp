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
			<h2>�α���</h2>
		</td>
	</tr>
	<tr height="50">
		<td width="300" align="center">
			<input type="text" name="id" placeholder="���̵� �Է��ϼ���" style="width:300px; height:30px">
		</td>
	</tr>
	
	<tr height="50">
		<td width="300" align="center">
			<input type="text" name="pw" placeholder="�н����带 �Է��ϼ���" style="width:300px; height:30px">
		</td>
	</tr>
	
	<tr height="50">
		<td width="300" align="right">
			<font size="2" color="gray"><a  style="text-decoration:none">���̵�ã��</a></font>
			<img alt="" src="<%=path %>/market/img/top1.jpg">
			<font size="2" color="gray"><a  style="text-decoration:none">��й�ȣã��</a></font>
		</td>
	</tr>
	
	<tr height="50">
		<td width="300">
			<!-- input type="image" src="img/login.PNG" name="submit" value="�α���" style="width:320px" -->
			<button type="submit">�α���</button>
		</td>
	</tr>
	
	<tr height = "50">
		<td width="300">
			<img alt="ȸ������" src="" onclick="location.href='top'"
				style="height:50px; width:320px; cursor:pointer">
			</td>
		</tr>
	</table>
</form>
 
