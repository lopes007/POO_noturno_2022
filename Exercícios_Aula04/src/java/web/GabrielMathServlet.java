/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fatec
 */
@WebServlet(name = "GabrielMathServlet", urlPatterns = {"/GabrielMathServlet"})
public class GabrielMathServlet extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GabrielMathServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GabrielMathServlet at " + request.getContextPath() + "</h1>");
            double n1 = 2;
            double n2 = 2;
            String op = "";
            try{
                    n1 = Double.parseDouble(request.getParameter("n1"));
                    n2 = Double.parseDouble(request.getParameter("n2"));
                    op = request.getParameter("op");
            }catch (Exception ex){
                out.println("<div style='color:red'>"
                +"Parâmetros inválidos</div>");
            }
            out.println("<form\n"+
           " <input type=\"number\" step=\"0.1\" name=\"n1\" value=\""+n1+"\"/>\n" +
           " <select name=\"op\">\n" +
           "     <option value=\""+op+"\">"+op+"</option>\n" +
           "     <option value=\"soma\">"+"</option>\n" +  
           "     <option value=\"sub\">-</option>\n" +  
           "     <option value=\"multi\">*</option>\n" +  
           "     <option value=\"div\">/</option>\n" +  
           "     </select>\n" +
           "     <input type=\"number\" step=\"0.1\" name=\"n2\" value=\""+n2+"\"/>\n" +
           "     <input type=\"submit\" value=\"=\"/>"        \n" +
           " </form");
            
            
            out.println("<h2>Soma" +op+ "</h2>");
            String soma = "soma";
               if (op.equals("soma")){
               out.println("<h3>"+n1+" + "+n2+" = "+(n1+n2)+"</h3>");
               }
               else if (op.equals("sub")){
               out.println("<h3>"+n1+" - "+n2+" = "+(n1-n2)+"</h3>");
               }
               else if (op.equals("multi")){
               out.println("<h3>"+n1+" + "+n2+" = "+(n1*n2)+"</h3>");
               }
               else if  (op.equals("divide")){
               out.println("<h3>"+n1+" + "+n2+" = "+(n1/n2)+"</h3>");
               }
            

            out.println("</body>");
            out.println("</html>");
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
