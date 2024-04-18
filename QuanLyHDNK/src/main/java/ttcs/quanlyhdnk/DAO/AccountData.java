package ttcs.quanlyhdnk.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import ttcs.quanlyhdnk.model.NguoiDung;
import ttcs.quanlyhdnk.util.Helper;
import ttcs.quanlyhdnk.util.DateTimeUtil;
public class AccountData {
    public NguoiDung Login(String idAccount, String password) throws Exception{
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
    public int ChangePassword(String idAccount, String oldPassword,String newPassword)throws Exception{
        String query =" UPDATE TaiKhoan SET matKhau= ? FROM TaiKhoan WHERE maTK=? AND matKhau =?";
        if(Login(idAccount,oldPassword)!=null){
            try(
                Connection con = Helper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(query);  
                ){
                pstmt.setString(1, newPassword);
                pstmt.setString(2, idAccount);
                pstmt.setString(3, oldPassword);
//                ResultSet rs = pstmt.executeQuery();
                if(pstmt.executeUpdate()>0) return 0;// 0 co loi
                else return 2;
            }
        }      
        return 1;   
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

        return account;
    }
}
