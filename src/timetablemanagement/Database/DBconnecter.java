/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetablemanagement.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class DBconnecter {
    
    public static Connection connection(){
        
    Connection connection=null;
    
    try{
        Class.forName("com.mysql.jdbc.Driver");
        connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/timetable management","root","");
       // JOptionPane.showMessageDialog(null, "database connected");
        
    }catch(Exception ex){
        
        JOptionPane.showMessageDialog(null, "error");
        
    }
    return connection;
    } 
}
