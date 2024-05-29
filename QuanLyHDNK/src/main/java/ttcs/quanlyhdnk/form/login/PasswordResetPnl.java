/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ttcs.quanlyhdnk.form.login;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ttcs.quanlyhdnk.DAO.AccountData;
import ttcs.quanlyhdnk.form.activity.ActivityPanel;

/**
 *
 * @author ADMIN
 */
public class PasswordResetPnl extends javax.swing.JPanel {

    private String idAccount;
//    public PasswordChangePanel() {
//        initComponents();
//    }
    public PasswordResetPnl(String idAccount) {
        initComponents();
        this.idAccount= idAccount;
    }

    private boolean changeForgoaPw(String idAccount,String newPassword){
        
        try {
            AccountData daoAccount = new AccountData();
            
            if(daoAccount.changeForgotPassword(idAccount,newPassword)){ 
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
    
    private boolean checkPwdNewPassword(){
        String newPw= String.valueOf(pwdNewPassword.getPassword());
        if(newPw.isEmpty()){
            lblEmptyNewPw.setVisible(true);
            lblErrorPassword.setForeground(Color.red);
            lblErrorPassword.setText("Vui lòng nhập đầy đủ thông tin!");
            lblErrorPassword.setVisible(true);
            return false;
        }else if(newPw.length()<6){
            lblErrorPassword.setForeground(Color.red);
            lblErrorPassword.setText("Mật khẩu phải có ít nhất 6 ký tự!");
            lblErrorPassword.setVisible(true);
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
            lblErrorPassword.setForeground(Color.red);
            lblErrorPassword.setText("Vui lòng nhập đầy đủ thông tin!");
            lblErrorPassword.setVisible(true);
            return false;
        }else if(!confirmPw.equals(newPw)&&!checkPwForm(confirmPw)){
            lblErrorPassword.setForeground(Color.red);
            lblErrorPassword.setText("Mật khẩu xác nhận phải giống mật khẩu mới!");
            lblErrorPassword.setVisible(true);
            return false;
        }
        lblEmptyConfirmPw.setVisible(false);
        return true;
    }
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        pwdConfirmPassword = new javax.swing.JPasswordField();
        lblErrorPassword = new javax.swing.JLabel();
        lblError = new javax.swing.JLabel();
        pwdNewPassword = new javax.swing.JPasswordField();
        lblEmptyNewPw = new javax.swing.JLabel();
        lblEmptyConfirmPw = new javax.swing.JLabel();

        setBackground(new java.awt.Color(252, 252, 252));
        setMinimumSize(new java.awt.Dimension(380, 420));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Đổi mật khẩu");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Nhập mật khẩu mới");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Nhập lại mật khẩu mới");

        btnLogin.setBackground(new java.awt.Color(30, 160, 204));
        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Xác nhận");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
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

        lblErrorPassword.setForeground(java.awt.Color.gray);
        lblErrorPassword.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblErrorPassword.setText("(Mật khẩu phải từ 6 ký tự, không được bắt đầu bằng ký tự *)");

        lblError.setForeground(java.awt.Color.red);
        lblError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblError.setText("Có lỗi trong quá trình đổi mật khẩu!");
        lblError.setVisible(false);

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

        lblEmptyNewPw.setForeground(java.awt.Color.red);
        lblEmptyNewPw.setText("*");
        lblEmptyNewPw.setVisible(false);

        lblEmptyConfirmPw.setForeground(java.awt.Color.red);
        lblEmptyConfirmPw.setText("*");
        lblEmptyConfirmPw.setVisible(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblError, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblErrorPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pwdConfirmPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pwdNewPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEmptyNewPw, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmptyConfirmPw, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jLabel2)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pwdNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmptyNewPw))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pwdConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmptyConfirmPw))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErrorPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed

        if(checkPwdNewPassword()&&checkPwdConfirmPassword()){
//            String password =String.valueOf(pwdPassword.getPassword());
            String newpassword =String.valueOf(pwdNewPassword.getPassword());
            lblErrorPassword.setVisible(false);
            
                 if(changeForgoaPw(idAccount,newpassword)){
                    JOptionPane.showMessageDialog(this,"Đổi mật khẩu thành công!");
                    this.setVisible(false);
                 }else{
                    lblError.setForeground(Color.RED);
                    //lblError.setText("Có lỗi trong quá trình đổi mật khẩu!");
                    lblError.setVisible(true);
                 }

        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExitActionPerformed

    private void pwdConfirmPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pwdConfirmPasswordFocusGained
        pwdConfirmPassword.setText("");
    }//GEN-LAST:event_pwdConfirmPasswordFocusGained

    private void pwdConfirmPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pwdConfirmPasswordFocusLost
        if(pwdConfirmPassword.getPassword().length==0){
            pwdConfirmPassword.setText("***************");
        }
        if(checkPwdConfirmPassword())   lblErrorPassword.setVisible(false);
//        checkPwdPassword();
    }//GEN-LAST:event_pwdConfirmPasswordFocusLost

    private void pwdConfirmPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pwdConfirmPasswordMouseClicked

    }//GEN-LAST:event_pwdConfirmPasswordMouseClicked

    private void pwdConfirmPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwdConfirmPasswordActionPerformed
        //        pwdPassword.setEchoChar((char)0);
    }//GEN-LAST:event_pwdConfirmPasswordActionPerformed

    private void pwdNewPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pwdNewPasswordFocusGained
        if(String.valueOf(pwdNewPassword.getPassword()).equals("***************")){
            pwdNewPassword.setText("");
        }
    }//GEN-LAST:event_pwdNewPasswordFocusGained

    private void pwdNewPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pwdNewPasswordFocusLost
        if(pwdNewPassword.getPassword().length==0){
            pwdNewPassword.setText("***************");
        }
        if(checkPwdNewPassword())   lblErrorPassword.setVisible(false);
        
    }//GEN-LAST:event_pwdNewPasswordFocusLost

    private void pwdNewPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pwdNewPasswordMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_pwdNewPasswordMouseClicked

    private void pwdNewPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwdNewPasswordActionPerformed

    }//GEN-LAST:event_pwdNewPasswordActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblEmptyConfirmPw;
    private javax.swing.JLabel lblEmptyNewPw;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblErrorPassword;
    private javax.swing.JPasswordField pwdConfirmPassword;
    private javax.swing.JPasswordField pwdNewPassword;
    // End of variables declaration//GEN-END:variables
}
