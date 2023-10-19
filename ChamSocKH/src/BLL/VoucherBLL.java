/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.VoucherDAL;
import java.sql.ResultSet;

/**
 *
 * @author MINH HOANG
 */
public class VoucherBLL {
    private VoucherDAL _dal;
    
    public VoucherBLL(){
        _dal = new VoucherDAL();
    }
    
     public ResultSet getAllVoucher(){
        try{
            return _dal.getAllVoucher();
        } catch(Exception e){
            return null;
        }
    }
     
    public ResultSet getAllVoucherByMaVoucher(String maVoucher){
        try{
            return _dal.getAllVoucherByMaVoucher(maVoucher);
        } catch(Exception e){
            return null;
        }
    }
    
    public ResultSet getAllVoucherByTenVoucher(String tenVoucher){
        try{
            return _dal.getAllVoucherByTenVoucher(tenVoucher);
        } catch(Exception e){
            return null;
        }
    }
    
    public int getSLVoucherTheoMa(String maVoucher){
        try{
            ResultSet kq = _dal.getSLVoucherTheoMa(maVoucher);
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
    
    public int insertNew(String maVoucher, String tenVoucher, Double giamGia){
        try{
            return _dal.insertNew(maVoucher, tenVoucher, giamGia);
        } catch(Exception e){
            return -1;
        }
    }
    
    public int delete(String madv){
        try{
            return _dal.delete(madv);
        } catch(Exception e){
            return -1;
        }
    }
    
    public int update(String maVoucher, String tenVoucher, Double giamGia){
        try{
            return _dal.update(maVoucher, tenVoucher, giamGia);
        } catch(Exception e){
            return -1;
        }
    }
    
    public ResultSet getAllVoucherByMaLH(String maLH){
        try{
            return _dal.getAllVoucherByMaLH(maLH);
        } catch(Exception e){
            return null;
        }
    }
}
