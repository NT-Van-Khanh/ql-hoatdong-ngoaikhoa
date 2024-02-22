USE [QuanLyHDNK]
GO

DELETE FROM ThongBao
GO

DELETE FROM  DangKy
GO

DELETE FROM HoatDong
GO

DELETE FROM TaiKhoan
GO

DELETE FROM LoaiHoatDong
GO

DELETE FROM VaiTro
GO

INSERT VaiTro(maVT, tenVT) VALUES('SV', N'Sinh viên')
INSERT VaiTro(maVT, tenVT) VALUES('ND', N'Người đăng bài')
INSERT VaiTro(maVT, tenVT) VALUES('QL', N'Quản lí hệ thống')
GO

INSERT LoaiHoatDong(maLHD, tenLHD) VALUES('LB', N'Câu lạc bộ')
INSERT LoaiHoatDong(maLHD, tenLHD) VALUES('TN', N'Tình nguyện')
INSERT LoaiHoatDong(maLHD, tenLHD) VALUES('HN', N'Hướng nghiệp')
INSERT LoaiHoatDong(maLHD, tenLHD) VALUES('DH', N'Đoàn hội')
INSERT LoaiHoatDong(maLHD, tenLHD) VALUES('SK', N'Sự kiện')
INSERT LoaiHoatDong(maLHD, tenLHD) VALUES('KH', N'Khóa học')
INSERT LoaiHoatDong(maLHD, tenLHD) VALUES('NC', N'Nghiên cứu')
GO

INSERT TaiKhoan(maTK, matKhau, tenTK, maVaiTro, email, sdt, diaChi, ngaySinh, gioiTinh)
VALUES('ADMIN','123456',N'Quản lý hệ thống','QL','admin@gmail.com','0123456789',NULL,'12-01-2000',NULL)
INSERT TaiKhoan(maTK, matKhau, tenTK, maVaiTro, email, sdt, diaChi, ngaySinh, gioiTinh)
VALUES('CLBA1','123456',N'Thư kí câu lạc bộ A-1','ND','clba@gmail.com','0123456788',NULL,'12-01-2000',NULL)
INSERT TaiKhoan(maTK, matKhau, tenTK, maVaiTro, email, sdt, diaChi, ngaySinh, gioiTinh)
VALUES('CLBB1','123456',N'Thư kí câu lạc bộ B-1','ND','clbb@gmail.com','0123456777',NULL,'5-11-2000',NULL)
INSERT TaiKhoan(maTK, matKhau, tenTK, maVaiTro, email, sdt, diaChi, ngaySinh, gioiTinh)
VALUES('N21DCCN000','123456',N'NGUYEN A','SV', 'n21dccn000@gmail.com','0123456666',NULL,'12-01-2003',1)
GO

INSERT HoatDong(tenHD, maTheLoai, noiDung, ngayBD, ngayKT, soLuongDK, maNguoiDang, diaDiem, anh)
VALUES(N'Khóa ôn tập thi cuối kì môn A','KH',
	N'Khóa ôn tập thi cuối kì do CLB A tổ chức, dành cho các bạn sinh viên muốn ôn thi môn A','12-02-2024',
	'12-04-2024',5,'CLBA1','Phong AAA',NULL)

INSERT HoatDong(tenHD, maTheLoai, noiDung, ngayBD, ngayKT, soLuongDK, maNguoiDang, diaDiem, anh)
VALUES(N'Khóa ôn tập thi cuối kì môn B','KH',
	N'Khóa ôn tập thi cuối kì do CLB A tổ chức, dành cho các bạn sinh viên muốn ôn thi môn B','02-22-2024',
	'02-25-2024',10,'CLBB1','Phong B',NULL)

INSERT HoatDong(tenHD, maTheLoai, noiDung, ngayBD, ngayKT, soLuongDK, maNguoiDang, diaDiem, anh)
VALUES(N'Khóa ôn tập thi cuối kì môn A', 'TN',
	N'Khóa ôn tập thi cuối kì do CLB A tổ chức, dành cho các bạn sinh viên muốn ôn thi môn C','04-20-2024',
	'06-01-2024',5,'CLBB1','Phong A1',NULL)
GO
INSERT DangKy(maHoatDong,maTaiKhoan)
VALUES(10,'N21DCCN000')