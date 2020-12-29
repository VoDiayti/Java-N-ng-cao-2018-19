<%@page import="bean.MonHocBean"%>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.Date" %>
<%@page import="java.text.DateFormat" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Book Shop</title>
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
	ArrayList<MonHocBean> lsMH = (ArrayList<MonHocBean>)request.getAttribute("lsMH");
	MonHocBean mh = (MonHocBean)request.getAttribute("monhoc");							// "monhoc" : MonHocController -> line 48
	String ngayNhapHoc = "2020-09-20";
	String ngayHetHan = "2020-08-20";
	if(mh != null) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		ngayNhapHoc = df.format(mh.getNgayNhapHoc());
		ngayHetHan = df.format(mh.getNgayHetHan());
	}
	DateFormat df = new SimpleDateFormat ("dd/MM/yyyy");
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
			<div class="col-12">
				<div class="col-sm-8 offset-sm-2 my-5">
					<a class="btn btn-warning" href="MonHocController">Thêm mới</a>
					<div class="card my-5">
					  <div class="card-header bg-primary text-white">
					  	THÊM MỚI / CHỈNH SỬA MÔN HỌC
					  </div>
					  <div class="card-body">
					  	<form action="MonHocController" method="POST">
					  		<div class="form-group">
					  			<label for="">Mã Môn Học</label>
						  		<input required type="text" name="maMH" value="<%= mh != null ? mh.getMaMonHoc() : "" %>" <%= mh != null ? "readonly" : "" %> class="form-control"  />
							</div>
					  		<div class="form-group">
							    <label for="">Tên Môn Học</label>
							    <input required name="tenMH" value="<%= mh != null  ? mh.getTenMonHoc() : "" %>" type="text" class="form-control" placeholder="">
							</div>
							<div class="row">
							 	<div class="form-group col-sm-6">
							    	<label for="">Số Tín Chỉ</label>
							    	<input required name="soTC" value="<%= mh != null  ? mh.getSoTinChi() : "" %>" type="number" class="form-control"  placeholder="">
								</div>
								<div class="form-group col-sm-6">
							    	<label for="">Số Buổi</label>
							    	<input required name="soBuoi" value="<%= mh != null  ? mh.getSoBuoi() : "" %>" type="number" class="form-control"  placeholder="">
								</div>
							</div>
							
							<div class="row">
							 	<div class="form-group col-sm-6 ">
							    	<label for="">Số SV Tối Thiểu</label>
							    	<input required name="soSVTT" value="<%= mh != null ? mh.getSoSVToiThieu() : "" %>" type="number" class="form-control"  placeholder="">
								</div>
								<div class="form-group col-sm-6">
							    	<label for="">Số SV Tối Đa</label>
							    	<input required name="soSVTD" value="<%= mh != null ? mh.getSoSVToiDa() : "" %>" type="number" class="form-control"  placeholder="">
								</div>
							</div>
							
							<div class="form-group">
						    	<label for="">Số SV Đăng Ký</label>
						    	<input required name="soSVDK" value="<%= mh != null ? mh.getSoSVDangKy() : "" %>" type="number" class="form-control"  placeholder="">
							</div>
							
							<div class="row">
							 	<div class="form-group col-sm-6">
							    	<label for="">Ngày Nhập Học</label>
							    	<input required name="ngayNhapHoc" value="<%= mh != null ? ngayNhapHoc : "" %>" type="date" class="form-control"  placeholder="">
								</div>
								<div class="form-group col-sm-6">
							    	<label for="">Ngày Hết Hạn</label>
							    	<input required name="ngayHetHan" value="<%= mh != null  ? ngayHetHan : "" %>" type="date" class="form-control"  placeholder="">
								</div>
							</div>
							
							<button id="btnCreate" type="submit" name="btnCreate" class="btn btn-success">Thêm mới</button>
							<button id="btnEdit" type="submit" name="btnEdit" class="btn btn-info">Chỉnh sửa</button>
					  	</form>
					  </div>
					</div>
				</div>
				<h3>DANH SÁCH MÔN HỌC</h3>
				<table class="table my-5">
					<thead class="bg-info text-white">
						<tr>
							<td>Mã MH</td>																								<!-- 1 -->
							<td>Tên MH</td>																								<!-- 2 -->
							<td>Số Tín Chỉ</td>																							<!-- 3 -->
							<td>Số Buổi</td>																							<!-- 4 -->
							<td>Số SV Tối Thiểu</td>																					<!-- 5 -->
							<td>Số SV Tối Đa</td>																						<!-- 6 -->
							<td>Ngày Nhập Học</td>																						<!-- 7 -->
							<td>Trạng Thái</td>																							<!-- 8 -->
							<td>Thao Tác</td>																							<!-- 9 -->
						</tr>
					</thead>
					<tbody>
						<% for(MonHocBean monhoc: lsMH) { %>
							<tr>
								<td><%= monhoc.getMaMonHoc() %></td>																	<!-- 1 -->
								<td><%= monhoc.getTenMonHoc() %></td>																	<!-- 2 -->
								<td><%= monhoc.getSoTinChi() %></td>																	<!-- 3 -->
								<td><%= monhoc.getSoBuoi() %></td>																		<!-- 4 -->
								<td><%= monhoc.getSoSVToiThieu() %></td>																<!-- 5 -->
								<td><%= monhoc.getSoSVToiDa() %></td>																	<!-- 6 -->
								<td><%= monhoc.getNgayNhapHoc() %></td>																	<!-- 7 -->
								<% if(monhoc.getNgayHetHan().compareTo(new Date()) < 0) { %>											<!-- 8 -->
								<td>Đã hết hạn đăng ký</td>
								<% } else if(monhoc.getSoSVDangKy() == monhoc.getSoSVToiDa()) { %>
								<td>Đã kết thúc</td>
								<% } else { %>
								<td>Đang mời đăng ký</td>
								<% } %>
								<td>																									<!-- 9 -->
									<a href="MonHocController?maChon=<%= monhoc.getMaMonHoc() %>" class="btn btn-primary">Chọn</a>
									<a href="MonHocController?maXoa=<%= monhoc.getMaMonHoc() %>" class="btn btn-danger">Xóa</a>
								</td>
							</tr>
						<% } %>
					</tbody>	
				</table>
			</div>
		</div>
	</div>
	
	
	<script>
		<% if(request.getAttribute("checkMaMH") != null) { %>
		alert("<%= request.getAttribute("checkMaMH") %>");
		<% } %>
		
		<% if(request.getAttribute("checkXoa") != null) { %>
		alert("<%= request.getAttribute("checkXoa") %>");
		<% } %>
	</script>
	
</body>
</html>