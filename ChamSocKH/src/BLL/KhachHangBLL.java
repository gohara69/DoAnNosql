/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.KhachHangDAL;
import DTO.KhachHangDTO;
import java.sql.ResultSet;

/**
 *
 * @author PC
 */
public class KhachHangBLL {
    private KhachHangDAL _khDAL;
    
    public KhachHangBLL(){
        _khDAL = new KhachHangDAL();
    }
    
    public ResultSet getAllTenKhachHang_TheoTenSPMua(String tenSP){
        try{
            return _khDAL.getAllTenKhachHang_TheoTenSPMua(tenSP);
        } catch(Exception e){
            return null;
        }
    }
    
    public ResultSet getAllKhachHang(){
        try{
            return _khDAL.getAllKhachHang();
        } catch(Exception e){
            return null;
        }
    }
    
    public ResultSet getAllKhachHangByMaKH(String makh){
        try{
            return _khDAL.getAllKhachHangByMaKh(makh);
        } catch(Exception e){
            return null;
        }
    }
    
    public ResultSet getAllKhachHangByTenKH(String tenkh){
        try{
            return _khDAL.getAllKhachHangByTenKh(tenkh);
        } catch(Exception e){
            return null;
        }
    }
    
    public int getSLKhachHangTheoMa(String makh){
        try{
            ResultSet kq = _khDAL.getSLKhachHangTheoMa(makh);
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
    
    public int insertNew(KhachHangDTO kh){
        try{
            return _khDAL.insertNew(kh);
        } catch(Exception e){
            return -1;
        }
    }
    
    public int update(KhachHangDTO kh){
        try{
            return _khDAL.update(kh);
        } catch(Exception e){
            return -1;
        }
    }
    
    public int delete(String makh){
        try{
            return _khDAL.delete(makh);
        } catch(Exception e){
            return -1;
        }
    }
}
