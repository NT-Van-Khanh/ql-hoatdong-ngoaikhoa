/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ttcs.quanlyhdnk.model;

import java.time.LocalDateTime;


public class ThongBao {
    private int id;
    private String title,content, idAction, idUser, nameUser; // tieu de, noi dung, maHoatDong, maNguoiDang;
    private LocalDateTime postingTime;// thoiGian tao tb
    public ThongBao() {
    }

    public ThongBao(int id, String title, String content, String idAction, String idUser, String nameUser, LocalDateTime postingTime) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.idAction = idAction;
        this.idUser = idUser;
        this.nameUser = nameUser;
        this.postingTime = postingTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getIdAction() {
        return idAction;
    }

    public void setIdAction(String idAction) {
        this.idAction = idAction;
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

    public LocalDateTime getPostingTime() {
        return postingTime;
    }

    public void setPostingTime(LocalDateTime postingTime) {
        this.postingTime = postingTime;
    }



    
}
