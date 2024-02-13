package ttcs.quanlyhdnk.model;

import java.util.Date;

public class QuanTri extends NguoiDung {

    public QuanTri() {
        super();
    }

    public QuanTri(String user, String password, String name, String gender, String email, String address, String phoneNumber, String ghiChu, String role, Date accountCreationDate, Date Birthday) {
        super(user, password, name, gender, email, address, phoneNumber, ghiChu, role, accountCreationDate, Birthday);
    }
    
}
