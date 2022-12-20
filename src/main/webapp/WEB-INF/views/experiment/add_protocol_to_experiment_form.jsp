<%--
  Created by IntelliJ IDEA.
  User: nasta
  Date: 12/14/2022
  Time: 4:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/views/header/header.jsp" %>
<div class="mt-4 d-flex flex-column">
    <div class="d-flex justify-content-center" style="font-size:40px;">Choose protocol</div>
    <div class="mt-4 d-flex justify-content-center">
        <form:form method="post" modelAttribute="experimentToAddProtocol">
            <form:select path="protocol" items="${protocols}" itemValue="id" itemLabel="name"/><br>
            <input type="submit" class="btn btn-outline-primary btn-sm" value="Add protocol to experiment"/>
        </form:form>
    </div>
</div>
</body>
</html>
