<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	request.setCharacterEncoding("EUC-KR");
	
	
	
	String log = (String)session.getAttribute("log");
	String Cartmember[]= (String[])session.getAttribute("Cartmember");
	int CartPrice[]= (int[])session.getAttribute("CartPrice");
	String CartName[]= (String[])session.getAttribute("CartName");
	String CartImg[]= (String[])session.getAttribute("CartImg");
	int CartcountList[]= (int[])session.getAttribute("CartcountList");
	int CartNumber[]= (int[])session.getAttribute("CartNumber");
	int CartSize = (int)session.getAttribute("CartSize");
	
	
	int mycartNumberList[] = new int[1000];
	String mycartBuyerList[] = new String[1000];
	String mycartItemNameList[] = new String[1000];
	int mycartBuyPriceList[] = new int[1000];
	int mycartBuyCountList[] = new int[1000];
	String mycartItemImageList[] = new String[1000];
	int mycartSize = 0;
	
	
	
	
	for(int i =0; i < CartSize; i++){
		if(log.equals(Cartmember[i])){
			mycartNumberList[mycartSize] = CartNumber[i];
			mycartBuyerList[mycartSize] = Cartmember[i];
			mycartItemNameList[mycartSize] = CartName[i];
			mycartBuyPriceList[mycartSize] = CartPrice[i];
			mycartBuyCountList[mycartSize] = CartcountList[i];
			mycartItemImageList[mycartSize] = CartImg[i];		
			mycartSize += 1;
		}
	}
	session.setAttribute("mycartItemNameList", mycartItemNameList);
	session.setAttribute("mycartBuyCountList", mycartBuyCountList);
	session.setAttribute("mycartSize", mycartSize);
	
			
	int num = 0;
	int cnt = mycartSize;
	int total = 0;
	int deliveryFee = 3000;
	
	String path = application.getContextPath();
	
%>	
	
	<h2>장바구니</h2>
	<hr size="2" color="purple" width="300">
	
	<%
		if(cnt == 0){
	%>
			<h3>장바구니에 담겨있는 상품이 없습니다.</h3>
	<%
		}else{
			
			for(int i = 0; i < mycartSize; i++){
				
	%>
				<table>
					<tr height="40">
						<td width="50" align="center">
							<font size="2"><%=++num %></font>
						</td>
						
						<td width="100" align="center">
							<img alt="" src="<%=path %>/project/img/<%=mycartItemImageList[i] %>" height="40">
						</td>
						
						<td width="300">
							<font size="3"><b><%=mycartItemNameList[i] %></b></font>
						</td>
						
						<td width="100" align="center">
							<font size = "3"><b><%=mycartBuyCountList[i] %></b></font>
						</td>
						
						<td width="100">
							<font size="3"><b><%=mycartBuyPriceList[i] * 
									mycartBuyCountList[i] %>원</b></font>
						</td>
						
						<td width="40" align="center">
							<input type="image" src="<%=path %>/project/img/delete.png" onclick="location.href='07_02_deleteCartPro.jsp?cart_number=<%=mycartNumberList[i]%>'">
						</td>
					</tr>
				</table>
	
				<hr size="1" color="gray" width="680">
	<%			
				total += mycartBuyPriceList[i] * mycartBuyCountList[i];
			}
	%>
			
			<!-- ------------------------------------------------------- -->
			
			<form method="post" action = "purchase.jsp">
				<table>
					<tr height="30">
						<td align="right" width="480" align="right">
							<h4>총 상품금액</h4>
						</td>
						
						<td align="right" width="200" align="right">
							<h4><%=total %>원</h4>
						</td>
					</tr>
					
					<tr height="30">
						<td align="right" width="480" align="right">
							<h4>배송비</h4>
						</td>
						
						<td align="right" width="200" align="right">
	<%
							if(total < 40000){
	%>
								<h4><%=deliveryFee %>원</h4>
								<font size="2" color="purple">
									<%=40000 - total %>원 추가주문 시, 무료배송
								</font>
	<%
							}else{
	%>
								<h4>0원</h4>
	<%
							}
	%>
						</td>
					</tr>
					
					<tr height="40">
						<td align="right" width="480" align="right">
							<h3>총 결제금액</h3>
						</td>
						
						<td align="right" width="200" align="right">
	<%
							if(total < 40000){
	%>
								<h3><b><%=total + deliveryFee %>원</b></h3>
	<%							
							}else{
	%>
								<h3><b><%=total %>원</b></h3>
	<%								
							}
	%>
						</td>
					</tr>
					
					<tr height="30">
						<td align="right" colspan="2">
							<input type="image" src="<%=path %>/project/img/order.PNG" name="submit" value="submit" style="height:50px">
							<input type="hidden" name="total" value=<%=total %>>
						</td>
					</tr>
				</table>
			</form>
	<%		
		}
	%>
