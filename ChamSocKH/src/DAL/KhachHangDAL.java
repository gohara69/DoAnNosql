/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.KhachHangDTO;
import java.sql.ResultSet;

/**
 *
 * @author PC
 */
public class KhachHangDAL {
    private Neo4jConnection _connection;
    
    public KhachHangDAL(){
        _connection = new Neo4jConnection();
    }
    
    public ResultSet getAllTenKhachHang_TheoTenSPMua(String tenSP){
        String query = "match (k:KHACHHANG) - [:MUA] -> (h:HOADON) -[:CO] -> "
                + "(s:SANPHAM{TenSP: '"+tenSP+"'}) return k.MaKH as MaKH";
        try{
            return _connection.executeQuery(query);
        } catch(Exception e){
            return null;
        }
    }
    
    public ResultSet getAllKhachHang(){
        String query = "match (p:KHACHHANG) return p.MaKH as MaKH, p.TenKH as TenKH,"
                     + " p.SDTKH as SoDienThoaiKH, p.DiaChiKH as DiaChiKH";
        try{
            return _connection.executeQuery(query);
        } catch(Exception e){
            return null;
        }
    }
    
    public ResultSet getAllKhachHangByMaKh(String makh){
        String query = String.format("match (p:KHACHHANG)" 
                     +  "where p.MaKH contains '%s'" 
                     +  "return p.MaKH as MaKH, p.TenKH as TenKH,"
                     + " p.SDTKH as SoDienThoaiKH, p.DiaChiKH as DiaChiKH", makh);
        try{
            return _connection.executeQuery(query);
        } catch(Exception e){
            return null;
        }
    }
    
    public ResultSet getAllKhachHangByTenKh(String tenkh){
        String query = String.format("match (p:KHACHHANG) " 
                    + "where p.TenKH contains '%s'" 
                    + "return p.MaKH as MaKH, p.TenKH as TenKH, "
                    + "p.SDTKH as SoDienThoaiKH, p.DiaChiKH as DiaChiKH", tenkh);
        try{
            return _connection.executeQuery(query);
        } catch(Exception e){
            return null;
        }
    }
    
    public ResultSet getSLKhachHangTheoMa(String makh){
        String query = String.format("match (p:KHACHHANG)\n" +
                                    "where p.MaKH = '%s'\n" +
                                    "return count(p.MaKH) as SL", makh);
        try{
            return _connection.executeQuery(query);
        } catch(Exception e){
            return null;
        }
    }
    
    public int insertNew(KhachHangDTO kh){
        String query = String.format("create (q:KHACHHANG {MaKH:'%s', TenKH: '%s', SDTKH: '%s', "
                                    + "DiaChiKH: '%s'})"
                                    ,kh.getMaKH(), kh.getTenKH(), kh.getSdtKH(), kh.getDiaChiKH());
        try{
            return _connection.executeUpdate(query);
        } catch(Exception e){
            return -1;
        }
    }
    
    public int update(KhachHangDTO kh){
        String query = String.format("match (p:KHACHHANG {MaKH: '%s'})  "
                                    + "set p.TenKH = '%s', p.SDTKH = '%s', p.DiaChiKH = '%s'"
                                    ,kh.getMaKH(), kh.getTenKH(), kh.getSdtKH(), kh.getDiaChiKH());
        try{
            return _connection.executeUpdate(query);
        } catch(Exception e){
            return -1;
        }
    }
    
    public int delete(String makh){
        String query = String.format("match (p:KHACHHANG)" 
                                    + "where p.MaKH = '%s'" 
                                    + "detach delete p"
                                    ,makh);
        try{
            return _connection.executeUpdate(query);
        } catch(Exception e){
            return -1;
        }
    }
}
