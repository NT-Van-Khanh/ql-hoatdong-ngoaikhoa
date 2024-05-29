package ttcs.quanlyhdnk.run;

import ttcs.quanlyhdnk.run.form.*;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;
import ttcs.quanlyhdnk.DAO.SinhVien.*;
import ttcs.quanlyhdnk.component.activity.ActivityRegisterPanel;
import ttcs.quanlyhdnk.model.Activity;
import ttcs.quanlyhdnk.model.NguoiDung;
import ttcs.quanlyhdnk.model.SinhVien;
import ttcs.quanlyhdnk.run.*;
import ttcs.quanlyhdnk.util.DateTimeUtil;
import ttcs.quanlyhdnk.util.SHA256Encryption;

import ttcs.quanlyhdnk.util.DateTimeUtil;
import java.time.LocalDateTime;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import ttcs.quanlyhdnk.component.ImageChoose;
import ttcs.quanlyhdnk.component.notification.NotificationDialog;
import ttcs.quanlyhdnk.component.login.PasswordChangePnl;
import ttcs.quanlyhdnk.model.DangKy;
import ttcs.quanlyhdnk.util.Image;
/**
 *
 * @author ADMIN
 */
public class KyThuatForm extends javax.swing.JFrame {
    private int selectedItemMenu=1;
    private NguoiDung account = new NguoiDung();
   // String pw=SHA256Encryption.toSHA256("abcdef"); 

    public KyThuatForm() {
        initComponents();
    //Load data  
        account.setUserID("N21DCCN000");
    //design frame
//        setExtendedState(MAXIMIZED_BOTH);
    //test
    }
    
    public KyThuatForm(NguoiDung account) {
        initComponents();  
    //Load data
    //lblAvatar.setIcon(new javax.swing.ImageIcon(getClass().getResource(""))); // NOI18N
        setStudentInformation(account);
        initDisplay();  
       
    //test
    //design frame
    //    setExtendedState(MAXIMIZED_BOTH);
    //test
    }

    private void setStudentInformation(NguoiDung account){
        this.account=account;
    }
    
    private void initDisplay(){        
        setExtendedState(MAXIMIZED_BOTH);
        lblNameUser.setText(account.getName());
        if(account.getAvatar()!=null) {
            lblAvatar.setIcon(Image.resizeImage(account.getAvatar(), 56, 56));  
        }
        loadInformationOfAccountDlg();
//        pnlMainBody.removeAll();
//        pnlMainBody.add(cpListHD);
//        pnlMainBody.revalidate();
//        pnlMainBody.repaint();
    }
    //
    private void changeBodyPanelDisplay(int index){
        if(this.selectedItemMenu==2 ){
            if(index==1||index==3){
//                pnlMainBody.removeAll();
//                pnlMainBody.add(cpListHD);
//                pnlMainBody.revalidate();
//                pnlMainBody.repaint();
            }
        }else if(index==2){
                pnlMainBody1.removeAll();
                pnlMainBody1.add(cpActivityRegistered);
                pnlMainBody1.revalidate();
                pnlMainBody1.repaint();
        }
    }
    private void showForm(int index){// error: cần xóa các panel activity cũ khi loading lại 
        
        if(index!=selectedItemMenu){
            changeBodyPanelDisplay(index);
            Font fontOfNewBtnMenu= new Font("Segoe UI",Font.BOLD,14);
            Font fontOfOldBtnMenu= new Font("Segoe UI",Font.PLAIN,14);
            switch( selectedItemMenu){
                case 1:
                    btnHome.setFont(fontOfOldBtnMenu);
                    
                    pnlHome.setOpaque(false);
                    break;
                case 2:
                    btnRegistrationHistory.setFont(fontOfOldBtnMenu);
                    pnlRegistrationHistory.setOpaque(false);

                    break;   
                case 3:
                    btnParticipationHistory.setFont(fontOfOldBtnMenu);
                    pnlParticipationHistory.setOpaque(false);
                    break;  
                case 4:
                    btnLogout.setFont(fontOfOldBtnMenu);
                    pnlLogout.setOpaque(false);
                    break;
                default:
                    break;
            }
            
            switch(index){
                case 1:
                    btnHome.setFont(fontOfNewBtnMenu);
                    pnlHome.setOpaque(true);
                    break;
                case 2:
                    btnRegistrationHistory.setFont(fontOfNewBtnMenu);
                    pnlRegistrationHistory.setOpaque(true);
                    break;   
                case 3:
                    btnParticipationHistory.setFont(fontOfNewBtnMenu);
                    pnlParticipationHistory.setOpaque(true);
                    break;
                case 4:
                    btnLogout.setFont(fontOfNewBtnMenu);
                    pnlLogout.setOpaque(true);
                    break;
                default:
                    break;
            }
            this.selectedItemMenu=index;   
        }
//        pnlListHD.removeAll();
//        pnlListHD.add(com);
//        pnlListHD.revalidate();
//        pnlListHD.repaint();
    }
    
//    private void setSizeFormSanPham(int soLuong){
//        Dimension dimension = new Dimension(pnlListHD.getWidth(),(int)(soLuong*250 + 10));
//        pnlListHD.setPreferredSize(dimension);
//    }
//    
//    private void setSizeFormSanPham(int soLuong,int soLuongDK){
//        Dimension dimension = new Dimension(pnlListHD.getWidth(),(int)(soLuong*220 + soLuongDK*250 + 10));
//        pnlListHD.setPreferredSize(dimension);
//    }    
    
//data transmission another form
    private void loadInformationOfAccountDlg(){
        lbNameAccountDlg.setText(account.getName());
        lblIdAccountDlg.setText(account.getUserID());
       // lblClassDlg.setText("tam thoi chua co");
        lblBirthdayDlg.setText(DateTimeUtil.LocalDateTimeToStringDay(account.getBirthday()));
        lblPhoneNumberDlg.setText(account.getPhoneNumber());
        lblEmailDlg.setText(account.getEmail());
        if(account.getAvatar()!=null) {
            lblAvatarDlg.setIcon(account.getAvatar());
        }
    }

    
   
    
   

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dlgAccountInformation = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        lblAvatarDlg = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbNameAccountDlg = new javax.swing.JLabel();
        lblIdAccountDlg = new javax.swing.JLabel();
        lblClassDlg = new javax.swing.JLabel();
        lblBirthdayDlg = new javax.swing.JLabel();
        lblPhoneNumberDlg = new javax.swing.JLabel();
        lblEmailDlg = new javax.swing.JLabel();
        btnChangePasswordDlg = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        pnlToolbar = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        pnlMainBody1 = new javax.swing.JPanel();
        cpActivityRegistered = new javax.swing.JScrollPane();
        tblActivityRegistered = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        pnlToolbar1 = new javax.swing.JPanel();
        pnlMainBody2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        lblAvatar = new javax.swing.JLabel();
        lblNameUser = new javax.swing.JLabel();
        pnlMenuBar = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        pnlHome = new javax.swing.JPanel();
        btnHome = new javax.swing.JButton();
        pnlRegistrationHistory = new javax.swing.JPanel();
        btnRegistrationHistory = new javax.swing.JButton();
        pnlParticipationHistory = new javax.swing.JPanel();
        btnParticipationHistory = new javax.swing.JButton();
        pnlLogout = new javax.swing.JPanel();
        btnLogout = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        pnlMainBody = new javax.swing.JPanel();

        dlgAccountInformation.setTitle("Thông tin tài khoản");
        dlgAccountInformation.setBackground(new java.awt.Color(255, 255, 255));
        dlgAccountInformation.setSize(new java.awt.Dimension(650, 340));

        jPanel2.setBackground(new java.awt.Color(235, 235, 235));

        lblAvatarDlg.setBackground(new java.awt.Color(0, 102, 153));
        lblAvatarDlg.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblAvatarDlg.setForeground(new java.awt.Color(255, 255, 255));
        lblAvatarDlg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAvatarDlg.setText("avatar");
        lblAvatarDlg.setToolTipText("Nhấn vào để thay đổi ảnh địa diện");
        lblAvatarDlg.setOpaque(true);
        lblAvatarDlg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAvatarDlgMouseClicked(evt);
            }
        });

        jLabel6.setText("MSV:");

        jLabel7.setText("Lớp:");

        jLabel8.setText("Ngày sinh:");

        jLabel9.setText("Số điện thoại:");

        jLabel10.setText("Email:");

        lbNameAccountDlg.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbNameAccountDlg.setForeground(new java.awt.Color(102, 102, 102));
        lbNameAccountDlg.setText("Nguyen Van A");
        lbNameAccountDlg.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lblIdAccountDlg.setText("N21DCCN000");

        lblClassDlg.setText("D21CQCN01-N");

        lblBirthdayDlg.setText("01/01/2003");

        lblPhoneNumberDlg.setText("0343935903");

        lblEmailDlg.setText("n21dccn000@student.ptithcm.edu.vn");

        btnChangePasswordDlg.setText("Đổi mật khẩu");
        btnChangePasswordDlg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangePasswordDlgActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblAvatarDlg, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPhoneNumberDlg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblBirthdayDlg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblIdAccountDlg, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblClassDlg, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblEmailDlg, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lbNameAccountDlg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnChangePasswordDlg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAvatarDlg, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbNameAccountDlg, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(lblIdAccountDlg))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(lblClassDlg, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(lblBirthdayDlg))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(lblPhoneNumberDlg))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(lblEmailDlg))
                        .addGap(18, 18, 18)
                        .addComponent(btnChangePasswordDlg)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(235, 235, 235));

        jLabel4.setText("Số hoạt động đã tham gia:");

        jLabel5.setBackground(new java.awt.Color(40, 49, 71));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 204, 51));
        jLabel5.setOpaque(true);

        jLabel17.setBackground(new java.awt.Color(243, 243, 225));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("0");
        jLabel17.setOpaque(true);

        jLabel18.setText("Số hoạt động đã đăng ký:");

        jLabel19.setBackground(new java.awt.Color(243, 243, 225));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("0");
        jLabel19.setOpaque(true);

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 102, 153));
        jLabel20.setText("Thống kê");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout dlgAccountInformationLayout = new javax.swing.GroupLayout(dlgAccountInformation.getContentPane());
        dlgAccountInformation.getContentPane().setLayout(dlgAccountInformationLayout);
        dlgAccountInformationLayout.setHorizontalGroup(
            dlgAccountInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgAccountInformationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dlgAccountInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        dlgAccountInformationLayout.setVerticalGroup(
            dlgAccountInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgAccountInformationLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        pnlToolbar.setBackground(new java.awt.Color(250, 204, 65));

        jButton1.setText("Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("jButton2");

        jButton3.setText("jButton3");

        javax.swing.GroupLayout pnlToolbarLayout = new javax.swing.GroupLayout(pnlToolbar);
        pnlToolbar.setLayout(pnlToolbarLayout);
        pnlToolbarLayout.setHorizontalGroup(
            pnlToolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlToolbarLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jButton1)
                .addGap(58, 58, 58)
                .addComponent(jButton2)
                .addGap(57, 57, 57)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlToolbarLayout.setVerticalGroup(
            pnlToolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlToolbarLayout.createSequentialGroup()
                .addContainerGap(96, Short.MAX_VALUE)
                .addGroup(pnlToolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(24, 24, 24))
        );

        pnlMainBody1.setOpaque(false);
        pnlMainBody1.setLayout(new java.awt.BorderLayout());

        cpActivityRegistered.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        tblActivityRegistered.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã tài khoản", "Tên tài khoản", "Giới tính", "Ngày sinh", "Email", "Số điện thoại", "Địa chỉ", "Quyền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblActivityRegistered.setColumnSelectionAllowed(true);
        tblActivityRegistered.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblActivityRegistered.getTableHeader().setReorderingAllowed(false);
        cpActivityRegistered.setViewportView(tblActivityRegistered);
        tblActivityRegistered.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tblActivityRegistered.getColumnModel().getColumnCount() > 0) {
            tblActivityRegistered.getColumnModel().getColumn(0).setResizable(false);
            tblActivityRegistered.getColumnModel().getColumn(0).setPreferredWidth(90);
            tblActivityRegistered.getColumnModel().getColumn(1).setPreferredWidth(250);
            tblActivityRegistered.getColumnModel().getColumn(2).setResizable(false);
            tblActivityRegistered.getColumnModel().getColumn(2).setPreferredWidth(60);
            tblActivityRegistered.getColumnModel().getColumn(3).setResizable(false);
            tblActivityRegistered.getColumnModel().getColumn(3).setPreferredWidth(60);
            tblActivityRegistered.getColumnModel().getColumn(4).setResizable(false);
            tblActivityRegistered.getColumnModel().getColumn(4).setPreferredWidth(80);
            tblActivityRegistered.getColumnModel().getColumn(5).setResizable(false);
            tblActivityRegistered.getColumnModel().getColumn(5).setPreferredWidth(60);
            tblActivityRegistered.getColumnModel().getColumn(6).setResizable(false);
            tblActivityRegistered.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblActivityRegistered.getColumnModel().getColumn(7).setResizable(false);
        }

        pnlMainBody1.add(cpActivityRegistered, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlToolbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlMainBody1, javax.swing.GroupLayout.DEFAULT_SIZE, 1100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(pnlToolbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlMainBody1, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        pnlToolbar1.setBackground(new java.awt.Color(250, 204, 65));

        javax.swing.GroupLayout pnlToolbar1Layout = new javax.swing.GroupLayout(pnlToolbar1);
        pnlToolbar1.setLayout(pnlToolbar1Layout);
        pnlToolbar1Layout.setHorizontalGroup(
            pnlToolbar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1100, Short.MAX_VALUE)
        );
        pnlToolbar1Layout.setVerticalGroup(
            pnlToolbar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );

        pnlMainBody2.setOpaque(false);
        pnlMainBody2.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlToolbar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlMainBody2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(pnlToolbar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlMainBody2, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hoạt Động Ngoại Khóa");
        setBackground(new java.awt.Color(255, 255, 255));
        setSize(new java.awt.Dimension(1100, 650));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(242, 242, 242));

        header.setBackground(new java.awt.Color(0, 153, 255));
        header.setPreferredSize(new java.awt.Dimension(332, 70));

        lblAvatar.setBackground(new java.awt.Color(255, 255, 255));
        lblAvatar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAvatar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/profile-user (2).png"))); // NOI18N
        lblAvatar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAvatarMouseClicked(evt);
            }
        });

        lblNameUser.setBackground(new java.awt.Color(255, 255, 255));
        lblNameUser.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNameUser.setForeground(new java.awt.Color(255, 255, 255));
        lblNameUser.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNameUser.setText("Tên ( NGUYEN VAN A)");

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblAvatar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNameUser, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(840, Short.MAX_VALUE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNameUser, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        pnlMenuBar.setBackground(new java.awt.Color(0, 153, 255));
        pnlMenuBar.setLayout(new javax.swing.BoxLayout(pnlMenuBar, javax.swing.BoxLayout.Y_AXIS));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setMaximumSize(new java.awt.Dimension(220, 50));
        jPanel5.setMinimumSize(new java.awt.Dimension(220, 55));
        jPanel5.setOpaque(false);
        jPanel5.setPreferredSize(new java.awt.Dimension(220, 55));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 55, Short.MAX_VALUE)
        );

        pnlMenuBar.add(jPanel5);

        pnlHome.setBackground(new java.awt.Color(50, 173, 255));
        pnlHome.setMaximumSize(new java.awt.Dimension(220, 45));
        pnlHome.setMinimumSize(new java.awt.Dimension(220, 45));
        pnlHome.setPreferredSize(new java.awt.Dimension(220, 45));

        btnHome.setBackground(new java.awt.Color(38, 168, 255));
        btnHome.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHome.setForeground(new java.awt.Color(255, 255, 255));
        btnHome.setText("TRANG CHỦ");
        btnHome.setContentAreaFilled(false);
        btnHome.setOpaque(true);
        btnHome.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnHomeMouseMoved(evt);
            }
        });
        btnHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHomeMouseExited(evt);
            }
        });
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlHomeLayout = new javax.swing.GroupLayout(pnlHome);
        pnlHome.setLayout(pnlHomeLayout);
        pnlHomeLayout.setHorizontalGroup(
            pnlHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnHome, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
        );
        pnlHomeLayout.setVerticalGroup(
            pnlHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnHome, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        pnlMenuBar.add(pnlHome);

        pnlRegistrationHistory.setBackground(new java.awt.Color(50, 173, 255));
        pnlRegistrationHistory.setMaximumSize(new java.awt.Dimension(220, 45));
        pnlRegistrationHistory.setMinimumSize(new java.awt.Dimension(220, 45));
        pnlRegistrationHistory.setOpaque(false);
        pnlRegistrationHistory.setPreferredSize(new java.awt.Dimension(220, 45));

        btnRegistrationHistory.setBackground(new java.awt.Color(38, 168, 255));
        btnRegistrationHistory.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnRegistrationHistory.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrationHistory.setText("QUẢN LÝ TÀI KHOẢN");
        btnRegistrationHistory.setContentAreaFilled(false);
        btnRegistrationHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRegistrationHistoryMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRegistrationHistoryMouseExited(evt);
            }
        });
        btnRegistrationHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrationHistoryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlRegistrationHistoryLayout = new javax.swing.GroupLayout(pnlRegistrationHistory);
        pnlRegistrationHistory.setLayout(pnlRegistrationHistoryLayout);
        pnlRegistrationHistoryLayout.setHorizontalGroup(
            pnlRegistrationHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnRegistrationHistory, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
        );
        pnlRegistrationHistoryLayout.setVerticalGroup(
            pnlRegistrationHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnRegistrationHistory, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        pnlMenuBar.add(pnlRegistrationHistory);

        pnlParticipationHistory.setBackground(new java.awt.Color(50, 173, 255));
        pnlParticipationHistory.setMaximumSize(new java.awt.Dimension(220, 45));
        pnlParticipationHistory.setMinimumSize(new java.awt.Dimension(220, 45));
        pnlParticipationHistory.setOpaque(false);

        btnParticipationHistory.setBackground(new java.awt.Color(38, 168, 255));
        btnParticipationHistory.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnParticipationHistory.setForeground(new java.awt.Color(255, 255, 255));
        btnParticipationHistory.setText("null");
        btnParticipationHistory.setContentAreaFilled(false);
        btnParticipationHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnParticipationHistoryMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnParticipationHistoryMouseExited(evt);
            }
        });
        btnParticipationHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnParticipationHistoryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlParticipationHistoryLayout = new javax.swing.GroupLayout(pnlParticipationHistory);
        pnlParticipationHistory.setLayout(pnlParticipationHistoryLayout);
        pnlParticipationHistoryLayout.setHorizontalGroup(
            pnlParticipationHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnParticipationHistory, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
        );
        pnlParticipationHistoryLayout.setVerticalGroup(
            pnlParticipationHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnParticipationHistory, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        pnlMenuBar.add(pnlParticipationHistory);

        pnlLogout.setBackground(new java.awt.Color(50, 173, 255));
        pnlLogout.setMaximumSize(new java.awt.Dimension(220, 45));
        pnlLogout.setMinimumSize(new java.awt.Dimension(220, 45));
        pnlLogout.setOpaque(false);

        btnLogout.setBackground(new java.awt.Color(38, 168, 255));
        btnLogout.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(255, 255, 255));
        btnLogout.setText("ĐĂNG XUẤT");
        btnLogout.setContentAreaFilled(false);
        btnLogout.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btnLogoutFocusGained(evt);
            }
        });
        btnLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLogoutMouseExited(evt);
            }
        });
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlLogoutLayout = new javax.swing.GroupLayout(pnlLogout);
        pnlLogout.setLayout(pnlLogoutLayout);
        pnlLogoutLayout.setHorizontalGroup(
            pnlLogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnLogout, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
        );
        pnlLogoutLayout.setVerticalGroup(
            pnlLogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnLogout, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        pnlMenuBar.add(pnlLogout);

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setOpaque(false);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 318, Short.MAX_VALUE)
        );

        pnlMenuBar.add(jPanel15);

        pnlMainBody.setBackground(new java.awt.Color(255, 255, 255));
        pnlMainBody.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(102, 102, 102)));

        javax.swing.GroupLayout pnlMainBodyLayout = new javax.swing.GroupLayout(pnlMainBody);
        pnlMainBody.setLayout(pnlMainBodyLayout);
        pnlMainBodyLayout.setHorizontalGroup(
            pnlMainBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 842, Short.MAX_VALUE)
        );
        pnlMainBodyLayout.setVerticalGroup(
            pnlMainBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 549, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, 1096, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(pnlMenuBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(pnlMainBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlMainBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlMenuBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1110, 650));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblAvatarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAvatarMouseClicked
        dlgAccountInformation.setVisible(true);
        dlgAccountInformation.setLocationRelativeTo(null);
        
    }//GEN-LAST:event_lblAvatarMouseClicked

    private void btnChangePasswordDlgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangePasswordDlgActionPerformed
        PasswordChangePnl changePasswordDlg = new PasswordChangePnl(this, true, account.getUserID());
        changePasswordDlg.setVisible(true);
        
    }//GEN-LAST:event_btnChangePasswordDlgActionPerformed

    private void btnHomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseEntered
        //System.out.println("mouseenter");
        pnlHome.setOpaque(true);
    }//GEN-LAST:event_btnHomeMouseEntered

    private void btnHomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseExited
        // System.out.println("mouseexit");
        pnlHome.setOpaque(false);
    }//GEN-LAST:event_btnHomeMouseExited

    private void btnRegistrationHistoryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrationHistoryMouseEntered
        pnlRegistrationHistory.setOpaque(true);
    }//GEN-LAST:event_btnRegistrationHistoryMouseEntered

    private void btnParticipationHistoryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnParticipationHistoryMouseEntered
        pnlParticipationHistory.setOpaque(true);
    }//GEN-LAST:event_btnParticipationHistoryMouseEntered

    private void btnRegistrationHistoryMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrationHistoryMouseExited
         pnlRegistrationHistory.setOpaque(false);
    }//GEN-LAST:event_btnRegistrationHistoryMouseExited

    private void btnParticipationHistoryMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnParticipationHistoryMouseExited
         pnlParticipationHistory.setOpaque(false);
    }//GEN-LAST:event_btnParticipationHistoryMouseExited

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        //btnHome.setFont();
        //pnlHome.setOpaque(true);
        showForm(1);
  
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnRegistrationHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrationHistoryActionPerformed
        showForm(2);
       
    }//GEN-LAST:event_btnRegistrationHistoryActionPerformed

    private void btnParticipationHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnParticipationHistoryActionPerformed
        // ChuaHoanThanh();
        showForm(3);
    
        
//        pnlListHD.removeAll();
//        pnlListHD.revalidate();
//        pnlListHD.repaint();
    }//GEN-LAST:event_btnParticipationHistoryActionPerformed

    private void btnLogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseEntered
        pnlLogout.setOpaque(true);
    }//GEN-LAST:event_btnLogoutMouseEntered

    private void btnLogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseExited
        pnlLogout.setOpaque(false);
    }//GEN-LAST:event_btnLogoutMouseExited

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        int kq=JOptionPane.showConfirmDialog(this, "Bạn có muốn đăng xuất không?",
                "Xác nhận",JOptionPane.YES_OPTION,JOptionPane.NO_OPTION);
        if(kq==JOptionPane.YES_OPTION){
            this.dispose();
            Login login = new Login();
            login.setVisible(true);
        }else if(kq==JOptionPane.NO_OPTION){
            
        }else {
            
        }
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnLogoutFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnLogoutFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLogoutFocusGained

    private void btnHomeMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseMoved
       // btnHome.setOpaque(true);
    }//GEN-LAST:event_btnHomeMouseMoved

    private void lblAvatarDlgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAvatarDlgMouseClicked

        ImageChoose imageChoose= new ImageChoose(dlgAccountInformation,(javax.swing.ImageIcon)lblAvatarDlg.getIcon());
        imageChoose.setVisible(true);
        if(imageChoose.getMessageType()==ImageChoose.MessageType.OK){
//            System.out.println("có");
            if(lblAvatarDlg.getText()!=null) lblAvatarDlg.setText(null);
            lblAvatarDlg.setIcon(imageChoose.getImageIcon());
            lblAvatar.setIcon(Image.resizeImage(imageChoose.getImageIcon(),56,56));
//            System.out.println("có");
            try {
                 byte[] tmpBytes = Image.ImageIconToByte((javax.swing.ImageIcon)lblAvatarDlg.getIcon());
                 ttcs.quanlyhdnk.DAO.AccountData dao = new ttcs.quanlyhdnk.DAO.AccountData();

                 try {
                     dao.updateAvatar(account.getUserID(),tmpBytes);
                 } catch (Exception ex) {
                     Logger.getLogger(KyThuatForm.class.getName()).log(Level.SEVERE, null, ex);
                 }
            } catch (IOException ex) {
                 Logger.getLogger(KyThuatForm.class.getName()).log(Level.SEVERE, null, ex);
            }

        }else{
            System.out.println("không");
        }
                
    }//GEN-LAST:event_lblAvatarDlgMouseClicked

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
//        Point point = evt.getPoint();
//        SwingUtilities.convertPointToScreen(point, this);
//        Rectangle bounds = 
    }//GEN-LAST:event_formMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param nguoiDung
     */
    public static void main(NguoiDung nguoiDung) {
        
            /* Set the Nimbus look and feel */
            //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
            /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
            * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
            */
        try {
            javax.swing.UIManager.setLookAndFeel( new FlatLightLaf() );
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(KyThuatForm.class.getName()).log(Level.SEVERE, null, ex);
        }

//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    javax.swing.UIManager.setLookAndFeel("com.formdev.flatlaf.FlatDarkLaf");
//                    javax.swing.UIManager.setLookAndFeel( new FlatLightLaf() );
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(SinhVienForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(SinhVienForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(SinhVienForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(SinhVienForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new SinhVienForm().setVisible(true);
                new KyThuatForm(nguoiDung).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChangePasswordDlg;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnParticipationHistory;
    private javax.swing.JButton btnRegistrationHistory;
    private javax.swing.JScrollPane cpActivityRegistered;
    private javax.swing.JDialog dlgAccountInformation;
    private javax.swing.JPanel header;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lbNameAccountDlg;
    private javax.swing.JLabel lblAvatar;
    private javax.swing.JLabel lblAvatarDlg;
    private javax.swing.JLabel lblBirthdayDlg;
    private javax.swing.JLabel lblClassDlg;
    private javax.swing.JLabel lblEmailDlg;
    private javax.swing.JLabel lblIdAccountDlg;
    private javax.swing.JLabel lblNameUser;
    private javax.swing.JLabel lblPhoneNumberDlg;
    private javax.swing.JPanel pnlHome;
    private javax.swing.JPanel pnlLogout;
    private javax.swing.JPanel pnlMainBody;
    private javax.swing.JPanel pnlMainBody1;
    private javax.swing.JPanel pnlMainBody2;
    private javax.swing.JPanel pnlMenuBar;
    private javax.swing.JPanel pnlParticipationHistory;
    private javax.swing.JPanel pnlRegistrationHistory;
    private javax.swing.JPanel pnlToolbar;
    private javax.swing.JPanel pnlToolbar1;
    private javax.swing.JTable tblActivityRegistered;
    // End of variables declaration//GEN-END:variables
}
