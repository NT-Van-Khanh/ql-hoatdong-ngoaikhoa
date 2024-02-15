USE [QuanLyHDNK]
GO

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

DELETE FROM DonVi
GO

DELETE FROM LoaiHoatDong
GO

DELETE FROM VaiTro
GO

INSERT VaiTro(maVT, tenVT) VALUES('SV', N'Sinh viên')
INSERT VaiTro(maVT, tenVT) VALUES('ND', N'Người đăng bài')
INSERT VaiTro(maVT, tenVT) VALUES('QL', N'Quản lí hệ thống')
GO

INSERT DonVi(maDV, tenDV) VALUES('D21CQCN01-N', N'Công nghệ thông tin 1-2021')
INSERT DonVi(maDV, tenDV) VALUES('D21CQCN02-N', N'Công nghệ thông tin 2-2021')
INSERT DonVi(maDV, tenDV) VALUES('D20CQAT01-N', N'An toàn  thông tin 1-2020')
INSERT DonVi(maDV, tenDV) VALUES('D20CQCN02-N', N'Công nghệ thông tin 2-2020')
INSERT DonVi(maDV, tenDV) VALUES('CLBA', N'Câu lạc bộ A')
INSERT DonVi(maDV, tenDV) VALUES('CLBB', N'Câu lạc bộ B')
INSERT DonVi(maDV, tenDV) VALUES('QL', N'Quản lí phần mềm')
GO

INSERT LoaiHoatDong(maLHD, tenLHD) VALUES('LB', N'Câu lạc bộ')
INSERT LoaiHoatDong(maLHD, tenLHD) VALUES('TN', N'Tình nguyện')
INSERT LoaiHoatDong(maLHD, tenLHD) VALUES('HN', N'Hướng nghiệp')
INSERT LoaiHoatDong(maLHD, tenLHD) VALUES('LE', N'Lễ')
INSERT LoaiHoatDong(maLHD, tenLHD) VALUES('KH', N'Khóa học')
INSERT LoaiHoatDong(maLHD, tenLHD) VALUES('NC', N'Nghiên cứu')
GO

INSERT TaiKhoan(maTK, matKhau, tenTK, maVaiTro, maDonVi, email, sdt, diaChi, ngaySinh, gioiTinh)
VALUES('TKCLBA1','123456',N'Thư kí câu lạc bộ A-1','ND','CLBA','clba@gmail.com','0123456789',NULL,'12-01-2000',NULL)
INSERT TaiKhoan(maTK, matKhau, tenTK, maVaiTro, maDonVi, email, sdt, diaChi, ngaySinh, gioiTinh)
VALUES('N21DCCN000','123456',N'NGUYEN A','SV','D21CQCN01-N','abc@gmail.com','0123456789',NULL,'12-01-2000',NULL)
GO

INSERT HoatDong(tenHD, maTheLoai, noiDung, ngayBD, ngayKT, soLuongDK, maNguoiDang, diaDiem, anh)
VALUES(N'Khóa ôn tập thi cuối kì môn A','KH',
	N'Khóa ôn tập thi cuối kì do CLB A tổ chức, dành cho các bạn sinh viên muốn ôn thi môn A','12-02-2024',
	'12-04-2024',5,'TKCLBA1','Phong AAA',NULL)
INSERT HoatDong(tenHD, maTheLoai, noiDung, ngayBD, ngayKT, soLuongDK, maNguoiDang, diaDiem, anh)
VALUES(N'Khóa ôn tập thi cuối kì môn B','KH',
	N'Khóa ôn tập thi cuối kì do CLB A tổ chức, dành cho các bạn sinh viên muốn ôn thi môn B','02-16-2024',
	'02-17-2024',5,'TKCLBA1','Phong AAA',NULL)
GO
INSERT DangKy(maHoatDong,maTaiKhoan)
VALUES(15,'N21DCCN000')