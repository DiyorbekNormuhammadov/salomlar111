
<%@ page import="java.util.ArrayList" %>
<%@ page import="uz.diyorbek_vs_asilbek_2.entity.Orders" %>
<%@ page import="uz.diyorbek_vs_asilbek_2.repo.OrderRepo" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-05-13
  Time: 7:30 a.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/static/bootstrap.min.css">
</head>
<body>
<%
    List<Orders>orders= OrderRepo.all();
    List<Orders> ordersList=new ArrayList<>();
    for (Orders order : orders) {
        if(order.getOrderStatus().equals("all")){
            ordersList.add(order);
        }
    }
%>
<div class="row">
    <div class="card col-3">
        <a href="orderAll.jsp" class="bg-info text-dark form-control">all</a>
        <a href="orderOpen.jsp" class="bg-info text-dark form-control">open</a>
        <a href="orderInprogres.jsp" class="bg-info text-dark form-control">inprogres</a>
        <a href="orderCompleted.jsp" class="bg-info text-dark form-control">completed</a>
    </div>
    <div class="col-9">
        <a href="login.jsp" class="btn btn-primary btn-lg btn-block">Login</a>
    </div>
</div>

<table class="table table-striped">
    <thead>
    <tr>
        <th>Id</th>
        <th>Date</th>
        <th>Status</th>
        <th>User</th>
    </tr>
    </thead>
    <tbody>
   <% for (Orders orders1 : ordersList) {%>
           <tr>
               <td><%=orders1.getId()%></td>
               <td><%=orders1.getOrderDate()%></td>
               <td><%=orders1.getOrderStatus()%></td>
               <td>User</td>
           </tr>
     <%  } %>
    </tbody>
</table>

</body>
</body>
</html>
