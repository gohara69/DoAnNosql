/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;


import java.sql.ResultSet;
import DAL.SanPhamDAL;

/**
 *
 * @author ASUS
 */
public class SanPhamBLL {
    private SanPhamDAL _spDAL;
    
    public SanPhamBLL(){
        _spDAL = new SanPhamDAL();
    }
    
    // Sang lam
    public ResultSet getAllTenSanPham(){
        try{
            return _spDAL.getAllTenSanPham();
        } catch(Exception e){
            return null;
        }
    }
    
    public ResultSet getAllSanPham(){
        try{
            return _spDAL.getAllSanPham();
        } catch(Exception e){
            return null;
        }
    }
    public ResultSet getAllDSanPhamByMaSP(String masp){
        try{
            return _spDAL.getAllSanPhamByMaSP(masp);
        } catch(Exception e){
            return null;
        }
    }
    public ResultSet getAllSanPhamByTenSP(String tensp){
        try{
            return _spDAL.getAllSanPhamTenSP(tensp);
        } catch(Exception e){
            return null;
        }
    }
    public int getSLSanPhamTheoMa(String masp){
        try{
            ResultSet kq = _spDAL.getSLSanPhamTheoMa(masp);
            if(kq != null){
                while(kq.next()){
                    String sl = kq.getString("SL");
                    return Integer.parseInt(sl);
                }
            }
        } catch(Exception e){
            return -1;
        }
        return 0;
    }
    public int insertNew(String masp, String tensp, Long giasp){
        try{
            return _spDAL.insertNew(masp, tensp, giasp);
        } catch(Exception e){
            return -1;
        }
    }
    
    public int update(String masp, String tensp, Long giasp){
        try{
            return _spDAL.update(masp, tensp, giasp);
        } catch(Exception e){
            return -1;
        }
    }
    
    public int delete(String masp){
        try{
            return _spDAL.delete(masp);
        } catch(Exception e){
            return -1;
        }
    }
}
