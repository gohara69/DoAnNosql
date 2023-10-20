/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package chamsockh.LienHe;

import BLL.DichVuBll;
import BLL.KhachHangBLL;
import BLL.LienHeBLL;
import BLL.NhanVienBll;
import BLL.VoucherBLL;
import chamsockh.ComboBoxItem;
import chamsockh.DichVu.frmDichVu;
import chamsockh.Voucher.frmVoucher;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MINH HOANG
 */
public class frmThucHienLH extends javax.swing.JInternalFrame {

    VoucherBLL voucherBll = new VoucherBLL();
    DichVuBll dvBll = new DichVuBll();
    NhanVienBll nvBll = new NhanVienBll();
    LienHeBLL lienHeBll = new LienHeBLL();
    KhachHangBLL khachHangBll = new KhachHangBLL();

    Vector dataVoucher = new Vector();
    Vector dataVoucherAdded = new Vector();
    Vector dataDichVuAdded = new Vector();
    Vector headerVoucher = new Vector();
    Vector dataDichVu = new Vector();
    Vector headerDichVu = new Vector();
    Vector dataLienHe = new Vector();
    Vector headerLienHe = new Vector();
    
    Boolean isAdd = false;
    /**
     * Creates new form frmThucHienLH
     */
    public frmThucHienLH() {
        initComponents();
        
        initTableVoucher();
        initTableDichVu();
        initTableLienHe();
        initTableVoucherAdded();
        initTableDichVuAdded();
        loadAllVoucher();
        loadAllDichVu();
        
        
        cboNhanVien.removeAllItems();
        ResultSet dsNCC = nvBll.getAllNhanVien();
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        try {
            while(dsNCC.next()){
                model.addElement(new ComboBoxItem(dsNCC.getString("MaNV"), dsNCC.getString("TenNV")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmLienHe.class.getName()).log(Level.SEVERE, null, ex);
        }
        cboNhanVien.setModel(model);
        cboNhanVien.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {
                String maNV = ((ComboBoxItem)cboNhanVien.getSelectedItem()).getKeyString();
                loadDataToTableLienHe(maNV);
            }
        });
        
        cboKhachHang.removeAllItems();
        ResultSet dsKH = khachHangBll.getAllKhachHang();
        DefaultComboBoxModel modelCBO = new DefaultComboBoxModel();
        try {
            while(dsKH.next()){
                modelCBO.addElement(new ComboBoxItem(dsKH.getString("MaKH"), dsKH.getString("TenKH")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmLienHe.class.getName()).log(Level.SEVERE, null, ex);
        }
        cboKhachHang.setModel(modelCBO);
    }
    
    public void loadAllVoucher(){
        dataVoucher.clear();
        ResultSet rs = voucherBll.getAllVoucher();
        try {
            while(rs.next()){
                Vector<String> info = new Vector<String>();
                info.add(rs.getString("MV"));
                info.add(rs.getString("TenV"));
                info.add(rs.getString("GiamGia"));
                dataVoucher.add(info);
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmVoucher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void loadAllDichVu(){
        dataDichVu.clear();
        ResultSet rsult = dvBll.getAllDichVu();
        try {
            while(rsult.next()){
                Vector<String> info = new Vector<String>();
                info.add(rsult.getString("MaDV"));
                info.add(rsult.getString("TenDV"));
                info.add(rsult.getString("MoTaDV"));
                info.add(rsult.getString("GiaDV"));
                dataDichVu.add(info);
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmDichVu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void initTableVoucher(){
        headerVoucher.add("Mã voucher");
        headerVoucher.add("Tên voucher");
        headerVoucher.add("Giảm giá");

        tblVoucher.setModel(new DefaultTableModel(dataVoucher, headerVoucher));
    }
    
    public void initTableVoucherAdded(){
        tblVoucherAdded.setModel(new DefaultTableModel(dataVoucherAdded, headerVoucher));
    }
    
    public void initTableDichVuAdded(){
        tblDichVuAdded.setModel(new DefaultTableModel(dataDichVuAdded, headerDichVu));
    }
    
    public void initTableLienHe(){
        headerLienHe.add("Mã liên hệ");
        headerLienHe.add("Thời gian liên hệ");
        headerLienHe.add("Tình trạng");
        headerLienHe.add("Khách hàng");
        tblLienHe.setModel(new DefaultTableModel(dataLienHe, headerLienHe));
    }
    
    public void initTableDichVu(){
        headerDichVu.add("Mã dịch vụ");
        headerDichVu.add("Tên dịch vụ");
        headerDichVu.add("Mô tả dịch vụ");
        headerDichVu.add("Giá dịch vụ");

        tblDichVu.setModel(new DefaultTableModel(dataDichVu, headerDichVu));
    }
    
    public void loadDataToTableLienHe(String maNV){
        DefaultTableModel table = (DefaultTableModel)tblLienHe.getModel();
        table.setRowCount(0);
        ResultSet rs = lienHeBll.getAllLienHeTheoMaNV(maNV);
        try {
            while(rs.next()){
                Vector<String> info = new Vector<String>();
                info.add(rs.getString("MALH"));
                info.add(rs.getString("TGLH"));
                info.add("true".equals(rs.getString("TinhTrang")) ? "thành công" : "thất bại");
                info.add(rs.getString("TENKH"));

                dataLienHe.add(info);
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmVoucher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void showVoucherDaLienHe(int index){
        loadAllVoucher();
        tblVoucher.updateUI();
        Vector info = (Vector) dataLienHe.get(index);
        dataVoucherAdded.clear();
        String maLH = info.get(0).toString();
        ResultSet rs = voucherBll.getAllVoucherByMaLH(maLH);
        DefaultTableModel table = (DefaultTableModel)tblVoucherAdded.getModel();
        table.setRowCount(0);
        try {
            while(rs.next()){
                Vector<String> inf = new Vector<String>();
                inf.add(rs.getString("MaVoc"));
                inf.add(rs.getString("TenVoc"));
                inf.add(rs.getString("GiamGia"));

                for(int i = 0 ; i < dataVoucher.size() ; i++){
                    Vector ino = (Vector)dataVoucher.get(i);
                    if(ino.get(0).toString().equals(inf.get(0).toString())){
                        dataVoucher.removeElementAt(i);
                    }
                }
                dataVoucherAdded.add(inf);
            }
            tblVoucher.updateUI();
            tblVoucherAdded.updateUI();
        } catch (SQLException ex) {
            Logger.getLogger(frmVoucher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void showDichVuDaLienHe(int index){
        loadAllDichVu();
        tblDichVu.updateUI();
        Vector info = (Vector) dataLienHe.get(index);
        dataDichVuAdded.clear();
        String maLH = info.get(0).toString();
        ResultSet rs = dvBll.getAllDichVuByMaLH(maLH);
        DefaultTableModel table = (DefaultTableModel)tblDichVuAdded.getModel();
        table.setRowCount(0);
        try {
            while(rs.next()){
                Vector<String> inf = new Vector<String>();
                inf.add(rs.getString("MaDV"));
                inf.add(rs.getString("TenDV"));
                inf.add(rs.getString("GiaDV"));
                inf.add(rs.getString("MoTaDV"));

                for(int i = 0 ; i < dataDichVu.size() ; i++){
                    Vector ino = (Vector)dataDichVu.get(i);
                    if(ino.get(0).toString().equals(inf.get(0).toString())){
                        dataDichVu.removeElementAt(i);
                    }
                }
                dataDichVuAdded.add(inf);
            }
            tblDichVu.updateUI();
            tblDichVuAdded.updateUI();
        } catch (SQLException ex) {
            Logger.getLogger(frmVoucher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void showDetail(int index){
        if(index >= 0){
            Vector<String> info = (Vector<String>) dataLienHe.get(index);
            txtMaLienHe.setText(info.get(0));
            txtTGLH.setText(info.get(1));
            cboTinhTrangLH.setSelectedIndex("thành công".equals(info.get(2).toString()) ? 1 : 2);
            cboKhachHang.setEditable(true);
            cboKhachHang.setSelectedItem(info.get(3).toString());
        }
    }
    
    public void themLienHe(){
        String maLH = txtMaLienHe.getText();
        String thoiGian = txtTGLH.getText();
        String tenNV = cboNhanVien.getSelectedItem().toString();
        String tenKH = cboKhachHang.getSelectedItem().toString();
        Boolean tt = (cboTinhTrangLH.getSelectedIndex() == 1) ? true : false;
        
        lienHeBll.insertNew(maLH, thoiGian, tt, tenNV, tenKH);
        String maNV = ((ComboBoxItem)cboNhanVien.getSelectedItem()).getKeyString();
        loadDataToTableLienHe(maNV);
        tblLienHe.updateUI();
        isAdd = false;
        btnThem.setEnabled(true);
        btnXoa.setEnabled(true);
        
        if(dataVoucherAdded.size() > 0){
            for(int i = 0 ; i < dataVoucherAdded.size() ; i++){
                Vector in = (Vector)dataVoucherAdded.get(i);
                lienHeBll.insertGioiThieuToVoucher(maLH, in.get(0).toString());
            }
        }
        
        if(dataDichVuAdded.size() > 0){
            for(int i = 0 ; i < dataDichVuAdded.size() ; i++){
                Vector in = (Vector)dataDichVuAdded.get(i);
                lienHeBll.insertGioiThieuToDichVu(maLH, in.get(0).toString());
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVoucherAdded = new javax.swing.JTable();
        btnXoa = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnToListDichVu = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblVoucher = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDichVuAdded = new javax.swing.JTable();
        btnBackListDichVu = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblDichVu = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtMaLienHe = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTGLH = new javax.swing.JFormattedTextField();
        cboNhanVien = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cboTinhTrangLH = new javax.swing.JComboBox<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblLienHe = new javax.swing.JTable();
        btnToListVoucher = new javax.swing.JButton();
        btnBackListVoucher = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        cboKhachHang = new javax.swing.JComboBox<>();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Liên hệ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        tblVoucherAdded.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã voucher", "Tên voucher", "Giảm giá"
            }
        ));
        tblVoucherAdded.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVoucherAddedMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblVoucherAdded);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 70, 440, 240));

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        getContentPane().add(btnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, -1, -1));

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        getContentPane().add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });
        getContentPane().add(btnLuu, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, -1, -1));

        btnToListDichVu.setText(">>");
        btnToListDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnToListDichVuActionPerformed(evt);
            }
        });
        getContentPane().add(btnToListDichVu, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 440, -1, -1));

        tblVoucher.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã voucher", "Tên voucher", "Giảm giá"
            }
        ));
        tblVoucher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVoucherMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblVoucher);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, 450, 240));

        tblDichVuAdded.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã dịch vụ", "Tên dịch vụ", "Mô tả", "Giá"
            }
        ));
        tblDichVuAdded.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDichVuAddedMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblDichVuAdded);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 350, 440, 240));

        btnBackListDichVu.setText("<<");
        btnBackListDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackListDichVuActionPerformed(evt);
            }
        });
        getContentPane().add(btnBackListDichVu, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 470, -1, -1));

        tblDichVu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã dịch vụ", "Tên dịch vụ", "Mô tả", "Giá"
            }
        ));
        tblDichVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDichVuMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblDichVu);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 350, -1, 240));

        jLabel5.setText("DANH SÁCH VOUCHER LIÊN HỆ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 50, -1, -1));

        jLabel6.setText("DANH SÁCH DỊCH VỤ LIÊN HỆ");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 330, -1, -1));

        jLabel1.setText("Nhân viên");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));
        getContentPane().add(txtMaLienHe, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 190, -1));

        jLabel3.setText("Thời gian liên hệ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jLabel4.setText("Tình trạng");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        txtTGLH.setToolTipText("__/__/____");
        getContentPane().add(txtTGLH, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 160, -1));

        cboNhanVien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        getContentPane().add(cboNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 190, -1));

        jLabel7.setText("Mã liên hệ");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        cboTinhTrangLH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "------------------", "Thành công", "Không thành công", " ", " " }));
        getContentPane().add(cboTinhTrangLH, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 190, -1));

        tblLienHe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã liên hệ", "Thời gian liên hệ", "Tình trạng", "Khách hàng"
            }
        ));
        tblLienHe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLienHeMouseClicked(evt);
            }
        });
        tblLienHe.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblLienHeKeyPressed(evt);
            }
        });
        jScrollPane5.setViewportView(tblLienHe);

        getContentPane().add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 350, 320));

        btnToListVoucher.setText(">>");
        btnToListVoucher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnToListVoucherActionPerformed(evt);
            }
        });
        getContentPane().add(btnToListVoucher, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 150, -1, -1));

        btnBackListVoucher.setText("<<");
        btnBackListVoucher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackListVoucherActionPerformed(evt);
            }
        });
        getContentPane().add(btnBackListVoucher, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 180, -1, -1));

        jLabel8.setText("Khách hàng");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        cboKhachHang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "------------------", "Thành công", "Không thành công", " ", " " }));
        getContentPane().add(cboKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 190, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblVoucherAddedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVoucherAddedMouseClicked
        //        displayDetail(((JTable)evt.getSource()).getSelectedRow());
    }//GEN-LAST:event_tblVoucherAddedMouseClicked

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        String maLienHe = txtMaLienHe.getText();
        if(maLienHe.isEmpty()){
            System.out.println("Vui lòng nhập mã liên hệ để xóa");
        } else {
            int sl = lienHeBll.getSLLienHeTheoMa(maLienHe);
            if(sl == 0){
                    JOptionPane.showMessageDialog(this, "Không tồn tại mã liên hệ để xóa");
                } else {
                    try{
                            lienHeBll.delete(maLienHe);
                            JOptionPane.showMessageDialog(this, "Xóa liên hệ thành công");
                            String maNV = ((ComboBoxItem)cboNhanVien.getSelectedItem()).getKeyString();
                             loadDataToTableLienHe(maNV);
                        } catch (Exception e){
                            JOptionPane.showMessageDialog(this, "Lỗi không thể xóa liên hệ");
                        }
                }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        isAdd = true;
        btnThem.setEnabled(false);
        btnXoa.setEnabled(false);

        txtMaLienHe.setText("");
        txtTGLH.setText("");
        cboTinhTrangLH.setSelectedIndex(0);
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        String maLH = txtMaLienHe.getText();
        String thoiGian = txtTGLH.getText();
        if(isAdd){
            
            
            if(maLH.isEmpty() || thoiGian.isEmpty()){
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin để thêm liên hệ");
                return;
            }
            
            if(lienHeBll.getSLLienHeTheoMa(maLH) > 0){
                JOptionPane.showMessageDialog(this, "Lỗi trùng mã liên hệ không thể thêm");
                return;
            }
            themLienHe();
        } else {
            lienHeBll.delete(maLH);
            themLienHe();
            JOptionPane.showMessageDialog(this, "Cập nhật liên hệ thành công");
        }

        //        String maVoucher = txtMaVoucher.getText();
        //        String tenVoucher = txtTenVoucher.getText();
        //        var giamGia = Double.valueOf("0");
        //        //String lienhe = ((ComboBoxItem)cboLienHe.getSelectedItem()).getKeyString();
        //
        //        if(maVoucher.isEmpty() || tenVoucher.isEmpty() || txtGiamGia.getText().isEmpty()){
            //            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin để sửa voucher");
            //            return;
            //        }
        //
        //        try{
            //            giamGia = Double.valueOf(txtGiamGia.getText());
            //        } catch (Exception e){
            //            JOptionPane.showMessageDialog(this, "Giảm giá phải thuộc [0,1]");
            //            return;
            //        }
        //
        //        if(giamGia < 0 || giamGia > 1){
            //            JOptionPane.showMessageDialog(this, "Giảm giá phải thuộc [0,1]");
            //            return;
            //        }
        //        try{
            //            int sl = _bll.getSLVoucherTheoMa(maVoucher);
            //            if(sl == 0){
                //                JOptionPane.showMessageDialog(this, "Không tồn tại voucher có mã " + maVoucher);
                //            } else {
                //                _bll.update(maVoucher, tenVoucher, giamGia);
                //                loadAllData();
                //                JOptionPane.showMessageDialog(this, "Sửa voucher thành công");
                //            }
            //        } catch (Exception e){
            //            JOptionPane.showMessageDialog(this, "Lỗi không thể thêm mới dịch vụ");
            //        }
    }//GEN-LAST:event_btnLuuActionPerformed

    private void tblVoucherMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVoucherMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblVoucherMouseClicked

    private void tblDichVuAddedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDichVuAddedMouseClicked
        //        displayDetail(((JTable)evt.getSource()).getSelectedRow());
    }//GEN-LAST:event_tblDichVuAddedMouseClicked

    private void tblDichVuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDichVuMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblDichVuMouseClicked

    private void tblLienHeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLienHeMouseClicked
        showVoucherDaLienHe(((JTable) evt.getSource()).getSelectedRow());
        showDichVuDaLienHe(((JTable) evt.getSource()).getSelectedRow());
        showDetail(((JTable) evt.getSource()).getSelectedRow());
    }//GEN-LAST:event_tblLienHeMouseClicked

    private void tblLienHeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblLienHeKeyPressed
        showVoucherDaLienHe(((JTable) evt.getSource()).getSelectedRow());
        showDichVuDaLienHe(((JTable) evt.getSource()).getSelectedRow());
        showDetail(((JTable) evt.getSource()).getSelectedRow());
    }//GEN-LAST:event_tblLienHeKeyPressed

    private void btnToListVoucherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnToListVoucherActionPerformed
        int index = tblVoucher.getSelectedRow();
        Vector info = (Vector)dataVoucher.get(index);
        dataVoucherAdded.add(info);
        dataVoucher.remove(info);
        tblVoucher.updateUI();
        tblVoucherAdded.updateUI();
    }//GEN-LAST:event_btnToListVoucherActionPerformed

    private void btnBackListVoucherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackListVoucherActionPerformed
        int index = tblVoucherAdded.getSelectedRow();
        Vector info = (Vector)dataVoucherAdded.get(index);
        dataVoucher.add(info);
        dataVoucherAdded.remove(info);
        tblVoucher.updateUI();
        tblVoucherAdded.updateUI();
    }//GEN-LAST:event_btnBackListVoucherActionPerformed

    private void btnToListDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnToListDichVuActionPerformed
        int index = tblDichVu.getSelectedRow();
        Vector info = (Vector)dataDichVu.get(index);
        dataDichVuAdded.add(info);
        dataDichVu.remove(info);
        tblDichVu.updateUI();
        tblDichVuAdded.updateUI();
    }//GEN-LAST:event_btnToListDichVuActionPerformed

    private void btnBackListDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackListDichVuActionPerformed
        int index = tblDichVuAdded.getSelectedRow();
        Vector info = (Vector)dataDichVuAdded.get(index);
        dataDichVu.add(info);
        dataDichVuAdded.remove(info);
        tblDichVu.updateUI();
        tblDichVuAdded.updateUI();
    }//GEN-LAST:event_btnBackListDichVuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBackListDichVu;
    private javax.swing.JButton btnBackListVoucher;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnToListDichVu;
    private javax.swing.JButton btnToListVoucher;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cboKhachHang;
    private javax.swing.JComboBox<String> cboNhanVien;
    private javax.swing.JComboBox<String> cboTinhTrangLH;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable tblDichVu;
    private javax.swing.JTable tblDichVuAdded;
    private javax.swing.JTable tblLienHe;
    private javax.swing.JTable tblVoucher;
    private javax.swing.JTable tblVoucherAdded;
    private javax.swing.JTextField txtMaLienHe;
    private javax.swing.JFormattedTextField txtTGLH;
    // End of variables declaration//GEN-END:variables
}
