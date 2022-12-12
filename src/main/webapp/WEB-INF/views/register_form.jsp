<%--
  Created by IntelliJ IDEA.
  User: nasta
  Date: 12/5/2022
  Time: 8:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Registration</title>
</head>
<body>
<h1>Registration</h1>
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
    <input type="submit" value="Register"/>
</form:form>
</body>
</html>