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
public class LienHeDAL {
    private Neo4jConnection _connection;
    
    public LienHeDAL(){
        _connection = new Neo4jConnection();
    }
    
    public ResultSet getAllMaLH(){
        String query = "match (a:LIENHE) return a.MaLH as MALH";
        try{
            return _connection.executeQuery(query);
        } catch(Exception e){
            return null;
        }
    }
}
