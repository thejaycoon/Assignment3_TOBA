/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toba.business.transactions;

import com.toba.business.shared.account;
import com.toba.data.AccountDB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jason
 */
@WebServlet( urlPatterns = {"/TransactionServlet"})
public class TransactionServlet extends HttpServlet {

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
        
        
        String amount = request.getParameter("amount");
        
        HttpSession session = request.getSession();
        account checking = (account)session.getAttribute("checking");
        account savings = (account)session.getAttribute("savings");
        
        Double checkingBal = checking.getStartingBal();
        Double savingsBal = savings.getStartingBal();
        
        checking.credit(Double.parseDouble(amount));
        transaction t1 = new transaction(
                checkingBal, Double.parseDouble(amount), checking.getStartingBal(), "Credit");
        checking.addTransactions(t1);
        
        savings.debit(Double.parseDouble(amount));
        transaction t2 = new transaction(
                savingsBal, Double.parseDouble(amount), savings.getStartingBal(), "Debit");
        savings.addTransactions(t2);
        
        
        AccountDB.update(savings);
        AccountDB.update(checking);
           // User user = (User)session.getAttribute("user");
        session.setAttribute("checking", checking);
        session.setAttribute("savings", savings);
        
        getServletContext()
            .getRequestDispatcher("/account_activity.jsp")
            .forward(request, response);
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
