package com.AiWenhao.week3.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;


//automatic -new -->servlet
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //request come here -<form method="post">
        //get parameter from request
        String Username = request.getParameter("name");//<!--这里面的name就是register.jsp里面的(name = "name")-->
        String Password = request.getParameter("password");//<input type="password" name="password"
        String Email = request.getParameter("email");
        String Gender = request.getParameter("gender");
        String Birthdate = request.getParameter("yyyy-mm-dd");

        //print - write into response
        PrintWriter writer = response.getWriter();
        writer.println("<br>Username: " + Username);
        writer.println("<br>Password: " + Password);
        writer.println("<br>Email: " + Email);
        writer.println("<br>Gender: " + Gender);
        writer.println("<br>Birthdate: " + Birthdate);
        writer.close();
    }
}
