/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ttcs.quanlyhdnk.component.activity;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ttcs.quanlyhdnk.DAO.SinhVien.StudentRegister;
import ttcs.quanlyhdnk.model.Activity;
import ttcs.quanlyhdnk.model.DangKy;
import ttcs.quanlyhdnk.util.DateTimeUtil;
import ttcs.quanlyhdnk.util.Image;

/**
 *
 * @author ADMIN
 */
public class ActivityDroppingOutPanel extends javax.swing.JPanel {

    private DangKy dangKy = new DangKy();
    public ActivityDroppingOutPanel() {
        initComponents();
    }

    public ActivityDroppingOutPanel(DangKy dangKy) {
        initComponents();
        this.dangKy=dangKy;
        setContentForCard();
        setContentForDlg();
    }
    private void setContentForCard(){
        taContent.setText(dangKy.getActivity().getContent());
        lblTitle.setText(dangKy.getActivity().getTitle());
        lblGenre.setText(dangKy.getActivity().getGenre());
        lblNameUser.setText(dangKy.getActivity().getNameUser());
        lblPostingTime.setText(DateTimeUtil.LocalDateTimeToStringDayTime(dangKy.getActivity().getPostingTime()));//sua 3 dong nay
        lblStartTime.setText(DateTimeUtil.LocalDateTimeToStringDayTime(dangKy.getActivity().getStartDate()));
        lblEndTime.setText(DateTimeUtil.LocalDateTimeToStringDayTime(dangKy.getActivity().getEndDate()));
        lblIDRegister.setText(String.valueOf(dangKy.getId()));
        lblRegisterTime.setText(DateTimeUtil.LocalDateTimeToStringDayTime(dangKy.getRegistrationsTime()));
        try {
            if(dangKy.getActivity().getPicture()!=null){
                lblPicture.setIcon(Image.ByteToImageIcon(dangKy.getActivity().getPicture()));
            }
        } catch (IOException ex) {
            Logger.getLogger(ActivityPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        //lblEndTime.setIcon();
    }
    private void setContentForDlg(){
        taContentOfDlg.setText(dangKy.getActivity().getContent());
        lblTitleOfDlg.setText(dangKy.getActivity().getTitle());
        lblGenreOfDlg.setText(dangKy.getActivity().getGenre());
        taNameUserOfDlg.setText(dangKy.getActivity().getNameUser());
        lblPostingTimeOfDlg.setText(DateTimeUtil.LocalDateTimeToStringDayTime(dangKy.getActivity().getPostingTime()));//sua 3 dong nay
        lblStartTimeOfDlg.setText(DateTimeUtil.LocalDateTimeToStringDayTime(dangKy.getActivity().getStartDate()));
        lblEndTimeOfDlg.setText(DateTimeUtil.LocalDateTimeToStringDayTime(dangKy.getActivity().getEndDate()));
        taAddressDlg.setText(dangKy.getActivity().getAddress());
        lblPictureOfDlg.setIcon(lblPicture.getIcon());
        //lblEndTime.setIcon();
    }
    
    private void candelRegister(){
        try {
            StudentRegister studentRegister = new StudentRegister();
            if(studentRegister.cancelRegisierDB(dangKy.getIdAcountRegister(),dangKy.getActivity().getId())){
                this.setVisible(false);
                JOptionPane.showMessageDialog(this, "Bạn đã hủy thành công!");
               //System.out.println("Huy dk thanh cong");
            }else{
                JOptionPane.showMessageDialog(this, "Lỗi! Không thể hủy!");
               // System.out.println("Loi huy dk");
            }
        } catch (Exception ex) {
            Logger.getLogger(ActivityDroppingOutPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dlgActivityInformation = new javax.swing.JDialog();
        jPanel4 = new javax.swing.JPanel();
        lblTitleOfDlg = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblStartTimeOfDlg = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblEndTimeOfDlg = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblGenreOfDlg = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblPostingTimeOfDlg = new javax.swing.JLabel();
        lblPictureOfDlg = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taContentOfDlg = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        taNameUserOfDlg = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        taAddressDlg = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        lblRegisterQuantity1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lblIDRegister1 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lblRegisterTime1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblStartTime = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblEndTime = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblNameUser = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblGenre = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblPostingTime = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taContent = new javax.swing.JTextArea();
        lblRegisterQuantity = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lblIDRegister = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lblRegisterTime = new javax.swing.JLabel();
        lblPicture = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();

        dlgActivityInformation.setBackground(new java.awt.Color(255, 255, 255));
        dlgActivityInformation.setSize(new java.awt.Dimension(760, 650));

        jPanel4.setBackground(new java.awt.Color(229, 229, 229));
        jPanel4.setPreferredSize(new java.awt.Dimension(750, 630));
        jPanel4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPanel4formFocusGained(evt);
            }
        });
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4formMouseClicked(evt);
            }
        });

        lblTitleOfDlg.setBackground(new java.awt.Color(212, 212, 216));
        lblTitleOfDlg.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        lblTitleOfDlg.setForeground(new java.awt.Color(0, 102, 153));
        lblTitleOfDlg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitleOfDlg.setText("Tieu de cua hoat dong");
        lblTitleOfDlg.setOpaque(true);

        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Diễn ra từ:");

        lblStartTimeOfDlg.setBackground(new java.awt.Color(51, 51, 51));
        lblStartTimeOfDlg.setForeground(new java.awt.Color(102, 102, 102));
        lblStartTimeOfDlg.setText("00:00 01-01-2024");

        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("đến:");

        lblEndTimeOfDlg.setForeground(new java.awt.Color(102, 102, 102));
        lblEndTimeOfDlg.setText("00:00 01-01-2024");

        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Người đăng:");

        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Thể loại:");

        lblGenreOfDlg.setForeground(new java.awt.Color(51, 51, 51));
        lblGenreOfDlg.setText("Phong trào");

        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Đăng lúc:");

        lblPostingTimeOfDlg.setForeground(new java.awt.Color(102, 102, 102));
        lblPostingTimeOfDlg.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPostingTimeOfDlg.setText("00:00 01-01-2024");

        lblPictureOfDlg.setBackground(new java.awt.Color(255, 204, 0));
        lblPictureOfDlg.setForeground(new java.awt.Color(255, 255, 255));
        lblPictureOfDlg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPictureOfDlg.setText("Ảnh");
        lblPictureOfDlg.setOpaque(true);

        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("Địa điểm:");

        taContentOfDlg.setEditable(false);
        taContentOfDlg.setBackground(new java.awt.Color(242, 242, 242));
        taContentOfDlg.setColumns(20);
        taContentOfDlg.setLineWrap(true);
        taContentOfDlg.setRows(20);
        jScrollPane2.setViewportView(taContentOfDlg);

        jScrollPane3.setBorder(null);

        taNameUserOfDlg.setEditable(false);
        taNameUserOfDlg.setBackground(new java.awt.Color(229, 229, 229));
        taNameUserOfDlg.setColumns(20);
        taNameUserOfDlg.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        taNameUserOfDlg.setForeground(new java.awt.Color(255, 153, 0));
        taNameUserOfDlg.setLineWrap(true);
        taNameUserOfDlg.setRows(2);
        taNameUserOfDlg.setText("CLB Hoạt động tình nguyện Học viện công nghệ bưu chính viễn thông cơ sở    TPHCM");
        taNameUserOfDlg.setAutoscrolls(false);
        taNameUserOfDlg.setBorder(null);
        taNameUserOfDlg.setCaretColor(new java.awt.Color(238, 238, 238));
        jScrollPane3.setViewportView(taNameUserOfDlg);

        jScrollPane4.setBorder(null);

        taAddressDlg.setEditable(false);
        taAddressDlg.setBackground(new java.awt.Color(229, 229, 229));
        taAddressDlg.setColumns(20);
        taAddressDlg.setForeground(new java.awt.Color(51, 51, 51));
        taAddressDlg.setLineWrap(true);
        taAddressDlg.setRows(2);
        taAddressDlg.setText("Phong A00");
        taAddressDlg.setAutoscrolls(false);
        taAddressDlg.setBorder(null);
        taAddressDlg.setCaretColor(new java.awt.Color(238, 238, 238));
        jScrollPane4.setViewportView(taAddressDlg);

        jButton2.setBackground(new java.awt.Color(255, 51, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(242, 242, 242));
        jButton2.setText("Hủy đăng ký");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        lblRegisterQuantity1.setBackground(new java.awt.Color(255, 255, 255));
        lblRegisterQuantity1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblRegisterQuantity1.setForeground(new java.awt.Color(102, 102, 102));
        lblRegisterQuantity1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblRegisterQuantity1.setText("1000/1000 ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Số lượng còn lại:");
        jLabel2.setToolTipText("Số lượng sinh viên đã đăng ký");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 50, 76));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("Mã đăng ký :");
        jLabel16.setToolTipText("Mã đăng ký");

        lblIDRegister1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblIDRegister1.setForeground(new java.awt.Color(0, 102, 153));
        lblIDRegister1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblIDRegister1.setText("00000000");

        jLabel18.setForeground(new java.awt.Color(51, 51, 51));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("Đã đăng ký lúc : ");

        lblRegisterTime1.setForeground(new java.awt.Color(0, 51, 51));
        lblRegisterTime1.setText("00:00 01-01-2024");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblGenreOfDlg, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(lblStartTimeOfDlg, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblEndTimeOfDlg, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPostingTimeOfDlg)
                                .addGap(8, 8, 8))))
                    .addComponent(lblTitleOfDlg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(574, 574, 574)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lblPictureOfDlg, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblRegisterQuantity1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(lblIDRegister1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRegisterTime1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(270, 270, 270)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblTitleOfDlg, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblGenreOfDlg)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(lblStartTimeOfDlg)
                            .addComponent(jLabel7)
                            .addComponent(lblEndTimeOfDlg)
                            .addComponent(jLabel13)
                            .addComponent(lblPostingTimeOfDlg))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(lblRegisterQuantity1))
                        .addGap(2, 2, 2)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(lblIDRegister1)
                            .addComponent(jLabel18)
                            .addComponent(lblRegisterTime1)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblPictureOfDlg, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout dlgActivityInformationLayout = new javax.swing.GroupLayout(dlgActivityInformation.getContentPane());
        dlgActivityInformation.getContentPane().setLayout(dlgActivityInformationLayout);
        dlgActivityInformationLayout.setHorizontalGroup(
            dlgActivityInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
        );
        dlgActivityInformationLayout.setVerticalGroup(
            dlgActivityInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(244, 244, 244));
        setMaximumSize(new java.awt.Dimension(800, 240));
        setMinimumSize(new java.awt.Dimension(800, 240));
        setPreferredSize(new java.awt.Dimension(800, 240));

        jPanel2.setBackground(new java.awt.Color(244, 244, 244));
        jPanel2.setMaximumSize(new java.awt.Dimension(590, 240));
        jPanel2.setMinimumSize(new java.awt.Dimension(590, 240));
        jPanel2.setPreferredSize(new java.awt.Dimension(590, 240));
        jPanel2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPanel2formFocusGained(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2formMouseClicked(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(0, 102, 204));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitle.setText("Tieu de cua hoat dong");
        lblTitle.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Diễn ra từ :");

        lblStartTime.setForeground(new java.awt.Color(51, 51, 51));
        lblStartTime.setText("00:00 01-01-2024");

        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("đến");

        lblEndTime.setForeground(new java.awt.Color(51, 51, 51));
        lblEndTime.setText("00:00 01-01-2024");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Từ             :");

        lblNameUser.setForeground(new java.awt.Color(51, 51, 51));
        lblNameUser.setText("CLB Hoạt động tình nguyện Học viện công nghệ bưu chính viễn thông cơ sở TPHCM");

        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Thể loại    :");

        lblGenre.setForeground(new java.awt.Color(51, 51, 51));
        lblGenre.setText("Phong trào");

        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Đăng lúc:");

        lblPostingTime.setForeground(new java.awt.Color(51, 51, 51));
        lblPostingTime.setText("00:00 01-01-2024");

        jScrollPane1.setBorder(null);

        taContent.setEditable(false);
        taContent.setBackground(new java.awt.Color(255, 255, 255));
        taContent.setColumns(20);
        taContent.setForeground(new java.awt.Color(51, 51, 51));
        taContent.setRows(5);
        taContent.setText("   Mô tả hoạt động\n\n\n\n\n\n\n\n");
        taContent.setBorder(null);
        jScrollPane1.setViewportView(taContent);

        lblRegisterQuantity.setBackground(new java.awt.Color(255, 255, 255));
        lblRegisterQuantity.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblRegisterQuantity.setForeground(new java.awt.Color(102, 102, 102));
        lblRegisterQuantity.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblRegisterQuantity.setText("1000/1000 ");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Số lượng:");
        jLabel1.setToolTipText("Số lượng sinh viên đã đăng ký");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 51, 102));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Mã ĐK :");
        jLabel15.setToolTipText("Mã đăng ký");

        lblIDRegister.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblIDRegister.setForeground(new java.awt.Color(0, 102, 153));
        lblIDRegister.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblIDRegister.setText("00000000");

        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Đã đăng ký lúc : ");

        lblRegisterTime.setForeground(new java.awt.Color(0, 51, 51));
        lblRegisterTime.setText("00:00 01-01-2024");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(lblStartTime, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblGenre, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblEndTime, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPostingTime, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblNameUser, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRegisterQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRegisterTime, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblIDRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addGap(12, 12, 12))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lblNameUser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lblGenre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStartTime)
                    .addComponent(jLabel6)
                    .addComponent(lblEndTime)
                    .addComponent(lblPostingTime)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblRegisterQuantity)
                    .addComponent(jLabel15)
                    .addComponent(lblIDRegister)
                    .addComponent(jLabel17)
                    .addComponent(lblRegisterTime))
                .addGap(10, 10, 10))
        );

        lblPicture.setBackground(new java.awt.Color(255, 204, 0));
        lblPicture.setForeground(new java.awt.Color(255, 255, 255));
        lblPicture.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPicture.setMaximumSize(new java.awt.Dimension(288, 288));
        lblPicture.setMinimumSize(new java.awt.Dimension(100, 100));
        lblPicture.setName(""); // NOI18N
        lblPicture.setOpaque(true);

        btnCancel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(153, 153, 153));
        btnCancel.setText("Hủy đăng ký");
        btnCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelMouseClicked(evt);
            }
        });
        btnCancel.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                btnCancelComponentResized(evt);
            }
        });
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblPicture, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addGap(8, 8, 8))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel4formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel4formFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel4formFocusGained

    private void jPanel4formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4formMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel4formMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       int kq=JOptionPane.showConfirmDialog(this, "Bạn có muốn hủy hoạt động này không?",
                "Xác nhận",JOptionPane.YES_OPTION,JOptionPane.NO_OPTION);
        if(kq==JOptionPane.YES_OPTION){
        candelRegister();
        dlgActivityInformation.dispose();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnCancelComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_btnCancelComponentResized
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelComponentResized

    private void btnCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMouseClicked
//        System.out.println("ádsdd");
    }//GEN-LAST:event_btnCancelMouseClicked

    private void jPanel2formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2formMouseClicked
        //       JOptionPane.showConfirmDialog(this,"Chi tiet hoat dong");

        dlgActivityInformation.setVisible(true);
        dlgActivityInformation.setLocationRelativeTo(null);
        //       List<HoatDong> ListHD= new ArrayList<>();
        //        try {
            //            ListHoatDong daoList = new ListHoatDong();
            //            ListHD = daoList.getList();
            //            for(int i=0;i<ListHD.size();i++){
                //                System.out.println(DateTimeUtil.LocalDateTimeToString(ListHD.get(i).getPostingTime()));
                //            }
            //        } catch (Exception ex) {
            //            System.out.println("aasdasdsd");
            //            Logger.getLogger(HoatDongCard.class.getName()).log(Level.SEVERE, null, ex);
            //        }
    }//GEN-LAST:event_jPanel2formMouseClicked

    private void jPanel2formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel2formFocusGained
        
        

    }//GEN-LAST:event_jPanel2formFocusGained

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        int kq=JOptionPane.showConfirmDialog(this, "Bạn có muốn hủy hoạt động này không?",
                "Xác nhận",JOptionPane.YES_OPTION,JOptionPane.NO_OPTION);
        if(kq==JOptionPane.YES_OPTION){
            candelRegister();
        }
    }//GEN-LAST:event_btnCancelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JDialog dlgActivityInformation;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblEndTime;
    private javax.swing.JLabel lblEndTimeOfDlg;
    private javax.swing.JLabel lblGenre;
    private javax.swing.JLabel lblGenreOfDlg;
    private javax.swing.JLabel lblIDRegister;
    private javax.swing.JLabel lblIDRegister1;
    private javax.swing.JLabel lblNameUser;
    private javax.swing.JLabel lblPicture;
    private javax.swing.JLabel lblPictureOfDlg;
    private javax.swing.JLabel lblPostingTime;
    private javax.swing.JLabel lblPostingTimeOfDlg;
    private javax.swing.JLabel lblRegisterQuantity;
    private javax.swing.JLabel lblRegisterQuantity1;
    private javax.swing.JLabel lblRegisterTime;
    private javax.swing.JLabel lblRegisterTime1;
    private javax.swing.JLabel lblStartTime;
    private javax.swing.JLabel lblStartTimeOfDlg;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitleOfDlg;
    private javax.swing.JTextArea taAddressDlg;
    private javax.swing.JTextArea taContent;
    private javax.swing.JTextArea taContentOfDlg;
    private javax.swing.JTextArea taNameUserOfDlg;
    // End of variables declaration//GEN-END:variables
}
