/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jeldis.servletmvc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jeldis.model.Product;
import org.jeldis.model.ProductDAO;

/**
 *
 * @author jorge.gonzalez
 */
public class HelloWorldController extends HttpServlet {

    /**
     *
     *
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        //PersonBeanModel person = new PersonBeanModel();
        ProductDAO productoDao = new ProductDAO();

        try {

            //person.setName(request.getParameter("name"));
            //person.setMail(request.getParameter("mail"));

            //person.doSomething();

            //request.setAttribute("person", person);

            //List<Product> products = productoDao.lista();

            //request.setAttribute("productos", products);
            //request.getRequestDispatcher("/index.jsp").forward(request, response);
            //request.setAttribute("servletName", "servletToJsp");
            getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            //getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            //request.getRequestDispatcher("/index.jsp").forward(request, response);
        } catch (Exception ex) {
            System.out.println(ex);
        } 
    
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
