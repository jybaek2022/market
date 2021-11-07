<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%
		String adminPath = "http://localhost:8080/admin/adminMain";
	
		request.setCharacterEncoding("UTF-8");				
	
		//String log = "백종윤";//session 못받아서 그냥 넣음
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
					<%--관리자 로그인시 버튼추가--%>
					<%if(adminCheck.equals("Y")){%>
					<button type="button" onClick="location.href='<%=adminPath%>'">관리자화면가기</button>	
					<%}%>
					<%=log %>님 &nbsp; <img alt="" src="../img/top1.jpg"> &nbsp;
					<a style="text-decoration:none">주문확인</a>&nbsp;
					<img alt="" src="../img/top1.jpg"> &nbsp;
					<a href="logout" style="text-decoration:none">로그아웃</a>&nbsp;
				<%} else{%>
					<a href="join" style="text-decoration:none">회원가입</a>&nbsp;
					<img alt="" src="../img/top1.jpg"> &nbsp;
					<a href="login" style="text-decoration:none">로그인</a>&nbsp;
				<%} %>
					<img alt="" src="../img/top1.jpg"> &nbsp;
					<a style="text-decoration:none">고객센터</a>&nbsp;
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
						<a href="allProduct" style="text-decoration:none"><b>전체상품</b></a>
					</font>
				</td>
				<td width="10" align="center">
					<img alt="" src="../img/top1.jpg">
				</td>
				<td width="180" align="center">
					<font size="3" color="black">
						<a href="recommandProduct" style="text-decoration:none"><b>추천상품</b></a>
					</font>
				</td>
				<td width="10" align="center">
					<img alt="" src="../img/top1.jpg">
				</td>
				<td width="180" align="center">
					<font size="3" color="black">
						<a href="newProduct" style="text-decoration:none"><b>신상품</b></a>
					</font>
				</td>
				<td width="10" align="center">
					<img alt="" src="../img/top1.jpg">
				</td>
				<td width="180" align="center">
					<font size="3" color="black">
						<a  style="text-decoration:none"><b>이벤트</b></a>
					</font>
				</td>
				<td width="10" align="center">
					<img alt="" src="../img/top1.jpg">
				</td>
				<td width="180" align="center">
					<font size="3" color="black">
						<a style="text-decoration:none" href = "board6List"><b>커뮤니티</b></a>
					</font>
				</td>
				<td width="10" align="center">
					<img alt="" src="../img/top1.jpg">
				</td>
				<td width="180" align="center">
					<font size="3" color="black">
						<a href = "allCart"><img src="../img/cart.png" width="30">장바구니</a>
					</font>
				</td>	
			</tr>
		</table>
	</div>