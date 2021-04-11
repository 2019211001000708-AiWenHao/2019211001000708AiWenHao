package com.AiWenhao.week5.demo;

import com.AiWenhao.dao.UserDao;
import com.AiWenhao.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.text.SimpleDateFormat;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    Connection con = null;

    @Override
    public void init() throws ServletException {
        super.init();
        con = (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // when user click login menu - request
        request.getRequestDispatcher("WEB-INF/views/Login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Username = request.getParameter("Username");//与login保持一致
        String password = request.getParameter("password");

        UserDao userDao = new UserDao();
        try {
            User user = userDao.findByUsernamePassword(con, Username, password);
            if (user != null) {
                //valid
                //set user into request
                request.setAttribute("user", user);//get user info in jsp
                request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request, response);

            } else {
                //invalid
                request.setAttribute("message", "Username or Password Error!!!");
                request.getRequestDispatcher("WEB-INF/views/Login.jsp").forward(request, response);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
  /*      String sql="select * from Usertable where username=? and password=?";
        PreparedStatement pstmt= null;
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,Username);
            pstmt.setString(2,password);
            ResultSet rs= pstmt.executeQuery();
            PrintWriter out=response.getWriter();
            if(rs.next()){
                /*out.println("Login Success!!!");
                out.println("Welcome,"+Username);
                request.setAttribute("id",rs.getInt("id"));
                request.setAttribute("username",rs.getString("username"));
                request.setAttribute("password",rs.getString("password"));
                request.setAttribute("email",rs.getString("email"));
                request.setAttribute("gender",rs.getString("gender"));
                request.setAttribute("birthdate",rs.getDate("birthdate"));
                request.getRequestDispatcher("userInfo.jsp").forward(request,response);
            }else {
                //out.println("Username or password Error!!!");
                request.setAttribute("message","Username or password Error!!!");
                request.getRequestDispatcher("Login.jsp").forward(request,response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }*/
    }


        @Override
        public void destroy() {
            super.destroy();
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
    }

