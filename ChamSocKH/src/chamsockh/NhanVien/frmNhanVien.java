/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package chamsockh.NhanVien;

import BLL.NhanVienBll;
import DTO.NhanVienDTO;
import chamsockh.frmTrangChu;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import org.json.JSONObject;

/**
 *
 * @author PC
 */
public class frmNhanVien extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmNhanVien
     */
    NhanVienBll nvBll = new NhanVienBll();
    Vector data = new Vector();
    Vector header = new Vector();

    public frmNhanVien() {
        initComponents();
        initTable();
        ResultSet rs = nvBll.getAllNhanVien();
        try {
            while (rs.next()) {
                Vector<String> info = new Vector<String>();
                // Lấy chuỗi ngày từ Neo4j qua, nó là 1 dạng JSON gì đó
                String ngaySinh = rs.getString("NgaySinhNV");
                LocalDateTime localDateTime = convertDateNeo4j_To_StandardDate(ngaySinh);
                info.add(rs.getString("MaNV"));
                info.add(rs.getString("TenNV"));
                // Chuyển kiểu LocalDateTime về kiểu Date phù hợp để xuất ra màn hình
                info.add(localDateTime.format(DateTimeFormatter.ISO_DATE));
                info.add(rs.getString("GioiTinhNV"));
                info.add(rs.getString("DiaChiNV"));
                info.add(rs.getString("ViTriCongViec"));
                data.add(info);
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void initTable() {
        header.add("Mã nhân viên");
        header.add("Tên nhân viên");
        header.add("Ngày sinh");
        header.add("Giới tính");
        header.add("Địa chỉ");
        header.add("Chức vụ");

        tbNhanVien.setModel(new DefaultTableModel(data, header));
    }

    public void displayDetail(int row) {
        if (row >= 0) {
            Vector<String> info = (Vector<String>) data.get(row);
            txtMaNV.setText(info.get(0));
            txtTenNV.setText(info.get(1));
            txtNgaySinh.setText(info.get(2));
            cboGioiTinh.setSelectedItem(info.get(3));
            txtDiaChi.setText(info.get(4));
            cboChucVu.setSelectedItem(info.get(5));
        }
    }

    public void loadAllData() {
        DefaultTableModel model = ((DefaultTableModel) tbNhanVien.getModel());
        model.setRowCount(0);
        ResultSet rs = nvBll.getAllNhanVien();
        if (rs != null) {
            try {
                while (rs.next()) {
                    Vector<String> info = new Vector<String>();
                    // Lấy chuỗi ngày từ Neo4j qua, nó là 1 dạng JSON gì đó
                    String ngaySinh = rs.getString("NgaySinhNV");
                    LocalDateTime localDateTime = convertDateNeo4j_To_StandardDate(ngaySinh);
                    info.add(rs.getString("MaNV"));
                    info.add(rs.getString("TenNV"));
                    // Chuyển kiểu LocalDateTime về kiểu Date phù hợp để xuất ra màn hình
                    info.add(localDateTime.format(DateTimeFormatter.ISO_DATE));
                    info.add(rs.getString("GioiTinhNV"));
                    info.add(rs.getString("DiaChiNV"));
                    info.add(rs.getString("ViTriCongViec"));
                    data.add(info);
                }
            } catch (SQLException ex) {
                Logger.getLogger(frmNhanVien.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Không tồn tại mã dịch vụ cần tìm");
        }
    }

    public void loadDataByMaNV(String manv) {
        DefaultTableModel model = ((DefaultTableModel) tbNhanVien.getModel());
        model.setRowCount(0);
        ResultSet rs = nvBll.getAllNhanVienByMaNv(manv);
        if (rs != null) {
            try {
                while (rs.next()) {
                    Vector<String> info = new Vector<String>();
                    // Lấy chuỗi ngày từ Neo4j qua, nó là 1 dạng JSON gì đó
                    String ngaySinh = rs.getString("NgaySinhNV");
                    LocalDateTime localDateTime = convertDateNeo4j_To_StandardDate(ngaySinh);
                    info.add(rs.getString("MaNV"));
                    info.add(rs.getString("TenNV"));
                    // Chuyển kiểu LocalDateTime về kiểu Date phù hợp để xuất ra màn hình
                    info.add(localDateTime.format(DateTimeFormatter.ISO_DATE));
                    info.add(rs.getString("GioiTinhNV"));
                    info.add(rs.getString("DiaChiNV"));
                    info.add(rs.getString("ViTriCongViec"));
                    data.add(info);
                }
            } catch (SQLException ex) {
                Logger.getLogger(frmNhanVien.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Không tồn tại mã nhân viên cần tìm");
        }
    }

    public void loadDataByTenNV(String tennv) {
        DefaultTableModel model = ((DefaultTableModel) tbNhanVien.getModel());
        model.setRowCount(0);
        ResultSet rs = nvBll.getAllNhanVienByTenNV(tennv);
        if (rs != null) {
            try {
                while (rs.next()) {
                    Vector<String> info = new Vector<String>();
                    // Lấy chuỗi ngày từ Neo4j qua, nó là 1 dạng JSON gì đó
                    String ngaySinh = rs.getString("NgaySinhNV");
                    LocalDateTime localDateTime = convertDateNeo4j_To_StandardDate(ngaySinh);
                    info.add(rs.getString("MaNV"));
                    info.add(rs.getString("TenNV"));
                    // Chuyển kiểu LocalDateTime về kiểu Date phù hợp để xuất ra màn hình
                    info.add(localDateTime.format(DateTimeFormatter.ISO_DATE));
                    info.add(rs.getString("GioiTinhNV"));
                    info.add(rs.getString("DiaChiNV"));
                    info.add(rs.getString("ViTriCongViec"));
                    data.add(info);
                }
            } catch (SQLException ex) {
                Logger.getLogger(frmNhanVien.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Không tồn tại tên nhân viên cần tìm");
        }
    }

    public LocalDateTime convertDateNeo4j_To_StandardDate(String dateJson) {
        // Tạo kiểu JSONObject để chứa kiểu dữ liệu ngày vừa lấy từ Neo4j qua
        JSONObject jsonObject = new JSONObject(dateJson);
        // Tạo một đối tượng LocalDateTime và phân tích chuỗi JSON ra thành kiểu LocalDateTime
        LocalDateTime localDateTime = LocalDateTime.of(
                jsonObject.getInt("year"),
                jsonObject.getInt("monthValue"),
                jsonObject.getInt("dayOfMonth"),
                0,
                0,
                0
        );
        return localDateTime;
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
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        txtTenNV = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        cboChucVu = new javax.swing.JComboBox<>();
        cboGioiTinh = new javax.swing.JComboBox<>();
        txtNgaySinh = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbNhanVien = new javax.swing.JTable();
        btnThoat = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Nhân viên");

        jLabel2.setText("Mã nhân viên");

        jLabel3.setText("Tên nhân viên");

        jLabel4.setText("Ngày sinh");

        jLabel5.setText("Giới tính");

        jLabel6.setText("Địa chỉ");

        jLabel7.setText("Chức vụ");

        cboChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chăm sóc Khách hàng", "Bán hàng" }));

        cboGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));

        tbNhanVien.setModel(new javax.swing.table.DefaultTableModel(
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
        tbNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbNhanVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbNhanVien);

        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(70, 70, 70)
                                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(50, 50, 50)
                                        .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 71, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtDiaChi, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                                        .addComponent(txtTenNV, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                                        .addComponent(txtMaNV)
                                        .addComponent(cboChucVu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cboGioiTinh, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)))))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cboGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cboChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbNhanVienMouseClicked
        displayDetail(((JTable) evt.getSource()).getSelectedRow());
    }//GEN-LAST:event_tbNhanVienMouseClicked

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String manv = txtMaNV.getText();
        String tennv = txtTenNV.getText();

        if (manv.isEmpty() && tennv.isEmpty()) {
            loadAllData();
        } else {
            if (manv.isEmpty() == false) {
                loadDataByMaNV(manv);
            } else {
                loadDataByTenNV(tennv);
            }
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        String maNV = txtMaNV.getText();
        String tenNV = txtTenNV.getText();
        String ngaySinh = txtNgaySinh.getText();
        String gioiTinh = cboGioiTinh.getItemAt(cboGioiTinh.getSelectedIndex()).toString();
        String diaChi = txtDiaChi.getText();
        String chucVu = cboChucVu.getItemAt(cboChucVu.getSelectedIndex()).toString();
        NhanVienDTO nv = new NhanVienDTO(maNV, tenNV, ngaySinh, gioiTinh, diaChi, chucVu);
        try{
            if(maNV.isEmpty() || tenNV.isEmpty() || ngaySinh.isEmpty() || diaChi.isEmpty()){
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin để thêm nhân viên");
            } else {
                int sl = nvBll.getSLNhanVienTheoMa(maNV);
                if(sl == 0){
                    int kq = nvBll.insertNew(nv);
                    JOptionPane.showMessageDialog(this, "Thêm nhân viên thành công");
                    loadAllData();
                } else if(sl > 0) {
                    JOptionPane.showMessageDialog(this, "Lỗi trùng khóa mã nhân viên");
                } else {
                    JOptionPane.showMessageDialog(this, "Lỗi không thể thêm mới nhân viên");
                }
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(this, "Lỗi không thể thêm mới nhân viên");
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        String maNV = txtMaNV.getText();
        String tenNV = txtTenNV.getText();
        String ngaySinh = txtNgaySinh.getText();
        String gioiTinh = cboGioiTinh.getItemAt(cboGioiTinh.getSelectedIndex()).toString();
        String diaChi = txtDiaChi.getText();
        String chucVu = cboChucVu.getItemAt(cboChucVu.getSelectedIndex()).toString();
        NhanVienDTO nv = new NhanVienDTO(maNV, tenNV, ngaySinh, gioiTinh, diaChi, chucVu);

        try{
            if(maNV.isEmpty() || tenNV.isEmpty() || ngaySinh.isEmpty() || diaChi.isEmpty()){
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ để chỉnh sửa thông tin nhân viên");
            } else {
                int sl = nvBll.getSLNhanVienTheoMa(maNV);
                if(sl > 0){
                    int kq = nvBll.update(nv);
                    JOptionPane.showMessageDialog(this, "Sửa nhân viên thành công");
                    loadAllData();
                } else {
                    JOptionPane.showMessageDialog(this, "Lỗi không thể sửa nhân viên");
                }
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(this, "Lỗi không thể sửa nhân viên");
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        String manv = txtMaNV.getText();
        if(manv.isEmpty()){
            System.out.println("Vui lòng nhập mã nhân viên để xóa");
        } else {
            try{
                int kq = nvBll.delete(manv);
                JOptionPane.showMessageDialog(this, "Xóa nhân viên thành công");
                loadAllData();
            } catch (Exception e){
                JOptionPane.showMessageDialog(this, "Lỗi không thể xóa nhân viên");
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        int result = JOptionPane.showConfirmDialog(this, "Bạn có muốn thoát chương trình không?", "Thông báo", JOptionPane.YES_NO_OPTION); 
        if(result ==JOptionPane.YES_OPTION)
            this.dispose();
    }//GEN-LAST:event_btnThoatActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cboChucVu;
    private javax.swing.JComboBox<String> cboGioiTinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbNhanVien;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtTenNV;
    // End of variables declaration//GEN-END:variables
}
