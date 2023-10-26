/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package chamsockh.HoaDon;
import BLL.HoaDonBLL;
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.json.JSONObject;
/**
 *
 * @author ASUS
 */
public class frmHoaDon extends javax.swing.JInternalFrame {

    HoaDonBLL hdBll = new HoaDonBLL();
    Vector data = new Vector();
    Vector header = new Vector();
    /**
     * Creates new form frmHoaDon
     */
    public frmHoaDon() {
        initComponents();
        initTable();
        ResultSet rs = hdBll.getAllHoaDon();
        try {
            while(rs.next()){
                Vector<String> info = new Vector<String>();
                // Lấy chuỗi ngày từ Neo4j qua, nó là 1 dạng JSON gì đó
                String ngaylap = rs.getString("NgayLapHD");
                LocalDateTime localDateTime = convertDateNeo4j_To_StandardDate(ngaylap);
                info.add(rs.getString("MaHD"));
                info.add(localDateTime.format(DateTimeFormatter.ISO_DATE));
                info.add(rs.getString("ThanhTienHD"));
                data.add(info);
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmHoaDon.class.getName()).log(Level.SEVERE, null, ex);
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
     public void initTable(){
        header.add("Mã hóa đơn");
        header.add("Ngày lập hóa đơn");
        header.add("Thành tiền");

        tblHoaDon.setModel(new DefaultTableModel(data, header));
    }
     public void displayDetail(int row) {
        if (row >= 0) {
            Vector<String> info = (Vector<String>) data.get(row);
            txtMaHD.setText(info.get(0));
            txtNgayLap.setText(info.get(1));
            txtThanhTien.setText(info.get(2));
            
        }
    }
      public void loadAllData(){
        DefaultTableModel model = ((DefaultTableModel)tblHoaDon.getModel());
        model.setRowCount(0);
        ResultSet rs = hdBll.getAllHoaDon();
        if(rs != null){
            try {
                while(rs.next()){
                    Vector<String> info = new Vector<String>();
                    String ngaylap = rs.getString("NgayLapHD");
                    LocalDateTime localDateTime = convertDateNeo4j_To_StandardDate(ngaylap);
                    info.add(rs.getString("MaHD"));
                    info.add(localDateTime.format(DateTimeFormatter.ISO_DATE));
                    info.add(rs.getString("ThanhTienHD"));
                    data.add(info);
                }   
            } catch (SQLException ex) {
                Logger.getLogger(frmHoaDon.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Không tồn tại mã dịch vụ cần tìm");
        }
    }
      public void loadAllDataByMa(String mahd){
        DefaultTableModel model = ((DefaultTableModel)tblHoaDon.getModel());
        model.setRowCount(0);
        ResultSet rs = hdBll.getAllHoaDonByMa(mahd);
        if(rs != null){
            try {
                while(rs.next()){
                    Vector<String> info = new Vector<String>();
                    String ngaylap = rs.getString("NgayLapHD");
                    LocalDateTime localDateTime = convertDateNeo4j_To_StandardDate(ngaylap);
                    info.add(rs.getString("MaHD"));
                    info.add(localDateTime.format(DateTimeFormatter.ISO_DATE));
                    info.add(rs.getString("ThanhTienHD"));
                    data.add(info);
                }   
            } catch (SQLException ex) {
                Logger.getLogger(frmHoaDon.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Không tồn tại mã dịch vụ cần tìm");
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
        tblHoaDon = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNgayLap = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtThanhTien = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnTimKiem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã hóa đơn", "Ngày lập", "Thành tiền"
            }
        ));
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDon);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Hóa Đơn");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin hóa đơn"));

        jLabel2.setText("Mã hóa đơn");

        jLabel3.setText("Ngày lập");

        jLabel4.setText("Thành tiền");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMaHD)
                    .addComponent(txtNgayLap)
                    .addComponent(txtThanhTien, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Chức năng"));

        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTimKiem)
                    .addComponent(btnXoa))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
         displayDetail(((JTable)evt.getSource()).getSelectedRow());
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
       String mahd = txtMaHD.getText();  
       if(mahd.isEmpty()){
           loadAllData();
       }else{
           loadAllDataByMa(mahd);
       }
//        if(mahd.isEmpty()){
//            loadAllData();
//        } else {
//            if(mahd.isEmpty() == false){
//                loadAllDataByMa(mahd);
//            }
//        }
    }//GEN-LAST:event_btnTimKiemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtNgayLap;
    private javax.swing.JTextField txtThanhTien;
    // End of variables declaration//GEN-END:variables
}
