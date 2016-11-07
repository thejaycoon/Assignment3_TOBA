/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toba.business.authentication;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.toba.business.shared.User;

/**
 *
 * @author Jason
 */
@WebServlet( urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, 
                          HttpServletResponse response) 
                          throws ServletException, IOException {

        String url = "/index.jsp";

        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "join";  // default action
        }

        // perform action and set URL to appropriate page
        if (action.equals("submit")) {
            url = "/login.jsp";   
        }
        else if (action.equals("add")) {                
            // get parameters from the request
            String userName = request.getParameter("username");
            String password = request.getParameter("password");
            if (userName.equals("jsmith@toba.com") && password.equals("letmein")) {
             url = "/account_activity.jsp";  // default action
        }
            else{url = "/login_failure.jsp";}

            // store data in User object and save User object in database
            //User user = (User)session.getAttribute("user");
            
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
