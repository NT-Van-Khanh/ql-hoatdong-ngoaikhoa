
package ttcs.quanlyhdnk.DAO.SinhVien;

import java.sql.Connection;
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
public class ListHoatDong{
    public List<Activity> getList() throws Exception{
        List<Activity> hoatDongList = new ArrayList<>();
        String sql = "SELECT HoatDong.maHD as maHD, HoatDong.tenHD as tenHD, HoatDong.noiDung as noiDung, LoaiHoatDong.tenLHD as theLoai, " +
                        "TaiKhoan.tenTK as tenNguoiDang, HoatDong.diaDiem as diaDiem, HoatDong.anh as anh, HoatDong.soLuongDK as soLuongDK, " +
                        "HoatDong.ngayBD as ngayBD , HoatDong.ngayKT as ngayKT, HoatDong.ngayDang as ngayDang " +
                        "FROM HoatDong, LoaiHoatDong, TaiKhoan " +
                        "WHERE ngayKT>GETDATE() AND HoatDong.maTheLoai = LoaiHoatDong.maLHD AND TaiKhoan.maTK=HoatDong.maNguoiDang";
        try(
            Connection con = Helper.openConnection();
            Statement stmt= con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
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
                hoatDongList.add(hd);
            }
                return hoatDongList;
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
