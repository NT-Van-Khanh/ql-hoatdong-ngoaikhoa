package ttcs.quanlyhdnk.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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
                account = setAccount(rs);
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
    
    private NguoiDung setAccount(ResultSet rs) throws Exception{
        NguoiDung account = new NguoiDung();
        account.setUserID(rs.getString("maTK"));
        account.setPassword(rs.getString("matKhau"));
        account.setRole(rs.getString("maVaiTro"));
        account.setName(rs.getString("tenTK"));
        account.setBirthday(rs.getTimestamp("ngaySinh").toLocalDateTime());
        Object checknull=rs.getObject("gioiTinh");
        
        //if(rs.getBoolean("gioiTinh")!=null)
        if(checknull==null){
            account.setGender("khác");
        }else if((boolean)checknull==true){
            account.setGender("nam");
        }else if((boolean)checknull==false){
            account.setGender("nữ");
        }
        
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
    
    public boolean checkAvailableEmail(String email) throws Exception{
        String query ="SELECT * FROM TaiKhoan WHERE email=? ";
         try(
            Connection con = Helper.openConnection();
            PreparedStatement pstmt = con.prepareStatement(query);  
            ){
            pstmt.setString(1,email);
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
    
    public boolean checkAvailablePhone(String phoneNumber) throws Exception{
        String query ="SELECT * FROM TaiKhoan WHERE sdt=? ";
         try(
            Connection con = Helper.openConnection();
            PreparedStatement pstmt = con.prepareStatement(query);  
            ){
            pstmt.setString(1,phoneNumber);
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
    
    public boolean checkAvailableAccount(String idAccount) throws Exception{
        String query ="SELECT * FROM TaiKhoan WHERE maTK=? ";
         try(
            Connection con = Helper.openConnection();
            PreparedStatement pstmt = con.prepareStatement(query);  
            ){
            pstmt.setString(1,idAccount);
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
    
    
//    private Account getRegisterDB(ResultSet rs, String idAcount) throws Exception{
//        DangKy dangKy = new DangKy();
//        //String checknull;
//        dangKy.setIdAcountRegister(idAcount);
//        dangKy.setId(Integer.parseInt(rs.getString("maDK")));
//        dangKy.setRegistrationsTime(rs.getTimestamp("thoiGian").toLocalDateTime());
//        dangKy.getActivity().getActivityDB(rs);
//        return dangKy;
//    }
    public static enum OrderBy{
        ID_ACCOUNT,NAME_ACCOUNT;     
    } 
    public static enum AccountRole{
        STUDENT,POSTER,MANAGER;     
    } 
    
    public boolean insertAccount(NguoiDung account) throws Exception {
        String sql = "INSERT TaiKhoan(maTK, matKhau, tenTK, maVaiTro, email, sdt, anhTK, diaChi, ngaySinh, gioiTinh) "
                    +"VALUES (?,?,?,?,?,?,?,?,?,?);";
        try (
                Connection con = Helper.openConnection(); 
                PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmt.setString(1, account.getUserID());
            pstmt.setString(2, account.getPassword());
            pstmt.setString(3, account.getName());
            pstmt.setString(4, account.getRole());
            pstmt.setString(5, account.getEmail());
            pstmt.setString(6, account.getPhoneNumber());
            if(account.getAvatar()!=null) pstmt.setBytes(7, Image.ImageIconToByte(account.getAvatar()));
            else pstmt.setNull(7,java.sql.Types.VARBINARY);
            
            String tmp=account.getAddress();
            if(tmp!=null) pstmt.setString(8, tmp);
            else pstmt.setNull(8,java.sql.Types.NVARCHAR);
            
            pstmt.setTimestamp(9, Timestamp.valueOf(account.getBirthday()));
            
            if(account.getGender().equals("nam")){
                pstmt.setBoolean(10, true);
            }else if(account.getGender().equals("nu")){
            pstmt.setBoolean(10, false);
            }else{
                pstmt.setNull(7,java.sql.Types.BOOLEAN);
            }
            return pstmt.executeUpdate() > 0;
        }
    }
    
    public List<NguoiDung> getAllAccountDB(OrderBy orderBy) throws Exception{
        List<NguoiDung> accountList = new ArrayList<>();
        String query="SELECT * FROM TaiKhoan Order By ";
        if(orderBy==OrderBy.ID_ACCOUNT){
                query=query+"maTK";
        }else if(orderBy==OrderBy.NAME_ACCOUNT){
                 query=query+"tenTK";
        }
        try(
            Connection con = Helper.openConnection();
            PreparedStatement pstmt= con.prepareStatement(query);
        ){
            
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){    
                NguoiDung account = new NguoiDung();
                account=setAccount(rs);
                accountList.add(account);
            }
        }
        return accountList;
    }
    
    public List<NguoiDung> getAccountByRoleDB(AccountRole role,OrderBy orderBy) throws Exception{
        List<NguoiDung> accountList = new ArrayList<>();
        String query="SELECT * FROM TaiKhoan WHERE maVaiTro=? ORDER BY ";
        if(orderBy==OrderBy.ID_ACCOUNT){
                query=query+"maTK";
        }else if(orderBy==OrderBy.NAME_ACCOUNT){
                 query=query+"tenTK";
        }
        try(
            Connection con = Helper.openConnection();
            PreparedStatement pstmt= con.prepareStatement(query);
        ){
            if(role==AccountRole.STUDENT){
                pstmt.setString(1,"SV");
            }else if(role==AccountRole.MANAGER){
                pstmt.setString(1,"QL");
            }else if(role==AccountRole.POSTER){
                pstmt.setString(1,"ND");
            }else{
                return null;
            }


            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){    
                NguoiDung account = new NguoiDung();
                account=setAccount(rs);
                accountList.add(account);
            }
            rs.close();
            pstmt.close();
            con.close();
        }
        return accountList;
    }
    
}
