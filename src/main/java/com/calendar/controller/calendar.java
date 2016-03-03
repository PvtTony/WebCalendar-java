package com.calendar.controller;

import com.calendar.model.EventManager;
import com.calendar.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by yst on 2016/2/20.
 * Calendar Controller Servlet
 */
@WebServlet(name = "calendar", urlPatterns = "/calendar", loadOnStartup = 1)
public class calendar extends HttpServlet
{


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession httpSession = request.getSession();
//        String sessionID = request.getParameter("id");

        User user = (User) httpSession.getAttribute("user");
        EventManager eventManager = new EventManager(user);

        request.setAttribute("usrID", user.getUsrID());
        request.setAttribute("usrNickname", user.getUsrNickname());
        request.setAttribute("usrEmail", user.getUsrEmail());
        request.setAttribute("usrRegistered", user.getUsrRegistered().toString());
        request.setAttribute("EventJson", eventManager.getEventsInJson());

        request.getRequestDispatcher("calendar.jsp").forward(request, response);
//        response.sendRedirect("/calendar.jsp");
    }
}
