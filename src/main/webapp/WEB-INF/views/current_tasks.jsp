<%--
  Created by IntelliJ IDEA.
  User: nasta
  Date: 12/13/2022
  Time: 3:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <style><%@include file="/WEB-INF/css/current_tasks.css"%></style>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Current tasks</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">LabNotebook</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="<c:url value="${pageContext.request.contextPath}/logout"/>">Logout</a>
            </li>
        </ul>
    </div>
</nav>


<h4>Current tasks</h4>
<table>
    <c:choose>
        <c:when test="${not empty currentTasks}">
            <c:forEach items="${currentTasks}" var="task">
                <tr>
                    <td>Task: ${task.name}<br>
                        <a href="<c:url value="${pageContext.request.contextPath}/project/${project.id}/task/${task.id}/experiments"/>">Show
                            details</a>
                        <br>
                    </td>
                </tr>
            </c:forEach>
        </c:when>
        <c:otherwise>
            No current tasks
        </c:otherwise>
    </c:choose>
</table>
</body>
</html>