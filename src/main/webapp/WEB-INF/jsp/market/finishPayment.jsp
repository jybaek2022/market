<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import= "java.util.ArrayList"%>

<%
int totalAmount = Integer.parseInt(request.getParameter("totalAmount"));
int discountRate = 0;
int dicountPrice = 0;
int a = (int)request.getAttribute("discountRate");

if(a != 0){
	discountRate = a;
	
	double dr = (double)discountRate/100;
	dicountPrice = (int) Math.round(totalAmount*dr);
}
%>

<jsp:include page="/WEB-INF/jsp/market/top.jsp"/>

<h1>구매완료</h1>
<br>
총금액 : <%=totalAmount%>
<br>
할인율 : <%=discountRate%>
<br>
할인금액 : <%=dicountPrice%>
<br>
결제금액 : <%=totalAmount-dicountPrice%>
<br>
<button onclick = "location.href='https://localhost:8443/market/home'">홈으로</button>