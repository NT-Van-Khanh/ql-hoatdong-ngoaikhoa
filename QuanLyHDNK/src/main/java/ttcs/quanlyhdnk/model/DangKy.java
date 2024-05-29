package ttcs.quanlyhdnk.model;

import java.time.LocalDateTime;

public class DangKy {
    private int id,soLuongDK,soLuongDaDK;
    private ThongBao notification;
    private LocalDateTime registrationsTime;// thoi gian dang ky
    private String idAcountRegister;
    private Activity activity;
    public DangKy() {
        activity = new Activity();
    }

    public DangKy(int id, int soLuongDK, int soLuongDaDK, ThongBao notification, LocalDateTime registrationsTime, String idAcountRegister, Activity activity) {
        this.id = id;
        this.soLuongDK = soLuongDK;
        this.soLuongDaDK = soLuongDaDK;
        this.notification = notification;
        this.registrationsTime = registrationsTime;
        this.idAcountRegister = idAcountRegister;
        this.activity = activity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSoLuongDK() {
        return soLuongDK;
    }

    public void setSoLuongDK(int soLuongDK) {
        this.soLuongDK = soLuongDK;
    }

    public int getSoLuongDaDK() {
        return soLuongDaDK;
    }

    public void setSoLuongDaDK(int soLuongDaDK) {
        this.soLuongDaDK = soLuongDaDK;
    }

    public ThongBao getNotification() {
        return notification;
    }

    public void setNotification(ThongBao notification) {
        this.notification = notification;
    }

    public LocalDateTime getRegistrationsTime() {
        return registrationsTime;
    }

    public void setRegistrationsTime(LocalDateTime registrationsTime) {
        this.registrationsTime = registrationsTime;
    }

    public String getIdAcountRegister() {
        return idAcountRegister;
    }

    public void setIdAcountRegister(String idAcountRegister) {
        this.idAcountRegister = idAcountRegister;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    
}
