/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetablemanagement.forConnection;

import java.sql.*;

/**
 *
 * @author Sajee
 */
public class connect {
    public Connection getConnection(){
        Connection connnet=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connnet = DriverManager.getConnection("jdbc:mysql://localhost:3306/timetable management", "root", "");

            
        }catch(Exception ex){
            ex.printStackTrace();
            System.err.print("Connection erre!!!");
        }
        return connnet;
    }
}
