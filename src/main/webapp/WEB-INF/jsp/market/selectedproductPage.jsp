<%@page import="javax.websocket.SendResult"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%//String productNo = request.getParameter("productNo"); %>

<table>
	<tr>
	<td rowspan = 4> 
		<c:catch var="e" >
	  		<c:import url="img/${product_info.getProductNo()}.jpg" var="imgSrc"/>
	  	</c:catch>
	  	<c:choose>
	  		<c:when test="${!empty e}">
	  	  		<img src="img/${product_info.getProductNo()}.jpg">
	  		</c:when>
	  		<c:otherwise>
	    		<img src="img/${product_info.getProductNo()}.jpg">
	  		</c:otherwise>
	  	</c:choose>
	  	</td>
	</tr>	
	<tr>
		<td>ǰ  ��  �� : ${product_info.getProductName()}</td>
	</tr>
	<tr>
		<td>ī �� �� �� : ${product_info.getProductName()}</td>
	</tr>
	<tr>
		<td>ǰ �� �� �� : ${product_info.getProductDetail()}</td>
	</tr>
	<tr>
		<td>��      �� : ${product_info.getProductPrice()}</td>
	</tr>
	
</table>
<form action = "">
	���� <input type = "number" name = "pCount" value =" ���ż���">
</form>
<button>�����ϱ�</button>
<br>��ǰ���亸���ֱ�