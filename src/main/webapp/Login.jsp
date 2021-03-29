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
<form method="post" action="/2019211001000708AiWenHao_war_exploded/login">
    <table>
        <tr> <td>Username:</td> <td><input type="text" name="Username" required><br/></td></tr>
        <tr> <td>password:</td> <td><input type="password" name="password" required minlength="8"><br/></td></tr>
        <tr> <td></td><td><input type="submit" value="Login"/></td>  </tr>
    </table>
</form>
<%@include file="footer.jsp"%>