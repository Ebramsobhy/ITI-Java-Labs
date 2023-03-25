/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Ebram
 */
public class ConnectDB {

    public static void main(String[] args) {
       Connection con = null;
       try {
           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebram","root","");
           if(con != null){
               System.out.println("connected successfully");
               
               // Create statement object
               Statement stmt = con.createStatement();
               
               // Execute query and get result set
               ResultSet rs = stmt.executeQuery("SELECT * FROM employee");
               
               // Print results
               while (rs.next()) {
                   System.out.println(rs.getString(1) + ", " + rs.getString(2) + ", " + rs.getString(3));
               }
               
           }  
           
       } catch (Exception e) {
           System.out.println("connected failed");
           e.printStackTrace();
       } 
     
    }
}