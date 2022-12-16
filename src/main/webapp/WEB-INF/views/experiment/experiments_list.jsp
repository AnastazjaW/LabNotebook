<%--
  Created by IntelliJ IDEA.
  User: nasta
  Date: 12/11/2022
  Time: 10:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/views/header/header.jsp" %>
<div class="mt-4 d-flex flex-column">
    <div class="ml-2 d-flex">
        <a href="<c:url value="${pageContext.request.contextPath}/project/${project.id}/task/${task.id}/experiment/add"/>"
           class="btn btn-outline-primary btn-sm">New experiment</a>
    </div>
    <div class="d-flex justify-content-center" style="font-size:20px;">Task: ${task.name}</div>
    <div class="d-flex justify-content-center" style="font-size:15px;">Description: ${task.description}</div>
    <div class="d-flex justify-content-center" style="font-size:25px;">Experiments</div>
    <div class="mt-4 d-flex justify-content-center">
<table>
    <c:choose>
        <c:when test="${not empty experimentsList}">
            <c:forEach items="${experimentsList}" var="experiment">
                <tr>
                    <td>${experiment.name}<br>
                        Last modification: ${experiment.lastModificationDate}<br>
                        <c:choose>
                            <c:when test="${experiment.isFinished == 0}">
                                <a href="<c:url value="${pageContext.request.contextPath}/project/${project.id}/task/${task.id}/experiment/finish/${experiment.id}"/>"
                                   class="btn btn-outline-danger btn-sm"
                                   onclick="return confirm('Are you sure?')">Mark as finished</a>
                            </c:when>
                            <c:otherwise>
                                Finished
                            </c:otherwise>
                        </c:choose>
                        <a href="<c:url value="${pageContext.request.contextPath}/project/${project.id}/task/${task.id}/experiment/delete/${experiment.id}"/>" class="btn btn-outline-danger btn-sm"
                           onclick="return confirm('Are you sure?')">Delete</a>
                        <a href="<c:url value="${pageContext.request.contextPath}/project/${project.id}/task/${task.id}/experiment/edit/${experiment.id}"/>" class="btn btn-outline-warning btn-sm">Edit</a>
                        <a href="<c:url value="${pageContext.request.contextPath}/project/${project.id}/task/${task.id}/experiment/${experiment.id}"/>" class="btn btn-outline-info btn-sm">Show
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
    </div>
</div>
</body>
</html>
