use [QuanLyHDNK]
GO

alter table [TaiKhoan]
ADD CONSTRAINT fk_tk_donvi FOREIGN KEY (donVi) REFERENCES DonVi(maDV)
go