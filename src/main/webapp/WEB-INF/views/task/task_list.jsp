<%--
  Created by IntelliJ IDEA.
  User: nasta
  Date: 12/11/2022
  Time: 10:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Tasks</title>
</head>
<body>
<h3>Project: ${project.name}</h3>
<h4>Description: ${project.description}</h4>
<h4>Participants: </h4>
<table>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.firstName} ${user.lastName}, ${user.degree}  ${user.affiliation}</td>
        </tr>
    </c:forEach>
</table>
<h3>Tasks</h3>
<a href="<c:url value="${pageContext.request.contextPath}/project/${project.id}/task/add"/>">New task</a><br><br>
<table>
    <c:choose>
        <c:when test="${not empty taskList}">
            <c:forEach items="${taskList}" var="task">
                <tr>
                    <td>Task: ${task.name}<br>
                        Last modification: ${task.lastModificationDate}<br>
                        <c:choose>
                            <c:when test="${task.isFinished == 0}">
                                <a href="<c:url value="${pageContext.request.contextPath}/project/${project.id}/task/finish/${task.id}"/>"
                                   class="btn btn-danger rounded-0 text-light m-1"
                                   onclick="return confirm('Are you sure?')">Mark as finished</a>
                            </c:when>
                            <c:otherwise>
                                Finished
                            </c:otherwise>
                        </c:choose>
                        <a href="<c:url value="${pageContext.request.contextPath}/project/${project.id}/task/delete/${task.id}"/>"
                           class="btn btn-danger rounded-0 text-light m-1" onclick="return confirm('Are you sure?')">Delete</a>
                        <a href="<c:url value="${pageContext.request.contextPath}/project/${project.id}/task/edit/${task.id}"/>">Edit</a>
                        <a href="<c:url value="${pageContext.request.contextPath}/project/${project.id}/task/${task.id}/experiments"/>">Show
                            details</a>
                        <br>
                    </td>
                </tr>
            </c:forEach>
        </c:when>
        <c:otherwise>
            No added tasks
        </c:otherwise>
    </c:choose>
</table>
</body>
</html>
