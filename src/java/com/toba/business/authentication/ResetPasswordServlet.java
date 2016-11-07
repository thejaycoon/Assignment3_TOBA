/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toba.business.authentication;

import com.toba.business.shared.User;
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
@WebServlet(name = "ResetPasswordServlet", urlPatterns = {"/ResetPasswordServlet"})
public class ResetPasswordServlet extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.setContentType("text/html;charset=UTF-8");
             String url = "/account_activity.jsp";

        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "join";  // default action
        }

        // perform action and set URL to appropriate page
        if (action.equals("submit")) {
            url = "/account_activity.jsp";   
        }
        else if (action.equals("add")) {                
            // get parameters from the request
            String userName = request.getParameter("username");
            String password = request.getParameter("password");
            if (userName.equals("jsmith@toba.com") && password.equals("")) {
             url = "/account_activity.jsp";  // default action
        }
            else{url = "/account_activity.jsp";}
             
            // store data in User object and save User object in database
            User user = new User();
            user.setPassword(""); 
            request.setAttribute("message", url);
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            // set User object in request object and set URL
            //request.setAttribute("user", user);
           // url = "/success.jsp";   // edit me
        }
        
        // forward request and response objects to specified URL
        getServletContext()
            .getRequestDispatcher(url)
            .forward(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, 
                          HttpServletResponse response) 
                          throws ServletException, IOException {
        doPost(request, response);
    }  

}