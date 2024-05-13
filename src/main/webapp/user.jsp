<%@ page import="java.util.List" %>
<%@ page import="uz.diyorbek_vs_asilbek_2.entity.Users" %>
<%@ page import="uz.diyorbek_vs_asilbek_2.repo.UserRepo" %><%--
  Created by IntelliJ IDEA.
  User: Asilb
  Date: 5/13/2024
  Time: 2:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%List<Users> users = UserRepo.findAll();%>
    <title>Title</title>
    <link rel="stylesheet" href="/static/bootstrap.min.css">
</head>
<body>
<table class="table table-striped">
    <thead>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>phone</th>
        <th>action</th>
    </tr>
    </thead>
    <tbody>
    <%
        for (Users user : users) {%>
    <tr>
        <td><%=user.getId()%>
        </td>
        <td><%=user.getName()%>
        </td>
        <td><%=user.getPhone()%>
        </td>
        <td>
            <a href="/editUser.jsp">
                <button class="btn btn-info">edit</button>
            </a>
        </td>
        <td>delete</td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
</body>
</html>
