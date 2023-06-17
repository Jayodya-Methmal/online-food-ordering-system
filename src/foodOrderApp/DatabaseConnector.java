package foodOrderApp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jayo
 */
public class DatabaseConnector {
    String url = "jdbc:derby://localhost:1527/";
    String dbName = "Users";
    String userName = "root"; 
    String password = "root";
    
    Connection conn = null;
    
    public Connection dbConnect(){
        try {
            conn = DriverManager.getConnection(url+dbName,userName,password);
            return conn;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
       
    }
}
