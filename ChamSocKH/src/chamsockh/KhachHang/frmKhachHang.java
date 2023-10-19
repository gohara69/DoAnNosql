/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package chamsockh.KhachHang;

import BLL.KhachHangBLL;
import DTO.KhachHangDTO;
import chamsockh.KhachHang.frmKhachHang;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.json.JSONObject;

/**
 *
 * @author PC
 */
public class frmKhachHang extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmKhachHang
     */
    
    KhachHangBLL khBll = new KhachHangBLL();
    Vector data = new Vector();
    Vector header = new Vector();
    public frmKhachHang() {
        initComponents();
        initTable();
        ResultSet rs = khBll.getAllKhachHang();
        try {
            while (rs.next()) {
                Vector<String> info = new Vector<String>();
                info.add(rs.getString("MaKH"));
                info.add(rs.getString("TenKH"));
                info.add(rs.getString("SoDienThoaiKH"));
                info.add(rs.getString("DiaChiKH"));
                data.add(info);
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void initTable() {
        header.add("Mã khách hàng");
        header.add("Tên khách hàng");
        header.add("Số điện thoại");
        header.add("Địa chỉ");
        tbKhachHang.setModel(new DefaultTableModel(data, header));
    }

    public void displayDetail(int row) {
        if (row >= 0) {
            Vector<String> info = (Vector<String>) data.get(row);
            txtMaKH.setText(info.get(0));
            txtTenKH.setText(info.get(1));
            txtSDT.setText(info.get(2));
            txtDiaChi.setText(info.get(3));
        }
    }

    public void loadAllData() {
        DefaultTableModel model = ((DefaultTableModel) tbKhachHang.getModel());
        model.setRowCount(0);
        ResultSet rs = khBll.getAllKhachHang();
        if (rs != null) {
            try {
                while (rs.next()) {
                    Vector<String> info = new Vector<String>();
                    info.add(rs.getString("MaKH"));
                    info.add(rs.getString("TenKH"));
                    info.add(rs.getString("SoDienThoaiKH"));
                    info.add(rs.getString("DiaChiKH"));
                    data.add(info);
                }
            } catch (SQLException ex) {
                Logger.getLogger(frmKhachHang.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Không tồn tại mã dịch vụ cần tìm");
        }
    }

    public void loadDataByMaNV(String makh) {
        DefaultTableModel model = ((DefaultTableModel) tbKhachHang.getModel());
        model.setRowCount(0);
        ResultSet rs = khBll.getAllKhachHangByMaKH(makh);
        if (rs != null) {
            try {
                while (rs.next()) {
                    Vector<String> info = new Vector<String>();
                    info.add(rs.getString("MaKH"));
                    info.add(rs.getString("TenKH"));
                    info.add(rs.getString("SoDienThoaiKH"));
                    info.add(rs.getString("DiaChiKH"));
                    data.add(info);
                }
            } catch (SQLException ex) {
                Logger.getLogger(frmKhachHang.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Không tồn tại mã nhân viên cần tìm");
        }
    }

    public void loadDataByTenNV(String tenkh) {
        DefaultTableModel model = ((DefaultTableModel) tbKhachHang.getModel());
        model.setRowCount(0);
        ResultSet rs = khBll.getAllKhachHangByTenKH(tenkh);
        if (rs != null) {
            try {
                while (rs.next()) {
                    Vector<String> info = new Vector<String>();
                    info.add(rs.getString("MaKH"));
                    info.add(rs.getString("TenKH"));
                    info.add(rs.getString("SoDienThoaiKH"));
                    info.add(rs.getString("DiaChiKH"));
                    data.add(info);
                }
            } catch (SQLException ex) {
                Logger.getLogger(frmKhachHang.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Không tồn tại tên nhân viên cần tìm");
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        txtTenKH = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbKhachHang = new javax.swing.JTable();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Khách hàng");

        jLabel2.setText("Mã khách hàng");

        jLabel3.setText("Tên khách hàng");

        jLabel4.setText("Số điện thoại");

        jLabel5.setText("Địa chỉ");

        tbKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbKhachHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbKhachHang);

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        btnSearch.setText("Tìm kiếm");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel1)
                                .addGap(58, 58, 58))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(28, 28, 28)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDiaChi)
                            .addComponent(txtSDT)
                            .addComponent(txtTenKH)
                            .addComponent(txtMaKH)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 71, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(142, 142, 142)
                                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        String maKH = txtMaKH.getText();
        String tenKH = txtTenKH.getText();
        String sdt = txtSDT.getText();
        String diaChi = txtDiaChi.getText();
        KhachHangDTO kh = new KhachHangDTO(maKH, tenKH, sdt, diaChi);
        try{
            if(maKH.isEmpty() || tenKH.isEmpty() || sdt.isEmpty() || diaChi.isEmpty()){
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin để thêm khách hàng");
            } else {
                int sl = khBll.getSLKhachHangTheoMa(maKH);
                if(sl == 0){
                    int kq = khBll.insertNew(kh);
                    JOptionPane.showMessageDialog(this, "Thêm khách hàng thành công");
                    loadAllData();
                } else if(sl > 0) {
                    JOptionPane.showMessageDialog(this, "Lỗi trùng khóa mã khách hàng");
                } else {
                    JOptionPane.showMessageDialog(this, "Lỗi không thể thêm mới khách hàng");
                }
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(this, "Lỗi không thể thêm mới khách hàng");
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        String maKH = txtMaKH.getText();
        String tenKH = txtTenKH.getText();
        String sdt = txtSDT.getText();
        String diaChi = txtDiaChi.getText();
        KhachHangDTO kh = new KhachHangDTO(maKH, tenKH, sdt, diaChi);

        try{
            if(maKH.isEmpty() || tenKH.isEmpty() || sdt.isEmpty() || diaChi.isEmpty()){
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ để chỉnh sửa thông tin khách hàng");
            } else {
                int sl = khBll.getSLKhachHangTheoMa(maKH);
                if(sl > 0){
                    int kq = khBll.update(kh);
                    JOptionPane.showMessageDialog(this, "Sửa khách hàng thành công");
                    loadAllData();
                } else {
                    JOptionPane.showMessageDialog(this, "Lỗi không thể sửa khách hàng");
                }
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(this, "Lỗi không thể sửa khách hàng");
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        String makh = txtMaKH.getText();
        if(makh.isEmpty()){
            System.out.println("Vui lòng nhập mã khách hàng để xóa");
        } else {
            try{
                int kq = khBll.delete(makh);
                JOptionPane.showMessageDialog(this, "Xóa khách hàng thành công");
                loadAllData();
            } catch (Exception e){
                JOptionPane.showMessageDialog(this, "Lỗi không thể xóa khách hàng");
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        int result = JOptionPane.showConfirmDialog(this, "Bạn có muốn thoát chương trình không?", "Thông báo", JOptionPane.YES_NO_OPTION);
        if(result ==JOptionPane.YES_OPTION)
        this.dispose();
    }//GEN-LAST:event_btnThoatActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String makh = txtMaKH.getText();
        String tenkh = txtTenKH.getText();

        if (makh.isEmpty() && tenkh.isEmpty()) {
            loadAllData();
        } else {
            if (makh.isEmpty() == false) {
                loadDataByMaNV(makh);
            } else {
                loadDataByTenNV(tenkh);
            }
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void tbKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbKhachHangMouseClicked
        displayDetail(((JTable) evt.getSource()).getSelectedRow());
    }//GEN-LAST:event_tbKhachHangMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbKhachHang;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenKH;
    // End of variables declaration//GEN-END:variables
}
