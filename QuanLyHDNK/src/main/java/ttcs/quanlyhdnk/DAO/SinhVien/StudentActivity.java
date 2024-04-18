
package ttcs.quanlyhdnk.DAO.SinhVien;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import ttcs.quanlyhdnk.model.Activity;
import ttcs.quanlyhdnk.util.Helper;
import ttcs.quanlyhdnk.util.DateTimeUtil;
public class StudentActivity{
//    private final String queryCurrentActivities = "SELECT HoatDong.maHD as maHD, HoatDong.tenHD as tenHD, HoatDong.noiDung as noiDung, LoaiHoatDong.tenLHD as theLoai, " +
//            "TaiKhoan.tenTK as tenNguoiDang, HoatDong.diaDiem as diaDiem, HoatDong.anh as anh, HoatDong.soLuongDK as soLuongDK, " +
//            "HoatDong.ngayBD as ngayBD , HoatDong.ngayKT as ngayKT, HoatDong.ngayDang as ngayDang " +
//            "FROM HoatDong, LoaiHoatDong, TaiKhoan " +
//            "WHERE ngayKT>GETDATE() AND HoatDong.maTheLoai = LoaiHoatDong.maLHD AND TaiKhoan.maTK=HoatDong.maNguoiDang ";
//    private final String queryTakenActivities="SELECT HoatDong.maHD as maHD, HoatDong.tenHD as tenHD, HoatDong.noiDung as noiDung, LoaiHoatDong.tenLHD as theLoai, " +
//            "NguoiDang.tenTK as tenNguoiDang, HoatDong.diaDiem as diaDiem, HoatDong.anh as anh, HoatDong.soLuongDK as soLuongDK, " +
//            "HoatDong.ngayBD as ngayBD , HoatDong.ngayKT as ngayKT, HoatDong.ngayDang as ngayDang " +
//            "FROM HoatDong, LoaiHoatDong, TaiKhoan AS NguoiDang, TaiKhoan AS NguoiXem, DangKy " +
//            "WHERE DangKy.maTaiKhoan=? AND ngayKT>=GETDATE() AND DangKy.maTaiKhoan = NguoiXem.maTK " +
//            "AND DangKy.maHoatDong=HoatDong.maHD " +
//            "AND maTheLoai = LoaiHoatDong.maLHD AND NguoiDang.maTK=HoatDong.maNguoiDang ";    
    
    private final String queryCurrentActivities = "SELECT HoatDong.*, " +
            "TaiKhoan.tenTK as tenNguoiDang, " +
            "LoaiHoatDong.tenLHD as theLoai "+
            "FROM HoatDong, LoaiHoatDong, TaiKhoan " +
            "WHERE HoatDong.ngayKT>GETDATE() AND HoatDong.maTheLoai = LoaiHoatDong.maLHD AND TaiKhoan.maTK=HoatDong.maNguoiDang ";
    
    private final String queryTakenActivities="SELECT DangKy.maDK, DangKy.thoiGian, HoatDong.*, " +
            "NguoiDang.tenTK AS tenNguoiDang, LoaiHoatDong.tenLHD AS theLoai " +
            "FROM DangKy " +
            "JOIN HoatDong " +
            "ON DangKy.maTaiKhoan =? AND HoatDong.ngayKT>=GETDATE() AND DangKy.maHoatDong = HoatDong.maHD " +
            "JOIN (SELECT TaiKhoan.maTK, TaiKhoan.tenTK FROM TaiKhoan) AS NguoiDang " +
            "ON HoatDong.maNguoiDang = NguoiDang.maTK  " +
            "JOIN LoaiHoatDong " +
            "ON HoatDong.maTheLoai= LoaiHoatDong.maLHD ";
    
    private final String queryParticipationHistory = "SELECT HoatDong.maHD as maHD, HoatDong.tenHD as tenHD, HoatDong.noiDung as noiDung, LoaiHoatDong.tenLHD as theLoai, " +
            "NguoiDang.tenTK as tenNguoiDang, HoatDong.diaDiem as diaDiem, HoatDong.anh as anh, HoatDong.soLuongDK as soLuongDK, " +
            "HoatDong.ngayBD as ngayBD , HoatDong.ngayKT as ngayKT, HoatDong.ngayDang as ngayDang " +
            "FROM HoatDong, LoaiHoatDong, TaiKhoan AS NguoiDang, TaiKhoan AS NguoiXem, DangKy " +
            "WHERE DangKy.maTaiKhoan=? AND ngayKT<GETDATE() AND DangKy.maTaiKhoan = NguoiXem.maTK " +
            "AND DangKy.maHoatDong=HoatDong.maHD " +
            "AND maTheLoai = LoaiHoatDong.maLHD AND NguoiDang.maTK=HoatDong.maNguoiDang ";
    
    private Activity getActivity(ResultSet rs) throws Exception{
        Activity activity = new Activity();
        String checknull;
        activity.setId(Integer.parseInt(rs.getString("maHD")));
        activity.setTitle(rs.getString("tenHD"));
        activity.setContent(rs.getString("noiDung"));
        activity.setGenre(rs.getString("theLoai"));
                 
        activity.setNameUser(rs.getString("tenNguoiDang"));
        activity.setAddress(rs.getString("diaDiem"));

        checknull=rs.getString("soLuongDK");
        if(checknull!=null) activity.setNumberOfRegistrations(Integer.parseInt(checknull));
        else activity.setNumberOfRegistrations(0);
        activity.setPicture(rs.getString("anh"));
        activity.setPostingTime((rs.getTimestamp("ngayDang").toLocalDateTime()));
        activity.setStartDate(rs.getTimestamp("ngayBD").toLocalDateTime());
        activity.setEndDate(rs.getTimestamp("ngayKT").toLocalDateTime());
        return activity;
    }
    
    private Activity getTakenActivities(ResultSet rs) throws Exception{
        Activity activity = new Activity();
        activity= getActivity(rs);
        return activity;
    }
    public List<Activity> getCurrentActivities() throws Exception{
        List<Activity> Activities = new ArrayList<>();
        String query = queryCurrentActivities;
        try(
            Connection con = Helper.openConnection();
            PreparedStatement pstmt= con.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
        ){
            while(rs.next()){    
                Activity hd = new Activity();
                hd = getActivity(rs);
                Activities.add(hd);
            }
            rs.close();
            pstmt.close();
            con.close();
        }
        return Activities;    
            
    }
    
    public List<Activity> getTakenActivities(String idAccount) throws Exception{
        List<Activity> activities = new ArrayList<>();
        String query = queryTakenActivities;
        try(
            Connection con = Helper.openConnection();  
            PreparedStatement pstmt= con.prepareStatement(query);

        ){
            pstmt.setString(1, idAccount);
            
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){    
                Activity hd = new Activity();
                hd = getActivity(rs);
                activities.add(hd);
            }
           
            rs.close();
            pstmt.close();
            con.close();
        }
        return activities;
    }
   
    public List<Activity> getParticipationHistory(String idAccount) throws Exception{
        List<Activity> activities = new ArrayList<>();
        String query = queryParticipationHistory;
        try(
            Connection con = Helper.openConnection();  
            PreparedStatement pstmt= con.prepareStatement(query);

        ){
            pstmt.setString(1, idAccount);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){    
                Activity hd = new Activity();
                hd = getActivity(rs);
                activities.add(hd);
            }
            
            rs.close();
            pstmt.close();
            con.close();
        }
        return activities;
    }
    
    public List<Activity> sortForPH(String idAccount,String byOpject) throws Exception{
        List<Activity> activities = new ArrayList<>();
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
                Activity hd = new Activity();
                hd = getActivity(rs);
                activities.add(hd);
            }
            
            rs.close();
            pstmt.close();
            con.close();
        }
        return activities;
    }
    
    public List<Activity> sortForTA(String idAccount,String byOpject) throws Exception{
        List<Activity> activities = new ArrayList<>();
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
                Activity hd = new Activity();
                hd = getActivity(rs);
                activities.add(hd);
            }
            
            rs.close();
            pstmt.close();
            con.close();
        }
        return activities;
    }
    
    public List<Activity> sortForCA(String byOpject) throws Exception{
        List<Activity> activities = new ArrayList<>();
        String querySort= " ORDER BY ? ";
        String query = queryCurrentActivities + querySort;
        try(
            Connection con = Helper.openConnection();  
            PreparedStatement pstmt= con.prepareStatement(query);

        ){
            pstmt.setString(1, byOpject);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){    
                Activity hd = new Activity();
                hd = getActivity(rs);
                activities.add(hd);
            }
            
            rs.close();
            pstmt.close();
            con.close();
        }
        return activities;
    }
    
    public void searchbyID(String id){
        
    }
    public void search(){
        
        
    }

}
