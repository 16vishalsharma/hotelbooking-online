/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lenovo pc
 */
@WebServlet(urlPatterns = {"/hotelbooking"})
public class hotelbooking extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String name=request.getParameter("Name").toString();
           
             String email=request.getParameter("email").toString();
              String number=request.getParameter("number").toString();
               String mobile=request.getParameter("mobile").toString();
                String party=request.getParameter("party").toString();
                String date=request.getParameter("Date").toString();
                 String comment=request.getParameter("comment").toString();
                  out.println("\nCustomer name"+name);
                 out.println("\nEmail ID"+email);
                  out.println("\nFirst number"+number);
                   out.println("\nSecond number"+mobile);
                    out.println("\nparty"+party);
                    out.println("\nDate"+date);
                     out.println("\nComment"+comment);
                 try{
       Class.forName("oracle.jdbc.driver.OracleDriver");
       Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","12345");
      // Statement st=conn.createStatement()
      
      
  PreparedStatement  ps = conn.prepareStatement("insert into hotel values(?,?,?,?,?,?,?)");
  ps.setString(1, name);
   ps.setString(2, email);
  ps.setString(3, mobile);
  ps.setString(4, number);
  ps.setString(5, party);
  ps.setString(6, date);
   ps.setString(7, comment);
  ps.executeUpdate();
System.out.println("insert value are loaded");
conn.close();
ps.close();
   
  
  
      
                 }catch(Exception e)
                 {
                   System.out.println(e);  
                 }
                
            
          /*  out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet hotelbooking</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet hotelbooking at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");*/
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
