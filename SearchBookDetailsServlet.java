/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package showbookservlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import showbook.dao.BookDetail;
import showbook.dto.BookDetails;

/**
 *
 * @author Vishal Kumar
 */
public class SearchBookDetailsServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw=response.getWriter();
        pw.println("<html>");
        pw.println("<head><title>FetchinBookDetails code</title></head>");  
        pw.println("<body>");
        
        String bname=request.getParameter("bs").trim();
        bname=bname.toLowerCase();
        pw.println(bname);
        RequestDispatcher rd=null;
        if(bname.length()==0)
        {
            pw.print("<h1 style='color: red; text-align: center;position: absolute;top: 15%;left: 38%;'>Please Fill book name!</h1>");
            rd=request.getRequestDispatcher("booksearch.html");
            rd.include(request, response);
            pw.close();
        }
        else
        {
            if(bname.equals("book") || bname.equals("books"))
            {
                pw.print("<h1 style='color: red; text-align: center;position: absolute;top: 15%;left: 38%;'>Please Fill book name!</h1>");
                rd=request.getRequestDispatcher("booksearch.html");
                rd.include(request, response);
                pw.close();
           }
            else if(bname.contains("book"))
            {
                int index=bname.indexOf("book");
                bname=bname.substring(0,index);
            }
            ArrayList<BookDetails> bookcoll=BookDetail.searchBook(bname.trim());
            if(bookcoll.isEmpty())
            {
               rd=request.getRequestDispatcher("nobook.html");
               rd.forward(request, response);
               pw.close(); 
            }  
            else
            { 
               
               rd=request.getRequestDispatcher("showbook.jsp");
               request.setAttribute("bname",bname);
               request.setAttribute("bookList",bookcoll);
               rd.forward(request, response);
               pw.close();
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
