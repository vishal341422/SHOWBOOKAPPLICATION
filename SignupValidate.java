/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package showbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import showbook.dbconn.DBConnection;


public class SignupValidate {
    public static Connection conn=null;
    public static boolean validate(String id,String pwd)
    {
       try
       {
           conn=DBConnection.getConnection();
           PreparedStatement ps=conn.prepareStatement("select userid from user_info where userid=? ");
           ps.setString(1,id);
           ResultSet rs=ps.executeQuery();
           if(rs.next()==true)
             return false;
       }
       catch(Exception ex)
       {
           System.out.println("Exception in SignUp validate validate  method");
           System.out.println(ex.getMessage());
       }  
       
       try
       {
           PreparedStatement ps=conn.prepareStatement("insert into user_info  values(?,?)");
           ps.setString(1,id);
           ps.setString(2,pwd);
           int rs=ps.executeUpdate();
           if(rs==1)
             return true;
           else
               return false;
       }
       catch(Exception ex)
       {
           System.out.println("Exception in Signup validate validate  method");
           System.out.println(ex.getMessage());
       }
       return true;
    }
  
}
