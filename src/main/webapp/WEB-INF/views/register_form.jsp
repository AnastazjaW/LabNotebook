<%--
  Created by IntelliJ IDEA.
  User: nasta
  Date: 12/5/2022
  Time: 8:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <style>
        <%@include file="/WEB-INF/css/current_tasks.css" %>
    </style>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>LabNotebook</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="<c:url value="${pageContext.request.contextPath}/"/>">LabNotebook</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
</nav>
<div class="mt-4 d-flex flex-column">
    <div class="d-flex justify-content-center" style="font-size:25px;">Register</div>
    <div class="mt-4 d-flex justify-content-center">
        <form:form method="post" modelAttribute="user">
            First name: <form:input path="firstName"/><br>
            <form:errors path="firstName"/><br>
            Last name: <form:input path="lastName"/><br>
            <form:errors path="lastName"/><br>
            Degree: <form:select path="degree"><br>
            <form:option value="-" label="choose degree"/>
            <form:options items="${degrees}"/>
            <form:errors path="degree"/><br>
        </form:select><br>
            Affiliation: <form:input path="affiliation"/><br>
            <form:errors path="affiliation"/><br>
            Email: <form:input path="email"/><br>
            <form:errors path="email"/><br>
            Password: <form:password path="password"/><br>
            <form:errors path="password"/><br>
            Confirm password: <form:password path="confirmPassword"/><br>
            <form:errors path="confirmPassword"/><br>
            <input type="submit" class="btn btn-lg btn-primary" value="Register"/>
            <a class="btn btn-lg btn-secondary" href="<c:url value="${pageContext.request.contextPath}/"/>">Cancel</a>
        </form:form>
    </div>
</div>
</body>
</html>