/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author MINH HOANG
 */
public class DichVuDAL {
    private Neo4jConnection _connection;
    
    public DichVuDAL(){
        _connection = new Neo4jConnection();
    }
    
    public ResultSet getAllDichVu(){
        String query = "match (p:DICHVU) return p.MaDV as MaDV, p.TenDV as TenDV,"
                     + " p.GiaDV as GiaDV, p.MoTaDV as MoTaDV";
        try{
            return _connection.executeQuery(query);
        } catch(Exception e){
            return null;
        }
    }
    
    public ResultSet getAllDichVuByMaDv(String madv){
        String query = String.format("match (p:DICHVU)\n" +
                       "where p.MaDV contains '%s'\n" +
                       "match (q:LIENHE)-[:GIOITHIEU]->(p)\n" +
                       "return p.MaDV as MaDV, p.TenDV as TenDV, p.GiaDV as GiaDV, p.MoTaDV as MoTaDV, q.MaLH as MaLH", madv);
        try{
            return _connection.executeQuery(query);
        } catch(Exception e){
            return null;
        }
    }
    
    public ResultSet getAllDichVuByTenDV(String tendv){
        String query = String.format("match (p:DICHVU)\n" +
                       "where p.TenDV contains '%s'\n" +
                       "return p.MaDV as MaDV, p.TenDV as TenDV, p.GiaDV as GiaDV, p.MoTaDV as MoTaDV", tendv);
        try{
            return _connection.executeQuery(query);
        } catch(Exception e){
            return null;
        }
    }
    
    public ResultSet getSLDichVuTheoMa(String madv){
        String query = String.format("match (p:DICHVU)\n" +
                                    "where p.MaDV = '%s'\n" +
                                    "return count(p.MaDV) as SL", madv);
        try{
            return _connection.executeQuery(query);
        } catch(Exception e){
            return null;
        }
    }
    
    public int insertNew(String madv, String tendv, Long giadv, String mota){
        String query = String.format("create (q:DICHVU {MaDV:'%s', TenDV: '%s', GiaDV: %d, MoTaDV: '%s'})"
                                    ,madv, tendv, giadv, mota);
        try{
            return _connection.executeUpdate(query);
        } catch(Exception e){
            return -1;
        }
    }
    
    public int update(String madv, String tendv, Long giadv, String mota){
        String query = String.format("match (p:DICHVU)\n" +
                                    "where p.MaDV = '%s'\n" +
                                    "set p.TenDV = '%s', p.GiaDV = %d, p.MoTaDV = '%s'"
                                    ,madv, tendv, giadv, mota);
        try{
            return _connection.executeUpdate(query);
        } catch(Exception e){
            return -1;
        }
    }
    
    public int delete(String madv){
        String query = String.format("match (p:DICHVU)\n" +
                                    "where p.MaDV = '%s'\n" +
                                    "detach delete p"
                                    ,madv);
        try{
            return _connection.executeUpdate(query);
        } catch(Exception e){
            return -1;
        }
    }
    
    public ResultSet getAllDichVuByMaLH(String maLH){
        String query = String.format("match (p:DICHVU)-[]-(:LIENHE {MaLH: '" + maLH + "'})" +
                       "return p.MaDV as MaDV, p.TenDV as TenDV, p.GiaDV as GiaDV, p.MoTaDV as MoTaDV");
        try{
            return _connection.executeQuery(query);
        } catch(Exception e){
            return null;
        }
    }
}
