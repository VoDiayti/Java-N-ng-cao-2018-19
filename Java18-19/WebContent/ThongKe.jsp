<%@page import="java.util.ArrayList" %>
<%@page import="java.util.Date" %>
<%@page import="java.text.DateFormat" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="bean.ThongKeBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>THI HOC KY</title>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/bootstrap-grid.css">
<link rel="stylesheet" href="css/bootstrap-reboot.css">
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">  -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<!-- <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>  -->
</head>
<body>
	<%
	ArrayList<ThongKeBean> lsTK = (ArrayList<ThongKeBean>)request.getAttribute("lsTK");
	%>
	<nav class="navbar navbar-expand-lg bg-info text-white">
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	  <div class="collapse navbar-collapse" id="navbarNav">
	    <ul class="navbar-nav">
	      <li class="nav-item active">
	        <a class="nav-link text-white" href="MonHocController">Quản lý môn học</a>
	      </li>
	      <li class="nav-item active">
	        <a class="nav-link text-white" href="ThongKeController">Thống kê</a>
	      </li>
	    </ul>
	  </div>
	</nav>
	<div class="container my-3">
		<div class="row">
			<h3>THỐNG KÊ SINH VIÊN</h3>
				<table class="table my-5">
					<thead class="bg-info text-white">
						<tr>
							<td>Mã SV</td>
							<td>Họ Tên</td>
							<td>Ngày Sinh</td>
							<td>Giới Tính</td>
							<td>Địa Chỉ</td>
							<td>Lớp</td>
							<td>Email</td>
							<td>Số Điện Thoại</td>
							<td>Tổng Số Tín Chỉ</td>
						</tr>
					</thead>
					<tbody>
						<% for(ThongKeBean tk: lsTK) { %>
							<tr>
								<td><%= tk.getMaSV() %></td>
								<td><%= tk.getHoTen() %></td>
								<td><%= tk.getNgaySinh() %></td>
								<td><%= tk.isGioiTinh() == true ? "Nam" : "Nữ" %></td>
								<td><%= tk.getDiaChi() %></td>
								<td><%= tk.getLop() %></td>
								<td><%= tk.getEmail() %></td>
								<td><%= tk.getSoDienThoai() %></td>
								<td><%= tk.getTongSoTinChi() %></td>
							</tr>
						<% } %>
					</tbody>	
				</table>
		</div>
	</div>
</body>
</html>