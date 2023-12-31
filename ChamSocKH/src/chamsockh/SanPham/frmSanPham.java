/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package chamsockh.SanPham;

import BLL.SanPhamBLL;
import chamsockh.frmTrangChu;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class frmSanPham extends javax.swing.JInternalFrame {

   SanPhamBLL spBLL = new SanPhamBLL();
    Vector data = new Vector();
    Vector header = new Vector();
    /**
     * Creates new form frmSanPham
     */
    public frmSanPham() {
        initComponents();
        initTable();
        ResultSet rs = spBLL.getAllSanPham();
        try {
            while(rs.next()){
                Vector<String> info = new Vector<String>();
                info.add(rs.getString("MaSP"));
                info.add(rs.getString("TenSP"));
                info.add(rs.getString("GiaSP"));
                data.add(info);
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        public void initTable()
        {
        header.add("Mã sản phẩm");
        header.add("Tên sản phẩm");
        header.add("Giá sản phẩm");
        tblSanPham.setModel(new DefaultTableModel(data, header));
    }
        public void displayDetail(int row){
        if(row >= 0){
            Vector<String> info = (Vector<String>) data.get(row);
            txtMaSP.setText(info.get(0));
            txtTenSP.setText(info.get(1));
            txtGiaSP.setText(info.get(2));
            
        }
    }
        public void loadAllData(){
        DefaultTableModel model = ((DefaultTableModel)tblSanPham.getModel());
        model.setRowCount(0);
        ResultSet rs = spBLL.getAllSanPham();
        if(rs != null){
            try {
                while(rs.next()){
                    Vector<String> info = new Vector<String>();
                    info.add(rs.getString("MaSP"));
                    info.add(rs.getString("TenSP"));
                    info.add(rs.getString("GiaSP"));
                    data.add(info);
                }   
            } catch (SQLException ex) {
                Logger.getLogger(frmSanPham.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Không tồn tại sản phẩm cần tìm");
        }
    }
        public void loadDataByMaSP(String masp){
        DefaultTableModel model = ((DefaultTableModel)tblSanPham.getModel());
        model.setRowCount(0);
        ResultSet rs = spBLL.getAllDSanPhamByMaSP(masp);
        if(rs != null){
            try {
                while(rs.next()){
                    Vector<String> info = new Vector<String>();
                    info.add(rs.getString("MaSP"));
                    info.add(rs.getString("TenSP"));
                    info.add(rs.getString("GiaSP"));
                    data.add(info);
                }   
            } catch (SQLException ex) {
                Logger.getLogger(frmSanPham.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Không tồn tại sản phẩm cần tìm");
        }
    }
        public void loadDataByTenSP(String tensp){
        DefaultTableModel model = ((DefaultTableModel)tblSanPham.getModel());
        model.setRowCount(0);
        ResultSet rs = spBLL.getAllSanPhamByTenSP(tensp);
        if(rs != null){
            try {
                while(rs.next()){
                    Vector<String> info = new Vector<String>();
                    info.add(rs.getString("MaSP"));
                    info.add(rs.getString("TenSP"));
                    info.add(rs.getString("GiaSP"));
                    data.add(info);
                }   
            } catch (SQLException ex) {
                Logger.getLogger(frmSanPham.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Không tồn tại sản phẩm cần tìm");
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnTimKiem = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtMaSP = new javax.swing.JTextField();
        txtTenSP = new javax.swing.JTextField();
        txtGiaSP = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã Sản Phẩm", "Tên Sản Phẩm", "Giá Sản Phẩm"
            }
        ));
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSanPham);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Sản Phẩm");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Chức Năng"));

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnXoa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnXoa))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSua)
                    .addComponent(btnTimKiem))
                .addContainerGap(125, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin sản phẩm"));

        jLabel2.setText("Mã Sản Phẩm");

        txtMaSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaSPActionPerformed(evt);
            }
        });

        jLabel3.setText("Tên Sản Phẩm");

        jLabel4.setText("Giá Sản Phẩm");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtGiaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGiaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(43, 43, 43)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaSPActionPerformed

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        // TODO add your handling code here:
        displayDetail(((JTable)evt.getSource()).getSelectedRow());
    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        String masp = txtMaSP.getText();
        String tensp = txtTenSP.getText();
        Long giasp = Long.parseLong("0");
    
        try{
            giasp = Long.parseLong(txtGiaSP.getText());
            if(masp.isEmpty() || tensp.isEmpty()){
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin để thêm sản phẩm");
            } else {
                int sl = spBLL.getSLSanPhamTheoMa(masp);
                if(sl == 0){
                    int kq = spBLL.insertNew(masp, tensp, giasp);
                    JOptionPane.showMessageDialog(this, "Thêm sản phẩm thành công");
                    loadAllData();
                } else if(sl > 0) {
                    JOptionPane.showMessageDialog(this, "Lỗi trùng khóa mã sản phẩm");
                } else {
                    JOptionPane.showMessageDialog(this, "Lỗi không thể thêm mới sản phẩm");
                }
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(this, "Lỗi không thể thêm mới sản phẩm");
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
      String masp = txtMaSP.getText();
        if(masp.isEmpty()){
            System.out.println("Vui lòng nhập mã sản phẩm để xóa");
        } else {
            try{
                int kq = spBLL.delete(masp);
                JOptionPane.showMessageDialog(this, "Xóa sản phẩm thành công");
                loadAllData();
            } catch (Exception e){
                JOptionPane.showMessageDialog(this, "Lỗi không thể xóa sản phẩm");
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
       String masp = txtMaSP.getText();
        String tensp = txtTenSP.getText();
        Long giasp = Long.parseLong("0");
        try{
            giasp = Long.parseLong(txtGiaSP.getText());
            if(masp.isEmpty() || tensp.isEmpty()){
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin để thêm sản phẩm");
            } else {
                int sl = spBLL.getSLSanPhamTheoMa(masp);
                if(sl > 0){
                    int kq = spBLL.update(masp,tensp,giasp);
                    JOptionPane.showMessageDialog(this, "Sửa sản phẩm thành công");
                    loadAllData();
                } else {
                    JOptionPane.showMessageDialog(this, "Lỗi không thể sửa sản phẩm");
                }
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(this, "Lỗi không thể sửa sản phẩm");
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
       String masp = txtMaSP.getText();
        String tensp = txtTenSP.getText();
        
        if(masp.isEmpty() && tensp.isEmpty()){
            loadAllData();
        } else {
            if(masp.isEmpty() == false){
                loadDataByMaSP(masp);
            } else {
                loadDataByTenSP(tensp);
            }
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextField txtGiaSP;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtTenSP;
    // End of variables declaration//GEN-END:variables
}
