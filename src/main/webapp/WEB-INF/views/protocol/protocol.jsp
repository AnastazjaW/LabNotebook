<%--
  Created by IntelliJ IDEA.
  User: nasta
  Date: 12/14/2022
  Time: 4:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/header/header.jsp" %>
<div class="mt-4 d-flex flex-column">
    <div class="d-flex justify-content-center" style="font-size:20px;">${protocolToShow.name}</div>
    <div class="d-flex justify-content-center" style="font-size:15px;">${protocolToShow.description}</div>
    <div class="d-flex justify-content-center" style="font-size:15px;">Last
        modification: ${protocolToShow.lastModificationDate}</div>
    <div class="mt-4 d-flex justify-content-center">
        <a href="<c:url value="${pageContext.request.contextPath}/protocol/delete/${protocolToShow.id}"/>"
           class="btn btn-outline-danger btn-sm" onclick="return confirm('Are you sure?')">Delete</a>
        <a href="<c:url value="${pageContext.request.contextPath}/protocol/edit/${protocolToShow.id}"/>"
           class="btn btn-outline-warning btn-sm">Edit</a>
    </div>
</div>
</body>
</html>
