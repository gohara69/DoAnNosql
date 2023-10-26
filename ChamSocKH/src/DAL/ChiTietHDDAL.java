/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author ASUS
 */
public class ChiTietHDDAL {
     private Neo4jConnection _connection;
    
    public ChiTietHDDAL(){
        _connection = new Neo4jConnection();
    }
    public ResultSet getAllCTHoaDon(){
        String query = "match (k:KHACHHANG)-[:MUA]->(h:HOADON)-[:LAP]-(nv:NHANVIEN)"
                + "return h.MaHD as MaHD,nv.MaNV as MaNV,k.MaKH as MaKH,"
                + "h.NgayLapHD as NgayLapHD,h.ThanhTienHD as ThanhTienHD";
        try{
            return _connection.executeQuery(query);
        } catch(Exception e){
            return null;
        }
    }
    public ResultSet getAllSPByMaHD(String mahd){
        String query = String.format("match (p:HOADON)-[r:CO]->(d:SANPHAM)\n" +
                       "where p.MaHD = '%s'\n" +
                       "return d.MaSP as MaSP, d.TenSP as TenSP,d.GiaSP as GiaSP,r.SoLuongSP as SoLuongSP", mahd);
        try{
            return _connection.executeQuery(query);
        } catch(Exception e){
            return null;
        }
    }
    public ResultSet getAllVoucherByMaHD(String mahd){
        String query = String.format("match (p:HOADON)-[:APDUNG]->(d:VOUCHER)\n" +
                       "where p.MaHD = '%s'\n" +
                       "return d.MaVoucher as MaVoucher, d.TenVoucher as TenVoucher,d.GiamGia as GiamGia", mahd);
        try{
            return _connection.executeQuery(query);
        } catch(Exception e){
            return null;
        }
    }
      public ResultSet getAllDihVuByMaHD(String mahd){
        String query = String.format("match (p:HOADON)-[:CO]->(d:DICHVU)\n" +
                       "where p.MaHD = '%s'\n" +
                       "return d.MaDV as MaDV, d.TenDV as TenDV,d.MoTaDV as MoTaDV,d.GiaDV as GiaDV", mahd);
        try{
            return _connection.executeQuery(query);
        } catch(Exception e){
            return null;
        }
    }
    
}
