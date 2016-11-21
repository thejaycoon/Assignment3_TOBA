/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toba.business.registration;

import com.toba.business.shared.User;
import com.toba.business.shared.account;
import com.toba.data.AccountDB;
import com.toba.data.UserDB;
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
@WebServlet( urlPatterns = {"/NewCustomerServlet"})
public class NewCustomerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, 
                          HttpServletResponse response) 
                          throws ServletException, IOException {

        String url = "/new_customer.jsp";

        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "join";  // default action
        }

        // perform action and set URL to appropriate page
        if (action.equals("submit")) {
            url = "/new_customer.jsp";   
        }
        else if (action.equals("add")) {                
            // get parameters from the request
            String firstName = request.getParameter("firstname");
            String lastName = request.getParameter("lastname");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");
            String city = request.getParameter("city");
            String state = request.getParameter("state");
            String zipCode = request.getParameter("zip");
            String eMail = request.getParameter("email");

           
            
            // set User object in request object and set URL
            //request.setAttribute("user", user);
            url = "/success.jsp";   // edit me
            String message;
            if (firstName == null || lastName == null || phone == null || address == null
                    || city == null || state == null || zipCode == null || eMail == null ||
                    firstName.isEmpty() || lastName.isEmpty() || phone.isEmpty() || address.isEmpty()
                    || city.isEmpty() || state.isEmpty() || zipCode.isEmpty() || eMail.isEmpty()){
                message = "Please fill out all the form fields.";
                url = "/new_customer.jsp";
            }
             // store data in User object and save User object in database
            User user = new User(firstName,lastName,phone,address,city,state,zipCode,eMail);
            user.setUserName (user.getLastName() + user.getZipCode());
            user.setPassword("welcome1"); 
            request.setAttribute("message", url);
         //   HttpSession session = request.getSession();
        //    session.setAttribute("user", user);
            UserDB.insert(user);//add customer to database
            //type attribute
            account checking = new account("Checking", 0, user);
            account savings = new account("Savings",25.00, user);
            AccountDB.insert(savings);
            AccountDB.insert(checking);
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