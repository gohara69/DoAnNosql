/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.ResultSet;
import DTO.NhanVienDTO;

/**
 *
 * @author PC
 */
public class NhanVienDAL {
    private Neo4jConnection _connection;
    
    public NhanVienDAL(){
        _connection = new Neo4jConnection();
    }
    
    public ResultSet getAllNhanVien(){
        String query = "match (p:NHANVIEN) return distinct p.MaNV as MaNV, p.TenNV as TenNV,"
                     + " p.NgaySinhNV as NgaySinhNV, p.GioiTinhNV as GioiTinhNV, p.DiaChiNV as DiaChiNV, p.ViTriCongViec as ViTriCongViec";
        try{
            return _connection.executeQuery(query);
        } catch(Exception e){
            return null;
        }
    }
    
    public ResultSet getAllNhanVienByMaNv(String manv){
        String query = String.format("match (p:NHANVIEN)\n" +
                       "where p.MaNV contains '%s'\n" +
                       "return p.MaNV as MaNV, p.TenNV as TenNV, p.NgaySinhNV as NgaySinhNV, "
                    + "p.GioiTinhNV as GioiTinhNV, p.DiaChiNV as DiaChiNV, p.ViTriCongViec as ViTriCongViec", manv);
        try{
            return _connection.executeQuery(query);
        } catch(Exception e){
            return null;
        }
    }
    
    public ResultSet getAllNhanVienByTenNV(String tennv){
        String query = String.format("match (p:NHANVIEN)\n" +
                       "where p.TenNV contains '%s'\n" 
                    + "return p.MaNV as MaNV, p.TenNV as TenNV, p.NgaySinhNV as NgaySinhNV, "
                    + "p.GioiTinhNV as GioiTinhNV, p.DiaChiNV as DiaChiNV, p.ViTriCongViec as ViTriCongViec", tennv);
        try{
            return _connection.executeQuery(query);
        } catch(Exception e){
            return null;
        }
    }
    
    public ResultSet getSLNhanVienTheoMa(String manv){
        String query = String.format("match (p:NHANVIEN)\n" +
                                    "where p.MaNV = '%s'\n" +
                                    "return count(p.MaNV) as SL", manv);
        try{
            return _connection.executeQuery(query);
        } catch(Exception e){
            return null;
        }
    }
    
    public int insertNew(NhanVienDTO nv){
        String query = String.format("create (q:NHANVIEN {MaNV:'%s', TenNV: '%s', NgaySinhNV: date('%s'), "
                                    + "GioiTinhNV: '%s', DiaChiNV: '%s', ViTriCongViec: '%s'})"
                                    ,nv.getMaNV(), nv.getTenNV(), nv.getNgaySinh(), 
                                    nv.getGioiTinh(), nv.getDiaChi(), nv.getViTriCongViec());
        try{
            return _connection.executeUpdate(query);
        } catch(Exception e){
            return -1;
        }
    }
    
    public int update(NhanVienDTO nv){
        String query = String.format("match (p:NHANVIEN {MaNV: '%s'})  "
                                    + "set p.TenNV = '%s', p.NgaySinhNV = date('%s'), p.GioiTinhNV = '%s', "
                                    + "p.DiaChiNV = '%s', p.ViTriCongViec = '%s'"
                                    ,nv.getMaNV(), nv.getTenNV(), nv.getNgaySinh(), 
                                    nv.getGioiTinh(), nv.getDiaChi(), nv.getViTriCongViec());
        try{
            return _connection.executeUpdate(query);
        } catch(Exception e){
            return -1;
        }
    }
    
    public int delete(String manv){
        String query = String.format("match (p:NHANVIEN)" 
                                    + "where p.MaNV = '%s'" 
                                    + "detach delete p"
                                    ,manv);
        try{
            return _connection.executeUpdate(query);
        } catch(Exception e){
            return -1;
        }
    }
}
