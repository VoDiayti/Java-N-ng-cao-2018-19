use DangKyMonHoc

go

create table SINHVIEN (
	MaSV nvarchar(50) not null,
	HoTen nvarchar(50) not null,
	NgaySinh date not null,
	GioiTinh nvarchar(50)  not null,
	DiaChi nvarchar(50) not null,
	Lop nvarchar(50) not null,
	Email nvarchar(50) not null,
	SoDienThoai nvarchar(50) not null,
	
	constraint PK_SINHVIEN primary key (MaSV)
);

go

create table DANGKY (
	MaSV nvarchar(50) not null,
	MaMH nvarchar(50) not null,
	
	constraint PK_DANGKY primary key (MaSV, MaMH)
);

go

create table MONHOC (
	MaMH nvarchar(50) not null,
	TenMH nvarchar(50) not null,
	SoTinChi int not null,
	SoBuoi int not null,
	SoSVToiThieu int not null,
	SoSVToiDa int not null,
	SoSVDangKy int not null,
	NgayNhapHoc date not null,
	NgayHetHan date not null,
	
	constraint PK_MONHOC primary key (MaMH)
);

go

alter table DANGKY
add constraint FK_DANGKY_SINHVIEN foreign key (MaSV) references SINHVIEN(MaSV)
on update cascade on delete cascade

go

alter table DANGKY
add constraint FK_DANGKY_MONHOC foreign key (MaMH) references MONHOC(MaMH)
on update cascade on delete cascade

go

---------------SinhVien


insert into SINHVIEN(MaSV, HoTen, NgaySinh, GioiTinh, DiaChi, Lop, Email, SoDienThoai) values
('SV003', 'Hieu', '1999-02-16', 'Khac', 'Ha Noi', 'K41C-CNTT', 'hieu@gmail.com', '0392184456'),
('SV002', 'Vinh', '1999-02-15', 'Nu', 'Da Nang', 'K41A-CNTT', 'vinh@gmail.com', '0392184457'),
('SV001', 'Truong', '1999-02-14', 'Nam', 'Hue', 'K41B-CNTT', 'truong@gmail.com', '0392184458');
select * from SINHVIEN
---------------MonHoc


insert into MONHOC(MaMH, TenMH, SoTinChi, SoBuoi, SoSVToiThieu, SoSVToiDa, SoSVDangKy, NgayNhapHoc, NgayHetHan) values
('MH003', 'Anh van chuyen nganh', 3, 15, 40, 80, 1, '2020-12-25', '2021-01-01'),
('MH002', 'Tin  hoc dai cuong', 3, 15, 40, 80, 0, '2020-12-25', '2020-01-01'),
('MH001', 'Toan cao cap', 3, 15, 40, 80, 3, '2020-12-25', '2021-01-01');

select * from MONHOC
---------------DangKy


insert into DANGKY(MaSV, MaMH) values
('SV001', 'MH001'),
('SV001', 'MH003'),
('SV002', 'MH001'),
('SV003', 'MH001')

select * from DANGKY
