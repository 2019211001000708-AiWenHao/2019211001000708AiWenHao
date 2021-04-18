<%--
  Created by IntelliJ IDEA.
  User: 艾文浩
  Date: 2021/4/5
  Time: 20:56
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Title</title>--%>
<%--</head>--%>
<%--<body>--%>

<%--</body>--%>
<%--</html>--%>
<%@include file="header.jsp"%>
<h1>Login</h1>
<%
    if(request.getAttribute("message")!=null){
        out.println(request.getAttribute("message"));
    }
%>
<%
    //read cookies
    Cookie[] allCookies = request.getCookies();//give all cookies
    String username= "",password= "",rememberMeVal= "";
    if (allCookies != null) {
        //we read 3 cookies
        for (Cookie c:allCookies) {
            if (c.getName().equals("cUsername")){
                ////get Values of this cookies
                username= c.getValue();
            }
            if (c.getName().equals("cPassword")){
                ////get Values of this cookies
                password= c.getValue();
            }
            if (c.getName().equals("cRememberMe")){
                ////get Values of this cookies
               rememberMeVal = c.getValue();
            }
        }

    }
%>
<form method="post" action="/2019211001000708AiWenHao_war_exploded/login">
    <table>
        <tr> <td>Username:</td> <td><input type="text" name="Username" value="<%=username%>"><br/></td></tr>
        <tr> <td>password:</td> <td><input type="password" name="password" value="<%=password%>"><br/></td></tr>
        <input type="checkbox" name="rememberMe " value="1" <%=rememberMeVal.equals("1") ?"checked":""%> /> RememberMe<br/>
        <tr> <td></td><td><input type="submit" value="Login"/></td>  </tr>
    </table>
</form>
<%@include file="footer.jsp"%>