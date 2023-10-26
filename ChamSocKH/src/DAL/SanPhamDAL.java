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
public class SanPhamDAL {
    private Neo4jConnection _connection;
    
    public SanPhamDAL(){
        _connection = new Neo4jConnection();
    }
    
    // Sang Lam
    public ResultSet getAllTenSanPham(){
        String query = "match (p:SANPHAM) return p.TenSP as TenSP";
        try{
            return _connection.executeQuery(query);
        } catch(Exception e){
            return null;
        }
    }
    
    public ResultSet getAllSanPham(){
        String query = "match (p:SANPHAM) return p.MaSP as MaSP, p.TenSP as TenSP,"
                     + " p.GiaSP as GiaSP";
        try{
            return _connection.executeQuery(query);
        } catch(Exception e){
            return null;
        }
    }
    public ResultSet getAllSanPhamByMaSP(String masp){
        String query = String.format("match (p:SANPHAM)\n" +
                       "where p.MaSP contains '%s'\n" +
                       "return p.MaSP as MaSP, p.TenSP as TenSP, p.GiaSP as GiaSP", masp);
        try{
            return _connection.executeQuery(query);
        } catch(Exception e){
            return null;
        }
    }
    public ResultSet getAllSanPhamTenSP(String tenSP){
        String query = String.format("match (p:SANPHAM)\n" +
                       "where p.TenSP contains '%s'\n" +
                       "return p.MaSP as MaSP, p.TenSP as TenSP, p.GiaSP as GiaSP", tenSP);
        try{
            return _connection.executeQuery(query);
        } catch(Exception e){
            return null;
        }
    }
     public ResultSet getSLSanPhamTheoMa(String masp){
        String query = String.format("match (p:SANPHAM)\n" +
                                    "where p.MaSP = '%s'\n" +
                                    "return count(p.MaSP) as SL", masp);
        try{
            return _connection.executeQuery(query);
        } catch(Exception e){
            return null;
        }
    }
     
     public int insertNew(String masp, String tensp, Long giasp){
        String query = String.format("create (q:SANPHAM {MaSP:'%s', TenSP: '%s', GiaSP: %d})"
                                    ,masp, tensp, giasp);
        try{
            return _connection.executeUpdate(query);
        } catch(Exception e){
            return -1;
        }
    }
    
    public int update(String masp, String tensp, Long giasp){
        String query = String.format("match (p:SANPHAM)\n" +
                                    "where p.MaSP = '%s'\n" +
                                    "set p.TenSP = '%s', p.GiaSP = %d"
                                    ,masp, tensp, giasp);
        try{
            return _connection.executeUpdate(query);
        } catch(Exception e){
            return -1;
        }
    }
    
    public int delete(String masp){
        String query = String.format("match (p:SANPHAM)\n" +
                                    "where p.MaSP = '%s'\n" +
                                    "detach delete p"
                                    ,masp);
        try{
            return _connection.executeUpdate(query);
        } catch(Exception e){
            return -1;
        }
    }
}
