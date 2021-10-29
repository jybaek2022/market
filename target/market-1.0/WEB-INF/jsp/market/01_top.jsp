<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

	<%
		
		request.setCharacterEncoding("EUC-KR");				

					
		//String log = "백종윤";//session 못받아서 그냥 넣음
		String log = null;

	%>
	<div align="right">
		<font size="2">
				<%--관리자페이지버튼추가. 로그인구성되면없앰--%>
				<button type="button" onClick="location.href='adminMain'">관리자화면가기</button>
				<%if(log != null) {%>
				<%=log %>님 &nbsp; <img alt="" src="img/top1.jpg"> &nbsp;
					<a style="text-decoration:none">주문확인</a>&nbsp;
					<!-- <img alt="" src="img/top1.jpg"> &nbsp; -->
					<img alt="" src="img/top1.jpg"> &nbsp;
					<a href="03_02_logoutPro.jsp" style="text-decoration:none">로그아웃</a>&nbsp;
				<%} else{%>
					<a href="memberJoin" style="text-decoration:none">회원가입</a>&nbsp;
					<img alt="" src="img/top1.jpg"> &nbsp;
					<a href="login" style="text-decoration:none">로그인</a>&nbsp;
				<%} %>
					
			
					<img alt="" src="img/top1.jpg"> &nbsp;
					<a style="text-decoration:none">고객센터</a>&nbsp;
		</font>
	</div>
	<div align="center">
		<a href="home">
			<img src="img/logo.png" alt="" height="80">
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
					<img alt="" src="img/top1.jpg">
				</td>
				<td width="180" align="center">
					<font size="3" color="black">
						<a href="recommandProduct" style="text-decoration:none"><b>추천상품</b></a>
					</font>
				</td>
				<td width="10" align="center">
					<img alt="" src="img/top1.jpg">
				</td>
				<td width="180" align="center">
					<font size="3" color="black">
						<a href="newProduct" style="text-decoration:none"><b>신상품</b></a>
					</font>
				</td>
				<td width="10" align="center">
					<img alt="" src="img/top1.jpg">
				</td>
				<td width="180" align="center">
					<font size="3" color="black">
						<a  style="text-decoration:none"><b>이벤트</b></a>
					</font>
				</td>
				<td width="10" align="center">
					<img alt="" src="img/top1.jpg">
				</td>
				<td width="180" align="center">
					<font size="3" color="black">
						<a style="text-decoration:none" href = "board6List"><b>커뮤니티</b></a>
					</font>
				</td>
				<td width="40" align="center">
					<a href = "00_main.jsp?center=07_01_cartInfoPage.jsp"><img src="img/cart.png" width="30">장바구니</a>
				</td>
				
			</tr>
		</table>
	</div>
	첫페이지
	<jsp:include page="01_center.jsp"/>