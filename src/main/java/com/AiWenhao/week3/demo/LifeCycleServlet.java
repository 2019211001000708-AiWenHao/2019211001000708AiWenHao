package com.AiWenhao.week3.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LifeCycleServlet extends HttpServlet {
    //1. tomcat read wen.xml file and find out all servlet class
    //2. load servlet - when ? 2.first request for this servlet
    //3. call default constructor - add code
    public LifeCycleServlet(){
        System.out.println("i am in constructor --> LifeCycleServlet() ");//only one time
    }
    //4. init() - add code
    // user for
    @Override
    public void init(){
        System.out.println("i am in init() ");//only one time
    }

    //5. tomcat call service() --> call doGet() or doPost()
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("i am in service() --> doGet() ");//many times
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void destroy(){
        System.out.println("i am in destroy() ");//stop can println
    }
}
