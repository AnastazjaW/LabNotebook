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
        <a href="<c:url value="${pageContext.request.contextPath}/project/${project.id}/task/add"/>"
           class="btn btn-outline-primary btn-sm">New task</a>
    </div>
    <div class="d-flex justify-content-center" style="font-size:20px;">Project: ${project.name}</div>
    <div class="d-flex justify-content-center" style="font-size:15px;">Description: ${project.description}</div>
    <div class="d-flex justify-content-center" style="font-size:25px;">Tasks</div>
    <div class="mt-4 d-flex justify-content-center">
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
                                           class="btn btn-outline-danger btn-sm"
                                           onclick="return confirm('Are you sure?')">Mark as finished</a>
                                    </c:when>
                                    <c:otherwise>
                                        Finished
                                    </c:otherwise>
                                </c:choose>
                                <a href="<c:url value="${pageContext.request.contextPath}/project/${project.id}/task/delete/${task.id}"/>"
                                   class="btn btn-outline-danger btn-sm" onclick="return confirm('Are you sure?')">Delete</a>
                                <a href="<c:url value="${pageContext.request.contextPath}/project/${project.id}/task/edit/${task.id}"/>"
                                   class="btn btn-outline-warning btn-sm">Edit</a>
                                <a href="<c:url value="${pageContext.request.contextPath}/project/${project.id}/task/${task.id}/experiments"/>"
                                   class="btn btn-outline-info btn-sm">Show experiments</a>
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
    </div>
</div>
</body>
</html>
