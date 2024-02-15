
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
    public List<Activity> getCurrentActivities() throws Exception{
        List<Activity> Activities = new ArrayList<>();
        String query = "SELECT HoatDong.maHD as maHD, HoatDong.tenHD as tenHD, HoatDong.noiDung as noiDung, LoaiHoatDong.tenLHD as theLoai, " +
                        "TaiKhoan.tenTK as tenNguoiDang, HoatDong.diaDiem as diaDiem, HoatDong.anh as anh, HoatDong.soLuongDK as soLuongDK, " +
                        "HoatDong.ngayBD as ngayBD , HoatDong.ngayKT as ngayKT, HoatDong.ngayDang as ngayDang " +
                        "FROM HoatDong, LoaiHoatDong, TaiKhoan " +
                        "WHERE ngayKT>GETDATE() AND HoatDong.maTheLoai = LoaiHoatDong.maLHD AND TaiKhoan.maTK=HoatDong.maNguoiDang ";
        try(
            Connection con = Helper.openConnection();
            PreparedStatement pstmt= con.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
        ){
            while(rs.next()){    
                Activity hd = new Activity();
                hd.setId(Integer.parseInt(rs.getString("maHD")));
                hd.setTitle(rs.getString("tenHD"));
                hd.setContent(rs.getString("noiDung"));
                hd.setGenre(rs.getString("theLoai"));
                
                //hd.setIdUser(rs.getString("maNguoiDang")); 
                hd.setNameUser(rs.getString("tenNguoiDang"));
                hd.setAddress(rs.getString("diaDiem"));
                System.out.print(rs.getString("ngayDang"));
                hd.setNumberOfRegistrations(Integer.parseInt(rs.getString("soLuongDK")));
                hd.setPicture(rs.getString("anh"));
                //DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-mm-dd HH:mm:ss");
                hd.setPostingTime((rs.getTimestamp("ngayDang").toLocalDateTime()));
                hd.setStartDate(rs.getTimestamp("ngayBD").toLocalDateTime());
                hd.setEndDate(rs.getTimestamp("ngayKT").toLocalDateTime());
                Activities.add(hd);
            }
            rs.close();
            pstmt.close();
            con.close();
            return Activities;
        }
            
            
    }
    public List<Activity> TakenActivities(String idAccount) throws Exception{
        List<Activity> Activities = new ArrayList<>();
        String query = "SELECT HoatDong.maHD as maHD, HoatDong.tenHD as tenHD, HoatDong.noiDung as noiDung, LoaiHoatDong.tenLHD as theLoai, " +
            "NguoiDang.tenTK as tenNguoiDang, HoatDong.diaDiem as diaDiem, HoatDong.anh as anh, HoatDong.soLuongDK as soLuongDK, " +
            "HoatDong.ngayBD as ngayBD , HoatDong.ngayKT as ngayKT, HoatDong.ngayDang as ngayDang " +
            "FROM HoatDong, LoaiHoatDong, TaiKhoan AS NguoiDang, TaiKhoan AS NguoiXem, DangKy " +
            "WHERE DangKy.maTaiKhoan=? AND DangKy.maTaiKhoan = NguoiXem.maTK " +
            "AND DangKy.maHoatDong=HoatDong.maHD " +
            "AND maTheLoai = LoaiHoatDong.maLHD AND NguoiDang.maTK=HoatDong.maNguoiDang ";
        try(
            Connection con = Helper.openConnection();
               
            PreparedStatement pstmt= con.prepareStatement(query);

        ){
            pstmt.setString(1, idAccount);
            System.out.println("asdas");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){    
                Activity hd = new Activity();
                hd.setId(Integer.parseInt(rs.getString("maHD")));
                hd.setTitle(rs.getString("tenHD"));
                hd.setContent(rs.getString("noiDung"));
                hd.setGenre(rs.getString("theLoai"));
                
                //hd.setIdUser(rs.getString("maNguoiDang")); 
                hd.setNameUser(rs.getString("tenNguoiDang"));
                hd.setAddress(rs.getString("diaDiem"));
                System.out.print(rs.getString("ngayDang"));
                hd.setNumberOfRegistrations(Integer.parseInt(rs.getString("soLuongDK")));
                hd.setPicture(rs.getString("anh"));
                //DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-mm-dd HH:mm:ss");
                hd.setPostingTime((rs.getTimestamp("ngayDang").toLocalDateTime()));
                hd.setStartDate(rs.getTimestamp("ngayBD").toLocalDateTime());
                hd.setEndDate(rs.getTimestamp("ngayKT").toLocalDateTime());
                Activities.add(hd);
            }
            System.out.println("asdas");
            rs.close();
            pstmt.close();
            con.close();
            return Activities;
        }
    }
    public void sortByID(){
    
    }
    
    public void sortByGence(){
        
    }
    
    public void searchbyID(){
        
    }
    public void search(){
        
        
    }

}
