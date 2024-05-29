/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ttcs.quanlyhdnk.run;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Component;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import ttcs.quanlyhdnk.util.mail.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.swing.UnsupportedLookAndFeelException;
import ttcs.quanlyhdnk.DAO.AccountData;
import ttcs.quanlyhdnk.DAO.SinhVien.StudentActivity;
import ttcs.quanlyhdnk.component.activity.ActivityPanel;
import ttcs.quanlyhdnk.component.login.CodeVerificationDlg;
import ttcs.quanlyhdnk.component.login.PasswordResetPnl;
import ttcs.quanlyhdnk.model.Activity;
import ttcs.quanlyhdnk.model.NguoiDung;
import ttcs.quanlyhdnk.model.SinhVien;
import ttcs.quanlyhdnk.util.Helper;
import static ttcs.quanlyhdnk.util.RandomCode.randomCode;
import ttcs.quanlyhdnk.util.SHA256Encryption;

/**
 *
 * @author ADMIN
 */
public class Login extends javax.swing.JFrame {

    private NguoiDung nguoiDung= new NguoiDung();
    //private test t = new test(this,true);
    public Login() {
//        try {
//            EmailUtil.sendEmail("n21dccn043@student.ptithcm.edu.vn", "test", "thanh cong");
//        } catch (MessagingException ex) {
//            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
//            System.out.println("errror");
//        }  
          System.out.println(SHA256Encryption.toSHA256("abcdef"));
        initComponents();
        //showForm(new PasswordChangePanel("N21DCCN000"));
        showForm(pnlPassword);
    }
    private void showForm(Component com){
        
        pnlMain.removeAll();
        
        pnlMain.add(com);
        pnlMain.revalidate();
        pnlMain.repaint();
    }
    
    private boolean checkTxtIDAccount(){
        String tmp= txtIDAccount.getText();
        if(tmp.isEmpty()){
            lblErrorIdAccount.setText("Vui lòng nhập tài khoản");
            return false;
        }else if(tmp.length()<5){
            lblErrorIdAccount.setText("Tài khoản phải có ít nhất 5 ký tự");
            return false;
        }
        lblErrorIdAccount.setText(null);
        return true;
    }
    
    private boolean checkPwdPassword(){
        String tmp= String.valueOf(pwdPassword.getPassword());
        if(tmp.isEmpty()){
            lblErrorPassword.setText("Vui lòng nhập mật khẩu");
            return false;
        }else if(tmp.length()<6){
            lblErrorPassword.setText("Mật khẩu phải có ít nhất 6 ký tự");
            return false;
        }
        lblErrorPassword.setText(null);
        return true;
    }
    
    private boolean checkLogin(String taiKhoan,String matKhau){
        
        try {
            AccountData daoAccount = new AccountData();
            NguoiDung user= daoAccount.checkAccount(taiKhoan,matKhau);
            if(user !=null) { 
               this.nguoiDung=user;
                return true;
            }
        } catch (Exception ex) {
           // System.out.println("aasdasdsd"); Thong bao loi
            Logger.getLogger(ActivityPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    

    
    private void showMain(){
        if(nguoiDung.getRole().equals("SV")){
            new SinhVienForm(nguoiDung).setVisible(true);
            this.setVisible(false);
        }else if(nguoiDung.getRole().equals("QL")){
            new KyThuatForm(nguoiDung).setVisible(true);
            this.setVisible(false);
        }else{
            
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlForgotPassword = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtIDAccountRCV = new javax.swing.JTextField();
        btnGetCode = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        lblErrorOfIdAccount = new javax.swing.JLabel();
        lblErrorOfEmail = new javax.swing.JLabel();
        txtEmailRCV = new javax.swing.JTextField();
        lblNotifyRcvPw = new javax.swing.JLabel();
        pnlPassword = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        txtIDAccount = new javax.swing.JTextField();
        pwdPassword = new javax.swing.JPasswordField();
        lblErrorIdAccount = new javax.swing.JLabel();
        lblErrorPassword = new javax.swing.JLabel();
        lblCompleteLogin = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pnlBackGround = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        pnlMain = new javax.swing.JPanel();

        pnlForgotPassword.setBackground(new java.awt.Color(252, 252, 252));
        pnlForgotPassword.setForeground(new java.awt.Color(252, 252, 252));
        pnlForgotPassword.setMinimumSize(new java.awt.Dimension(380, 420));
        pnlForgotPassword.setPreferredSize(new java.awt.Dimension(380, 420));

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 204));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Khôi phục mật khẩu");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Tài khoản :");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Email       :");

        txtIDAccountRCV.setBackground(new java.awt.Color(229, 229, 229));
        txtIDAccountRCV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtIDAccountRCV.setForeground(new java.awt.Color(102, 102, 102));
        txtIDAccountRCV.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtIDAccountRCV.setBorder(null);
        txtIDAccountRCV.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIDAccountRCVFocusLost(evt);
            }
        });
        txtIDAccountRCV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDAccountRCVActionPerformed(evt);
            }
        });

        btnGetCode.setBackground(new java.awt.Color(31, 170, 216));
        btnGetCode.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGetCode.setForeground(new java.awt.Color(255, 255, 255));
        btnGetCode.setText("Lấy mã ");
        btnGetCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetCodeActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(178, 178, 178));
        jButton1.setText("Quay lại");
        jButton1.setBorder(null);
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton1.setIconTextGap(6);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lblErrorOfIdAccount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblErrorOfIdAccount.setText("jLabel10");
        lblErrorOfIdAccount.setVisible(false);

        lblErrorOfEmail.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblErrorOfEmail.setText("jLabel10");
        lblErrorOfEmail.setVisible(false);

        txtEmailRCV.setBackground(new java.awt.Color(229, 229, 229));
        txtEmailRCV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtEmailRCV.setForeground(new java.awt.Color(102, 102, 102));
        txtEmailRCV.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtEmailRCV.setBorder(null);
        txtEmailRCV.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmailRCVFocusLost(evt);
            }
        });
        txtEmailRCV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailRCVActionPerformed(evt);
            }
        });

        lblNotifyRcvPw.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNotifyRcvPw.setForeground(new java.awt.Color(255, 51, 51));
        lblNotifyRcvPw.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNotifyRcvPw.setText("Tài khoản hoặc email không hợp lệ!");
        lblNotifyRcvPw.setVisible(false);

        javax.swing.GroupLayout pnlForgotPasswordLayout = new javax.swing.GroupLayout(pnlForgotPassword);
        pnlForgotPassword.setLayout(pnlForgotPasswordLayout);
        pnlForgotPasswordLayout.setHorizontalGroup(
            pnlForgotPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
            .addGroup(pnlForgotPasswordLayout.createSequentialGroup()
                .addGroup(pnlForgotPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlForgotPasswordLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1))
                    .addGroup(pnlForgotPasswordLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(pnlForgotPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlForgotPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(pnlForgotPasswordLayout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtEmailRCV, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(pnlForgotPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblErrorOfEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblErrorOfIdAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlForgotPasswordLayout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtIDAccountRCV, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(lblNotifyRcvPw, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 17, Short.MAX_VALUE))
            .addGroup(pnlForgotPasswordLayout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(btnGetCode, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlForgotPasswordLayout.setVerticalGroup(
            pnlForgotPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlForgotPasswordLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(45, 45, 45)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(pnlForgotPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtIDAccountRCV)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErrorOfIdAccount)
                .addGap(13, 13, 13)
                .addGroup(pnlForgotPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmailRCV, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErrorOfEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(btnGetCode)
                .addGap(30, 30, 30)
                .addComponent(lblNotifyRcvPw, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        pnlPassword.setBackground(new java.awt.Color(252, 252, 252));
        pnlPassword.setMinimumSize(new java.awt.Dimension(380, 420));
        pnlPassword.setPreferredSize(new java.awt.Dimension(380, 420));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Đăng nhập");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Tài khoản:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Mật khẩu:");

        btnLogin.setBackground(new java.awt.Color(30, 160, 204));
        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Đăng nhập");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnExit.setBackground(new java.awt.Color(191, 191, 191));
        btnExit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setText("Thoát");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        txtIDAccount.setBackground(new java.awt.Color(229, 229, 229));
        txtIDAccount.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtIDAccount.setForeground(new java.awt.Color(102, 102, 102));
        txtIDAccount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtIDAccount.setBorder(null);
        txtIDAccount.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIDAccountFocusLost(evt);
            }
        });

        pwdPassword.setBackground(new java.awt.Color(229, 229, 229));
        pwdPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        pwdPassword.setForeground(new java.awt.Color(102, 102, 102));
        pwdPassword.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        pwdPassword.setText("***************");
        pwdPassword.setBorder(null);
        pwdPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pwdPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                pwdPasswordFocusLost(evt);
            }
        });
        pwdPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pwdPasswordMouseClicked(evt);
            }
        });
        pwdPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwdPasswordActionPerformed(evt);
            }
        });

        lblErrorIdAccount.setForeground(new java.awt.Color(255, 51, 51));
        lblErrorIdAccount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        lblErrorPassword.setForeground(new java.awt.Color(255, 51, 51));
        lblErrorPassword.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        lblCompleteLogin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCompleteLogin.setForeground(new java.awt.Color(51, 204, 255));
        lblCompleteLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCompleteLogin.setText("Đăng nhập thành công!");
        lblCompleteLogin.setVisible(false);

        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Quên mật khẩu? ");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlPasswordLayout = new javax.swing.GroupLayout(pnlPassword);
        pnlPassword.setLayout(pnlPasswordLayout);
        pnlPasswordLayout.setHorizontalGroup(
            pnlPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPasswordLayout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(pnlPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPasswordLayout.createSequentialGroup()
                            .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                            .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlPasswordLayout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(pwdPassword))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPasswordLayout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(pnlPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblErrorIdAccount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtIDAccount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))))
                    .addComponent(lblErrorPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
            .addComponent(lblCompleteLogin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlPasswordLayout.setVerticalGroup(
            pnlPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPasswordLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(pnlPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIDAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErrorIdAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(pwdPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErrorPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(pnlPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCompleteLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 420));
        setResizable(false);

        pnlBackGround.setBackground(new java.awt.Color(0, 153, 204));
        pnlBackGround.setMinimumSize(new java.awt.Dimension(420, 420));
        pnlBackGround.setPreferredSize(new java.awt.Dimension(420, 420));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Ảnh");

        javax.swing.GroupLayout pnlBackGroundLayout = new javax.swing.GroupLayout(pnlBackGround);
        pnlBackGround.setLayout(pnlBackGroundLayout);
        pnlBackGroundLayout.setHorizontalGroup(
            pnlBackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
        );
        pnlBackGroundLayout.setVerticalGroup(
            pnlBackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlMain.setBackground(new java.awt.Color(229, 229, 229));
        pnlMain.setMinimumSize(new java.awt.Dimension(380, 420));
        pnlMain.setPreferredSize(new java.awt.Dimension(380, 420));
        pnlMain.setLayout(new java.awt.GridLayout(1, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlBackGround, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackGround, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExitActionPerformed

    private void pwdPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwdPasswordActionPerformed
//        pwdPassword.setEchoChar((char)0);
    }//GEN-LAST:event_pwdPasswordActionPerformed
    
    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed

        if(checkPwdPassword()&&checkTxtIDAccount()){
            if(checkLogin(txtIDAccount.getText(),String.valueOf(pwdPassword.getPassword())))
            {
                //System.out.println("Dang nhap thanh cong");
                lblCompleteLogin.setForeground(new java.awt.Color(51, 204, 255));
                lblCompleteLogin.setText("Đăng nhập thành công!");
                System.out.println(SHA256Encryption.toSHA256(String.valueOf(pwdPassword.getPassword())));
                lblCompleteLogin.setVisible(true);
                
                showMain();

            }else{
                lblCompleteLogin.setForeground(new java.awt.Color(255, 51, 51));
                lblCompleteLogin.setText("Sai tài khoản hoặc mật khẩu!");
                lblCompleteLogin.setVisible(true);
                // System.out.println("Dang nhap that bai");
            }
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void pwdPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pwdPasswordMouseClicked

    }//GEN-LAST:event_pwdPasswordMouseClicked

    private void pwdPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pwdPasswordFocusGained
       if(String.valueOf(pwdPassword.getPassword()).equals("***************")){
            pwdPassword.setText("");
        }
    }//GEN-LAST:event_pwdPasswordFocusGained

    private void pwdPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pwdPasswordFocusLost
        if(pwdPassword.getPassword().length==0){
            pwdPassword.setText("***************");
        }
        checkPwdPassword();
    }//GEN-LAST:event_pwdPasswordFocusLost

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        showForm(pnlForgotPassword);


    }//GEN-LAST:event_jLabel4MouseClicked

    private void txtIDAccountFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIDAccountFocusLost
        checkTxtIDAccount();
    }//GEN-LAST:event_txtIDAccountFocusLost

    private void txtIDAccountRCVFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIDAccountRCVFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDAccountRCVFocusLost

    private void btnGetCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetCodeActionPerformed
        
        try {
            AccountData daoAccount = new AccountData();
            if(daoAccount.checkEmailRecovery(txtIDAccountRCV.getText(),txtEmailRCV.getText()))
            {
                try {
                    String code =randomCode();
                    
                    EmailUtil.sendEmail(txtEmailRCV.getText(), "Mã khôi phục mật khẩu", code);
                    CodeVerificationDlg codeVerification = new CodeVerificationDlg(this,code);
                    codeVerification.setVisible(true);
                    if(codeVerification.getMessageType()==CodeVerificationDlg.MessageType.OK){ 
                        showForm(new PasswordResetPnl(txtIDAccountRCV.getText()));
//                        System.out.println("co the doi mat khau");
                    }
                } catch (MessagingException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("errror không thể gửi mã khôi phục");
                }
            }else{
                lblNotifyRcvPw.setVisible(true);
            }
        } catch (Exception ex) {
            lblNotifyRcvPw.setVisible(true);
        }
    }//GEN-LAST:event_btnGetCodeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        showForm(pnlPassword);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtIDAccountRCVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDAccountRCVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDAccountRCVActionPerformed

    private void txtEmailRCVFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailRCVFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailRCVFocusLost

    private void txtEmailRCVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailRCVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailRCVActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
            /* Set the Nimbus look and feel */
            //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
            /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
            * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
            */
        try {
            javax.swing.UIManager.setLookAndFeel( new FlatLightLaf() );
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnGetCode;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lblCompleteLogin;
    private javax.swing.JLabel lblErrorIdAccount;
    private javax.swing.JLabel lblErrorOfEmail;
    private javax.swing.JLabel lblErrorOfIdAccount;
    private javax.swing.JLabel lblErrorPassword;
    private javax.swing.JLabel lblNotifyRcvPw;
    private javax.swing.JPanel pnlBackGround;
    private javax.swing.JPanel pnlForgotPassword;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlPassword;
    private javax.swing.JPasswordField pwdPassword;
    private javax.swing.JTextField txtEmailRCV;
    private javax.swing.JTextField txtIDAccount;
    private javax.swing.JTextField txtIDAccountRCV;
    // End of variables declaration//GEN-END:variables
}
