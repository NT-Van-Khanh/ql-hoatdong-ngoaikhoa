/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ttcs.quanlyhdnk.form;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ttcs.quanlyhdnk.DAO.SinhVien.StudentActivity;
import ttcs.quanlyhdnk.model.Activity;
import ttcs.quanlyhdnk.util.DateTimeUtil;
/**
 *
 * @author ADMIN
 */
public class ActivityPanel extends javax.swing.JPanel {
    
    public ActivityPanel() {
        initComponents();
   
    }
    
    public ActivityPanel(Activity hoatDong){
        initComponents();
        setContentForCard(hoatDong);
        setContentForDlg(hoatDong);
    }
    
    private void setContentForCard(Activity hoatDong){
        lblContent.setText(hoatDong.getContent());
        lblTitle.setText(hoatDong.getTitle());
        lblGenre.setText(hoatDong.getGenre());
        lblNameUser.setText(hoatDong.getNameUser());
        lblPostingTime.setText(hoatDong.getPostingTime().toString());//sua 3 dong nay
        lblStartTime.setText(hoatDong.getStartDate().toString());
        lblEndTime.setText(hoatDong.getEndDate().toString());
        //lblEndTime.setIcon();
    }
    private void setContentForDlg(Activity hoatDong){
        lblContentOfDlg.setText(hoatDong.getContent());
        lblTitleOfDlg.setText(hoatDong.getTitle());
        lblGenreOfDlg.setText(hoatDong.getGenre());
        lblNameUserOfDlg.setText(hoatDong.getNameUser());
        lblPostingTimeOfDlg.setText(hoatDong.getPostingTime().toString());//sua 3 dong nay
        lblStartTimeOfDlg.setText(hoatDong.getStartDate().toString());
        lblEndTimeOfDlg.setText(hoatDong.getEndDate().toString());
        //lblEndTime.setIcon();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dlgActivityInformation = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        lblTitleOfDlg = new javax.swing.JLabel();
        lblContentOfDlg = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblStartTimeOfDlg = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblEndTimeOfDlg = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblNameUserOfDlg = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblGenreOfDlg = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblPostingTimeOfDlg = new javax.swing.JLabel();
        lblPictureOfDlg = new javax.swing.JLabel();
        btnRegister1 = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        lblPicture = new javax.swing.JLabel();
        lblContent = new javax.swing.JLabel();
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

        dlgActivityInformation.setBackground(new java.awt.Color(255, 255, 255));
        dlgActivityInformation.setSize(new java.awt.Dimension(800, 350));

        jPanel2.setBackground(new java.awt.Color(242, 242, 242));
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

        lblTitleOfDlg.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTitleOfDlg.setForeground(new java.awt.Color(0, 102, 204));
        lblTitleOfDlg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitleOfDlg.setText("Tieu de cua hoat dong");

        lblContentOfDlg.setText("Mô tả hoạt động");

        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Diễn ra từ");

        lblStartTimeOfDlg.setText("00:00 01-01-2024");

        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("đến");

        lblEndTimeOfDlg.setText("00:00 01-01-2024");

        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Người đăng:");

        lblNameUserOfDlg.setText("CLB Hoạt động tình nguyện Học viện công nghệ bưu chính viễn thông cơ sở TPHCM");

        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Loại hoạt động:");

        lblGenreOfDlg.setText("Phong trào");

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Đăng lúc:");

        lblPostingTimeOfDlg.setText("00:00 01-01-2024");

        lblPictureOfDlg.setBackground(new java.awt.Color(255, 204, 0));
        lblPictureOfDlg.setForeground(new java.awt.Color(255, 255, 255));
        lblPictureOfDlg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPictureOfDlg.setText("Ảnh");
        lblPictureOfDlg.setOpaque(true);

        btnRegister1.setText("Đăng ký");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitleOfDlg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnRegister1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPostingTimeOfDlg, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblPictureOfDlg, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNameUserOfDlg, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(lblStartTimeOfDlg, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblEndTimeOfDlg, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addComponent(lblContentOfDlg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblGenreOfDlg, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(lblTitleOfDlg, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(lblNameUserOfDlg))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblStartTimeOfDlg)
                                .addComponent(jLabel7)
                                .addComponent(lblEndTimeOfDlg))
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblGenreOfDlg)
                            .addComponent(jLabel11))
                        .addGap(12, 12, 12)
                        .addComponent(lblContentOfDlg, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblPictureOfDlg, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(lblPostingTimeOfDlg))
                    .addComponent(btnRegister1))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout dlgActivityInformationLayout = new javax.swing.GroupLayout(dlgActivityInformation.getContentPane());
        dlgActivityInformation.getContentPane().setLayout(dlgActivityInformationLayout);
        dlgActivityInformationLayout.setHorizontalGroup(
            dlgActivityInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dlgActivityInformationLayout.setVerticalGroup(
            dlgActivityInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(242, 242, 242));
        setMinimumSize(new java.awt.Dimension(800, 200));
        setPreferredSize(new java.awt.Dimension(800, 200));
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

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(0, 102, 204));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitle.setText("Tieu de cua hoat dong");
        lblTitle.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lblPicture.setBackground(new java.awt.Color(255, 204, 0));
        lblPicture.setForeground(new java.awt.Color(255, 255, 255));
        lblPicture.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPicture.setText("Ảnh");
        lblPicture.setOpaque(true);

        lblContent.setText("Mô tả hoạt động");
        lblContent.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Diễn ra từ");

        lblStartTime.setText("00:00 01-01-2024");

        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("đến");

        lblEndTime.setText("00:00 01-01-2024");

        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Người đăng:");

        lblNameUser.setText("CLB Hoạt động tình nguyện Học viện công nghệ bưu chính viễn thông cơ sở TPHCM");

        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Loại hoạt động:");

        lblGenre.setText("Phong trào");

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Đăng lúc:");

        lblPostingTime.setText("00:00 01-01-2024");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(lblPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblGenre, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(176, 176, 176)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPostingTime, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNameUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblStartTime, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblEndTime, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lblNameUser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblStartTime)
                        .addComponent(jLabel6)
                        .addComponent(lblEndTime))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblContent, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lblGenre)
                    .addComponent(jLabel12)
                    .addComponent(lblPostingTime))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
    private javax.swing.JButton btnRegister1;
    private javax.swing.JDialog dlgActivityInformation;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblContent;
    private javax.swing.JLabel lblContentOfDlg;
    private javax.swing.JLabel lblEndTime;
    private javax.swing.JLabel lblEndTimeOfDlg;
    private javax.swing.JLabel lblGenre;
    private javax.swing.JLabel lblGenreOfDlg;
    private javax.swing.JLabel lblNameUser;
    private javax.swing.JLabel lblNameUserOfDlg;
    private javax.swing.JLabel lblPicture;
    private javax.swing.JLabel lblPictureOfDlg;
    private javax.swing.JLabel lblPostingTime;
    private javax.swing.JLabel lblPostingTimeOfDlg;
    private javax.swing.JLabel lblStartTime;
    private javax.swing.JLabel lblStartTimeOfDlg;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitleOfDlg;
    // End of variables declaration//GEN-END:variables
}
