/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;
import DAL.HoaDonDAL;
import java.sql.ResultSet;
/**
 *
 * @author ASUS
 */
public class HoaDonBLL {
    private HoaDonDAL _hdDAL;
    
    public HoaDonBLL(){
        _hdDAL = new HoaDonDAL();
    }
    
    public ResultSet getAllHoaDon(){
        try{
            return _hdDAL.getAllHoaDon();
        } catch(Exception e){
            return null;
        }
    }
     public ResultSet getAllHoaDonByMa(String mahd){
        try{
            return _hdDAL.getAllHoaDonByMa(mahd);
        } catch(Exception e){
            return null;
        }
    }
}
