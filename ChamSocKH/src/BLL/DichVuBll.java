/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.DichVuDAL;
import java.sql.ResultSet;

/**
 *
 * @author MINH HOANG
 */
public class DichVuBll {
    private DichVuDAL _dvDAL;
    
    public DichVuBll(){
        _dvDAL = new DichVuDAL();
    }
    
    public ResultSet getAllDichVu(){
        try{
            return _dvDAL.getAllDichVu();
        } catch(Exception e){
            return null;
        }
    }
    
    public ResultSet getAllDichVuByMaDv(String madv){
        try{
            return _dvDAL.getAllDichVuByMaDv(madv);
        } catch(Exception e){
            return null;
        }
    }
    
    public ResultSet getAllDichVuByTenDV(String tendv){
        try{
            return _dvDAL.getAllDichVuByTenDV(tendv);
        } catch(Exception e){
            return null;
        }
    }
    
    public int getSLDichVuTheoMa(String madv){
        try{
            ResultSet kq = _dvDAL.getSLDichVuTheoMa(madv);
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
    
    public int insertNew(String madv, String tendv, Long giadv, String mota){
        try{
            return _dvDAL.insertNew(madv, tendv, giadv, mota);
        } catch(Exception e){
            return -1;
        }
    }
    
    public int update(String madv, String tendv, Long giadv, String mota){
        try{
            return _dvDAL.update(madv, tendv, giadv, mota);
        } catch(Exception e){
            return -1;
        }
    }
    
    public int delete(String madv){
        try{
            return _dvDAL.delete(madv);
        } catch(Exception e){
            return -1;
        }
    }
    
    public ResultSet getAllDichVuByMaLH(String maLH){
        try{
            return _dvDAL.getAllDichVuByMaLH(maLH);
        } catch(Exception e){
            return null;
        }
    }
}
