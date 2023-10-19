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
}
