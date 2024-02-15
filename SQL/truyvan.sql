SELECT HoatDong.maHD as maHD, HoatDong.tenHD as tenHD, HoatDong.noiDung as noiDung, LoaiHoatDong.tenLHD as theLoai, 
TaiKhoan.tenTK as tenNguoiDang, HoatDong.diaDiem as diaDiem, HoatDong.anh as anh, HoatDong.soLuongDK as soLuongDK, 
HoatDong.ngayBD as ngayBD , HoatDong.ngayKT as ngayKT, HoatDong.ngayDang as ngayDang 
FROM HoatDong, LoaiHoatDong, TaiKhoan
WHERE ngayDang>GETDATE() AND HoatDong.maTheLoai = LoaiHoatDong.maLHD AND TaiKhoan.maTK=HoatDong.maNguoiDang
GO

SELECT HoatDong.maHD as maHD, HoatDong.tenHD as tenHD, HoatDong.noiDung as noiDung, LoaiHoatDong.tenLHD as theLoai, 
NguoiDang.tenTK as tenNguoiDang, HoatDong.diaDiem as diaDiem, HoatDong.anh as anh, HoatDong.soLuongDK as soLuongDK,  
HoatDong.ngayBD as ngayBD , HoatDong.ngayKT as ngayKT, HoatDong.ngayDang as ngayDang 
FROM HoatDong, LoaiHoatDong, TaiKhoan AS NguoiDang, TaiKhoan AS NguoiXem, DangKy
WHERE DangKy.maTaiKhoan = 'N21DCCN000' AND DangKy.maTaiKhoan = NguoiXem.maTK 
AND DangKy.maHoatDong=HoatDong.maHD
AND maTheLoai = LoaiHoatDong.maLHD AND NguoiDang.maTK=HoatDong.maNguoiDang
