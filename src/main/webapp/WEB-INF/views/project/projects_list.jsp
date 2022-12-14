<%--
  Created by IntelliJ IDEA.
  User: nasta
  Date: 12/3/2022
  Time: 12:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Projects</title>
</head>
<body>
<h1>Projects</h1>
<a href="<c:url value="${pageContext.request.contextPath}/project/add"/>">New project</a><br><br>
<table>
    <c:choose>
        <c:when test="${not empty projectsList}">
            <c:forEach items="${projectsList}" var="project">
                <tr>
                    <td>Project title: ${project.name}<br>
                        Start date: ${project.startDate}<br>
                        Finish date: ${project.finishDate}<br>
                        <c:choose>
                            <c:when test="${empty project.finishDate}">
                                <a href="<c:url value="${pageContext.request.contextPath}/project/finish/${project.id}"/>"
                                   class="btn btn-danger rounded-0 text-light m-1"
                                   onclick="return confirm('Are you sure?')">Finish project</a>
                            </c:when>
                        </c:choose>
                        <a href="<c:url value="${pageContext.request.contextPath}/project/delete/${project.id}"/>"
                           class="btn btn-danger rounded-0 text-light m-1" onclick="return confirm('Are you sure?')">Delete</a>
                        <a href="<c:url value="${pageContext.request.contextPath}/project/edit/${project.id}"/>">Edit</a>
                        <a href="<c:url value="${pageContext.request.contextPath}/project/${project.id}/tasks"/>">Show
                            details</a>
                        <br>
                    </td>
                </tr>
            </c:forEach>
        </c:when>
        <c:otherwise>
            No added projects
        </c:otherwise>
    </c:choose>
</table>
</body>
</html>
