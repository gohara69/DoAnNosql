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
}
