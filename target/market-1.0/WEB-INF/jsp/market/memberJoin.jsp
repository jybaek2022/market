<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

    <%
	String path = application.getContextPath();

	%>    
    

<div align="center">
	<h1>ȸ������</h1>
	<hr width="700" color="black" size="3"/>
	<br>
	<form method="post" action="memberJoinPro" >
		<table>
		<tr height="50">
				<td width="150"><b>����</b></td>
				<td width="300" align="center"><input type="number" name="no" placeholder="����, ���߿� �ڵ����� +1" style="width:300px; height:40px"></td>
			</tr>
			<tr height="50">
				<td width="150"><b>���̵�</b></td>
				<td width="300" align="center"><input type="text" name="id" placeholder="id�Է�" style="width:300px; height:30px"></td>
			</tr>
			
			<tr height="50">
				<td width="150"><b>��й�ȣ</b></td>
				<td width="300" align="center"><input type="password" name="pw" placeholder="pw�Է�" style="width:300px; height:30px"></td>
			</tr>
			
			<tr height="50">
				<td width="150"><b>�̸�</b></td>
				<td width="300" align="center"><input type="text" name="name" placeholder="�̸� �Է�" style="width:300px; height:40px"></td>
			</tr>
			<tr height="50">
				<td width="150"><b>��ȭ��ȣ</b></td>
				<td width="300" align="center"><input type="text" name="phone" placeholder="��ȣ��ȣ �Է�" style="width:300px; height:40px"></td>
			</tr>
			<tr height="50">
				<td width="150"><b>�ּ�1</b></td>
				<td width="300" align="center"><input type="text" name="address1" placeholder="�ּ�1 �Է�" style="width:300px; height:40px"></td>
			</tr>
			<tr height="50">
				<td width="150"><b>�ּ�2</b></td>
				<td width="300" align="center"><input type="text" name="address2" placeholder="�ּ�2 �Է�" style="width:300px; height:40px"></td>
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
    
    
    