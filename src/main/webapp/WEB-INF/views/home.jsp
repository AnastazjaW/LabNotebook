<%--
  Created by IntelliJ IDEA.
  User: nasta
  Date: 12/3/2022
  Time: 12:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <title>LabNotebook</title>
    <style><%@include file="/WEB-INF/css/home_styles.css"%></style>
</head>
<body>
<div class="jumbotron vertical-center">
    <div class="container">
        <h1 class="display-4 text-center">LabNotebook</h1>
        <p class="lead">Laboratory electronic notebook for you and your team. Plan your research project, keep laboratory documentation and share with your colleagues. </p>
        <div class="text-center">
            <div class="col-md-16 text-center">
                <a href="${pageContext.request.contextPath}/login"><button type="button" class="btn btn-primary btn-lg">Login</button></a>
                <a href="${pageContext.request.contextPath}/register"><button type="button" class="btn btn-success btn-lg">Register</button></a>
            </div>
        </div>
    </div>
</div>
</body>
</html>