<%--
  Created by IntelliJ IDEA.
  User: nasta
  Date: 12/2/2022
  Time: 9:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/views/header/header.jsp" %>
<div class="mt-4 d-flex flex-column">
    <div class="d-flex justify-content-center" style="font-size:25px;">Create project</div>
    <div class="mt-4 d-flex justify-content-center">
<form:form method="post" modelAttribute="project">
    Title: <form:input path="name"/><br>
    <form:errors path="name"/><br>
    Description: <form:textarea path="description"/><br>
    <form:errors path="description"/>
    Add people to project (press Ctrl for multiple adds): <form:select path="users" multiple="true" items="${users}" itemValue="id" itemLabel="fullName"/><br>
    <form:errors path="users"/>
    <input type="submit" class="btn btn-outline-primary btn-sm" value="Create project"/>
</form:form>
    </div>
</div>
</body>
</html>
