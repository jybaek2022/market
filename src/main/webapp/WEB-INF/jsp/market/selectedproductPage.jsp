<%@page import="javax.websocket.SendResult"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%Object id = session.getAttribute("id");
String memberId = (String) id;%>

<form action = "purchase">
<table>
	<tr>
	<td rowspan = 8> 
		<c:catch var="e" >
	  		<c:import url="../img/${product_info.getProductNo()}.jpg" var="imgSrc"/>
	  	</c:catch>
	  	<c:choose>
	  		<c:when test="${empty e}">
	  	  		<img height = "600" src="../img/${product_info.getProductNo()}.jpg">
	  		</c:when>
	  		<c:otherwise>
	    		<img src="../img/logo.png">
	  		</c:otherwise>
	  	</c:choose>
	  	</td>
	</tr>	
	<tr>
		<td>ǰ  ��  �� : ${product_info.getProductName()}</td>
	</tr>
	<tr>
		<td>ī �� �� �� : ${product_info.getProductCatCode()}</td>
	</tr>
	<tr>
		<td>ǰ �� �� �� : ${product_info.getProductDetail()}</td>
	</tr>
	<tr>
		<td>��      �� : ${product_info.getProductPrice()}</td>
	</tr>
	<tr>
		<td>��      �� : <input type = "number" name = "salesCount" value ="���ż���"><td>
	</tr>
	<tr>
		<td><button type = "submit">�����ϱ�</button></td>
		<td><button type = "submit">��ٱ��ϴ�� ��� �����ϱ�</button></td>
	</tr>
</table>
	<input type = "hidden" name = "memberId" value=<%=memberId%>>
	<input type = "hidden" name = "productNo" value="${product_info.getProductNo()}">
	<input type = "hidden" name = "productPrice" value="${product_info.getProductPrice()}">	
</form>

<br>��ǰ���亸���ֱ�