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
    <form>
        Username:<input type="text" name="name" required><br/>
        Password:<input type="password" name="password" required minlength="8"><br/>
        Email:<input type="email" name="email" required><br/>
        Birthdate:<input type="datetime-local" name="yyyy-mm-dd" required><br/>
        Sex:Male<input name="sex" type="radio" value="Male"/>
        Female<input name="sex" type="radio" value="Female"/><br/>
        <input type="submit" value="Send data to sever"/>

    </form>
</body>
</html>
