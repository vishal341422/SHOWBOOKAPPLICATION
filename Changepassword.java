/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package showbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import showbook.dbconn.DBConnection;


public class Changepassword {
    public static boolean changePwd(String id,String pwd)
    {
        try
       {
           Connection conn=DBConnection.getConnection();
           String qry="update user_info set password=? where userid=?";
           PreparedStatement ps=conn.prepareStatement(qry);
           ps.setString(1,pwd);
           ps.setString(2,id);
          int ans=ps.executeUpdate();
          if(ans==0)
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
