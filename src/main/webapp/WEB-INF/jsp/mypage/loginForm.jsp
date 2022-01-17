<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.security.SecureRandom" %>
<%@ page import="java.math.BigInteger" %>
<jsp:include page="/WEB-INF/jsp/market/top.jsp"/>
<%
	String path = application.getContextPath();
	System.out.print(path);
%>
<div align ="center">
<form method="post" action="login" enctype="multipart/form-data">
<h1>로그인</h1>
<hr width="700" color="black" size="3"/>
	<table>
		<tr height="50">
			<td width="150"><b>아이디</b></td>
			<td width="300" align="center">
				<input type="text" name="id" placeholder="아이디를 입력하세요" style="width:300px; height:30px">
			</td>
		</tr>
		<tr height="50">
			<td width="150"><b>비밀번호</b></td>
			<td width="300" align="center">
				<input type="text" name="pw" placeholder="패스워드를 입력하세요" style="width:300px; height:30px">
			</td>
		</tr>
		
		<tr height="50">
			<td colspan="2" width="300" align="right">
				<font size="2" color="gray"><a  style="text-decoration:none">아이디찾기</a></font>
				<img alt="" src="<%=path %>/market/img/top1.jpg">
				<font size="2" color="gray"><a  style="text-decoration:none">비밀번호찾기</a></font>
			</td>
		</tr>
		
		<tr height="50">
			<td colspan="2" width="300" align="center">
				<button type="submit" style="height:50px; width:300px; cursor:pointer">로그인</button>
			</td>
		</tr>
	</table>
</form>	
<table>
<tr>
<td>
<%
    String clientId = "P1HlKvAQKRjUSy0O4ib2";//애플리케이션 클라이언트 아이디값";
    String redirectURI = URLEncoder.encode("https://localhost:8443/market/auth", "UTF-8");
    SecureRandom random = new SecureRandom();
    String state = new BigInteger(130, random).toString();
    String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
    apiURL += "&client_id=" + clientId;
    apiURL += "&redirect_uri=" + redirectURI;
    apiURL += "&state=" + state;
    session.setAttribute("state", state);
 %>
  <a href="<%=apiURL%>"><img height="50" width ="300" src="http://static.nid.naver.com/oauth/small_g_in.PNG"/></a>
</td>
</tr>
	<tr height = "100">
		<td width="300">
			<button onclick="location.href='join'" 
			style="height:50px; width:300px; cursor:pointer">회원가입</button>		
		</td>
	</tr>
</table>
</div>