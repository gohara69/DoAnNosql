/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;
import java.sql.ResultSet;

/**
 *
 * @author MINH HOANG
 */
public class LienHeDAL {
    private Neo4jConnection _connection;
    
    public LienHeDAL(){
        _connection = new Neo4jConnection();
    }
    
    public ResultSet getAllMaLH(){
        String query = "match (a:LIENHE) return a.MaLH as MALH";
        try{
            return _connection.executeQuery(query);
        } catch(Exception e){
            return null;
        }
    }
    
    public ResultSet getAllLienHeTheoMaNV(String maNV){
        String query = "match (q:KHACHHANG)-[]-(p:LIENHE)-[]-(:NHANVIEN {MaNV: '" + maNV + "'})\n" +
                       "return distinct p.MaLH as MALH, p.ThoiGianLH.year+\"-\"+p.ThoiGianLH.month+\"-\"+p.ThoiGianLH.day as TGLH, p.TinhTrangLH as TinhTrang, q.TenKH as TENKH";
        
        try{
            return _connection.executeQuery(query);
        } catch(Exception e){
            return null;
        }
    }
    
    public ResultSet getSLLienHeTheoMa(String maLH){
        String query = String.format("match (p:LIENHE)\n" +
                                    "where p.MaLH = '%s'\n" +
                                    "return count(p.MaLH) as SL", maLH);
        try{
            return _connection.executeQuery(query);
        } catch(Exception e){
            return null;
        }
    }
    
    public int insertNew(String maLienHe, String ngayLienHe, Boolean tinhTrang, String tenNV, String tenKH){
        String query = String.format("create (p:LIENHE {MaLH: '%s', ThoiGianLH: date('%s'), TinhTrangLH: %s})\n" +
                                    "with p\n" +
                                    "match (q:NHANVIEN {TenNV:'%s'}), (r:KHACHHANG {TenKH: '%s'})\n" +
                                    "create (q)-[:THUCHIEN]->(p), (p)-[:TOI]->(r)"
                                    ,maLienHe, ngayLienHe, tinhTrang.equals(true)? "true" : "false", tenNV, tenKH);
        try{
            return _connection.executeUpdate(query);
        } catch(Exception e){
            return -1;
        }
    }
    
    public int insertGioiThieuToVoucher(String maLienHe, String maVoucher){
        String query = String.format("match (p:LIENHE {MaLH: '%s'}),(q:VOUCHER {MaVoucher: '%s'})\n" +
                                    "create (p)-[:GIOITHIEU]->(q)"
                                    ,maLienHe, maVoucher);
        try{
            return _connection.executeUpdate(query);
        } catch(Exception e){
            return -1;
        }
    }
    
    public int insertGioiThieuToDichVu(String maLienHe, String maDichVu){
        String query = String.format("match (p:LIENHE {MaLH: '%s'}),(q:DICHVU {MaDV: '%s'})\n" +
                                    "create (p)-[:GIOITHIEU]->(q)"
                                    ,maLienHe, maDichVu);
        try{
            return _connection.executeUpdate(query);
        } catch(Exception e){
            return -1;
        }
    }
    
    public int delete(String maLienhe){
        String query = String.format("match (p:LIENHE)\n" +
                                    "where p.MaLH = '%s'\n" +
                                    "detach delete p"
                                    ,maLienhe);
        try{
            return _connection.executeUpdate(query);
        } catch(Exception e){
            return -1;
        }
    }
}
