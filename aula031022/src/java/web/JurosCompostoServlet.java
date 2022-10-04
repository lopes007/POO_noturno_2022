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
import org.json.JSONObject;

/**
 *
 * @author Fatec
 */
@WebServlet(name = "JurosCompostoServlet", urlPatterns = {"/juros-composto.json"})
public class JurosCompostoServlet extends HttpServlet {

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
        
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        double capital = 0;
        double taxa = 0;
        double periodo = 0;
        double montante = 0;
        
        try{
            if(request.getParameter("capital")!=null && request.getParameter("taxa")!=null && 
                      request.getParameter("periodo")!=null){
                
                capital = Double.parseDouble(request.getParameter("capital"));
                taxa = Double.parseDouble(request.getParameter("taxa"));
                periodo = Double.parseDouble(request.getParameter("periodo"));
                montante = capital*(1+(taxa/100));
                montante = Math.pow(montante, periodo);
                montante = montante/100;
                
                JSONObject file = new JSONObject();
                file.put("capital", capital );
                file.put("taxa", taxa );
                file.put("periodo", periodo );
                file.put("montante", montante );
                
                response.getWriter().println(file.toString());
                
              
            }
            else{
                JSONObject obj = new JSONObject();
            obj.put("erro", ex.getMessage());
            out.print(obj.toString());
            }
        }catch(Exception ex){
            response.setStatus(500);
            JSONObject obj = new JSONObject();
            obj.put("ERRO", ex.getMessage());
            out.print(obj.toString());
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
