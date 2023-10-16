/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.ResultSet;

/**
 *
 * @author MINH HOANG
 */
public class VoucherDAL {
    public Neo4jConnection _connection;

    public VoucherDAL() {
        _connection = new Neo4jConnection();
    }
    
    public ResultSet getAllVoucher(){
        String query = "match (p:VOUCHER) return p.MaVoucher as MV, p.TenVoucher as TenV, p.GiamGia as GiamGia";
        try{
            return _connection.executeQuery(query);
        } catch(Exception e){
            return null;
        }
    }
    
    public ResultSet getAllVoucherByMaVoucher(String maVoucher){
        String query = String.format("match (p:VOUCHER) " +
                                    "where p.MaVoucher contains '%s' " +
                                    "return p.MaVoucher as MaVoc, p.TenVoucher as TenVoc, p.GiamGia as GiamGia", maVoucher);
        try{
            return _connection.executeQuery(query);
        } catch(Exception e){
            return null;
        }
    }
    
    public ResultSet getAllVoucherByTenVoucher(String tenVoucher){
        String query = String.format("match (p:VOUCHER) " +
                       "where p.TenVoucher contains '%s' " +
                       "return p.MaVoucher as MaVoc, p.TenVoucher as TenVoc, p.GiamGia as GiamGia", tenVoucher);
        try{
            return _connection.executeQuery(query);
        } catch(Exception e){
            return null;
        }
    }
    
    public ResultSet getSLVoucherTheoMa(String maVoucher){
        String query = String.format("match (p:VOUCHER)\n" +
                                    "where p.MaVoucher = '%s'\n" +
                                    "return count(p.MaVoucher) as SL", maVoucher);
        try{
            return _connection.executeQuery(query);
        } catch(Exception e){
            return null;
        }
    }
    
    public int insertNew(String maVoucher, String tenVoucher, Double giamGia){
        String query = String.format("create (q:VOUCHER {MaVoucher:'%s', TenVoucher: '%s', GiamGia: %f})"
                                    ,maVoucher, tenVoucher, giamGia);
        try{
            return _connection.executeUpdate(query);
        } catch(Exception e){
            return -1;
        }
    }
    
    public int delete(String maVoucher){
        String query = String.format("match (p:VOUCHER)\n" +
                                    "where p.MaVoucher = '%s'\n" +
                                    "detach delete p"
                                    ,maVoucher);
        try{
            return _connection.executeUpdate(query);
        } catch(Exception e){
            return -1;
        }
    }
    
    public int update(String maVoucher, String tenVoucher, Double giamGia){
        String query = String.format("match (p:VOUCHER)\n" +
                                    "where p.MaVoucher = '%s'\n" +
                                    "set p.TenVoucher = '%s', p.GiamGia = %f"
                                    ,maVoucher, tenVoucher, giamGia);
        try{
            return _connection.executeUpdate(query);
        } catch(Exception e){
            return -1;
        }
    }
}
