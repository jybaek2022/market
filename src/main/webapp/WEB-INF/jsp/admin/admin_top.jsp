<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");				

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
String adminPath = "http://localhost:8080/admin";
String myPath = "http://localhost:8080/mypage/myinfo";
String marketPath = "http://localhost:8080/market";
%>
	<div align="right">
		<font size="2">
				<%if(log != "") {%>
					<%if(adminCheck.equals("Y")){%>
					<button type="button" onClick="location.href='<%=marketPath%>/home'">일반회원화면가기</button>	
					<%}%>
					<%=log %>님 &nbsp; <img alt="" src="../img/top1.jpg"> &nbsp;
					<a style="text-decoration:none">주문확인</a>&nbsp;
					<img alt="" src="../img/top1.jpg"> &nbsp;
					<a href="<%=marketPath%>/logout" style="text-decoration:none">로그아웃</a>&nbsp;
				<%} else{%>
					<a href="join" style="text-decoration:none">회원가입</a>&nbsp;
					<img alt="" src="../img/top1.jpg"> &nbsp;
					<a href="<%=marketPath%>/login" style="text-decoration:none">로그인</a>&nbsp;
				<%} %>
					<img alt="" src="../img/top1.jpg"> &nbsp;
					<a style="text-decoration:none">고객센터</a>&nbsp;
		</font>
	</div>
	<div align="center">
		<a href="<%=marketPath%>/home">
			<img src="../img/logo.png" alt="" height="80">
		</a>
	</div>
	<br>
	<div align="center">
		<table style="font-size: 1vw">
			<tr height="50">
				<td width="180" align="center" id="dropdown">
					<font size="3" color="black">
						<a href="<%=adminPath%>/allMember" style="text-decoration:none"><b>회원관리</b></a>
					</font>
				</td>
				<td width="10" align="center">
					<img alt="" src="../img/top1.jpg">
				</td>
				<td width="180" align="center">
					<font size="3" color="black">
						<a style="text-decoration:none" href ="<%=adminPath%>/addProduct"><b>상품추가</b></a>
					</font>
				</td>
				<td width="10" align="center">
					<img alt="" src="../img/top1.jpg"> &nbsp;
				</td>
				<td width="180" align="center">
					<font size="3" color="black">
						<a style="text-decoration:none" href ="<%=adminPath%>/productSales"><b>운영현황</b></a>
					</font>
				</td>
				<td width="10" align="center">
					<img alt="" src="../img/top1.jpg"> &nbsp;
				</td>
				<td width="180" align="center">
					<font size="3" color="black">
						<a style="text-decoration:none" href = "board6List"><b>클레임관리</b></a>
					</font>
				</td>
			</tr>
		</table>
	</div>