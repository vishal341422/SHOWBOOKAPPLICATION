/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package showbook.dao;

import showbook.dto.BookDetails;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import showbook.dbconn.DBConnection;


public class BookDetail {
    public  static ArrayList<BookDetails> searchBook(String bookname)
    {
        System.out.println(bookname);
        ArrayList<BookDetails> bookList=new ArrayList();
        Connection conn=DBConnection.getConnection();
        try
        {    
            PreparedStatement ps=conn.prepareStatement("select bookname,writername,bookprice from books where subject=?");
            ps.setString(1,bookname);
            
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                String bname=rs.getString(1);
                String bwriter=rs.getString(2);
                double bprice=rs.getDouble(3);
                BookDetails bd=new BookDetails(bname,bwriter,bprice);
                bookList.add(bd);
                
            }
        }
        catch(Exception ex)
        {
            System.out.println("Exception in searchBook");
            System.out.println(ex.getMessage());
        }
        finally
        {
            System.out.println(bookList);
            return bookList;
        }
    }
}
