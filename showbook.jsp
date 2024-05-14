<%-- 
    Document   : showbook
    Created on : 9 Apr, 2024, 8:36:07 AM
    Author     : Vishal Kumar
--%>


<%@page import="java.util.*,showbook.dto.BookDetails" contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book</title>
        
        <link rel="stylesheet" href="showbook.css">
    </head>
    <body>
       
        <form action="thankyou.html">
            <table>
                <tr>
                    <th><input type="submit" value="Logout" name="logout" class='tbbb'/></th>
                    <th><a href="booksearch.html" class='tbbb'>search another book</a></th>
                </tr>
            </table>
        </form>    
        <%
            
            ArrayList<BookDetails> bookList=(ArrayList<BookDetails>)request.getAttribute("bookList");
            out.println("<table border='1px' align='center' class='tbbb'>");
            out.println("<tr class='tb'><th colspan='3'>results for '"+(String)request.getAttribute("bname")+"' books</th></tr>");
            out.println("<tr class='tbb'><th align=left>Book Name</th><th align=left>Writer Name</th><th align=left>Book Price</th>");
            for(BookDetails b:bookList)
            {
               out.println("<tr><td>"+b.getBookname()+"</td><td>"+b.getBookwriter()+"</td><td>"+b.getBookprice()+"</td></tr>");  
            }
        %>
        
    </body>
</html>
