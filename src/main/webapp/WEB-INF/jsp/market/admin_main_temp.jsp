<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%request.setCharacterEncoding("EUC-KR");				

String log = "";
Object name = session.getAttribute("name");
if(name != null) {
	log = (String) name;
}
String admin = (String)session.getAttribute("admin");
String adminCheck ="";
if(admin !=null){
	adminCheck = admin;
}
		
	%>
	<div align="right">
		<font size="2">
				<%if(log != "") {%>
					<%--������ �α��ν� ��ư�߰�--%>
					<%if(adminCheck.equals("Y")){%>
					<button type="button" onClick="location.href='top'">�Ϲ�ȸ��ȭ�鰡��</button>	
					<%}%>
					<%=log %>�� &nbsp; <img alt="" src="../img/top1.jpg"> &nbsp;
					<a style="text-decoration:none">�ֹ�Ȯ��</a>&nbsp;
					<img alt="" src="../img/top1.jpg"> &nbsp;
					<a href="logout" style="text-decoration:none">�α׾ƿ�</a>&nbsp;
				<%} else{%>
					<a href="join" style="text-decoration:none">ȸ������</a>&nbsp;
					<img alt="" src="../img/top1.jpg"> &nbsp;
					<a href="login" style="text-decoration:none">�α���</a>&nbsp;
				<%} %>
					<img alt="" src="../img/top1.jpg"> &nbsp;
					<a style="text-decoration:none">������</a>&nbsp;
		</font>
	</div>
	<div align="center">
		<a href="home">
			<img src="../img/logo.png" alt="" height="80">
		</a>
	</div>
	<br>
	<div align="center">
		<table style="font-size: 1vw">
			<tr height="50">
				<td width="180" align="center" id="dropdown">
					<font size="3" color="black">
						<a href="allMember" style="text-decoration:none"><b>ȸ������</b></a>
					</font>
				</td>
				<td width="10" align="center">
					<img alt="" src="../img/top1.jpg">
				</td>
				<td width="180" align="center">
					<font size="3" color="black">
						<a style="text-decoration:none" href ="addProduct"><b>��ǰ�߰�</b></a>
					</font>
				</td>
				<td width="10" align="center">
					<img alt="" src="../img/top1.jpg"> &nbsp;
				</td>
				<td width="180" align="center">
					<font size="3" color="black">
						<a style="text-decoration:none"><b>���Ȳ</b></a>
					</font>
				</td>
				<td width="10" align="center">
					<img alt="" src="../img/top1.jpg"> &nbsp;
				</td>
				<td width="180" align="center">
					<font size="3" color="black">
						<a style="text-decoration:none" href = "board6List"><b>Ŭ���Ӱ���</b></a>
					</font>
				</td>
			</tr>
		</table>
	</div>
	<div align="center"><img src ="../img/admin.jpg"></div>