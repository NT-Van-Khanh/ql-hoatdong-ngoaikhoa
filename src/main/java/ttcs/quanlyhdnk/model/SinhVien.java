/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ttcs.quanlyhdnk.model;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class SinhVien extends NguoiDung{

    public SinhVien() {
        super();
    }

    public SinhVien(String user, String password, String name, String gender, String email, String address, String phoneNumber, String ghiChu, String role, Date accountCreationDate, Date Birthday) {
        super(user, password, name, gender, email, address, phoneNumber, ghiChu, role, accountCreationDate, Birthday);
    }
    
    
}
