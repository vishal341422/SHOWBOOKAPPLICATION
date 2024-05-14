/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package showbook.dbconn;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection conn=null;
    static 
    {
      try{
            Class.forName("oracle.jdbc.OracleDriver");
            System.out.println("class load successfully");
            conn=DriverManager.getConnection("jdbc:oracle:thin:@//LAPTOP-GK4M53R5:1521/xe","ora","12345");
            System.out.println("Connection open successfully");
        }
        catch(Exception ex)
        {
            System.out.println("Exception in LoginValidate");
            System.out.println(ex);
        }
    }
    
    public static Connection getConnection()
    {
        return conn;
    }
    
    public static void closeConnection()
    {
        try
        {
            if(conn!=null)
            {
               conn.close();
               System.out.println("DB connection close!");
            }
        }
        catch(Exception ex)
        {
             System.out.println("DB connection not closed!");
             System.out.println(ex.getMessage());
        }
    }
}
