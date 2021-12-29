<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%
		String adminPath = "https://localhost:8443/admin";
		String myPath = "https://localhost:8443/mypage";
		String marketPath = "https://localhost:8443/market";
		String boardPath = "https://localhost:8443/board";
	
		request.setCharacterEncoding("UTF-8");				
	
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
						<button type="button" onClick="location.href='<%=adminPath%>/adminMain'">관리자화면가기</button>	
					<%}%>
					<%=log %>님 &nbsp; <img alt="" src="../img/top1.jpg"> &nbsp;
					<a href="<%=myPath%>/purchaseList" style="text-decoration:none">주문확인</a>&nbsp;
					<img alt="" src="../img/top1.jpg"> &nbsp;
					<a href="<%=myPath%>/logout" style="text-decoration:none">로그아웃</a>&nbsp;
					<img alt="" src="../img/top1.jpg"> &nbsp;
					<a href="<%=myPath%>/myinfo" style="text-decoration:none">마이페이지</a>&nbsp;
				<%} else{%>
					<a href="<%=myPath%>/join" style="text-decoration:none">회원가입</a>&nbsp;
					<img alt="" src="../img/top1.jpg"> &nbsp;
					<a href="<%=myPath%>/login" style="text-decoration:none">로그인</a>&nbsp;
				<%} %>
					
		</font>
	</div>
	<div align="right">
	<form action = "search">
		<input type ="text" name = "productName" value = "품목명">
		<button type ="submit" value = "search">검색</button>
	</form>
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
						<a href="<%=marketPath%>/allProduct" style="text-decoration:none"><b>전체상품</b></a>
					</font>
				</td>
				<td width="10" align="center">
					<img alt="" src="../img/top1.jpg">
				</td>
				<td width="180" align="center">
					<font size="3" color="black">
						<a href="<%=marketPath%>/recommandProduct" style="text-decoration:none"><b>추천상품</b></a>
					</font>
				</td>
				<td width="10" align="center">
					<img alt="" src="../img/top1.jpg">
				</td>
				<td width="180" align="center">
					<font size="3" color="black">
						<a href="<%=marketPath%>/newProduct" style="text-decoration:none"><b>신상품</b></a>
					</font>
				</td>
				<td width="10" align="center">
					<img alt="" src="../img/top1.jpg">
				</td>
				<td width="180" align="center">
					<font size="3" color="black">
						<a href="https://localhost:8443/notice/noticeList" style="text-decoration:none"><b>공지사항</b></a>
					</font>
				</td>
				<td width="10" align="center">
					<img alt="" src="../img/top1.jpg">
				</td>
				<td width="180" align="center">
					<font size="3" color="black">
						<a style="text-decoration:none" href = "<%=boardPath%>/boardList"><b>커뮤니티</b></a>
					</font>
				</td>
				<td width="10" align="center">
					<img alt="" src="../img/top1.jpg">
				</td>
				<td width="180" align="center">
					<font size="3" color="black">
						<a style="text-decoration:none" href = "<%=marketPath%>/allCart" ><img src="../img/cart.png" width="30"><b>장바구니</b></a>
					</font>
				</td>
				<td width="10" align="center">
					<img alt="" src="../img/top1.jpg">
				</td>	
			</tr>
		</table>
	</div>