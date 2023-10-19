/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package chamsockh.KhieuNai;

import BLL.KhieuNaiBLL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.json.JSONObject;

/**
 *
 * @author PC
 */
public class frmHienThiKhieuNai extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmHienThiKhieuNai
     */
    KhieuNaiBLL knBll = new KhieuNaiBLL();
    Vector data = new Vector();
    Vector header = new Vector();

    public frmHienThiKhieuNai() {
        initComponents();
        initTable();
        ResultSet rs = knBll.getAllKhieuNai();
        try {
            while (rs.next()) {
                // Lấy chuỗi ngày từ Neo4j qua, nó là 1 dạng JSON gì đó
                String ngayKN = rs.getString("NgayKN");
                LocalDateTime localDateTime = convertDateNeo4j_To_StandardDate(ngayKN);
                Vector<String> info = new Vector<String>();
                info.add(rs.getString("MaKN"));
                info.add(localDateTime.format(DateTimeFormatter.ISO_DATE));
                info.add(rs.getString("NoiDungKN"));
                data.add(info);
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmHienThiKhieuNai.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void initTable() {
        header.add("Mã khiếu nại");
        header.add("Ngày khiếu nại");
        header.add("Nội dung khiếu nại");
        tbKhieuNai.setModel(new DefaultTableModel(data, header));
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tbKhieuNai = new javax.swing.JTable();
        btnThoat = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("DANH SÁCH KHIẾU NẠI");

        tbKhieuNai.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbKhieuNai);

        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 342, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(393, 393, 393))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(341, 341, 341))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        int result = JOptionPane.showConfirmDialog(this, "Bạn có muốn thoát chương trình không?", "Thông báo", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION)
            this.dispose();
    }//GEN-LAST:event_btnThoatActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThoat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbKhieuNai;
    // End of variables declaration//GEN-END:variables
}
