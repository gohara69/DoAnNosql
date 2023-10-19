/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.KhieuNaiDAL;
import DTO.KhieuNaiDTO;
import java.sql.ResultSet;

/**
 *
 * @author PC
 */
public class KhieuNaiBLL {
    private KhieuNaiDAL _knDAL;
    
    public KhieuNaiBLL(){
        _knDAL = new KhieuNaiDAL();
    }
    
    public ResultSet getAllKhieuNai(){
        try{
            return _knDAL.getAllKhieuNai();
        } catch(Exception e){
            return null;
        }
    }
    
    public int insertNew(KhieuNaiDTO kn){
        try{
            return _knDAL.insertNew(kn);
        } catch(Exception e){
            return -1;
        }
    }
    
    public void taoQuanHe_KH_KN(String maKH, String maKN){
        _knDAL.taoQuanHe_KH_KN(maKH, maKN);
    }
    
    public void taoQuanHe_SP_KN(String tenSP, String maKN){
        _knDAL.taoQuanHe_SP_KN(tenSP, maKN);
    }
    
    public void taoQuanHe_KN_SP(String maKN, String tenSP){
        _knDAL.taoQuanHe_KN_SP(maKN, tenSP);
    }
}
