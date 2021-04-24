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
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Username = request.getParameter("Username");//与login保持一致
        String password = request.getParameter("password");


        try {
            UserDao userDao = new UserDao();
            User user = userDao.findByUsernamePassword(con, Username, password);
            if (user != null) {
                //valid
                //add code for remember me
                String rememberMe= request.getParameter("rememberMe");//1=checked
                if (rememberMe!= null && rememberMe.equals("1")){
                    Cookie usernameCookie= new Cookie("cUsername",user.getUsername());
                    Cookie passwordCookie= new Cookie("cPassword",user.getPassword());
                    Cookie rememberMeCookie= new Cookie("cRememberMe",rememberMe);

                    //set age of cookies
                    usernameCookie.setMaxAge(5);
                    passwordCookie.setMaxAge(5);
                    rememberMeCookie.setMaxAge(5);

                    response.addCookie(usernameCookie);
                    response.addCookie(passwordCookie);
                    response.addCookie(rememberMeCookie);


                }

                //set user into request

//                //week 8 code - demo #1 use cookie for session
//                //create cookie
//                //step 1:create an object of cookie class
//                Cookie c = new Cookie("sessionid","" + user.getId());
//                //step 2:set age of cookie
//                c.setMaxAge(10*60);
//                //step 3:add cookie into response
//                response.addCookie(c);

                //create a session
                HttpSession session =request.getSession();
                System.out.println("session id -->" + session.getId());
                //set time for session
                session.setMaxInactiveInterval(10);

                //set User model into request
                //change(one page) to session
                session.setAttribute("user", user);//get user info in jsp
                request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request, response);

            } else {
                //invalid
                request.setAttribute("message", "Username or Password Error!!!");
                request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
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

