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
        <a href="<c:url value="${pageContext.request.contextPath}/protocol/add"/>"
           class="btn btn-outline-primary btn-sm">New protocol</a>
    </div>
    <div class="d-flex justify-content-center" style="font-size:25px;">Protocols</div>
    <div class="mt-4 d-flex justify-content-center">
        <table>
            <c:choose>
                <c:when test="${not empty protocolsList}">
                    <c:forEach items="${protocolsList}" var="protocol">
                        <tr>
                            <td>${protocol.name}<br>
                                Last modification: ${protocol.lastModificationDate}<br>
                                <a href="<c:url value="${pageContext.request.contextPath}/protocol/delete/${protocol.id}"/>"
                                   class="btn btn-outline-danger btn-sm" onclick="return confirm('Are you sure?')">Delete</a>
                                <a href="<c:url value="${pageContext.request.contextPath}/protocol/edit/${protocol.id}"/>"
                                   class="btn btn-outline-warning btn-sm">Edit</a>
                                <a href="<c:url value="${pageContext.request.contextPath}/protocol/${protocol.id}"/>"
                                   class="btn btn-outline-info btn-sm">Show details</a>
                                <br>
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
    </div>
</div>
</body>
</html>
