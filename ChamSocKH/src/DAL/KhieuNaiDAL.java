/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.KhieuNaiDTO;
import chamsockh.KhieuNai.frmThucHienKhieuNai;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class KhieuNaiDAL {
    private Neo4jConnection _connection;
    
    public KhieuNaiDAL(){
        _connection = new Neo4jConnection();
    }
    
    public ResultSet getAllKhieuNai(){
        String query = "match (p:THONGTINKHIEUNAI) return p.MaKN as MaKN, p.NgayKN as NgayKN,"
                     + " p.NoiDungKN as NoiDungKN";
        try{
            return _connection.executeQuery(query);
        } catch(Exception e){
            return null;
        }
    }
    
    // Lấy mã khiếu nại cuối trong csdl
    public String get_MaKNCuoi(){
        String query = "match (K:THONGTINKHIEUNAI) return K.MaKN as MaKN order by K.MaKN desc limit 1";
        try{
            ResultSet rs = _connection.executeQuery(query);
            rs.next();
            return rs.getString("MaKN");
        } catch(Exception e){
            return null;
        }
    }
    // Sinh mã khiếu nại tự động
    public String auto_SinhMaKN(){
        String maKN_Cuoi = get_MaKNCuoi();
        String maSoCuoi = maKN_Cuoi.substring(maKN_Cuoi.length() - 3, maKN_Cuoi.length());
        int soMaKN = Integer.parseInt(maSoCuoi);
        return maKN_Cuoi.substring(0, maKN_Cuoi.length() - 3) + ++soMaKN;
    }
    
    public int insertNew(KhieuNaiDTO kn){
        String query = String.format("create (q:THONGTINKHIEUNAI {MaKN:'%s', NgayKN: date('%s'), NoiDungKN: '%s'})"
                                    ,auto_SinhMaKN(), kn.getNgayKN(), kn.getNoiDungKN());
        try{
            return _connection.executeUpdate(query);
        } catch(Exception e){
            return -1;
        }
    }
    
    public void taoQuanHe_KH_KN(String maKH, String maKN){
        String query = String.format("match (a: KHACHHANG {MaKH: '%s'}), (b: THONGTINKHIEUNAI{MaKN: '%s'}) "
                + "CREATE (a)-[r:KHIEUNAI]->(b)"
                                    ,maKH, maKN);
        try{
            _connection.executeUpdate(query);
        } catch(Exception e){
            Logger.getLogger(frmThucHienKhieuNai.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public void taoQuanHe_SP_KN(String tenSP, String maKN){
        String query = String.format("match (a: SANPHAM {TenSP: '%s'}), (b: THONGTINKHIEUNAI{MaKN: '%s'}) "
                + "CREATE (a)-[r:CO]->(b) return a, b"
                                    ,tenSP, maKN);
        try{
            _connection.executeUpdate(query);
        } catch(Exception e){
            Logger.getLogger(frmThucHienKhieuNai.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public void taoQuanHe_KN_SP(String maKN, String tenSP){
        String query = String.format("match (a: THONGTINKHIEUNAI {MaKN: '%s'}), (b: SANPHAM{TenSP: '%s'}) "
                + "CREATE (a)-[r:CUA]->(b)"
                                    , maKN, tenSP);
        try{
            _connection.executeUpdate(query);
        } catch(Exception e){
            Logger.getLogger(frmThucHienKhieuNai.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
