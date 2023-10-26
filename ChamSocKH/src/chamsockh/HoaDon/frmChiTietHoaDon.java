/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package chamsockh.HoaDon;
import BLL.ChiTienHDBLL;
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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.json.JSONObject;
/**
 *
 * @author ASUS
 */
public class frmChiTietHoaDon extends javax.swing.JInternalFrame {
    ChiTienHDBLL cthdBll = new ChiTienHDBLL();
    Vector data = new Vector();
    Vector header = new Vector();
    Vector dataVoucher = new Vector();
    Vector headerVoucher = new Vector();
    Vector dataDichVu = new Vector();
    Vector headerDichVu = new Vector();
    Vector dataSanPham = new Vector();
    Vector headerSanPham = new Vector();
    /**
     * Creates new form frmChiTietHoaDon
     */
    public frmChiTietHoaDon() {
        initComponents();
        initTable();
        initTableVoucher();
        initTableSanPham();
        initTableDichVu();
        ResultSet rs = cthdBll.getAllCTHoaDon();
        try {
            while(rs.next()){
                Vector<String> info = new Vector<String>();
                String ngaylap = rs.getString("NgayLapHD");
                LocalDateTime localDateTime = convertDateNeo4j_To_StandardDate(ngaylap);
                info.add(rs.getString("MaHD"));
                info.add(rs.getString("MaNV"));
                info.add(rs.getString("MaKH"));
                info.add(localDateTime.format(DateTimeFormatter.ISO_DATE));
                info.add(rs.getString("ThanhTienHD"));
                data.add(info);
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmChiTietHoaDon.class.getName()).log(Level.SEVERE, null, ex);
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
        header.add("Mã nhân viên");
        header.add("Mã khách hàng");
        header.add("Ngày lập hóa đơn");
        header.add("Thành tiền");
        tblChiTietHoaDon.setModel(new DefaultTableModel(data, header));
    }
     public void initTableSanPham(){
        headerSanPham.add("Mã Sản phẩm");
        headerSanPham.add("Tên sản phẩm");
        headerSanPham.add("Giá sản phẩm");
        headerSanPham.add("Số lượng mua");
        tblSanPhamALL.setModel(new DefaultTableModel(dataSanPham, headerSanPham));
    }
       public void initTableDichVu(){
        headerDichVu.add("Mã dịch vụ");
        headerDichVu.add("Tên dịch vụ");
        headerDichVu.add("Mô tả");
        headerDichVu.add("Giá");
        tblDichVuAll.setModel(new DefaultTableModel(dataDichVu, headerDichVu));
    }
        public void initTableVoucher(){
        headerVoucher.add("Mã voucher");
        headerVoucher.add("Tên voucher");
        headerVoucher.add("Giảm giá");
        tblVoucher.setModel(new DefaultTableModel(dataVoucher, headerVoucher));
    }
       public void loadDichVuByMaHD(int index){
        Vector info = (Vector) data.get(index);
        String maHD = info.get(0).toString();
        ResultSet rs = cthdBll.getAllDichVuByMaHD(maHD);
        DefaultTableModel model = ((DefaultTableModel)tblDichVuAll.getModel());
        model.setRowCount(0);
            try {
                while(rs.next()){
                    Vector<String> inf = new Vector<String>();
                    inf.add(rs.getString("MaDV"));
                    inf.add(rs.getString("TenDV"));
                    inf.add(rs.getString("MoTaDV"));
                    inf.add(rs.getString("GiaDV"));
                    dataDichVu.add(inf);
                }   
            } catch (SQLException ex) {
                Logger.getLogger(frmChiTietHoaDon.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
       public void loadSPByMaHD(int index){
        Vector info = (Vector) data.get(index);
        String maHD = info.get(0).toString();
        ResultSet rs = cthdBll.getAllSPByMaHD(maHD);
        DefaultTableModel model = ((DefaultTableModel)tblSanPhamALL.getModel());
        model.setRowCount(0);
            try {
                while(rs.next()){
                    Vector<String> inf = new Vector<String>();
                    inf.add(rs.getString("MaSP"));
                    inf.add(rs.getString("TenSP"));
                    inf.add(rs.getString("GiaSP"));
                    inf.add(rs.getString("SoLuongSP"));
                    dataSanPham.add(inf);
                }   
            } catch (SQLException ex) {
                Logger.getLogger(frmChiTietHoaDon.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
        public void loadVoucherByMaHD(int index){
        Vector info = (Vector) data.get(index);
        String maHD = info.get(0).toString();
        ResultSet rs = cthdBll.getAllVoucherByMaHD(maHD);
        DefaultTableModel model = ((DefaultTableModel)tblVoucher.getModel());
        model.setRowCount(0);
            try {
                while(rs.next()){
                    Vector<String> inf = new Vector<String>();
                    inf.add(rs.getString("MaVoucher"));
                    inf.add(rs.getString("TenVoucher"));
                    inf.add(rs.getString("GiamGia"));
                    dataVoucher.add(inf);
                }   
            } catch (SQLException ex) {
                Logger.getLogger(frmChiTietHoaDon.class.getName()).log(Level.SEVERE, null, ex);
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
        tblChiTietHoaDon = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSanPhamALL = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblVoucher = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblDichVuAll = new javax.swing.JTable();

        tblChiTietHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã hóa đơn", "Mã nhân viên", "Mã khách hàng", "Ngày lập", "Thành tiền"
            }
        ));
        tblChiTietHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblChiTietHoaDonMouseClicked(evt);
            }
        });
        tblChiTietHoaDon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblChiTietHoaDonKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblChiTietHoaDon);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Chi tiết hóa đơn");

        tblSanPhamALL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Giá sản phẩm", "Số lượng mua"
            }
        ));
        tblSanPhamALL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamALLMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblSanPhamALL);

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
        jScrollPane3.setViewportView(tblVoucher);

        tblDichVuAll.setModel(new javax.swing.table.DefaultTableModel(
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
        tblDichVuAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDichVuAllMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblDichVuAll);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE)
                            .addComponent(jScrollPane4))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(234, 234, 234)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(79, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblChiTietHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChiTietHoaDonMouseClicked
         loadDichVuByMaHD(((JTable) evt.getSource()).getSelectedRow());
         loadSPByMaHD(((JTable) evt.getSource()).getSelectedRow());
         loadVoucherByMaHD(((JTable) evt.getSource()).getSelectedRow());
    }//GEN-LAST:event_tblChiTietHoaDonMouseClicked

    private void tblChiTietHoaDonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblChiTietHoaDonKeyPressed
        loadDichVuByMaHD(((JTable) evt.getSource()).getSelectedRow());
        loadSPByMaHD(((JTable) evt.getSource()).getSelectedRow());
        loadVoucherByMaHD(((JTable) evt.getSource()).getSelectedRow());
    }//GEN-LAST:event_tblChiTietHoaDonKeyPressed

    private void tblSanPhamALLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamALLMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblSanPhamALLMouseClicked

    private void tblDichVuAllMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDichVuAllMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblDichVuAllMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tblChiTietHoaDon;
    private javax.swing.JTable tblDichVuAll;
    private javax.swing.JTable tblSanPhamALL;
    private javax.swing.JTable tblVoucher;
    // End of variables declaration//GEN-END:variables
}
