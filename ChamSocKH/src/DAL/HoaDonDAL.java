/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class HoaDonDAL {
     private Neo4jConnection _connection;
    
    public HoaDonDAL(){
        _connection = new Neo4jConnection();
    }
    
     public ResultSet getAllHoaDon(){
        String query = "match (p:HOADON) return p.MaHD as MaHD, p.NgayLapHD as NgayLapHD,"
                     + " p.ThanhTienHD as ThanhTienHD";
        try{
            return _connection.executeQuery(query);
        } catch(Exception e){
            return null;
        }
    }
     public ResultSet getAllHoaDonByMa(String mahd){
        String query = String.format("match (p:HOADON) where p.MaHD = '%s' "
                     + "return p.MaHD as MaHD, p.NgayLapHD as NgayLapHD,"
                     + " p.ThanhTienHD as ThanhTienHD",mahd);
        try{
            return _connection.executeQuery(query);
        } catch(Exception e){
            return null;
        }
    }
}
