/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ttcs.quanlyhdnk.DAO.SinhVien;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import ttcs.quanlyhdnk.model.Activity;
import ttcs.quanlyhdnk.model.DangKy;
import ttcs.quanlyhdnk.util.Helper;

/**
 *
 * @author ADMIN
 */
public class StudentRegister {
    private final String queryTakenActivities="SELECT DangKy.maDK, DangKy.thoiGian, HoatDong.*, " +
            "NguoiDang.tenTK AS tenNguoiDang, LoaiHoatDong.tenLHD AS theLoai " +
            "FROM DangKy " +
            "JOIN HoatDong " +
            "ON DangKy.flagDK=0 AND DangKy.maTaiKhoan =? " + 
            "AND HoatDong.ngayKT>=GETDATE() AND DangKy.maHoatDong = HoatDong.maHD " +
            "JOIN (SELECT maTK, tenTK FROM TaiKhoan WHERE flagTK =0) AS NguoiDang " +
            "ON HoatDong.maNguoiDang = NguoiDang.maTK  " +
            "JOIN LoaiHoatDong " +
            "ON HoatDong.maTheLoai= LoaiHoatDong.maLHD ";
    
    private final String queryParticipationHistory = "SELECT DangKy.maDK, DangKy.thoiGian, HoatDong.* , " +
            "NguoiDang.tenTK AS tenNguoiDang, " +
            "LoaiHoatDong.tenLHD AS theLoai " +
            "FROM DangKy " +
            "JOIN HoatDong " +
            "ON DangKy.flagDK=0 AND DangKy.maTaiKhoan =? " +
            "AND HoatDong.ngayKT > GETDATE() AND DangKy.maHoatDong = HoatDong.maHD " +
            "JOIN (SELECT maTK, tenTK FROM TaiKhoan WHERE flagTK =0) AS NguoiDang " +
            "ON HoatDong.maNguoiDang = NguoiDang.maTK " +
            "JOIN LoaiHoatDong " +
            "ON HoatDong.maTheLoai= LoaiHoatDong.maLHD ";
    private final String querySoluongDaDK="Select COUNT(*) AS SoLuongDaDK " +
            "FROM DangKy " +
            "WHERE DangKy.maHoatDong=?";
    
    
    private DangKy getRegisterDB(ResultSet rs, String idAcount) throws Exception{
        DangKy dangKy = new DangKy();
        //String checknull;
        dangKy.setIdAcountRegister(idAcount);
        dangKy.setId(Integer.parseInt(rs.getString("maDK")));
        dangKy.setRegistrationsTime(rs.getTimestamp("thoiGian").toLocalDateTime());
        dangKy.getActivity().getActivityDB(rs);
        return dangKy;
    }
    
    public List<DangKy> getTakenActivities(String idAccount) throws Exception{
        List<DangKy> dsDangKy = new ArrayList<>();
        String query = queryTakenActivities;
        try(
            Connection con = Helper.openConnection();  
            PreparedStatement pstmt= con.prepareStatement(query);
        ){
            pstmt.setString(1, idAccount);
            
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){    
                DangKy dk = new DangKy();
                dk = getRegisterDB(rs,idAccount);
                dsDangKy.add(dk);
            }
            rs.close();
            pstmt.close();
            con.close();
        }
        return dsDangKy;
    }
    
    public boolean checkRegisterDB(String idAccount,int idActivity) throws Exception{
        String query ="SELECT * FROM DangKy WHERE maTaiKhoan=? AND maHoatDong=? AND flagDK = 1 ";
        Connection con = Helper.openConnection();
        
        PreparedStatement pstmt = con.prepareCall(query);
        pstmt.setString(1,idAccount);
        pstmt.setInt(2, idActivity);
        ResultSet rs =pstmt.executeQuery();
        return rs.next();
    }
    
    public boolean updateRegisterDB(String idAccount,int idActivity) throws Exception{
        String query ="UPDATE DangKy SET flagDK = 0 WHERE maTaiKhoan=? AND maHoatDong =? ";
        Connection con = Helper.openConnection();
        PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setString(1,idAccount);
        pstmt.setInt(2, idActivity);
        return pstmt.executeUpdate()>0;
    }
    
    public boolean insertRegisterDB(String idAccount,int idActivity) throws Exception{
        String query ="INSERT INTO DangKy(maHoatDong,maTaiKhoan) VALUES(?,?)";
        Connection con = Helper.openConnection();
        PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setInt(1, idActivity);
        pstmt.setString(2, idAccount);
        
        return pstmt.executeUpdate()>0;
    }
    
    public boolean cancelRegisierDB(String idAccount,int idActivity) throws Exception{
        String query ="UPDATE DangKy SET flagDK = 1 WHERE maTaiKhoan=? AND maHoatDong =? ";
        Connection con = Helper.openConnection();
        PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setString(1,idAccount);
        pstmt.setInt(2, idActivity);
        return pstmt.executeUpdate()>0;
    }
    
    public List<DangKy> sortForTA(String idAccount,String byOpject) throws Exception{
        List<DangKy> dsDangKy = new ArrayList<>();
        String querySort= " ORDER BY ? ";
        String query = queryTakenActivities + querySort;
        try(
            Connection con = Helper.openConnection();  
            PreparedStatement pstmt= con.prepareStatement(query);

        ){
            pstmt.setString(1, idAccount);
            pstmt.setString(2, byOpject);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){    
                DangKy dk = new DangKy();
                dk = getRegisterDB(rs,idAccount);
                dsDangKy.add(dk);
            }
            rs.close();
            pstmt.close();
            con.close();
        }
        return dsDangKy;
    }
    
    public List<DangKy> getParticipationHistory(String idAccount) throws Exception{
        List<DangKy> dsDangKy = new ArrayList<>();
        String query = queryParticipationHistory;
        try(
            Connection con = Helper.openConnection();  
            PreparedStatement pstmt= con.prepareStatement(query);

        ){
            pstmt.setString(1, idAccount);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){    
                DangKy dk = new DangKy();
                dk = getRegisterDB(rs,idAccount);
                dsDangKy.add(dk);
            }
            rs.close();
            pstmt.close();
            con.close();
        }
        return dsDangKy;
    }
    
    public List<DangKy> sortForPH(String idAccount,String byOpject) throws Exception{
        List<DangKy> dsDangKy = new ArrayList<>();
        String querySort= " ORDER BY ? ";
        String query = queryParticipationHistory + querySort;
        try(
            Connection con = Helper.openConnection();  
            PreparedStatement pstmt= con.prepareStatement(query);

        ){
            pstmt.setString(1, idAccount);
            pstmt.setString(2, byOpject);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){    
                DangKy dk = new DangKy();
                dk = getRegisterDB(rs,idAccount);
                dsDangKy.add(dk);
            }
            
            rs.close();
            pstmt.close();
            con.close();
        }
        return dsDangKy;
    }
}


