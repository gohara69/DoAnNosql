/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package chamsockh.KhieuNai;

import BLL.KhachHangBLL;
import BLL.KhieuNaiBLL;
import BLL.SanPhamBLL;
import DAL.KhieuNaiDAL;
import DTO.KhieuNaiDTO;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class frmThucHienKhieuNai extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmThucHienKhieuNai
     */
    KhieuNaiDAL knDAL = new KhieuNaiDAL();
    KhieuNaiBLL knBll = new KhieuNaiBLL();
    SanPhamBLL spBLL = new SanPhamBLL();
    KhachHangBLL khBLL = new KhachHangBLL();

    public frmThucHienKhieuNai() {
        initComponents();
        txtMaKN.setText(knDAL.auto_SinhMaKN());
        loadDataCboSanPham();

    }

    public void loadDataCboSanPham() {
        ResultSet rs = spBLL.getAllTenSanPham();
        try {
            while (rs.next()) {
                cboSPKN.addItem(rs.getString("TenSP"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmThucHienKhieuNai.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNgayKN = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaNoiDungKN = new javax.swing.JTextArea();
        btnSubmit = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cboSPKN = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtMaKN = new javax.swing.JTextField();
        cboMaKH = new javax.swing.JComboBox<>();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("KHIẾU NẠI DỊCH VỤ");

        jLabel2.setText("Mã khách hàng");

        jLabel3.setText("Ngày khiếu nại");

        jLabel4.setText("Nội dung khiếu nại");

        txaNoiDungKN.setColumns(20);
        txaNoiDungKN.setRows(5);
        jScrollPane1.setViewportView(txaNoiDungKN);

        btnSubmit.setText("Gửi");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        jLabel5.setText("Khiếu nại về sản phẩm");

        cboSPKN.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboSPKNItemStateChanged(evt);
            }
        });

        jLabel6.setText("Mã khiếu nại");

        txtMaKN.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(12, 12, 12)
                                .addComponent(jScrollPane1))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtMaKN)
                                    .addComponent(cboSPKN, 0, 268, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNgayKN)
                                    .addComponent(cboMaKH, 0, 278, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(351, 351, 351)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(279, 279, 279)
                                .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72)
                                .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 332, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtMaKN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(cboMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cboSPKN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtNgayKN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        String maKN = txtMaKN.getText();
        String ngayKN = txtNgayKN.getText();
        String noiDungKN = txaNoiDungKN.getText();
        String maKH = cboMaKH.getSelectedItem().toString();
        String tenSP = cboSPKN.getSelectedItem().toString();
        KhieuNaiDTO kn = new KhieuNaiDTO(maKN, ngayKN, noiDungKN);
        try {
            if (maKN.isEmpty() || ngayKN.isEmpty() || noiDungKN.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin để thực hiện khiếu nại");
            } else {
                // Insert Nút
                int kq = knBll.insertNew(kn);
                // Insert Quan Hệ
                knBll.taoQuanHe_KH_KN(maKH, maKN);
                knBll.taoQuanHe_SP_KN(tenSP, maKN);
                knBll.taoQuanHe_KN_SP(maKN, tenSP);
                JOptionPane.showMessageDialog(this, "Khiếu nại của bạn đã được gửi, cảm ơn bạn đã góp ý");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi không thể thực hiện gửi khiếu nại");
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void cboSPKNItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboSPKNItemStateChanged
        ResultSet rs = khBLL.getAllTenKhachHang_TheoTenSPMua(cboSPKN.getSelectedItem().toString());
        cboMaKH.removeAllItems();
        try {
            while (rs.next()) {
                cboMaKH.addItem(rs.getString("MaKH"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmThucHienKhieuNai.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cboSPKNItemStateChanged

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        int result = JOptionPane.showConfirmDialog(this, "Bạn có muốn thoát chương trình không?", "Thông báo", JOptionPane.YES_NO_OPTION);
        if(result ==JOptionPane.YES_OPTION)
        this.dispose();
    }//GEN-LAST:event_btnThoatActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSubmit;
    private javax.swing.JButton btnThoat;
    private javax.swing.JComboBox<String> cboMaKH;
    private javax.swing.JComboBox<String> cboSPKN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txaNoiDungKN;
    private javax.swing.JTextField txtMaKN;
    private javax.swing.JTextField txtNgayKN;
    // End of variables declaration//GEN-END:variables
}
