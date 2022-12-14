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
    <title>Experiments</title>
</head>
<body>
<h3>Project: ${project.name}</h3>
<h3>Task: ${task.name}</h3>
<h4>Description: ${task.description}</h4>
<h3>Experiments</h3>

<a href="<c:url
        value="${pageContext.request.contextPath}/project/${project.id}/task/${task.id}/experiment/add"/>">New
    experiment</a><br><br>
<table>
    <c:choose>
        <c:when test="${not empty experimentsList}">
            <c:forEach items="${experimentsList}" var="experiment">
                <tr>
                    <td> Task: ${experiment.name}<br>
                        Last modification: ${experiment.lastModificationDate}<br>
                        <c:choose>
                            <c:when test="${experiment.isFinished == 0}">
                                <a href="<c:url value="${pageContext.request.contextPath}/project/${project.id}/task/${task.id}/experiment/finish/${experiment.id}"/>"
                                   class="btn btn-danger rounded-0 text-light m-1"
                                   onclick="return confirm('Are you sure?')">Mark as finished</a>
                            </c:when>
                            <c:otherwise>
                                Finished
                            </c:otherwise>
                        </c:choose>
                        <a href="<c:url value="${pageContext.request.contextPath}/project/${project.id}/task/${task.id}/experiment/delete/${experiment.id}"/>"
                           class="btn btn-danger rounded-0 text-light m-1" onclick="return confirm('Are you sure?')">Delete</a>
                        <a href="<c:url value="${pageContext.request.contextPath}/project/${project.id}/task/${task.id}/experiment/edit/${experiment.id}"/>">Edit</a>
                        <a href="<c:url value="${pageContext.request.contextPath}/project/${project.id}/task/${task.id}/experiment/${experiment.id}"/>">Show
                            details</a>
                        <br>
                    </td>
                </tr>
            </c:forEach>
        </c:when>
        <c:otherwise>
            No added experiments
        </c:otherwise>
    </c:choose>
</table>
</body>
</html>
