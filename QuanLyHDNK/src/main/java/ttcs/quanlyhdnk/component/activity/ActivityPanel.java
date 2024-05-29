/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ttcs.quanlyhdnk.component.activity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ttcs.quanlyhdnk.DAO.SinhVien.StudentActivity;
import ttcs.quanlyhdnk.model.Activity;
import ttcs.quanlyhdnk.util.DateTimeUtil;
import ttcs.quanlyhdnk.util.Image;
/**
 *
 * @author ADMIN
 */
public class ActivityPanel extends javax.swing.JPanel {
    
    private Activity hoatDong = new Activity();
    public ActivityPanel(Activity hoatDong){
        initComponents();
        this.hoatDong=hoatDong;
        setContentForCard();
        setContentForDlg();
    }
    
    private void setContentForCard(){
        try {
            if(hoatDong.getPicture()!=null){
                lblPicture.setIcon(Image.ByteToImageIcon(hoatDong.getPicture()));
            }
        } catch (IOException ex) {
            Logger.getLogger(ActivityPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        taContent.setText(hoatDong.getContent());
        lblTitle.setText(hoatDong.getTitle());
        lblGenre.setText(hoatDong.getGenre());
        lblNameUser.setText(hoatDong.getNameUser());
        lblPostingTime.setText(DateTimeUtil.LocalDateTimeToStringDayTime(hoatDong.getPostingTime()));//sua 3 dong nay
        lblStartTime.setText(DateTimeUtil.LocalDateTimeToStringDayTime(hoatDong.getStartDate()));
        lblEndTime.setText(DateTimeUtil.LocalDateTimeToStringDayTime(hoatDong.getEndDate()));
        //lblEndTime.setIcon();
    }
    private void setContentForDlg(){
        taContentOfDlg.setText(hoatDong.getContent());
        lblTitleOfDlg.setText(hoatDong.getTitle());
        lblGenreOfDlg.setText(hoatDong.getGenre());
        taNameUserOfDlg.setText(hoatDong.getNameUser());
        lblPostingTimeOfDlg.setText(DateTimeUtil.LocalDateTimeToStringDayTime(hoatDong.getPostingTime()));//sua 3 dong nay
        lblStartTimeOfDlg.setText(DateTimeUtil.LocalDateTimeToStringDayTime(hoatDong.getStartDate()));
        lblEndTimeOfDlg.setText(DateTimeUtil.LocalDateTimeToStringDayTime(hoatDong.getEndDate()));
        taAddressDlg.setText(hoatDong.getAddress());
        lblPictureOfDlg.setIcon(lblPicture.getIcon());
        //lblEndTime.setIcon();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dlgActivityInformation = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taContentOfDlg = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        taNameUserOfDlg = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        taAddressDlg = new javax.swing.JTextArea();
        lblPicture = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        lblGenre = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblPostingTime = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblStartTime = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblEndTime = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblNameUser = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taContent = new javax.swing.JTextArea();

        dlgActivityInformation.setBackground(new java.awt.Color(255, 255, 255));
        dlgActivityInformation.setSize(new java.awt.Dimension(760, 635));

        jPanel2.setBackground(new java.awt.Color(229, 229, 229));
        jPanel2.setPreferredSize(new java.awt.Dimension(750, 630));
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
        lblPostingTimeOfDlg.setText("00:00 01-01-2024");

        lblPictureOfDlg.setBackground(new java.awt.Color(255, 204, 0));
        lblPictureOfDlg.setForeground(new java.awt.Color(255, 255, 255));
        lblPictureOfDlg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPictureOfDlg.setOpaque(true);

        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Địa điểm:");

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblPictureOfDlg, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPostingTimeOfDlg, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(lblStartTimeOfDlg, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblEndTimeOfDlg, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblGenreOfDlg, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 18, Short.MAX_VALUE))))
                    .addComponent(lblTitleOfDlg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(574, 574, 574)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(12, 12, 12))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblTitleOfDlg, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblPictureOfDlg, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblGenreOfDlg)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(lblStartTimeOfDlg)
                            .addComponent(jLabel7)
                            .addComponent(lblEndTimeOfDlg))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(lblPostingTimeOfDlg))))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        javax.swing.GroupLayout dlgActivityInformationLayout = new javax.swing.GroupLayout(dlgActivityInformation.getContentPane());
        dlgActivityInformation.getContentPane().setLayout(dlgActivityInformationLayout);
        dlgActivityInformationLayout.setHorizontalGroup(
            dlgActivityInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
        );
        dlgActivityInformationLayout.setVerticalGroup(
            dlgActivityInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(249, 249, 249));
        setMaximumSize(new java.awt.Dimension(800, 210));
        setMinimumSize(new java.awt.Dimension(800, 210));
        setPreferredSize(new java.awt.Dimension(800, 210));
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        lblPicture.setBackground(new java.awt.Color(255, 204, 0));
        lblPicture.setForeground(new java.awt.Color(255, 255, 255));
        lblPicture.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPicture.setText("Ảnh");
        lblPicture.setOpaque(true);

        jPanel1.setOpaque(false);

        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Loại hoạt động:");

        lblGenre.setText("Phong trào");

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Đăng lúc:");

        lblPostingTime.setText("00:00 01-01-2024");

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(0, 102, 204));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitle.setText("Tieu de cua hoat dong");
        lblTitle.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Diễn ra từ");

        lblStartTime.setText("00:00 01-01-2024");

        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("đến");

        lblEndTime.setText("00:00 01-01-2024");

        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Người đăng:");

        lblNameUser.setText("CLB Hoạt động tình nguyện Học viện công nghệ bưu chính viễn thông cơ sở TPHCM");

        taContent.setEditable(false);
        taContent.setBackground(new java.awt.Color(255, 255, 255));
        taContent.setColumns(20);
        taContent.setRows(5);
        taContent.setText("Mô tả nội dung");
        jScrollPane1.setViewportView(taContent);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNameUser, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblStartTime, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblEndTime, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblGenre, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPostingTime, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lblNameUser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblStartTime)
                        .addComponent(jLabel6)
                        .addComponent(lblEndTime))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lblGenre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(lblPostingTime))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(lblPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
       
    }//GEN-LAST:event_formFocusGained

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
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
       
    }//GEN-LAST:event_formMouseClicked

    private void jPanel2formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel2formFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2formFocusGained

    private void jPanel2formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2formMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog dlgActivityInformation;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblEndTime;
    private javax.swing.JLabel lblEndTimeOfDlg;
    private javax.swing.JLabel lblGenre;
    private javax.swing.JLabel lblGenreOfDlg;
    private javax.swing.JLabel lblNameUser;
    private javax.swing.JLabel lblPicture;
    private javax.swing.JLabel lblPictureOfDlg;
    private javax.swing.JLabel lblPostingTime;
    private javax.swing.JLabel lblPostingTimeOfDlg;
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
