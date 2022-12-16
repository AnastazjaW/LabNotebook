<%--
  Created by IntelliJ IDEA.
  User: nasta
  Date: 12/14/2022
  Time: 4:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/views/header/header.jsp" %>
<div class="mt-4 d-flex flex-column">
    <div class="ml-2 d-flex">
        <c:choose>
            <c:when test="${not empty experimentToShow.protocol}">
                <a href="<c:url value="${pageContext.request.contextPath}/project/${project.id}/task/${task.id}/experiment/${experimentToShow.id}/add_protocol"/>"
                class = "btn btn-outline-info btn-sm">Change protocol</a>
            </c:when>
            <c:otherwise>
                <a href="<c:url value="${pageContext.request.contextPath}/project/${project.id}/task/${task.id}/experiment/${experimentToShow.id}/add_protocol"/>"
                   class="btn btn-outline-primary btn-sm">Add protocol</a>
            </c:otherwise>
        </c:choose>
    </div>
    <div class="d-flex justify-content-center" style="font-size:20px;">${experimentToShow.name}</div>
    <div class="d-flex justify-content-center" style="font-size:15px;">${experimentToShow.description}</div>
    <br>
    <div class="d-flex justify-content-center" style="font-size:18px;">Protocol of experiment</div>
    <div class="mt-4 d-flex justify-content-center">
        <c:choose>
            <c:when test="${not empty experimentToShow.protocol}">
                ${protocol.description}
            </c:when>
            <c:otherwise>
                No added protocols
            </c:otherwise>
        </c:choose>
    </div>
</div>
</body>
</html>
