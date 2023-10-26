/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;
import DAL.ChiTietHDDAL;
import java.sql.ResultSet;
/**
 *
 * @author ASUS
 */
public class ChiTienHDBLL {
    private ChiTietHDDAL _cthdDAL;
    
    public ChiTienHDBLL(){
        _cthdDAL = new ChiTietHDDAL();
    }
    
    public ResultSet getAllCTHoaDon(){
        try{
            return _cthdDAL.getAllCTHoaDon();
        } catch(Exception e){
            return null;
        }
    }
    public ResultSet getAllSPByMaHD(String mahd){
        try{
            return _cthdDAL.getAllSPByMaHD(mahd);
        } catch(Exception e){
            return null;
        }
    }
    public ResultSet getAllVoucherByMaHD(String mahd){
        try{
            return _cthdDAL.getAllVoucherByMaHD(mahd);
        } catch(Exception e){
            return null;
        }
    }
    public ResultSet getAllDichVuByMaHD(String mahd){
        try{
            return _cthdDAL.getAllDihVuByMaHD(mahd);
        } catch(Exception e){
            return null;
        }
    }
}
