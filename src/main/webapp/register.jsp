<%--
  Created by IntelliJ IDEA.
  User: 艾文浩
  Date: 2021/3/14
  Time: 22:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="post" action="register"><!--within doPost() in servlet-->
        Username:<input type="text" name="name" required><br/>
        Password:<input type="password" name="password" required><br/>
        Email:<input type="email" name="email" required><br/>
        Gender:<input type="radio" name="gender" value="male">Male<input type="radio" name="gender" value="female">Female<br/>
        <!--if name is same it make array-->
        Birthdate:<input type="datetime-local" name="yyyy-mm-dd" required><br/>
        <input type="submit" value="Register"/>

    </form>
</body>
</html>
