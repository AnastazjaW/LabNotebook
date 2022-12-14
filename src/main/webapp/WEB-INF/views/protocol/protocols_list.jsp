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
    <title>Protocols</title>
</head>
<body>
<h3>Protocols</h3>
<a href="<c:url value="${pageContext.request.contextPath}/protocol/add"/>">New protocol</a><br><br>
<table>
    <c:choose>
        <c:when test="${not empty protocolsList}">
            <c:forEach items="${protocolsList}" var="protocol">
                <tr>
                    <td>Name: ${protocol.name}<br>
                        Last modification: ${protocol.lastModificationDate}<br>
                        <a href="<c:url value="${pageContext.request.contextPath}/protocol/delete/${protocol.id}"/>"
                           class="btn btn-danger rounded-0 text-light m-1" onclick="return confirm('Are you sure?')">Delete</a>
                        <a href="<c:url value="${pageContext.request.contextPath}/protocol/edit/${protocol.id}"/>">Edit</a>
                        <a href="<c:url value="${pageContext.request.contextPath}/protocol/${protocol.id}"/>">Show
                            details</a>
                        <br>
                    </td>
                </tr>
            </c:forEach>
        </c:when>
        <c:otherwise>
            No added protocols
        </c:otherwise>
    </c:choose>
</table>
</body>
</html>
