/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ttcs.quanlyhdnk.model;

import java.time.LocalDateTime;
import java.util.Date;
import javax.swing.ImageIcon;

/**
 *
 * @author ADMIN
 */
public class NguoiDung {
    private String userID, password;
    private String name, gender, email, phoneNumber, address, note, role;//donVi 
    private LocalDateTime accountCreationDate, Birthday;
    private javax.swing.ImageIcon avatar;
    public NguoiDung() {
    }

    public NguoiDung(String userID, String password, String name, String gender, String email, String phoneNumber, String address, String note, String role, LocalDateTime accountCreationDate, LocalDateTime Birthday, ImageIcon avatar) {
        this.userID = userID;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.note = note;
        this.role = role;
        this.accountCreationDate = accountCreationDate;
        this.Birthday = Birthday;
        this.avatar = avatar;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDateTime getAccountCreationDate() {
        return accountCreationDate;
    }

    public void setAccountCreationDate(LocalDateTime accountCreationDate) {
        this.accountCreationDate = accountCreationDate;
    }

    public LocalDateTime getBirthday() {
        return Birthday;
    }

    public void setBirthday(LocalDateTime Birthday) {
        this.Birthday = Birthday;
    }

    public ImageIcon getAvatar() {
        return avatar;
    }

    public void setAvatar(ImageIcon avatar) {
        this.avatar = avatar;
    }

}