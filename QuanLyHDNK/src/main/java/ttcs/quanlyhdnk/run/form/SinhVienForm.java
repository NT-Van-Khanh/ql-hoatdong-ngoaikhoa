package ttcs.quanlyhdnk.run.form;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;
import ttcs.quanlyhdnk.DAO.SinhVien.StudentActivity;
import ttcs.quanlyhdnk.form.ActivityPanel;
import ttcs.quanlyhdnk.form.ActivityRegisterPanel;
import ttcs.quanlyhdnk.model.Activity;
import ttcs.quanlyhdnk.model.NguoiDung;
import ttcs.quanlyhdnk.model.SinhVien;
import ttcs.quanlyhdnk.run.*;
import ttcs.quanlyhdnk.util.DateTimeUtil;
import ttcs.quanlyhdnk.util.SHA256Encryption;

import ttcs.quanlyhdnk.util.DateTimeUtil;
import java.time.LocalDateTime;
/**
 *
 * @author ADMIN
 */
public class SinhVienForm extends javax.swing.JFrame {
    private int selectedItemMenu=1;
    private NguoiDung account = new NguoiDung();
    String pw=SHA256Encryption.toSHA256("abcdef");
    public SinhVienForm() {
        initComponents();
    //Load data
        account.setUserID("N21DCCN000");
        loadCurrentActivitiesPanel(); 
        System.out.println(pw);
    //design frame
//        setExtendedState(MAXIMIZED_BOTH);
    //test

    }
    public SinhVienForm(NguoiDung account) {
        initComponents();
    //Load data
        this.account=account;
        InforOfSinhVienForm();
        loadCurrentActivitiesPanel(); 
        loadInformationOfStudentDlg();
    //design frame
//        setExtendedState(MAXIMIZED_BOTH);
    //test
    }
    
    private void InforOfSinhVienForm(){
        lblNameUser.setText(account.getName());
    }
    //
    private void showForm(int index){
        if(index!=selectedItemMenu){
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
    
    private void setSizeFormSanPham(int soLuong){
        Dimension dimension = new Dimension(pnlListHD.getWidth(),(int)(soLuong*210+10));
        pnlListHD.setPreferredSize(dimension);
    }
    
    private void setSizeFormSanPham(int soLuong,int soLuongDK){
        Dimension dimension = new Dimension(pnlListHD.getWidth(),(int)(soLuong*220+ soLuongDK*240+10));
        pnlListHD.setPreferredSize(dimension);
    }    
    //data transmission another form
    private void loadInformationOfStudentDlg(){
        lblStudentNameDlg.setText(account.getName());
        lblStudentIDDlg.setText(account.getUserID());
       // lblClassDlg.setText("tam thoi chua co");
        lblBirthdayDlg.setText(DateTimeUtil.LocalDateTimeToStringDay(account.getBirthday()));
        lblPhoneNumberDlg.setText(account.getPhoneNumber());
        lblEmailDlg.setText(account.getEmail());
    }
    
    //data transmission
    private void loadCurrentActivitiesPanel(){ 
        List<Activity> ListHD=  loadActivityList();
        loadActivityPanelList( ListHD);
    }
    
    private void loadTakenActivitiesPanel(String IDAccount){
        List<Activity> ListHD= loadTakenActivities(IDAccount);
        loadActivityPanelList( ListHD);
    }
    
    private void loadParticipationHistoryPanel(String IDAccount){
        List<Activity> ListHD= loadParticipationHistory(IDAccount);
        loadActivityPanelList( ListHD);
    }
    
    private void loadActivityPanelList(List<Activity> ListHD){
        pnlListHD.removeAll();
        if(!ListHD.isEmpty()){
            for(int index =0;index<ListHD.size();++index){
                //System.out.println(ListHD.get(index).getId());
                ActivityPanel activityPanel =new ActivityPanel(ListHD.get(index));
                pnlListHD.add(activityPanel);
            }
             pnlListHD.add(new ActivityRegisterPanel());
        }
        pnlListHD.revalidate();
        pnlListHD.repaint();
        setSizeFormSanPham(ListHD.size(),1);
    }
    
    
    //loading data  
    private List<Activity> loadTakenActivities(String IDAccount){
        
        List<Activity> activityList = new ArrayList<>();
        try {
            StudentActivity daoList = new StudentActivity();
            activityList = daoList.getTakenActivities(IDAccount);          
        } catch (Exception ex) {
           // System.out.println("aasdasdsd"); Thong bao loi
            Logger.getLogger(ActivityPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return activityList;
    }
    
    private List<Activity> loadParticipationHistory(String IDAccount){
        
        List<Activity> activityList = new ArrayList<>();
        try {
            
            StudentActivity daoList = new StudentActivity();
            activityList = daoList.getParticipationHistory(IDAccount); 
            
        } catch (Exception ex) {
     
            Logger.getLogger(ActivityPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return activityList;
    }
    
    private List<Activity> loadActivityList(){
        
        List<Activity> activityList = new ArrayList<>();
        try {
            StudentActivity daoList = new StudentActivity();
            activityList = daoList.getCurrentActivities();           
        } catch (Exception ex) {
           // System.out.println("aasdasdsd"); Thong bao loi
            Logger.getLogger(ActivityPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return activityList;
    }
    
    
    private void cmbSortLoadData(){
        
    }
    
    private void reLoadData(String type){
        pnlListHD.removeAll();
        cmbSort.removeAllItems();
        cmbSortLoadData();  
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dlgSinhVienInformation = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        lblAvatarDlg = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblStudentNameDlg = new javax.swing.JLabel();
        lblStudentIDDlg = new javax.swing.JLabel();
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
        dlgNotification = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        notificationPanel1 = new ttcs.quanlyhdnk.form.NotificationPanel();
        notificationPanel2 = new ttcs.quanlyhdnk.form.NotificationPanel();
        notificationPanel3 = new ttcs.quanlyhdnk.form.NotificationPanel();
        notificationPanel4 = new ttcs.quanlyhdnk.form.NotificationPanel();
        notificationPanel5 = new ttcs.quanlyhdnk.form.NotificationPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        lblAvatar = new javax.swing.JLabel();
        lblNameUser = new javax.swing.JLabel();
        btnTB = new javax.swing.JButton();
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
        pnlBody = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        cmbSort = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        pnlListHD = new javax.swing.JPanel();
        activityRegisterPanel1 = new ttcs.quanlyhdnk.form.ActivityRegisterPanel();

        dlgSinhVienInformation.setTitle("Thông tin tài khoản");
        dlgSinhVienInformation.setAlwaysOnTop(true);
        dlgSinhVienInformation.setBackground(new java.awt.Color(255, 255, 255));
        dlgSinhVienInformation.setSize(new java.awt.Dimension(650, 340));

        jPanel2.setBackground(new java.awt.Color(235, 235, 235));

        lblAvatarDlg.setBackground(new java.awt.Color(0, 102, 153));
        lblAvatarDlg.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblAvatarDlg.setForeground(new java.awt.Color(255, 255, 255));
        lblAvatarDlg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAvatarDlg.setText("avatar");
        lblAvatarDlg.setOpaque(true);

        jLabel6.setText("MSV:");

        jLabel7.setText("Lớp:");

        jLabel8.setText("Ngày sinh:");

        jLabel9.setText("Số điện thoại:");

        jLabel10.setText("Email:");

        lblStudentNameDlg.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblStudentNameDlg.setForeground(new java.awt.Color(102, 102, 102));
        lblStudentNameDlg.setText("Nguyen Van A");
        lblStudentNameDlg.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lblStudentIDDlg.setText("N21DCCN000");

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
                                .addComponent(lblStudentIDDlg, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblClassDlg, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblEmailDlg, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblStudentNameDlg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                        .addComponent(lblStudentNameDlg, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(lblStudentIDDlg))
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

        javax.swing.GroupLayout dlgSinhVienInformationLayout = new javax.swing.GroupLayout(dlgSinhVienInformation.getContentPane());
        dlgSinhVienInformation.getContentPane().setLayout(dlgSinhVienInformationLayout);
        dlgSinhVienInformationLayout.setHorizontalGroup(
            dlgSinhVienInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgSinhVienInformationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dlgSinhVienInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        dlgSinhVienInformationLayout.setVerticalGroup(
            dlgSinhVienInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgSinhVienInformationLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        dlgNotification.setUndecorated(true);
        dlgNotification.setSize(new java.awt.Dimension(320, 390));
        dlgNotification.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                dlgNotificationFocusLost(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(229, 229, 229));
        jPanel3.setMinimumSize(new java.awt.Dimension(320, 370));
        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 2));
        jPanel3.add(notificationPanel1);
        jPanel3.add(notificationPanel2);
        jPanel3.add(notificationPanel3);
        jPanel3.add(notificationPanel4);
        jPanel3.add(notificationPanel5);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Xem thêm");
        jLabel1.setOpaque(true);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 204));
        jLabel2.setText("Thông báo");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout dlgNotificationLayout = new javax.swing.GroupLayout(dlgNotification.getContentPane());
        dlgNotification.getContentPane().setLayout(dlgNotificationLayout);
        dlgNotificationLayout.setHorizontalGroup(
            dlgNotificationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dlgNotificationLayout.setVerticalGroup(
            dlgNotificationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgNotificationLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hoạt Động Ngoại Khóa");
        setBackground(new java.awt.Color(255, 255, 255));
        setSize(new java.awt.Dimension(1100, 650));

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

        btnTB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/notification.png"))); // NOI18N
        btnTB.setContentAreaFilled(false);
        btnTB.setMaximumSize(new java.awt.Dimension(50, 50));
        btnTB.setMinimumSize(new java.awt.Dimension(50, 50));
        btnTB.setPreferredSize(new java.awt.Dimension(50, 50));
        btnTB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblAvatar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNameUser, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNameUser, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        pnlHome.setOpaque(false);
        pnlHome.setPreferredSize(new java.awt.Dimension(220, 45));

        btnHome.setBackground(new java.awt.Color(38, 168, 255));
        btnHome.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHome.setForeground(new java.awt.Color(255, 255, 255));
        btnHome.setText("TRANG CHỦ");
        btnHome.setContentAreaFilled(false);
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
        btnRegistrationHistory.setText("ĐÃ ĐĂNG KÝ");
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
        btnParticipationHistory.setText("ĐÃ THAM GIA");
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
            .addGap(0, 322, Short.MAX_VALUE)
        );

        pnlMenuBar.add(jPanel15);

        pnlBody.setBackground(new java.awt.Color(255, 255, 255));
        pnlBody.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(102, 102, 102)));

        jPanel16.setBackground(new java.awt.Color(250, 204, 65));

        cmbSort.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tên", "Thời gian bắt đầu", "Thời gian kết thúc" }));
        cmbSort.setMinimumSize(new java.awt.Dimension(127, 30));
        cmbSort.setPreferredSize(new java.awt.Dimension(127, 30));
        cmbSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSortActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Sắp xếp:");

        txtSearch.setForeground(new java.awt.Color(153, 153, 153));
        txtSearch.setText("Tìm kiếm");
        txtSearch.setPreferredSize(new java.awt.Dimension(64, 30));
        txtSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSearchFocusLost(evt);
            }
        });
        txtSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSearchMouseClicked(evt);
            }
        });

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Search.24.png"))); // NOI18N

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbSort, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbSort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(txtSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel17.setOpaque(false);

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setMinimumSize(new java.awt.Dimension(830, 6));

        pnlListHD.setBackground(new java.awt.Color(255, 255, 255));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 10);
        flowLayout1.setAlignOnBaseline(true);
        pnlListHD.setLayout(flowLayout1);
        pnlListHD.add(activityRegisterPanel1);

        jScrollPane2.setViewportView(pnlListHD);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlBodyLayout = new javax.swing.GroupLayout(pnlBody);
        pnlBody.setLayout(pnlBodyLayout);
        pnlBodyLayout.setHorizontalGroup(
            pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlBodyLayout.setVerticalGroup(
            pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBodyLayout.createSequentialGroup()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(pnlBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        dlgSinhVienInformation.setVisible(true);
        dlgSinhVienInformation.setLocationRelativeTo(null);
        
    }//GEN-LAST:event_lblAvatarMouseClicked

    private void btnChangePasswordDlgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangePasswordDlgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnChangePasswordDlgActionPerformed

    private void txtSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchMouseClicked
//        if(jTextField1.getText().equals("Tìm kiếm".strip())){
//            jTextField1.setText("");
//        }
    }//GEN-LAST:event_txtSearchMouseClicked

    private void txtSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusGained
        if(txtSearch.getText().equals("Tìm kiếm".strip())){
            txtSearch.setText("");
            txtSearch.setForeground(new Color(51,51,51));
        }
    }//GEN-LAST:event_txtSearchFocusGained

    private void txtSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusLost
        if(txtSearch.getText().equals("".strip())){
            txtSearch.setText("Tìm kiếm");
            txtSearch.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_txtSearchFocusLost

    private void btnTBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTBActionPerformed
        dlgNotification.setVisible(true);
        // dlgNotification.setLocationRelativeTo(btnTB);
          dlgNotification.setLocation(btnTB.getLocation());
    }//GEN-LAST:event_btnTBActionPerformed

    private void btnHomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseEntered
        btnHome.setOpaque(true);
    }//GEN-LAST:event_btnHomeMouseEntered

    private void btnHomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseExited
        btnHome.setOpaque(false);
    }//GEN-LAST:event_btnHomeMouseExited

    private void btnRegistrationHistoryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrationHistoryMouseEntered
        btnRegistrationHistory.setOpaque(true);
    }//GEN-LAST:event_btnRegistrationHistoryMouseEntered

    private void btnParticipationHistoryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnParticipationHistoryMouseEntered
        btnParticipationHistory.setOpaque(true);
    }//GEN-LAST:event_btnParticipationHistoryMouseEntered

    private void btnRegistrationHistoryMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrationHistoryMouseExited
         btnRegistrationHistory.setOpaque(false);
    }//GEN-LAST:event_btnRegistrationHistoryMouseExited

    private void btnParticipationHistoryMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnParticipationHistoryMouseExited
         btnParticipationHistory.setOpaque(false);
    }//GEN-LAST:event_btnParticipationHistoryMouseExited

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        //btnHome.setFont();
        //pnlHome.setOpaque(true);
        showForm(1);
        loadCurrentActivitiesPanel();
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnRegistrationHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrationHistoryActionPerformed
        showForm(2);
        loadTakenActivitiesPanel(account.getUserID());
    }//GEN-LAST:event_btnRegistrationHistoryActionPerformed

    private void btnParticipationHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnParticipationHistoryActionPerformed
        // ChuaHoanThanh();
        showForm(3);
        loadParticipationHistoryPanel(account.getUserID());
        
//        pnlListHD.removeAll();
//        pnlListHD.revalidate();
//        pnlListHD.repaint();
    }//GEN-LAST:event_btnParticipationHistoryActionPerformed

    private void btnLogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseEntered
        btnLogout.setOpaque(true);
    }//GEN-LAST:event_btnLogoutMouseEntered

    private void btnLogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseExited
        btnLogout.setOpaque(false);
    }//GEN-LAST:event_btnLogoutMouseExited

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        int kq=JOptionPane.showConfirmDialog(this, "Bạn có muốn đăng xuất không?",
                "Xác nhận",JOptionPane.YES_OPTION,JOptionPane.NO_OPTION);
        if(kq==JOptionPane.YES_OPTION){
            this.setVisible(false);
            Login login = new Login();
            login.setVisible(true);
        }else if(kq==JOptionPane.NO_OPTION){
            
        }else {
            
        }
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnLogoutFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnLogoutFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLogoutFocusGained

    private void dlgNotificationFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dlgNotificationFocusLost
        dlgNotification.setVisible(false);
    }//GEN-LAST:event_dlgNotificationFocusLost

    private void cmbSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSortActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbSortActionPerformed

    private void btnHomeMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseMoved
        btnHome.setOpaque(true);
    }//GEN-LAST:event_btnHomeMouseMoved

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
            Logger.getLogger(SinhVienForm.class.getName()).log(Level.SEVERE, null, ex);
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
                new SinhVienForm(nguoiDung).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ttcs.quanlyhdnk.form.ActivityRegisterPanel activityRegisterPanel1;
    private javax.swing.JButton btnChangePasswordDlg;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnParticipationHistory;
    private javax.swing.JButton btnRegistrationHistory;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnTB;
    private javax.swing.JComboBox<String> cmbSort;
    private javax.swing.JDialog dlgNotification;
    private javax.swing.JDialog dlgSinhVienInformation;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAvatar;
    private javax.swing.JLabel lblAvatarDlg;
    private javax.swing.JLabel lblBirthdayDlg;
    private javax.swing.JLabel lblClassDlg;
    private javax.swing.JLabel lblEmailDlg;
    private javax.swing.JLabel lblNameUser;
    private javax.swing.JLabel lblPhoneNumberDlg;
    private javax.swing.JLabel lblStudentIDDlg;
    private javax.swing.JLabel lblStudentNameDlg;
    private ttcs.quanlyhdnk.form.NotificationPanel notificationPanel1;
    private ttcs.quanlyhdnk.form.NotificationPanel notificationPanel2;
    private ttcs.quanlyhdnk.form.NotificationPanel notificationPanel3;
    private ttcs.quanlyhdnk.form.NotificationPanel notificationPanel4;
    private ttcs.quanlyhdnk.form.NotificationPanel notificationPanel5;
    private javax.swing.JPanel pnlBody;
    private javax.swing.JPanel pnlHome;
    private javax.swing.JPanel pnlListHD;
    private javax.swing.JPanel pnlLogout;
    private javax.swing.JPanel pnlMenuBar;
    private javax.swing.JPanel pnlParticipationHistory;
    private javax.swing.JPanel pnlRegistrationHistory;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
