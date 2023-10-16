/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 *
 * @author MINH HOANG
 */
public class Neo4jConnection {
    private Connection _connection;
    
    public Neo4jConnection(){
        try {
            _connection = DriverManager.getConnection("jdbc:neo4j:bolt://localhost:7687/", "neo4j", "123456789");
        } catch (SQLException ex) {
            Logger.getLogger(Neo4jConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSet executeQuery(String query){
        ResultSet kq = null;
        try {
            Statement st = _connection.createStatement();
            kq = st.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(Neo4jConnection.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return kq;
    }
    
    public int executeUpdate(String query){
        int n = -1;
        try {
            Statement st = _connection.createStatement();
            n = st.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Neo4jConnection.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return n;
    }
}
