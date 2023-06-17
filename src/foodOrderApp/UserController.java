package foodOrderApp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jayo
 */

 
public class UserController {
    
    
    
    
     Connection conn = null;
     PreparedStatement prestmnt = null;
     PreparedStatement prestmnt2 = null;
     PreparedStatement prestmnt3 = null;
     PreparedStatement prestmnt4 = null;
     
     ResultSet Reltset = null;
     ResultSet Reltset2 = null;
     DatabaseConnector connect = new DatabaseConnector();//DB connector object
     
     
     
    public void checkUser(String un, String pw){//parsed from UI
        
         Customer u = new Customer (un, pw);//create User Object
    
         try {
             conn = connect.dbConnect();//start here -- later add exceptions
             String sql = "SELECT * FROM Users WHERE username= '"+u.getUsername()+"' and password = '"+u.getPasswrod()+"'";
             String logginStatus = "UPDATE Users SET login_status = true WHERE username= '"+u.getUsername()+"'";
             prestmnt=conn.prepareStatement(sql);
             Reltset=prestmnt.executeQuery();
             
             if (Reltset.next()){
                 prestmnt2=conn.prepareStatement(logginStatus);
                 prestmnt2.executeUpdate();
                 JOptionPane.showMessageDialog(null, "User Name or Password is Correct");
                 
                 
                 
             }
             else{
                 JOptionPane.showMessageDialog(null, "User Name or Password is Wrong");
             }
         } 
         catch (SQLException ex) {
             Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    public void getLoggedInUser(){
        try {
             conn = connect.dbConnect();//start here -- later add exceptions
             String sql = "SELECT username FROM Users WHERE login_status = true";
             
            
             prestmnt2=conn.prepareStatement(sql);
             Reltset=prestmnt2.executeQuery();
             
             if (Reltset.next()){
                 String username1 = Reltset.getString(1);
                 JOptionPane.showMessageDialog(null, "Welcome back! You are logged in as : " + username1);
               }
             else{
                 JOptionPane.showMessageDialog(null, "Welcome to our online fast food store." + "\nYou are not currently logged in. Some features might be unavailable.");
             }
         } 
         catch (SQLException ex) {
             Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        
    }
    
    
   
    
      
    
    
    public void logout(){
         try {
             conn = connect.dbConnect();//start here -- later add exceptions
             String logginStat = "UPDATE Users SET login_status = false WHERE login_status = true";
             prestmnt3=conn.prepareStatement(logginStat);
             prestmnt3.executeUpdate();
             
         } catch (SQLException ex) {
             Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
         }
        
    }
    
    
    

    
    public void updateLoginInfo(){
        try {
             conn = connect.dbConnect();//start here -- later add exceptions
             String sql = "SELECT username FROM Users WHERE login_status = true";
             
            
             prestmnt4=conn.prepareStatement(sql);
             Reltset=prestmnt4.executeQuery();
             
             if (Reltset.next()){
                 String username1 = Reltset.getString(1);
                 FoodOrderSystem.Instance.lbl.setText("   You are logged in as : "+username1);
                
                 
                 
               }
             else{
                 FoodOrderSystem.Instance.lbl.setText("You are not logged in. Some features might be unavailable");
             }
         } 
         catch (SQLException ex) {
             Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        
        
        
    } 
    
     public void updateLoginInfo2(){
        try {
             conn = connect.dbConnect();//start here -- later add exceptions
             String sql = "SELECT username FROM Users WHERE login_status = true";
             
            
             prestmnt4=conn.prepareStatement(sql);
             Reltset=prestmnt4.executeQuery();
             
             if (Reltset.next()){
                 String username1 = Reltset.getString(1);
                 viewMenu.Instance2.lbl2.setText("You are logged in as : "+ username1);
                 
                 
               }
             else{
                 viewMenu.Instance2.lbl2.setText("Please login to Place the Order");
             }
         } 
         catch (SQLException ex) {
             Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        
        
        
    }
     
    
    
    
  
   

}
