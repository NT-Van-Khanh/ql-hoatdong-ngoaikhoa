
package ttcs.quanlyhdnk.model;

import java.time.LocalDateTime;

public class HoatDong {
    private int id, numberOfRegistrations;// soLuongDangKy
    private String title, content, genre, address, picture, note;// ten, noiDung,theLoai,diaChi,anh, ghichu;
    private LocalDateTime startDate, endDate, postingTime;
    private String idUser,nameUser;// nguoiDangHoatDong

    public HoatDong() {
    }
    public HoatDong(int id, int numberOfRegistrations, String title, String content, String genre, String address, String picture, String note, LocalDateTime startDate, LocalDateTime endDate, LocalDateTime postingTime, String idUser, String nameUser) {
        this.id = id;
        this.numberOfRegistrations = numberOfRegistrations;
        this.title = title;
        this.content = content;
        this.genre = genre;
        this.address = address;
        this.picture = picture;
        this.note = note;
        this.startDate = startDate;
        this.endDate = endDate;
        this.postingTime = postingTime;
        this.idUser = idUser;
        this.nameUser = nameUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberOfRegistrations() {
        return numberOfRegistrations;
    }

    public void setNumberOfRegistrations(int numberOfRegistrations) {
        this.numberOfRegistrations = numberOfRegistrations;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public LocalDateTime getPostingTime() {
        return postingTime;
    }

    public void setPostingTime(LocalDateTime postingTime) {
        this.postingTime = postingTime;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }


    
}
