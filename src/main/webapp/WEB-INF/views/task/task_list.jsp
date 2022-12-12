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
<h1>Tasks</h1>
<a href="<c:url value="${pageContext.request.contextPath}/task/add"/>">New task</a><br><br>
<table>
    <c:choose>
        <c:when test="${!(taskList == null)}">
            <c:forEach items="${taskList}" var="task">
                <tr>
                    <td>Project title: ${task.name}<br>
                        Start date: ${task.startDate}<br>
                        Finish date: ${task.finishDate}<br>
                        <a href="<c:url value="${pageContext.request.contextPath}/project/delete/${task.id}"/>"
                           class="btn btn-danger rounded-0 text-light m-1" onclick="return confirm('Are you sure?')">Delete</a>
                        <a href="<c:url value="${pageContext.request.contextPath}/project/edit/${task.id}"/>">Edit</a>
                        <a href="<c:url value="${pageContext.request.contextPath}/task/list/${task.id}"/>">Show
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
