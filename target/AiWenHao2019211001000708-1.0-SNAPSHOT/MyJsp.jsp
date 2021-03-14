<%--
  Created by IntelliJ IDEA.
  User: 艾文浩
  Date: 2021/3/14
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="index.jsp">go to ecjtu</a><!---method is get-->
<form method="post"><!---what is method when we used form--><!--its GET,why?
                                                    default is get , data is  add in the URL,you can see-->
    <!---is better to use POST in form ,data is not add in the URL-->
    Name:<input type="text" name="name"><br/>
    ID:<input type="text" name="id"><br/>
    <input type="submit" value="Send data to sever"/>

</form>

</body>
</html>
