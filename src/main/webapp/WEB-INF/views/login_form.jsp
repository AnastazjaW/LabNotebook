<%--
  Created by IntelliJ IDEA.
  User: nasta
  Date: 12/3/2022
  Time: 2:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Sign up</title>
</head>
<body>
<h1>Sign up</h1>
<form method="post" action="<c:url value="/login"/>">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <label for="email"></label>
        <input type="text" name="username" id="email" class="form-control" maxlength="60"/>
        <label for="password"></label>
        <input type="password" name="password" id="password" class="form-control"/>
    <input type="submit"/>
</form>
<%--<form:form method="post" modelAttribute="user">--%>
<%--    Email: <form:input path="email"/><br>--%>
<%--    <form:errors path="email"/><br>--%>
<%--    Password: <form:input path="password"/><br>--%>
<%--    <form:errors path="password"/>--%>
<%--    <input type="submit" value="Sign up"/>--%>
<%--&lt;%&ndash;    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>&ndash;%&gt;--%>
<%--</form:form>--%>
</body>
</html>
