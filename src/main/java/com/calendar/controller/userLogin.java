package com.calendar.controller;

import com.calendar.util.Logger;
import com.calendar.model.User;
import com.calendar.model.UserLoginException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by yuson on 2016/2/19.
 * User Login Servlet Controller
 */
@WebServlet(name = "userLogin", urlPatterns = "/userlogin", loadOnStartup = 1)
public class userLogin extends HttpServlet
{

    @Override
    public void init() throws ServletException
    {
        super.init();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //new empty user object
        User user = new User();
        //get user input
        String usrEmail = request.getParameter("usr_email");
        String usrPass = request.getParameter("usr_pass");


        try
        {
            //try login
            user.login(usrEmail, usrPass);
            //set data to HttpSession
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("user", user);
//            request.getRequestDispatcher("/calendar").forward(request, response);
//            response.sendRedirect("/calendar");
            Logger.log(response.encodeRedirectURL("/calendar"));
            //redirect to new Servlet without losing Session
            response.sendRedirect(response.encodeRedirectURL("/calendar"));
        }
        catch (UserLoginException e)
        {
            Logger.log(e.getMessage());
            e.printStackTrace();
            //forward the error reporting
            request.setAttribute("message", e.getMessage());
            request.getRequestDispatcher("fail.jsp").forward(request, response);
            response.sendRedirect("fail.jsp");
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}
