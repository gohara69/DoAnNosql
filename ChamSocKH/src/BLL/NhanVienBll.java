/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.NhanVienDAL;
import DTO.NhanVienDTO;
import java.sql.ResultSet;

/**
 *
 * @author PC
 */
public class NhanVienBll {
    private NhanVienDAL _nvDAL;
    
    public NhanVienBll(){
        _nvDAL = new NhanVienDAL();
    }
    
    public ResultSet getAllNhanVien(){
        try{
            return _nvDAL.getAllNhanVien();
        } catch(Exception e){
            return null;
        }
    }
    
    public ResultSet getAllNhanVienByMaNv(String manv){
        try{
            return _nvDAL.getAllNhanVienByMaNv(manv);
        } catch(Exception e){
            return null;
        }
    }
    
    public ResultSet getAllNhanVienByTenNV(String tennv){
        try{
            return _nvDAL.getAllNhanVienByTenNV(tennv);
        } catch(Exception e){
            return null;
        }
    }
    
    public int getSLNhanVienTheoMa(String manv){
        try{
            ResultSet kq = _nvDAL.getSLNhanVienTheoMa(manv);
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
    
    public int insertNew(NhanVienDTO nv){
        try{
            return _nvDAL.insertNew(nv);
        } catch(Exception e){
            return -1;
        }
    }
    
    public int update(NhanVienDTO nv){
        try{
            return _nvDAL.update(nv);
        } catch(Exception e){
            return -1;
        }
    }
    
    public int delete(String manv){
        try{
            return _nvDAL.delete(manv);
        } catch(Exception e){
            return -1;
        }
    }
}
