<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page="/WEB-INF/jsp/market/admin_main_temp.jsp"/>

<div align="center">
<h1>상품추가</h1>
	<hr width="700" color="black" size="3"/>
	<br>
	<form method="post" action="addProduct" enctype="multipart/form-data">
		<table>
			<tr height="50">
				<td width="150"><b>품목명</b></td>
				<td width="300" align="center"><input type="text" name="pName" placeholder="품목명 입력" style="width:300px; height:30px"></td>
			</tr>
			<tr height="50">
				<td width="150"><b>카테고리코드</b></td>
				<td width="300" align="center"><input type="number" name="pCCode" placeholder="카테고리코드(숫자) 옵션선택으로바꿔야할듯" style="width:300px; height:30px"></td>
			</tr>
			<tr height="50">
				<td width="150"><b>품목상세</b></td>
				<td width="300" align="center"><input type="text" name="pDetail" placeholder="품목상세내용 입력" style="width:300px; height:40px"></td>
			</tr>
			<tr height="50">
				<td width="150"><b>단가</b></td>
				<td width="300" align="center"><input type="number" name="pPrice" placeholder="단가 입력" style="width:300px; height:40px"></td>
			</tr>
			<tr height="50">
				<td width="150"><b>초기 세팅 재고</b></td>
				<td width="300" align="center"><input type="number" name="pStock" placeholder="초기세팅 재고수 입력" style="width:300px; height:40px"></td>
			</tr>
			<tr height="50">
				<td width="150"><b>상태(판매중orX)</b></td>
				<td width="300" align="center"><input type="text" name="pStatus" placeholder="품목 상태 입력(판매중-공백, 판매종료시-N)" style="width:300px; height:40px"></td>
			</tr>
			<tr height="50">
				<td width="150"><b>이미지</b></td>
				<td width="300" align="center"><input type="text" name="pImgSrc" placeholder="이미지 주소" style="width:300px; height:40px"></td>
			</tr>
		</table>
	
		<table>
			<tr height="50">
				<td colspan="2" align="center"><br>
					<button type="submit">상품추가</button>
				</td>
			</tr>
		</table>
	</form>
</div>