/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.citymanagerweb;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
@WebServlet(name = "ThreadSafeGetSeed", urlPatterns = {"/threadsafegetseed.do"})
public class ThreadSafeGetSeed extends HttpServlet {

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
        setCurrentSeedFromInitialSeed();
        determineSendRedirect(request, response);
    }

    private void setCurrentSeedFromInitialSeed() throws NumberFormatException {
        getServletContext().setAttribute("currentSeedValue", Integer.valueOf(getServletContext().getInitParameter("initialseed")));
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

    private void determineSendRedirect(HttpServletRequest request, HttpServletResponse response) throws IOException {
        switch (request.getParameter("theadsafetyselection")) {
            case "nonthreadsafe":
                response.sendRedirect("nonthreadsafeservlet.do");
                break;
            case "threadsafe":
                response.sendRedirect("threadsafeservlet.do");
                break;
            case "requestthread":
                response.sendRedirect("threadsaferequest.do");
                break;
            default:
                response.sendRedirect("index3.html");
        }
    }

}
