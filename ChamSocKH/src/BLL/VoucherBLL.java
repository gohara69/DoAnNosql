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
}
