<%--
  Created by IntelliJ IDEA.
  User: nasta
  Date: 12/13/2022
  Time: 3:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/views/header/header.jsp" %>
<div class="mt-4 d-flex flex-column">
    <div class="d-flex justify-content-center" style="font-size:25px;">Last task</div>
    <div class="mt-4 d-flex justify-content-center">
        <table>
            <c:choose>
                <c:when test="${null != lastTask}">
                    ${lastTask.name}<br>
                    Last modification: ${lastTask.lastModificationDate}
                    <div>
                        <a href="<c:url value="${pageContext.request.contextPath}/project/${project.id}/task/${lastTask.id}/experiments"/>" class="btn btn-primary btn-sm">Show
                            details</a>
                    </div>
                    <br>
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
