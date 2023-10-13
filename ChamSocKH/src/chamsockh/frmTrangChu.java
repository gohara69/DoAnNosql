/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package chamsockh;

import chamsockh.DichVu.frmDichVu;
import chamsockh.DichVu.frmSuaDichVu;
import chamsockh.DichVu.frmThemDichVu;
import chamsockh.Voucher.frmVoucher;

/**
 *
 * @author MINH HOANG
 */
public class frmTrangChu extends javax.swing.JFrame {

    /**
     * Creates new form frmTrangChu
     */
    public frmTrangChu() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        desktop = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        mnuDichVu = new javax.swing.JMenu();
        mnuAllDichVu = new javax.swing.JMenuItem();
        mnuThemDichVu = new javax.swing.JMenuItem();
        mnuSuaDichVu = new javax.swing.JMenuItem();
        mnuVoucher = new javax.swing.JMenu();
        mnuHienThiVoucher = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jMenu2.setText("File");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Edit");
        jMenuBar1.add(jMenu3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 826, Short.MAX_VALUE)
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
        );

        getContentPane().add(desktop, java.awt.BorderLayout.CENTER);

        mnuDichVu.setText("Dịch vụ");

        mnuAllDichVu.setText("Hiển thị dịch vụ");
        mnuAllDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAllDichVuActionPerformed(evt);
            }
        });
        mnuDichVu.add(mnuAllDichVu);

        mnuThemDichVu.setText("Thêm dịch vụ");
        mnuThemDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuThemDichVuActionPerformed(evt);
            }
        });
        mnuDichVu.add(mnuThemDichVu);

        mnuSuaDichVu.setText("Sửa dịch vu");
        mnuSuaDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSuaDichVuActionPerformed(evt);
            }
        });
        mnuDichVu.add(mnuSuaDichVu);

        menuBar.add(mnuDichVu);

        mnuVoucher.setText("Voucher");

        mnuHienThiVoucher.setText("Hiển thị voucher");
        mnuHienThiVoucher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuHienThiVoucherActionPerformed(evt);
            }
        });
        mnuVoucher.add(mnuHienThiVoucher);

        menuBar.add(mnuVoucher);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuAllDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAllDichVuActionPerformed
        frmDichVu frm = new frmDichVu();
        frm.setSize(790, 550);
        this.desktop.add(frm);
        frm.toFront();
        frm.show();
    }//GEN-LAST:event_mnuAllDichVuActionPerformed

    private void mnuThemDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuThemDichVuActionPerformed
        frmThemDichVu frm = new frmThemDichVu();
        frm.setSize(790, 550);
        this.desktop.add(frm);
        frm.toFront();
        frm.show();
    }//GEN-LAST:event_mnuThemDichVuActionPerformed

    private void mnuSuaDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSuaDichVuActionPerformed
        frmSuaDichVu frm = new frmSuaDichVu();
        frm.setSize(790, 550);
        this.desktop.add(frm);
        frm.toFront();
        frm.show();
    }//GEN-LAST:event_mnuSuaDichVuActionPerformed

    private void mnuHienThiVoucherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuHienThiVoucherActionPerformed
        frmVoucher frm = new frmVoucher();
        frm.setSize(790, 550);
        this.desktop.add(frm);
        frm.toFront();
        frm.show();
    }//GEN-LAST:event_mnuHienThiVoucherActionPerformed

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
            java.util.logging.Logger.getLogger(frmTrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmTrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmTrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmTrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmTrangChu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem mnuAllDichVu;
    private javax.swing.JMenu mnuDichVu;
    private javax.swing.JMenuItem mnuHienThiVoucher;
    private javax.swing.JMenuItem mnuSuaDichVu;
    private javax.swing.JMenuItem mnuThemDichVu;
    private javax.swing.JMenu mnuVoucher;
    // End of variables declaration//GEN-END:variables
}
