/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package showbook.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import  showbook.dbconn.DBConnection;
import showbook.dto.Login;


public class Loginvalidate {
     public static boolean validate(Login login)
    {
       
       try
       {
           Connection conn=DBConnection.getConnection();
           PreparedStatement ps=conn.prepareStatement("select userid,password from user_info where userid=? and password=?");
           ps.setString(1,login.getId());
           ps.setString(2,login.getPwd());
           ResultSet rs=ps.executeQuery();
           return rs.next();
               
       }
       catch(Exception ex)
       {
           System.out.println("Exception in Login validate  method");
           System.out.println(ex.toString());
       }
       return false;
    }
}
