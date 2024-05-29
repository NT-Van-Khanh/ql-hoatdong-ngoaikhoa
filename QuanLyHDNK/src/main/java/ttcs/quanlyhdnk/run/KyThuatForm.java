package ttcs.quanlyhdnk.run;

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
import java.util.ArrayList;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import ttcs.quanlyhdnk.DAO.AccountData;

import ttcs.quanlyhdnk.model.NguoiDung;
import ttcs.quanlyhdnk.run.*;


import ttcs.quanlyhdnk.util.DateTimeUtil;

import ttcs.quanlyhdnk.component.AccountAdd;
import ttcs.quanlyhdnk.component.ImageChoose;

import ttcs.quanlyhdnk.component.login.PasswordChangePnl;
import ttcs.quanlyhdnk.util.Image;
/**
 *
 * @author ADMIN
 */
public class KyThuatForm extends javax.swing.JFrame {
    private int selectedItemMenu=1;
    private NguoiDung account = new NguoiDung();
    private List<NguoiDung> accountList = new ArrayList<>();
   // String pw=SHA256Encryption.toSHA256("abcdef"); 
    private AccountData.OrderBy oderBy=AccountData.OrderBy.ID_ACCOUNT;
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
        getAccountList(oderBy);
        fillToTable();
       
    //test
    //design frame
    //    setExtendedState(MAXIMIZED_BOTH);
    //test
    }
    private void getAccountList(AccountData.OrderBy orderBy){
        try {
            AccountData dao = new AccountData();
            accountList = dao.getAllAccountDB(orderBy);
        } catch (Exception ex) {
            Logger.getLogger(KyThuatForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void getAccountListByRole(AccountData.AccountRole role,AccountData.OrderBy orderBy){
        try {
            AccountData dao = new AccountData();
            accountList = dao.getAccountByRoleDB(role,orderBy);
        } catch (Exception ex) {
            Logger.getLogger(KyThuatForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void fillToTable(){
        DefaultTableModel tblModel=(DefaultTableModel) tblAccountList.getModel();
        tblModel.setRowCount(0); 
        for(NguoiDung account:accountList){
            Object[] row = new Object[]{account.getUserID(),account.getName(),account.getGender()
                        ,DateTimeUtil.LocalDateTimeToStringDay(account.getBirthday())
                        ,account.getEmail(),account.getPhoneNumber(),account.getAddress(),account.getRole()};
            tblModel.addRow(row);
        }
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

    private void showForm(int index){// error: cần xóa các panel activity cũ khi loading lại 
        
        if(index!=selectedItemMenu){
           
            Font fontOfNewBtnMenu= new Font("Segoe UI",Font.BOLD,14);
            Font fontOfOldBtnMenu= new Font("Segoe UI",Font.PLAIN,14);
            switch( selectedItemMenu){
                case 1:
                    btnHome.setFont(fontOfOldBtnMenu);
                    
                    pnlHome.setOpaque(false);
                    break;
                case 2:
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
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbNameAccountDlg = new javax.swing.JLabel();
        lblIdAccountDlg = new javax.swing.JLabel();
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
        jPanel4 = new javax.swing.JPanel();
        pnlToolbar1 = new javax.swing.JPanel();
        pnlAMBody = new javax.swing.JPanel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        lblAvatar = new javax.swing.JLabel();
        lblNameUser = new javax.swing.JLabel();
        pnlMenuBar = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        pnlHome = new javax.swing.JPanel();
        btnHome = new javax.swing.JButton();
        pnlLogout = new javax.swing.JPanel();
        btnLogout = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        pnlMainBody = new javax.swing.JPanel();
        pnlAccountManagerForm = new javax.swing.JPanel();
        pnlToolbar = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txtSearch2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cmbSort = new javax.swing.JComboBox<>();
        btnSearch = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        pnlMainBody1 = new javax.swing.JPanel();
        cpActivityRegistered = new javax.swing.JScrollPane();
        tblAccountList = new javax.swing.JTable();

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

        jLabel6.setText("Mã tài khoản");

        jLabel8.setText("Ngày sinh:");

        jLabel9.setText("Số điện thoại:");

        jLabel10.setText("Email:");

        lbNameAccountDlg.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbNameAccountDlg.setForeground(new java.awt.Color(102, 102, 102));
        lbNameAccountDlg.setText("Nguyen Van A");
        lbNameAccountDlg.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lblIdAccountDlg.setText("N21DCCN000");

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
                                .addComponent(lblIdAccountDlg, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAvatarDlg, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbNameAccountDlg, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(lblIdAccountDlg))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(lblBirthdayDlg))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(lblPhoneNumberDlg))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(lblEmailDlg))
                        .addGap(34, 34, 34)
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

        pnlAMBody.setOpaque(false);
        pnlAMBody.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlToolbar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlAMBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(pnlToolbar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlAMBody, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        btnHome.setText("QUẢN LÝ TÀI KHOẢN");
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
            .addGap(0, 408, Short.MAX_VALUE)
        );

        pnlMenuBar.add(jPanel15);

        pnlMainBody.setBackground(new java.awt.Color(255, 255, 255));
        pnlMainBody.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(102, 102, 102)));
        pnlMainBody.setLayout(new java.awt.BorderLayout());

        pnlAccountManagerForm.setBackground(new java.awt.Color(255, 255, 255));

        pnlToolbar.setBackground(new java.awt.Color(250, 204, 65));

        jButton1.setBackground(new java.awt.Color(51, 153, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Thêm tài khoản mới");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(204, 51, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Xóa tài khoản ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(229, 229, 229));
        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(51, 51, 51));
        jButton3.setText("Cập nhật thông tin tài khoản");

        txtSearch2.setForeground(new java.awt.Color(153, 153, 153));
        txtSearch2.setText("Tìm kiếm");
        txtSearch2.setPreferredSize(new java.awt.Dimension(64, 30));
        txtSearch2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearch2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSearch2FocusLost(evt);
            }
        });
        txtSearch2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSearch2MouseClicked(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Sắp xếp:");

        cmbSort.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã tài khoản", "Tên tài khoản" }));
        cmbSort.setMinimumSize(new java.awt.Dimension(127, 30));
        cmbSort.setPreferredSize(new java.awt.Dimension(127, 30));
        cmbSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSortActionPerformed(evt);
            }
        });

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Search.24.png"))); // NOI18N

        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Hiện đối tượng:");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setForeground(new java.awt.Color(51, 51, 51));
        jRadioButton1.setText("Sinh Viên");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setForeground(new java.awt.Color(51, 51, 51));
        jRadioButton2.setText("Người đăng");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setForeground(new java.awt.Color(51, 51, 51));
        jRadioButton3.setText("Quản lý");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setForeground(new java.awt.Color(51, 51, 51));
        jRadioButton4.setSelected(true);
        jRadioButton4.setText("Tất cả");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlToolbarLayout = new javax.swing.GroupLayout(pnlToolbar);
        pnlToolbar.setLayout(pnlToolbarLayout);
        pnlToolbarLayout.setHorizontalGroup(
            pnlToolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlToolbarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlToolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlToolbarLayout.createSequentialGroup()
                        .addComponent(txtSearch2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlToolbarLayout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlToolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlToolbarLayout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlToolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbSort, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlToolbarLayout.createSequentialGroup()
                        .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlToolbarLayout.setVerticalGroup(
            pnlToolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlToolbarLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlToolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlToolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtSearch2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlToolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jRadioButton2)
                        .addComponent(jRadioButton3)
                        .addComponent(jLabel11)
                        .addComponent(jRadioButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(pnlToolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlToolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbSort, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addGroup(pnlToolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton3)
                        .addComponent(jButton1)
                        .addComponent(jButton2)))
                .addContainerGap())
        );

        pnlMainBody1.setOpaque(false);
        pnlMainBody1.setLayout(new java.awt.BorderLayout());

        cpActivityRegistered.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        tblAccountList.setModel(new javax.swing.table.DefaultTableModel(
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
        tblAccountList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblAccountList.getTableHeader().setReorderingAllowed(false);
        cpActivityRegistered.setViewportView(tblAccountList);
        tblAccountList.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tblAccountList.getColumnModel().getColumnCount() > 0) {
            tblAccountList.getColumnModel().getColumn(0).setResizable(false);
            tblAccountList.getColumnModel().getColumn(0).setPreferredWidth(90);
            tblAccountList.getColumnModel().getColumn(1).setPreferredWidth(250);
            tblAccountList.getColumnModel().getColumn(2).setResizable(false);
            tblAccountList.getColumnModel().getColumn(2).setPreferredWidth(60);
            tblAccountList.getColumnModel().getColumn(3).setResizable(false);
            tblAccountList.getColumnModel().getColumn(3).setPreferredWidth(60);
            tblAccountList.getColumnModel().getColumn(4).setResizable(false);
            tblAccountList.getColumnModel().getColumn(4).setPreferredWidth(80);
            tblAccountList.getColumnModel().getColumn(5).setResizable(false);
            tblAccountList.getColumnModel().getColumn(5).setPreferredWidth(60);
            tblAccountList.getColumnModel().getColumn(6).setResizable(false);
            tblAccountList.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblAccountList.getColumnModel().getColumn(7).setResizable(false);
        }

        pnlMainBody1.add(cpActivityRegistered, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout pnlAccountManagerFormLayout = new javax.swing.GroupLayout(pnlAccountManagerForm);
        pnlAccountManagerForm.setLayout(pnlAccountManagerFormLayout);
        pnlAccountManagerFormLayout.setHorizontalGroup(
            pnlAccountManagerFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlToolbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlMainBody1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlAccountManagerFormLayout.setVerticalGroup(
            pnlAccountManagerFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAccountManagerFormLayout.createSequentialGroup()
                .addComponent(pnlToolbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlMainBody1, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE))
        );

        pnlMainBody.add(pnlAccountManagerForm, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, 1389, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(pnlMenuBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(pnlMainBody, javax.swing.GroupLayout.DEFAULT_SIZE, 1139, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlMainBody, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
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

        setSize(new java.awt.Dimension(1403, 650));
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

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        //btnHome.setFont();
        //pnlHome.setOpaque(true);
        showForm(1);
  
    }//GEN-LAST:event_btnHomeActionPerformed

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
        AccountAdd addAccountDlg = new AccountAdd(this, true);
        addAccountDlg.setLocationRelativeTo(null);
        addAccountDlg.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtSearch2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearch2FocusGained

    }//GEN-LAST:event_txtSearch2FocusGained

    private void txtSearch2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearch2FocusLost
//
    }//GEN-LAST:event_txtSearch2FocusLost

    private void txtSearch2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearch2MouseClicked
        //        if(jTextField1.getText().equals("Tìm kiếm".strip())){
            //            jTextField1.setText("");
            //        }
    }//GEN-LAST:event_txtSearch2MouseClicked

    private void cmbSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSortActionPerformed
        if(cmbSort.getSelectedIndex()==1){
            oderBy=AccountData.OrderBy.ID_ACCOUNT;
        }else{
            oderBy=AccountData.OrderBy.NAME_ACCOUNT;
        }
    }//GEN-LAST:event_cmbSortActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        getAccountList(oderBy);
        fillToTable();
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        getAccountListByRole(AccountData.AccountRole.STUDENT,oderBy);
        fillToTable();
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        getAccountListByRole(AccountData.AccountRole.POSTER,oderBy);
       
        fillToTable();
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        getAccountListByRole(AccountData.AccountRole.MANAGER,oderBy);
        fillToTable();
    }//GEN-LAST:event_jRadioButton3ActionPerformed

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
    private javax.swing.JButton btnSearch;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cmbSort;
    private javax.swing.JScrollPane cpActivityRegistered;
    private javax.swing.JDialog dlgAccountInformation;
    private javax.swing.JPanel header;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JLabel lbNameAccountDlg;
    private javax.swing.JLabel lblAvatar;
    private javax.swing.JLabel lblAvatarDlg;
    private javax.swing.JLabel lblBirthdayDlg;
    private javax.swing.JLabel lblEmailDlg;
    private javax.swing.JLabel lblIdAccountDlg;
    private javax.swing.JLabel lblNameUser;
    private javax.swing.JLabel lblPhoneNumberDlg;
    private javax.swing.JPanel pnlAMBody;
    private javax.swing.JPanel pnlAccountManagerForm;
    private javax.swing.JPanel pnlHome;
    private javax.swing.JPanel pnlLogout;
    private javax.swing.JPanel pnlMainBody;
    private javax.swing.JPanel pnlMainBody1;
    private javax.swing.JPanel pnlMenuBar;
    private javax.swing.JPanel pnlToolbar;
    private javax.swing.JPanel pnlToolbar1;
    private javax.swing.JTable tblAccountList;
    private javax.swing.JTextField txtSearch2;
    // End of variables declaration//GEN-END:variables
}
