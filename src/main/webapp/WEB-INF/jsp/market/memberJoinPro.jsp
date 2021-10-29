<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

	<% request.setCharacterEncoding("EUC-KR"); %>
	
	<% 	
		String no = request.getParameter("no");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");

	%>
	<%		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			String jdbcUrl = "jdbc:mysql://localhost:3306/market?serverTimezone=UTC&useSSL=false";
			String dbId = "root";
			String dbPw = "1111";
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
			
			String sql = "INSERT INTO member VALUES(?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,no);
			pstmt.setString(2,id);
			pstmt.setString(3,pw);
			pstmt.setString(4,name);
			pstmt.setString(5,phone);
			pstmt.setString(6,address1);
			pstmt.setString(7,address2);
			pstmt.executeUpdate();
			conn.close();
			pstmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		response.sendRedirect("top");
	%>
