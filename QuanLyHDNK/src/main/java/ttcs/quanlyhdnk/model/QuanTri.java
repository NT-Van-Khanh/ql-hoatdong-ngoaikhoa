package ttcs.quanlyhdnk.model;

import java.time.LocalDateTime;
import java.util.Date;

public class QuanTri extends NguoiDung {

    public QuanTri() {
        super();
    }

    public QuanTri(String user, String password, String name, String gender, String email, String phoneNumber, String address, String note, String role, LocalDateTime accountCreationDate, LocalDateTime Birthday) {
        super(user, password, name, gender, email, phoneNumber, address, note, role, accountCreationDate, Birthday);
    }

}
