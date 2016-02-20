package com.calendar.controller;

import com.calendar.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        User user = new User();
        String usrEmail = request.getParameter("usr_email");
        String usrPass = request.getParameter("usr_pass");

        if (user.login(usrEmail, usrPass))
        {


            request.setAttribute("usrID", user.getUsrID());
            request.setAttribute("usrNickname", user.getUsrNickname());
            request.setAttribute("usrEmail", user.getUsrEmail());
            request.setAttribute("usrRegistered", user.getUsrRegistered().toString());
            request.getRequestDispatcher("calendar.jsp").forward(request, response);
            response.sendRedirect("calendar.jsp");
        }
        else
        {
            response.sendRedirect("fail.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}
