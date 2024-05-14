/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package showbookservlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import showbook.dao.SignupValidate;

/**
 *
 * @author Vishal Kumar
 */
public class SignupServlett extends HttpServlet {

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
        pw.println("<head><title>SignUp code</title></head>");  
        pw.println("<body>");
         
        String pwd=request.getParameter("pwd").trim();
        String id=request.getParameter("lg").trim();
        RequestDispatcher rd=null;
        if(pwd.length()==0 || id.length()==0)
        {
            pw.print("<h1 style='color: red; text-align: center;position: absolute;top: 20%;left: 38%;'>Please Fill Id/Password!</h1>");
            rd=request.getRequestDispatcher("signup.html");
            rd.include(request, response);
            pw.close();
        }
        
        int digitcount=0;
        int charcount=0;
        for(int i=0;i<id.length();i++)
        {
            if(Character.isDigit(id.charAt(i)))
                digitcount++;
            else
                charcount++;
        }
        
        if(digitcount<2 || charcount<2 )
        {
            pw.print("<h1 style='color: red; text-align: center;'>username wrong please enter atleast 2 digit & 2 character !</h1>");
            rd=request.getRequestDispatcher("signup.html");
            rd.include(request, response);
            pw.close();
        }
      
        int numcount=0;
        int uppcharcount=0;
        int lowcharcount=0;
        int specharcount=0;
        for(int i=0;i<pwd.length();i++)
        {
            if(Character.isDigit(pwd.charAt(i)))
                numcount++;
            else if(Character.isAlphabetic(pwd.charAt(i)))
            {
                if(Character.isUpperCase(pwd.charAt(i)))
                    uppcharcount++;
                else
                    lowcharcount++; 
            }
            else
                specharcount++;
        }
        if(numcount<2 || uppcharcount<2 || lowcharcount<2 || specharcount<=0 || specharcount>2 )
        {
            pw.print("<h1 style='color: red; text-align: center;'>please enter atleast 2 digit & 2 upper-lower character & maximum 2 special character in password!!</h1>");
            rd=request.getRequestDispatcher("signup.html");
            rd.include(request, response);
            pw.close();
        }
        boolean b=SignupValidate.validate(id, pwd);
        
        if(b==false)
        {
        pw.print("<h1 style='color: red; text-align: center;position: absolute;top: 20%;left: 38%;'>username already present!</h1>");
        rd=request.getRequestDispatcher("signup.html");
        rd.include(request, response); 
        }
        else if(b==true)
        {
            pw.print("<h1 style='color: red; text-align: center;position: absolute;top: 20%;left: 38%;'> Signup successfull please login!</h1>");
            rd=request.getRequestDispatcher("index.html");
            rd.include(request, response); 
        }
            
        pw.println("</body>");
        pw.println("</html>");
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
