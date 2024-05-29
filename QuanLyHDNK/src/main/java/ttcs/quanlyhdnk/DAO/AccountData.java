package ttcs.quanlyhdnk.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import ttcs.quanlyhdnk.model.NguoiDung;
import ttcs.quanlyhdnk.util.Helper;
import ttcs.quanlyhdnk.util.DateTimeUtil;
import ttcs.quanlyhdnk.util.Image;
public class AccountData {
    
    public NguoiDung checkAccount(String idAccount, String password) throws Exception{
        NguoiDung account = null;
        String query =" SELECT * FROM TaiKhoan WHERE maTK=? AND matKhau =?";
        try(
            Connection con = Helper.openConnection();
            PreparedStatement pstmt = con.prepareStatement(query);
        ){
            pstmt.setString(1, idAccount);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                account = setNguoiDung(rs);
            }
            rs.close();
            pstmt.close();
            con.close();
        }
        return account;
    }
    
    public boolean checkEmailRecovery(String idAccount, String email) throws Exception{
        String query =" SELECT * FROM TaiKhoan WHERE maTK=? AND email =?";
            try(
                Connection con = Helper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(query);
            ){
                pstmt.setString(1, idAccount);
                pstmt.setString(2, email);
                ResultSet rs = pstmt.executeQuery();
                if(rs.next()){
                    return true;
                }
                rs.close();
                pstmt.close();
                con.close();
            }     
        return false;
    }
    
    public boolean changePassword(String idAccount, String oldPassword,String newPassword)throws Exception{
        String query =" UPDATE TaiKhoan SET matKhau= ? FROM TaiKhoan WHERE maTK=? AND matKhau =?";
            try(
                Connection con = Helper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(query);  
                ){
                pstmt.setString(1, newPassword);
                pstmt.setString(2, idAccount);
                pstmt.setString(3, oldPassword);
//                ResultSet rs = pstmt.executeQuery();
                if(pstmt.executeUpdate()>0) return true;// 0 co loi
            }      
        return false;   
    }

    public boolean changeForgotPassword(String idAccount, String newPassword)throws Exception{
        String query =" UPDATE TaiKhoan SET matKhau= ? FROM TaiKhoan WHERE maTK=? ";
            try(
                Connection con = Helper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(query);  
                ){
                pstmt.setString(1, newPassword);
                pstmt.setString(2, idAccount);
//                ResultSet rs = pstmt.executeQuery();
                if(pstmt.executeUpdate()>0) return true;// update mk thanh cong
                else return false;//that bai
            }      
    }    
    
    private NguoiDung setNguoiDung(ResultSet rs) throws Exception{
        NguoiDung account = new NguoiDung();
        account.setUserID(rs.getString("maTK"));
        account.setPassword(rs.getString("matKhau"));
        account.setRole(rs.getString("maVaiTro"));
        account.setName(rs.getString("tenTK"));
        account.setBirthday(rs.getTimestamp("ngaySinh").toLocalDateTime());
        account.setGender(rs.getString("gioiTinh"));
        account.setAddress(rs.getString("diaChi"));
        account.setEmail(rs.getString("email"));
        account.setPhoneNumber(rs.getString("sdt"));
        account.setAccountCreationDate(rs.getTimestamp("ngayTao").toLocalDateTime());
        byte[] checknullOfAvatar=rs.getBytes("anhTK");
        if(checknullOfAvatar!=null) account.setAvatar(Image.ByteToImageIcon(checknullOfAvatar));
        return account;
    }
    
    public boolean updateAvatar(String idAccount, byte[] byteImage) throws Exception{
        String query ="UPDATE TaiKhoan SET anhTK=? WHERE maTK=? ";
         try(
             Connection con = Helper.openConnection();
             PreparedStatement pstmt = con.prepareStatement(query);  
             ){
             pstmt.setBytes(1,byteImage);
             pstmt.setString(2, idAccount);
                //ResultSet rs = pstmt.executeQuery();
             if(pstmt.executeUpdate()>0) return true;// 0 co loi
        } 
         
    return false;   
    }
}
