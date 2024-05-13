<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="static/bootstrap.min.css">
</head>
<body>
<div class="row">
    <div class="card col-3">
        <a href="orderAll.jsp" class="bg-info text-dark form-control">all</a>
        <a href="orderOpen.jsp" class="bg-info text-dark form-control">open</a>
        <a href="orderInprogres.jsp" class="bg-info text-dark form-control">inprogres</a>
        <a href="orderCompleted.jsp" class="bg-info text-dark form-control">completed</a>
    </div>
    <div class="col-9">
        <a href="/admin.jsp" class="btn btn-primary btn-lg btn-block">Admin panel</a>
    </div>
</div>
</body>
</html>