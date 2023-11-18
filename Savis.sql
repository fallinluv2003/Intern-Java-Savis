CREATE DATABASE AssignmentJava5
USE AssignmentJava5
GO

-- Account
CREATE TABLE account(
id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
tai_khoan VARCHAR(30),
mat_khau VARCHAR(MAX) DEFAULT NULL,
email VARCHAR(50),
ngay_tao DATE,
trang_thai INT
)
GO

-- ChucVu
CREATE TABLE chuc_vu(
id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
ma VARCHAR(20) UNIQUE,
ten NVARCHAR(50) DEFAULT NULL,
ngay_tao DATE,
ngay_sua DATE,
trang_thai INT
)
GO

INSERT INTO chuc_vu(ma,ten,ngay_tao,ngay_sua,trang_thai) VALUES('NV1', N'Nhân viên tư vấn',GETDATE(),GETDATE(),1)

-- NhanVien
CREATE TABLE nhan_vien(
id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
ma VARCHAR(20) UNIQUE,
ten NVARCHAR(30) DEFAULT NULL,
ten_dem NVARCHAR(30) DEFAULT NULL,
ho NVARCHAR(30) DEFAULT NULL,
gioi_tinh BIT NULL,
ngay_sinh DATE DEFAULT NULL,
dia_chi NVARCHAR(100) DEFAULT NULL,
sdt VARCHAR(30) DEFAULT NULL,
id_chuc_vu UNIQUEIDENTIFIER,
id_gui_bc UNIQUEIDENTIFIER,
trang_thai INT
)
GO

INSERT INTO nhan_vien(ma,ten,ten_dem,ho,gioi_tinh,ngay_sinh,dia_chi,sdt,id_chuc_vu,trang_thai) VALUES('NV1', N'Đạt',N'Thành',N'Bùi',1,'2003-12-19',N'Hà Nội','0123456789','E7CA84AE-D9B7-45F1-A62C-576F9A634119',1)

-- ChatLieu
CREATE TABLE chat_lieu(
id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
ma VARCHAR(20) UNIQUE,
ten NVARCHAR(30),
ngay_tao DATE,
ngay_sua Date,
trang_thai INT
)
GO
INSERT INTO chat_lieu(ma,ten,ngay_tao,ngay_sua,trang_thai) VALUES ('CL1',N'Lông cừu',GETDATE(),GETDATE(),1),
							('CL2',N'Da nhân tạo',GETDATE(),GETDATE(),1)
INSERT INTO chat_lieu(ma,ten,ngay_tao,ngay_sua,trang_thai) VALUES ('CL7',N'6% Polyurethane, 94% polyamid',GETDATE(),GETDATE(),1)

-- Brand
CREATE TABLE brand(
id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
ma VARCHAR(20) UNIQUE,
ten NVARCHAR(30),
ngay_tao DATE,
ngay_sua Date,
trang_thai INT
)
GO
INSERT INTO brand(ma,ten,ngay_tao,ngay_sua,trang_thai) VALUES ('B1','MLB',GETDATE(),GETDATE(),1),
							('B2','COACH',GETDATE(),GETDATE(),1)
INSERT INTO brand(ma,ten,ngay_tao,ngay_sua,trang_thai) VALUES ('B8',N'KARL LAGERFELD',GETDATE(),GETDATE(),1)
SELECT * FROM brand

-- MauSac
CREATE TABLE mau_sac(
id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
ma VARCHAR(20) UNIQUE,
ten NVARCHAR(30),
ngay_tao DATE,
ngay_sua Date,
trang_thai INT
)
GO
INSERT INTO mau_sac(ma,ten,ngay_tao,ngay_sua,trang_thai) VALUES ('M1',N'Hồng',GETDATE(),GETDATE(),1),
							('M2',N'Trắng',GETDATE(),GETDATE(),1)
INSERT INTO mau_sac(ma,ten,ngay_tao,ngay_sua,trang_thai) VALUES ('DM7',N'Trắng kem',GETDATE(),GETDATE(),1)
SELECT * FROM mau_sac

-- DongSP
CREATE TABLE danh_muc(
id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
ma VARCHAR(20) UNIQUE,
ten NVARCHAR(30),
ngay_tao DATE,
ngay_sua Date,
trang_thai INT
)
GO

-- ChiTietSP
CREATE TABLE chi_tiet_sp(
id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
ma VARCHAR(20),
ten_sp NVARCHAR(MAX),
id_brand UNIQUEIDENTIFIER,
id_mau_sac UNIQUEIDENTIFIER,
id_danh_muc UNIQUEIDENTIFIER,
id_chat_lieu UNIQUEIDENTIFIER,
image VARCHAR(50),
so_luong INT,
gia_nhap DECIMAL(20,0) DEFAULT 0,
gia_ban DECIMAL(20,0) DEFAULT 0,
mo_ta NVARCHAR(MAX) DEFAULT NULL,
trang_thai INT
)
GO

SELECT * FROM brand
SELECT * FROM mau_sac
SELECT * FROM danh_muc
SELECT * FROM chat_lieu
SELECT * FROM chi_tiet_sp

-- KhachHang
CREATE TABLE khach_hang(
id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
ma VARCHAR(20) UNIQUE,
ho_va_ten NVARCHAR(30) NULL,
sdt VARCHAR(30) DEFAULT NULL,
dia_chi NVARCHAR(100) DEFAULT NULL,
thanh_pho NVARCHAR(50) DEFAULT NULL,
quoc_gia NVARCHAR(50) DEFAULT NULL,
)
GO


INSERT INTO khach_hang(ma,ho_va_ten,sdt,dia_chi,thanh_pho,quoc_gia)
VALUES ('KH1', N'Bùi Thành Đạt', '0922505266', N'Phương Canh', N'Hà Nội', N'Việt Nam')
SELECT * FROM khach_hang
GO

--GioHang
CREATE TABLE gio_hang(
id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
id_kh UNIQUEIDENTIFIER,
id_chi_tiet_sp UNIQUEIDENTIFIER,
so_luong INT,
don_gia DECIMAL(20,0) DEFAULT 0,
trang_thai INT,
CONSTRAINT FK1_IdKhachHang FOREIGN KEY(id_kh) REFERENCES khach_hang(id),
CONSTRAINT FK2_IdChiTietSP FOREIGN KEY(id_chi_tiet_sp) REFERENCES chi_tiet_sp(id),
)
GO

SELECT * FROM gio_hang

--HoaDon
CREATE TABLE hoa_don(
id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
id_kh UNIQUEIDENTIFIER,
--id_nv UNIQUEIDENTIFIER,
ma VARCHAR(20) UNIQUE,
ngay_tao DATE DEFAULT NULL,
ngay_thanh_toan DATE DEFAULT NULL,
ngay_ship DATE DEFAULT NULL,
ngay_nhan DATE DEFAULT NULL,
nguoi_nhan NVARCHAR(50) DEFAULT NULL,
dia_chi NVARCHAR(100) DEFAULT NULL,
sdt VARCHAR(30) DEFAULT NULL,
trang_thai INT
)
GO
/*SELECT * FROM NhanVien
SELECT * FROM HoaDon
DELETE FROM HoaDon WHERE Id = 'FC314DA7-D6C4-494D-B31A-B02DBF1F36A2'
*/

-- HoaDonChiTiet
CREATE TABLE hoa_don_chi_tiet(
id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
id_hoa_don UNIQUEIDENTIFIER,
id_chi_tiet_sp UNIQUEIDENTIFIER,
so_luong INT,
don_gia DECIMAL(20,0) DEFAULT 0,
trang_thai INT,
CONSTRAINT FK1 FOREIGN KEY(id_hoa_don) REFERENCES hoa_don(id),
CONSTRAINT FK2 FOREIGN KEY(id_chi_tiet_sp) REFERENCES chi_tiet_sp(id),
)
GO

SELECT * FROM khach_hang
SELECT * FROM hoa_don
SELECT * FROM hoa_don_chi_tiet
SELECT * FROM gio_hang
SELECT * FROM chi_tiet_sp
SELECT * FROM nhan_vien


--TẠO QUAN HỆ GIỮA CÁC BẢNG
--NhanVien - ChucVu
ALTER TABLE nhan_vien ADD FOREIGN KEY (id_chuc_vu) REFERENCES chuc_vu(id)
--GioHang - KhachHang
ALTER TABLE gio_hang ADD FOREIGN KEY (id_kh) REFERENCES khach_hang(id)
-- HoaDon - KhachHang
ALTER TABLE hoa_don ADD FOREIGN KEY (id_kh) REFERENCES khach_hang(id)
-- HoaDon - NhanVien
ALTER TABLE hoa_don ADD FOREIGN KEY (id_nv) REFERENCES nhan_vien(id)
-- ChiTietSP - Brand
ALTER TABLE chi_tiet_sp ADD FOREIGN KEY(id_brand) REFERENCES brand(id)
-- ChiTietSP - MauSac
ALTER TABLE chi_tiet_sp ADD FOREIGN KEY(id_mau_sac) REFERENCES mau_sac(id)
-- ChiTietSP - DanhMuc
ALTER TABLE chi_tiet_sp ADD FOREIGN KEY(id_danh_muc) REFERENCES danh_muc(id)
-- ChiTietSP - ChatLieu
ALTER TABLE chi_tiet_sp ADD FOREIGN KEY(id_chat_lieu) REFERENCES chat_lieu(id)

/*SELECT * FROM DongSP
SELECT * FROM SanPham
SELECT * FROM MauSac
SELECT * FROM NSX
SELECT * FROM ChiTietSP
*/