/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ttcs.quanlyhdnk.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import ttcs.quanlyhdnk.model.DangKy;
import ttcs.quanlyhdnk.model.ThongBao;
import ttcs.quanlyhdnk.util.Helper;

public class NotificationData {
    private final String queryGetNotification ="SELECT ThongBao.*,TaiKhoan.tenTK " +
                        "FROM ThongBao " +
                        "JOIN   (SELECT HoatDong.maHD " +
                        "	FROM HoatDong " +
                        "	JOIN DangKy  " +
                        "	ON HoatDong.maHD=DangKy.maHoatDong " +
                        "	AND DangKy.maTaiKhoan= ? ) AS HD " +
                        "ON ThongBao.flagTB=0 AND ThongBao.maHoatDong=HD.maHD " +
                        "JOIN TaiKhoan " +
                        "ON ThongBao.maNguoiDang= TaiKhoan.maTK " +
                        "ORDER BY ThongBao.thoiGian";
        
    private ThongBao getNotificationDB(ResultSet rs) throws Exception{
        ThongBao thongBao = new ThongBao();
        //String checknull;

        thongBao.setId(Integer.parseInt(rs.getString("maTB")));
        thongBao.setTitle(rs.getString("tieuDe")); 
        thongBao.setContent(rs.getString("noiDung")); 
        thongBao.setPostingTime(rs.getTimestamp("thoiGian").toLocalDateTime()); 
        thongBao.setIdAction(Integer.parseInt(rs.getString("maHoatDong")));
        thongBao.setIdUser(rs.getString("maNguoiDang"));
        thongBao.setIdUser(rs.getString("tenTK")); 

        return thongBao;
    }
    
    public List<ThongBao> getNotificationsDB(String idAccount) throws Exception{
        List<ThongBao> notifications = new ArrayList<>();
        String query = queryGetNotification;
        
        try(
            Connection con = Helper.openConnection();
            PreparedStatement pstmt= con.prepareStatement(query);
        ){
            pstmt.setString(1,idAccount);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){    
                ThongBao tb = new ThongBao();
                tb = getNotificationDB(rs);
                notifications.add(tb);
            }
            rs.close();
            pstmt.close();
            con.close();
        }
        return notifications;    
            
    }
    
    
}
