/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package ttcs.quanlyhdnk.component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ttcs.quanlyhdnk.DAO.AccountData;
import ttcs.quanlyhdnk.model.NguoiDung;
import ttcs.quanlyhdnk.util.DateTimeUtil;
/**
 *
 * @author ADMIN
 */
public class AccountAdd extends javax.swing.JDialog {
    List <NguoiDung> listAccount= new ArrayList<>();
    /**
     * Creates new form AccountAdd
     */
    public AccountAdd(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
   
    private boolean checkInforInDB(){
        try {
            AccountData dao = new AccountData();;
            if(dao.checkAvailableAccount(txtUserID.getText())){
                JOptionPane.showMessageDialog(this,"Mã tài khoản đã tồn tại!");
                return false;
            }
        } catch (Exception ex) { Logger.getLogger(AccountAdd.class.getName()).log(Level.SEVERE, null, ex);}
        
        try {
            AccountData dao = new AccountData();
            if(dao.checkAvailableEmail(txtEmail.getText())){
                JOptionPane.showMessageDialog(this,"Email đã tồn tại!");
                return false;
            }
        } catch (Exception ex) {Logger.getLogger(AccountAdd.class.getName()).log(Level.SEVERE, null, ex);}
        
        try {
            AccountData dao = new AccountData();
            if(dao.checkAvailablePhone(txtPhoneNumber.getText())){
                JOptionPane.showMessageDialog(this,"Số điện thoại đã tồn tại!");
                return false;
            }
        } catch (Exception ex) {Logger.getLogger(AccountAdd.class.getName()).log(Level.SEVERE, null, ex);}
        
        return true;
    }
    
    private boolean checkInforInList(){
        String idAccount=txtUserID.getText();
        String email =txtEmail.getText();
        String phone = txtPhoneNumber.getText();
        for(NguoiDung account:listAccount){
            if(idAccount.equals(account.getUserID())){
                JOptionPane.showMessageDialog(this,"Tài khoản đã tồn tại trong danh sách thêm!"); 
                return false;
            }
            if (email.equals(account.getEmail())){
               JOptionPane.showMessageDialog(this,"Email đã tồn tại trong danh sách thêm!"); 
               return false;
            }
            if (phone.equals(account.getPhoneNumber())){
               JOptionPane.showMessageDialog(this,"Số điện thoại đã tồn tại trong danh sách thêm!"); 
               return false;
            }
        }
        return true;
    }
    
    private boolean checkInfor(){
        if(txtUserID.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Vui lòng nhập Mã tài khoản!");
            return false;
        }
        if(txtPassword.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Vui lòng nhập Mật khẩu!");
            return false;
        }
        if(txtPassword.getText().length()<6){
            JOptionPane.showMessageDialog(this,"Mật khẩu phải trên 6 ký tự!");
            return false;
        }
        if(txtUserName.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Vui lòng nhập tên người dùng!");
            return false;
        }
        if(txtEmail.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Vui lòng nhập email!");
            return false;
        }
        if(dtcBirthday.getDate()==null){
            JOptionPane.showMessageDialog(this,"Vui lòng chọn ngày sinh!");
            return false;
        }
        if(txtPhoneNumber.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Vui lòng nhập số điện thoại!");
            return false;
        }
        if(dtcBirthday.getDateFormatString().equals("")){
            JOptionPane.showMessageDialog(this,"Vui lòng nhập ngày sinh!");
            return false;
        }
        if(checkInforInDB()){
            return true;
        }
        return false;
    }
    
    private NguoiDung setInforAccount(){
        if(checkInfor()){
            NguoiDung account = new NguoiDung();
            account.setUserID(txtUserID.getText());
            account.setName(txtUserName.getText());
            if(lblAvatarDlg.getIcon()!=null){
                account.setAvatar((javax.swing.ImageIcon)lblAvatarDlg.getIcon());
            }
            account.setPassword(txtPassword.getText());

            if(rbtBoy.isSelected()){
                account.setGender("nam");
            }else if(rbtGirl.isSelected()){
                account.setGender("nữ");
            }
          
            account.setBirthday(DateTimeUtil.DateToLocalDateTime(dtcBirthday.getDate()));
            account.setEmail(txtEmail.getText());
            account.setPhoneNumber(txtPhoneNumber.getText());
            account.setAddress(txtAddress.getText());
            
            if(rbtManager.isSelected()){
                account.setRole("QL");
            }else if(rbtPoster.isSelected()){
                account.setRole("ND");
            }else{
                account.setRole("SV");
            }
            return account;
            //listAccount.add(account);
        }else{
            return null;
        }
        
    }
    
    private void addAccount(){
        NguoiDung account = setInforAccount();
        if(account!=null&&checkInforInList()){
            listAccount.add(account);
            fillToTable();
        }
    }
    private void removeAccount(){
        int index=tblAccount.getSelectedRow();
        listAccount.remove(index);
        this.fillToTable();
    }
//    
    private void updateAccount(){
        int index=tblAccount.getSelectedRow();
        NguoiDung account =setInforAccount();
        if(account!=null){
            int kq=JOptionPane.showConfirmDialog(this, "Bạn có muốn thay đổi thông tin của tài khoản này không?",
                "Xác nhận",JOptionPane.YES_OPTION,JOptionPane.NO_OPTION);
            if(kq==JOptionPane.YES_OPTION){
                listAccount.set(index,account);
                fillToTable();
            }
        }
    }
//    
    private void fillToTable(){
        DefaultTableModel tblModel=(DefaultTableModel) tblAccount.getModel();
        tblModel.setRowCount(0); 
        for(NguoiDung account:listAccount){
            Object[] row = new Object[]{account.getUserID(),account.getName(),account.getGender()
                        ,DateTimeUtil.LocalDateTimeToStringDay(account.getBirthday())
                        ,account.getEmail(),account.getPhoneNumber(),account.getAddress(),account.getRole()};
            tblModel.addRow(row);
        }
    }
 
    private void showDetail(){
        int index= tblAccount.getSelectedRow();
        NguoiDung account= listAccount.get(index);
            txtUserID.setText(account.getUserID());
            txtUserName.setText(account.getName());
            if(account.getAvatar()!=null){
                lblAvatarDlg.setText(null);
                lblAvatarDlg.setIcon(account.getAvatar());
            }else{
                lblAvatarDlg.setIcon(null);
                lblAvatarDlg.setText("Nhấn vào để chọn ảnh");
            }
            txtPassword.setText(account.getPassword());
            if(account.getGender()==null){
                rbtAnotherChoice.setSelected(true);
            }else if(account.getGender().equals("nam")){
                rbtBoy.setSelected(true);
            }else {
                rbtBoy.setSelected(true);
            }
            dtcBirthday.setDate(DateTimeUtil.LocalDateTimeToDate(account.getBirthday()));
            //account.setBirthday(DateTimeUtil.StringToLocalDateTime(""));
            
            txtEmail.setText(account.getEmail());
            txtPhoneNumber.setText(account.getPhoneNumber());
            txtAddress.setText(account.getAddress());
            if(account.getRole().equals("QL")){
                rbtManager.setSelected(true);
            }else if(account.getRole().equals("ND")){
                rbtPoster.setSelected(true);
            }else{
                rbtStudent.setSelected(true);
            }
    }
   
     private void resetDetail(){

            txtUserID.setText("");
            txtUserName.setText("");
            lblAvatarDlg.setIcon(null);
            lblAvatarDlg.setText("Nhấn vào để chọn ảnh");
            txtPassword.setText("");
            rbtBoy.setSelected(true);
            dtcBirthday.setDate(null);
            txtEmail.setText("");
            txtPhoneNumber.setText("");
            txtAddress.setText("");
            rbtStudent.setSelected(true);
            
           
     }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgpSelectObject = new javax.swing.ButtonGroup();
        bgpSelectGender = new javax.swing.ButtonGroup();
        cpActivityRegistered = new javax.swing.JScrollPane();
        tblAccount = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        lblAvatarDlg = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtUserID = new javax.swing.JTextField();
        txtPhoneNumber = new javax.swing.JTextField();
        lblTitleOfDlg = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        rbtStudent = new javax.swing.JRadioButton();
        rbtPoster = new javax.swing.JRadioButton();
        rbtManager = new javax.swing.JRadioButton();
        dtcBirthday = new com.toedter.calendar.JDateChooser();
        rbtBoy = new javax.swing.JRadioButton();
        rbtGirl = new javax.swing.JRadioButton();
        rbtAnotherChoice = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnUpdateAccount = new javax.swing.JButton();
        btnResetForm = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnAddAccountDB = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1100, 720));
        setPreferredSize(new java.awt.Dimension(1100, 670));
        setSize(new java.awt.Dimension(1100, 720));

        cpActivityRegistered.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        tblAccount.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã tài khoản", "Tên tài khoản", "Giới tính", "Ngày sinh", "Email", "Số điện thoại", "Địa chỉ", "Đối tượng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblAccount.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tblAccount.getTableHeader().setReorderingAllowed(false);
        tblAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAccountMouseClicked(evt);
            }
        });
        cpActivityRegistered.setViewportView(tblAccount);
        tblAccount.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (tblAccount.getColumnModel().getColumnCount() > 0) {
            tblAccount.getColumnModel().getColumn(0).setResizable(false);
            tblAccount.getColumnModel().getColumn(0).setPreferredWidth(60);
            tblAccount.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblAccount.getColumnModel().getColumn(2).setResizable(false);
            tblAccount.getColumnModel().getColumn(2).setPreferredWidth(40);
            tblAccount.getColumnModel().getColumn(3).setResizable(false);
            tblAccount.getColumnModel().getColumn(3).setPreferredWidth(50);
            tblAccount.getColumnModel().getColumn(4).setResizable(false);
            tblAccount.getColumnModel().getColumn(4).setPreferredWidth(150);
            tblAccount.getColumnModel().getColumn(5).setResizable(false);
            tblAccount.getColumnModel().getColumn(5).setPreferredWidth(50);
            tblAccount.getColumnModel().getColumn(6).setResizable(false);
            tblAccount.getColumnModel().getColumn(6).setPreferredWidth(200);
            tblAccount.getColumnModel().getColumn(7).setResizable(false);
            tblAccount.getColumnModel().getColumn(7).setPreferredWidth(50);
        }
        javax.swing.ListSelectionModel selectionModel = tblAccount.getSelectionModel();
        selectionModel.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            @Override
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                // Kiểm tra xem có dòng nào được chọn không
                if (!evt.getValueIsAdjusting()) {
                    if (tblAccount.getSelectedRow() != -1) {
                        btnUpdateAccount.setEnabled(true);
                    } else {
                        btnUpdateAccount.setEnabled(false);
                    }
                }
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1070, 300));
        jPanel1.setPreferredSize(new java.awt.Dimension(1070, 300));

        lblAvatarDlg.setBackground(new java.awt.Color(0, 102, 153));
        lblAvatarDlg.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblAvatarDlg.setForeground(new java.awt.Color(255, 255, 255));
        lblAvatarDlg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAvatarDlg.setText("Nhấn vào để chọn ảnh");
        lblAvatarDlg.setToolTipText("Nhấn vào để thay đổi ảnh địa diện");
        lblAvatarDlg.setOpaque(true);
        lblAvatarDlg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAvatarDlgMouseClicked(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Mã số tài khoản:");

        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Ngày sinh:");

        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Mật khẩu:");

        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Email:");

        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Tên:");

        txtPhoneNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhoneNumberActionPerformed(evt);
            }
        });

        lblTitleOfDlg.setBackground(new java.awt.Color(212, 212, 216));
        lblTitleOfDlg.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitleOfDlg.setForeground(new java.awt.Color(0, 102, 153));
        lblTitleOfDlg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitleOfDlg.setText("Thêm tài khoản");
        lblTitleOfDlg.setOpaque(true);

        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Giới tính:");

        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("Địa chỉ:");

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        txtAddress.setText("Địa chỉ");

        jLabel14.setForeground(new java.awt.Color(102, 102, 102));
        jLabel14.setText("Đối tượng:");

        bgpSelectObject.add(rbtStudent);
        rbtStudent.setForeground(new java.awt.Color(102, 102, 102));
        rbtStudent.setSelected(true);
        rbtStudent.setText("Sinh Viên");

        bgpSelectObject.add(rbtPoster);
        rbtPoster.setForeground(new java.awt.Color(102, 102, 102));
        rbtPoster.setText("Đăng hoạt động");

        bgpSelectObject.add(rbtManager);
        rbtManager.setForeground(new java.awt.Color(102, 102, 102));
        rbtManager.setText("Kỹ thuật viên");

        dtcBirthday.setDateFormatString("dd/MM/yyyy");

        bgpSelectGender.add(rbtBoy);
        rbtBoy.setForeground(new java.awt.Color(102, 102, 102));
        rbtBoy.setSelected(true);
        rbtBoy.setText("Nam");

        bgpSelectGender.add(rbtGirl);
        rbtGirl.setForeground(new java.awt.Color(102, 102, 102));
        rbtGirl.setText("Nữ");

        bgpSelectGender.add(rbtAnotherChoice);
        rbtAnotherChoice.setForeground(new java.awt.Color(102, 102, 102));
        rbtAnotherChoice.setText("Khác");

        jButton1.setBackground(new java.awt.Color(51, 204, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Thêm đối tượng vào danh sách");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Xóa khỏi danh sách ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnUpdateAccount.setText("Cập nhật vào danh sách");
        btnUpdateAccount.setEnabled(false);
        btnUpdateAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateAccountActionPerformed(evt);
            }
        });

        btnResetForm.setText("Đặt lại dữ liệu ");
        btnResetForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetFormActionPerformed(evt);
            }
        });

        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Số điện thoại:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblTitleOfDlg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblAvatarDlg, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(rbtStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(rbtPoster, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(rbtManager, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(txtUserID, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(33, 33, 33)
                                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(34, 34, 34)
                                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(dtcBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(135, 135, 135)
                                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(rbtBoy, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(rbtGirl, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(rbtAnotherChoice, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(50, 50, 50))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnResetForm, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnUpdateAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitleOfDlg, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAvatarDlg, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel14)
                                .addComponent(rbtStudent)
                                .addComponent(rbtPoster, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(rbtManager, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtUserID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dtcBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(rbtBoy)
                                    .addComponent(rbtAnotherChoice)
                                    .addComponent(rbtGirl))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnResetForm)
                    .addComponent(jButton1)
                    .addComponent(btnUpdateAccount)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        btnAddAccountDB.setBackground(new java.awt.Color(0, 204, 0));
        btnAddAccountDB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAddAccountDB.setForeground(new java.awt.Color(255, 255, 255));
        btnAddAccountDB.setText("Lưu dữ liệu");
        btnAddAccountDB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAccountDBActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(255, 51, 0));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Hủy thêm");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(376, Short.MAX_VALUE)
                .addComponent(btnAddAccountDB, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(404, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(btnAddAccountDB))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(cpActivityRegistered)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1100, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(cpActivityRegistered, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblAvatarDlgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAvatarDlgMouseClicked

        ImageChoose imageChoose= new ImageChoose(this,(javax.swing.ImageIcon)lblAvatarDlg.getIcon());
        imageChoose.setVisible(true);
        if(imageChoose.getMessageType()==ImageChoose.MessageType.OK){

            if(lblAvatarDlg.getText()!=null) lblAvatarDlg.setText(null);
                lblAvatarDlg.setIcon(imageChoose.getImageIcon());
           
//            try {
//                byte[] tmpBytes = Image.ImageIconToByte((javax.swing.ImageIcon)lblAvatarDlg.getIcon());
//                ttcs.quanlyhdnk.DAO.AccountData dao = new ttcs.quanlyhdnk.DAO.AccountData();
//
//                try {
//                    dao.updateAvatar(account.getUserID(),tmpBytes);
//                } catch (Exception ex) {
//                    Logger.getLogger(SinhVienForm.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            } catch (IOException ex) {
//                Logger.getLogger(SinhVienForm.class.getName()).log(Level.SEVERE, null, ex);
//            }

        }else{
//            System.out.println("không");
        }

    }//GEN-LAST:event_lblAvatarDlgMouseClicked

    private void txtPhoneNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhoneNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhoneNumberActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int kq=JOptionPane.showConfirmDialog(this, "Bạn có muốn XÓA thông tin của tài khoản này không?",
                "Xác nhận",JOptionPane.YES_OPTION,JOptionPane.NO_OPTION);
            if(kq==JOptionPane.YES_OPTION){
                removeAccount();
            }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnUpdateAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateAccountActionPerformed
        updateAccount();
    }//GEN-LAST:event_btnUpdateAccountActionPerformed

    private void tblAccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAccountMouseClicked
        this.showDetail();
    }//GEN-LAST:event_tblAccountMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        addAccount();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnResetFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetFormActionPerformed
        int kq=JOptionPane.showConfirmDialog(this, "Bạn có muốn RESET thông tin đang điền này không?",
                "Xác nhận",JOptionPane.YES_OPTION,JOptionPane.NO_OPTION);
            if(kq==JOptionPane.YES_OPTION){
                resetDetail();
            }
    }//GEN-LAST:event_btnResetFormActionPerformed

    private void btnAddAccountDBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAccountDBActionPerformed
        AccountData dao = new AccountData();
        boolean checkBug=false;
        for(NguoiDung account: listAccount){
            try {
                dao.insertAccount(account);
            } catch (Exception ex) {
                checkBug=true;
                Logger.getLogger(AccountAdd.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(!checkBug){
            JOptionPane.showMessageDialog(this,"Thêm thành công!");
            listAccount= new ArrayList<>();
            fillToTable();
        } 
    }//GEN-LAST:event_btnAddAccountDBActionPerformed

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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AccountAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AccountAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AccountAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AccountAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AccountAdd dialog = new AccountAdd(new javax.swing.JFrame(), true);
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
    private javax.swing.ButtonGroup bgpSelectGender;
    private javax.swing.ButtonGroup bgpSelectObject;
    private javax.swing.JButton btnAddAccountDB;
    private javax.swing.JButton btnResetForm;
    private javax.swing.JButton btnUpdateAccount;
    private javax.swing.JScrollPane cpActivityRegistered;
    private com.toedter.calendar.JDateChooser dtcBirthday;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblAvatarDlg;
    private javax.swing.JLabel lblTitleOfDlg;
    private javax.swing.JRadioButton rbtAnotherChoice;
    private javax.swing.JRadioButton rbtBoy;
    private javax.swing.JRadioButton rbtGirl;
    private javax.swing.JRadioButton rbtManager;
    private javax.swing.JRadioButton rbtPoster;
    private javax.swing.JRadioButton rbtStudent;
    private javax.swing.JTable tblAccount;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtPhoneNumber;
    private javax.swing.JTextField txtUserID;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
