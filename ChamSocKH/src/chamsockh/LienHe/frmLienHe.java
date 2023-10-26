/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package chamsockh.LienHe;

import BLL.DichVuBll;
import BLL.LienHeBLL;
import BLL.NhanVienBll;
import BLL.VoucherBLL;
import chamsockh.ComboBoxItem;
import chamsockh.Voucher.frmVoucher;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;

/**
 *
 * @author MINH HOANG
 */
public class frmLienHe extends javax.swing.JInternalFrame {

    NhanVienBll nvBll = new NhanVienBll();
    LienHeBLL lienHeBll = new LienHeBLL();
    VoucherBLL voucherBll = new VoucherBLL();
    DichVuBll dichVuBll = new DichVuBll();
    Vector dataLienHe = new Vector();
    Vector headerLienHe = new Vector();
    Vector dataVoucher = new Vector();
    Vector headerVoucher = new Vector();
    Vector dataDichVu = new Vector();
    Vector headerDichVu = new Vector();
    /**
     * Creates new form frmLienHe
     */
    public frmLienHe() {
        initComponents();
        
        initTableLienHe();
        initTableVoucher();
        initTableDichVu();
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
    }
    
    public void initTableLienHe(){
        headerLienHe.add("Mã liên hệ");
        headerLienHe.add("Thời gian liên hệ");
        headerLienHe.add("Tình trạng");
        headerLienHe.add("Khách hàng");
        tblLienHe.setModel(new DefaultTableModel(dataLienHe, headerLienHe));
    }
    
    public void initTableVoucher(){
        headerVoucher.add("Mã voucher");
        headerVoucher.add("Tên voucher");
        headerVoucher.add("Giảm giá");
        tblVoucher.setModel(new DefaultTableModel(dataVoucher, headerVoucher));
    }
    
    public void initTableDichVu(){
        headerDichVu.add("Mã dịch vụ");
        headerDichVu.add("Tên dịch vụ");
        headerDichVu.add("Mô tả");
        headerDichVu.add("Giá");

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
        Vector info = (Vector) dataLienHe.get(index);
        String maLH = info.get(0).toString();
        ResultSet rs = voucherBll.getAllVoucherByMaLH(maLH);
        DefaultTableModel table = (DefaultTableModel)tblVoucher.getModel();
        table.setRowCount(0);
        try {
            while(rs.next()){
                Vector<String> inf = new Vector<String>();
                inf.add(rs.getString("MaVoc"));
                inf.add(rs.getString("TenVoc"));
                inf.add(rs.getString("GiamGia"));

                dataVoucher.add(inf);
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmVoucher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void showDichVuDaLienHe(int index){
        Vector info = (Vector) dataLienHe.get(index);
        String maLH = info.get(0).toString();
        ResultSet rs = dichVuBll.getAllDichVuByMaLH(maLH);
        DefaultTableModel table = (DefaultTableModel)tblDichVu.getModel();
        table.setRowCount(0);
        try {
            while(rs.next()){
                Vector<String> inf = new Vector<String>();
                inf.add(rs.getString("MaDV"));
                inf.add(rs.getString("TenDV"));
                inf.add(rs.getString("GiaDV"));
                inf.add(rs.getString("MoTaDV"));

                dataDichVu.add(inf);
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmVoucher.class.getName()).log(Level.SEVERE, null, ex);
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
        jLabel1 = new javax.swing.JLabel();
        cboNhanVien = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblLienHe = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblDichVu = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblVoucher = new javax.swing.JTable();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Liên hệ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel1.setText("Nhân viên");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        cboNhanVien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        getContentPane().add(cboNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 190, -1));

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
        jScrollPane2.setViewportView(tblLienHe);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 450, 240));

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

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 350, -1, 240));

        jLabel5.setText("THÔNG TIN LIÊN HỆ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, -1, -1));

        jLabel6.setText("DANH SÁCH DỊCH VỤ LIÊN HỆ");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 330, -1, -1));

        jLabel8.setText("DANH SÁCH VOUCHER LIÊN HỆ");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 40, -1, -1));

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
        jScrollPane5.setViewportView(tblVoucher);

        getContentPane().add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 60, 450, 240));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblLienHeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLienHeMouseClicked
        showVoucherDaLienHe(((JTable) evt.getSource()).getSelectedRow());
        showDichVuDaLienHe(((JTable) evt.getSource()).getSelectedRow());
    }//GEN-LAST:event_tblLienHeMouseClicked

    private void tblDichVuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDichVuMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblDichVuMouseClicked

    private void tblVoucherMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVoucherMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblVoucherMouseClicked

    private void tblLienHeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblLienHeKeyPressed
        showVoucherDaLienHe(((JTable) evt.getSource()).getSelectedRow());
        showDichVuDaLienHe(((JTable) evt.getSource()).getSelectedRow());
    }//GEN-LAST:event_tblLienHeKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cboNhanVien;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable tblDichVu;
    private javax.swing.JTable tblLienHe;
    private javax.swing.JTable tblVoucher;
    // End of variables declaration//GEN-END:variables
}
