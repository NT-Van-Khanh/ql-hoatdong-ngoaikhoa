/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package ttcs.quanlyhdnk.component.login;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ttcs.quanlyhdnk.DAO.AccountData;
import ttcs.quanlyhdnk.component.activity.ActivityPanel;
import ttcs.quanlyhdnk.model.NguoiDung;

/**
 *
 * @author ADMIN
 */
public class PasswordChangePnl extends javax.swing.JDialog {

    private String idAccount;
    
//    public ChangePassword(java.awt.Frame parent, boolean modal) {
//        super(parent, modal);
//        initComponents();
//    }
    public PasswordChangePnl(java.awt.Frame parent, boolean modal, String idAcount) {
        super(parent, modal);
        this.idAccount=idAcount;
        initComponents();
    }
    
    private boolean changePw(String idAccount,String oldPassword, String newPassword){
        
        try {
            AccountData daoAccount = new AccountData();
            
            if(daoAccount.changePassword(idAccount,oldPassword,newPassword)){ 
                return true;
            }
        } catch (Exception ex) {
           // System.out.println("aasdasdsd"); Thong bao loi
            Logger.getLogger(ActivityPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    private boolean checkPwForm(String pw){
        if(pw.equals("***************")){
            return true;
        }
            return false;
    }
    
    private boolean checkLogin(String taiKhoan,String matKhau){
        try {
            AccountData daoAccount = new AccountData();
            NguoiDung user= daoAccount.checkAccount(taiKhoan,matKhau);
            if(user !=null) {
                return true;
            }
        } catch (Exception ex) {
           // System.out.println("aasdasdsd"); Thong bao loi
            Logger.getLogger(ActivityPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    private boolean checkPwdPassword(){
        String pw= String.valueOf(pwdPassword.getPassword());
        
        if(pw.isEmpty()){
            lblEmptyPw.setVisible(true);
            lblError.setText("Vui lòng nhập đầy đủ thông tin.");
            return false;
        }else if(pw.length()<6){
            lblError.setText("Mật khẩu phải có ít nhất 6 ký tự");
            return false;
        }
         lblEmptyPw.setVisible(false);
        return true;
    }
    
    private boolean checkPwdNewPassword(){
        String pw= String.valueOf(pwdPassword.getPassword());
        String newPw= String.valueOf(pwdNewPassword.getPassword());
        
        if(newPw.isEmpty()){
           lblEmptyNewPw.setVisible(true);
           lblError.setText("Vui lòng nhập đầy đủ thông tin!");
           return false;
        }else if(newPw.length()<6){
            lblError.setText("Mật khẩu phải có ít nhất 6 ký tự!");
            return false;
        }else if(newPw.equals(pw)&&!checkPwForm(newPw)){
            lblError.setText("Mật khẩu mới bị trùng với mật khẩu hiện tại!");
            return false;
        }
        lblEmptyNewPw.setVisible(false);
        return true;
    }
    
    private boolean checkPwdConfirmPassword(){
        String newPw= String.valueOf(pwdNewPassword.getPassword());
        String confirmPw= String.valueOf(pwdConfirmPassword.getPassword());
        
        if(confirmPw.isEmpty()){
           lblEmptyConfirmPw.setVisible(true);
           lblError.setText("Vui lòng nhập đầy đủ thông tin!");
           return false;
        }else if(!confirmPw.equals(newPw)&&!checkPwForm(confirmPw)){
            lblError.setText("Mật khẩu xác nhận phải giống mật khẩu mới!");
            return false;
        }
        lblEmptyConfirmPw.setVisible(false);
        return true;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel7 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        pwdPassword = new javax.swing.JPasswordField();
        jLabel13 = new javax.swing.JLabel();
        pwdNewPassword = new javax.swing.JPasswordField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        pwdConfirmPassword = new javax.swing.JPasswordField();
        btnConfirm = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        lblError = new javax.swing.JLabel();
        lblNotify = new javax.swing.JLabel();
        lblEmptyPw = new javax.swing.JLabel();
        lblEmptyNewPw = new javax.swing.JLabel();
        lblEmptyConfirmPw = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setMinimumSize(new java.awt.Dimension(360, 420));
        setUndecorated(true);

        jPanel7.setBackground(new java.awt.Color(252, 252, 252));

        jLabel11.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 153, 204));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Đổi mật khẩu");

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

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("Mật khẩu hiện tại ");

        pwdNewPassword.setBackground(new java.awt.Color(229, 229, 229));
        pwdNewPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        pwdNewPassword.setForeground(new java.awt.Color(102, 102, 102));
        pwdNewPassword.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        pwdNewPassword.setText("***************");
        pwdNewPassword.setBorder(null);
        pwdNewPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pwdNewPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                pwdNewPasswordFocusLost(evt);
            }
        });
        pwdNewPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pwdNewPasswordMouseClicked(evt);
            }
        });
        pwdNewPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwdNewPasswordActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 102, 102));
        jLabel14.setText("Mật khẩu mới");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("Nhập lại mật khẩu mới");

        pwdConfirmPassword.setBackground(new java.awt.Color(229, 229, 229));
        pwdConfirmPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        pwdConfirmPassword.setForeground(new java.awt.Color(102, 102, 102));
        pwdConfirmPassword.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        pwdConfirmPassword.setText("***************");
        pwdConfirmPassword.setBorder(null);
        pwdConfirmPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pwdConfirmPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                pwdConfirmPasswordFocusLost(evt);
            }
        });
        pwdConfirmPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pwdConfirmPasswordMouseClicked(evt);
            }
        });
        pwdConfirmPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwdConfirmPasswordActionPerformed(evt);
            }
        });

        btnConfirm.setBackground(new java.awt.Color(30, 160, 204));
        btnConfirm.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnConfirm.setForeground(new java.awt.Color(255, 255, 255));
        btnConfirm.setText("Xác nhận");
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

        btnExit.setBackground(new java.awt.Color(191, 191, 191));
        btnExit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setText("Hủy");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        lblError.setForeground(java.awt.Color.red);
        lblError.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblError.setText("Mật khẩu không trùng khớp!");
        lblError.setVisible(false);

        lblNotify.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNotify.setForeground(java.awt.Color.green);
        lblNotify.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNotify.setText("Đổi mật khẩu thành công!");
        lblNotify.setVisible(false);

        lblEmptyPw.setForeground(java.awt.Color.red);
        lblEmptyPw.setText("*");
        lblEmptyPw.setVisible(false);

        lblEmptyNewPw.setForeground(java.awt.Color.red);
        lblEmptyNewPw.setText("*");
        lblEmptyNewPw.setVisible(false);

        lblEmptyConfirmPw.setForeground(java.awt.Color.red);
        lblEmptyConfirmPw.setText("*");
        lblEmptyConfirmPw.setVisible(false);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(0, 25, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pwdPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pwdNewPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pwdConfirmPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEmptyPw, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmptyNewPw, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmptyConfirmPw, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
            .addComponent(lblNotify, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel13)
                .addGap(2, 2, 2)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pwdPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmptyPw))
                .addGap(12, 12, 12)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pwdNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmptyNewPw))
                .addGap(12, 12, 12)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pwdConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmptyConfirmPw))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExit)
                    .addComponent(btnConfirm))
                .addGap(18, 18, 18)
                .addComponent(lblNotify, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void pwdPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pwdPasswordFocusGained
        if(checkPwForm(String.valueOf(pwdPassword.getPassword()))){
            pwdPassword.setText("");
        }
    }//GEN-LAST:event_pwdPasswordFocusGained

    private void pwdPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pwdPasswordFocusLost
        if(pwdPassword.getPassword().length==0){
            pwdPassword.setText("***************");
        }
        if(!checkPwdPassword()){
            lblError.setVisible(true);
        }else{
         lblError.setVisible(false);
        }
    }//GEN-LAST:event_pwdPasswordFocusLost

    private void pwdPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pwdPasswordMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_pwdPasswordMouseClicked

    private void pwdPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwdPasswordActionPerformed

    }//GEN-LAST:event_pwdPasswordActionPerformed

    private void pwdNewPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pwdNewPasswordFocusGained
        if(checkPwForm(String.valueOf(pwdNewPassword.getPassword()))){
            pwdNewPassword.setText("");
        }
    }//GEN-LAST:event_pwdNewPasswordFocusGained

    private void pwdNewPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pwdNewPasswordFocusLost
        if(pwdNewPassword.getPassword().length==0){
            pwdNewPassword.setText("***************");
        }
        if(!checkPwdNewPassword()){
            lblError.setVisible(true);
        }else{
         lblError.setVisible(false);
        }
        
    }//GEN-LAST:event_pwdNewPasswordFocusLost

    private void pwdNewPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pwdNewPasswordMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_pwdNewPasswordMouseClicked

    private void pwdNewPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwdNewPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pwdNewPasswordActionPerformed

    private void pwdConfirmPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pwdConfirmPasswordFocusGained
        if(checkPwForm(String.valueOf(pwdConfirmPassword.getPassword()))){
            pwdConfirmPassword.setText("");
        }
    }//GEN-LAST:event_pwdConfirmPasswordFocusGained

    private void pwdConfirmPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pwdConfirmPasswordFocusLost
        if(pwdConfirmPassword.getPassword().length==0){
            pwdConfirmPassword.setText("***************");
        }
        if(!checkPwdConfirmPassword()){
            lblError.setVisible(true);
        }else{
         lblError.setVisible(false);
        }
    }//GEN-LAST:event_pwdConfirmPasswordFocusLost

    private void pwdConfirmPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pwdConfirmPasswordMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_pwdConfirmPasswordMouseClicked

    private void pwdConfirmPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwdConfirmPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pwdConfirmPasswordActionPerformed

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed

        if(checkPwdPassword()&&checkPwdNewPassword()&&checkPwdConfirmPassword()){
            String password =String.valueOf(pwdPassword.getPassword());
            String newpassword =String.valueOf(pwdNewPassword.getPassword());
            lblError.setVisible(false);
            
            if(checkLogin(idAccount,password))
            {
                 if(changePw(idAccount,password,newpassword)){
                    //System.out.println("Dang nhap thanh cong");
                    lblNotify.setForeground(Color.GREEN);
                    //lblNotify.setText("Đổi mật khẩu thành công!");
                    JOptionPane.showMessageDialog(this,"Đổi mật khẩu thành công!");
                    this.setVisible(false);
                    lblNotify.setVisible(true);
                 }else{
                    lblNotify.setForeground(Color.RED);
                    lblNotify.setText("Có lỗi trong quá trình đổi mật khẩu!");
                    lblNotify.setVisible(true);
                 }
            }else{
                lblNotify.setForeground(Color.RED);
                lblNotify.setText("Sai mật khẩu!");
                lblNotify.setVisible(true);
                // System.out.println("Dang nhap that bai");
            }
        }else{
            lblError.setVisible(true);
        }
    }//GEN-LAST:event_btnConfirmActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
       this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[],String idAcount) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PasswordChangePnl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PasswordChangePnl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PasswordChangePnl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PasswordChangePnl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PasswordChangePnl dialog = new PasswordChangePnl(new javax.swing.JFrame(), true,idAcount);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirm;
    private javax.swing.JButton btnExit;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel lblEmptyConfirmPw;
    private javax.swing.JLabel lblEmptyNewPw;
    private javax.swing.JLabel lblEmptyPw;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblNotify;
    private javax.swing.JPasswordField pwdConfirmPassword;
    private javax.swing.JPasswordField pwdNewPassword;
    private javax.swing.JPasswordField pwdPassword;
    // End of variables declaration//GEN-END:variables
}
