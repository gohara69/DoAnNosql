/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.LienHeDAL;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author MINH HOANG
 */
public class LienHeBLL {
    private LienHeDAL _dal;
    
    public LienHeBLL(){
        _dal = new LienHeDAL();
    }
    
    public ArrayList<String> getAllMaLH(){
        ResultSet kq = null;
        try{
            kq =  _dal.getAllMaLH();
            if(kq != null){
                ArrayList<String> result = new ArrayList<>();
                while(kq.next()){
                    result.add(kq.getString("MALH"));
                }
                return result;
            }
        } catch(Exception e){
            return null;
        }
        return null;
    }
    
    public ResultSet getAllLienHeTheoMaNV(String maNV){
        try{
            return _dal.getAllLienHeTheoMaNV(maNV);
        } catch(Exception e){
            return null;
        }
    }
    
    public int getSLLienHeTheoMa(String maLH){
        try{
            ResultSet kq = _dal.getSLLienHeTheoMa(maLH);
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
    
    public int insertNew(String maLienHe, String ngayLienHe, Boolean tinhTrang, String tenNV, String tenKH){
        try{
            return _dal.insertNew(maLienHe, ngayLienHe, tinhTrang, tenNV, tenKH);
        } catch(Exception e){
            return -1;
        }
    }
    
    public int insertGioiThieuToVoucher(String maLienHe, String maVoucher){
        try{
            return _dal.insertGioiThieuToVoucher(maLienHe, maVoucher);
        } catch(Exception e){
            return -1;
        }
    }
    
    public int insertGioiThieuToDichVu(String maLienHe, String maDichVu){
        try{
            return _dal.insertGioiThieuToDichVu(maLienHe, maDichVu);
        } catch(Exception e){
            return -1;
        }
    }
    
    public int delete(String maLienhe){
        try{
            return _dal.delete(maLienhe);
        } catch(Exception e){
            return -1;
        }
    }
}
