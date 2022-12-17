<%--
  Created by IntelliJ IDEA.
  User: nasta
  Date: 12/3/2022
  Time: 12:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/views/header/header.jsp" %>
<div class="mt-4 d-flex flex-column">
    <div class="ml-2 d-flex">
        <a href="<c:url value="${pageContext.request.contextPath}/project/add"/>"
           class="btn btn-outline-primary btn-sm">New project</a>
    </div>
    <div class="d-flex justify-content-center" style="font-size:25px;">Projects</div>
    <div class="mt-4 d-flex justify-content-center">
        <table>
            <c:choose>
                <c:when test="${not empty projectsList}">
                    <c:forEach items="${projectsList}" var="project">
                        <tr>
                            <td>${project.name}<br>
                                Start date: ${project.startDate}<br>
                                Finish date: ${project.finishDate}<br>
                                Participants:
                                <c:forEach items="${project.users}" var="user">
                                    ${user.firstName} ${user.lastName}, ${user.degree}  (${user.affiliation});
                                </c:forEach> <br>
                                <c:choose>
                                    <c:when test="${empty project.finishDate}">
                                        <a href="<c:url value="${pageContext.request.contextPath}/project/finish/${project.id}"/>"
                                           class="btn btn-outline-danger btn-sm"
                                           onclick="return confirm('Are you sure?')">Finish project</a>
                                    </c:when>
                                </c:choose>
                                <a href="<c:url value="${pageContext.request.contextPath}/project/delete/${project.id}"/>"
                                   class="btn btn-outline-danger btn-sm" onclick="return confirm('Are you sure?')">Delete</a>
                                <a href="<c:url value="${pageContext.request.contextPath}/project/edit/${project.id}"/>"
                                   class="btn btn-outline-warning btn-sm">Edit</a>
                                <a href="<c:url value="${pageContext.request.contextPath}/project/${project.id}/tasks"/>"
                                   class="btn btn-outline-info btn-sm">Show
                                    tasks</a>
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
    </div>
</div>
</body>
</html>
