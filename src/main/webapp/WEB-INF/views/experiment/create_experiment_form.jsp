<%--
  Created by IntelliJ IDEA.
  User: nasta
  Date: 12/2/2022
  Time: 9:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Create experiment</title>
</head>
<body>
<h1>Create experiment</h1>
<form:form method="post" modelAttribute="experiment">
    Title: <form:input path="name"/><br>
    <form:errors path="name"/><br>
    Description: <form:input path="description"/><br>
    <form:errors path="description"/>
    <input type="submit" value="Create experiment"/>
</form:form>
</body>
</html>
