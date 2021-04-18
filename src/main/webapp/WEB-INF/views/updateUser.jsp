<%--
  Created by IntelliJ IDEA.
  User: 艾文浩
  Date: 2021/4/24
  Time: 23:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1> User Update</h1>

<%
    //get user from session
    User u = (User) session.getAttribute("user");
%>
<form method="post" action="/2019211001000708AiWenHao_war_exploded/updateUser">
    <table>
        <tr> <td>Id:</td> <td><input type="text" name="Id" value="<%=u.getId()%>" required><br/></td></tr>
        <tr> <td class="right">Username：</td> <td><input type="text" name="Username" value="<%=u.getUsername()%>"><br/></td></tr>
        <tr> <td class="right">password：</td> <td><input type="password" name="password" value="<%=u.getPassword()%>"><br/></td></tr>
        <tr> <td class="right">Email：</td> <td><input type="email" name="Email" value="<%=u.getEmail()%>"><br/></td></tr>
        <tr>
            <td class="right">Gender：</td>
            <td>
                <input type="radio" name="Gender" value="Male" checked="checked" <%="Male".equals(u.getGender())?"checked" : ""%>/> Male <!-- checked="checked"默认选择项 -->
                <input type="radio" name="Gender" value="Female" checked="checked" <%="Female".equals(u.getGender())?"checked" : ""%>/> Female
            </td>
        </tr>
        <tr> <td class="right">Birthdate：</td> <td><input type="date" name="Date" required dataformatas="yyyy-dd-mm" value="<%=u.getBirthdate()%>"><br/></td></tr>
        <tr> <td></td><td><input type="submit" value="Save Changes"/></td>  </tr>
    </table>
</form>
<%@include file="footer.jsp"%>