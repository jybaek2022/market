<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<h1>��ǰ�߰�</h1>
	<hr width="700" color="black" size="3"/>
	<br>
	<form method="post" action="addProduct" enctype="multipart/form-data">
		<table>
			<tr height="50">
				<td width="150"><b>ǰ���</b></td>
				<td width="300" align="center"><input type="text" name="pName" placeholder="ǰ��� �Է�" style="width:300px; height:30px"></td>
			</tr>
			<tr height="50">
				<td width="150"><b>ī�װ��ڵ�</b></td>
				<td width="300" align="center"><input type="number" name="pCCode" placeholder="ī�װ��ڵ�(����) �ɼǼ������ιٲ���ҵ�" style="width:300px; height:30px"></td>
			</tr>
			<tr height="50">
				<td width="150"><b>ǰ���</b></td>
				<td width="300" align="center"><input type="text" name="pDetail" placeholder="ǰ��󼼳��� �Է�" style="width:300px; height:40px"></td>
			</tr>
			<tr height="50">
				<td width="150"><b>�ܰ�</b></td>
				<td width="300" align="center"><input type="number" name="pPrice" placeholder="�ܰ� �Է�" style="width:300px; height:40px"></td>
			</tr>
			<tr height="50">
				<td width="150"><b>�ʱ� ���� ���</b></td>
				<td width="300" align="center"><input type="number" name="pStock" placeholder="�ʱ⼼�� ���� �Է�" style="width:300px; height:40px"></td>
			</tr>
			<tr height="50">
				<td width="150"><b>����(�Ǹ���orX)</b></td>
				<td width="300" align="center"><input type="text" name="pStatus" placeholder="ǰ�� ���� �Է�(�Ǹ���-����, �Ǹ������-N)" style="width:300px; height:40px"></td>
			</tr>
			<tr height="50">
				<td width="150"><b>�̹���</b></td>
				<td width="300" align="center"><input type="text" name="pImgSrc" placeholder="�̹��� �ּ�" style="width:300px; height:40px"></td>
			</tr>
		</table>
	
		<table>
			<tr height="50">
				<td colspan="2" align="center"><br>
					<button type="submit">��ǰ�߰�</button>
				</td>
			</tr>
		</table>
	</form>
