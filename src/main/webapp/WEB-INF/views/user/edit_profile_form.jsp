<%--
  Created by IntelliJ IDEA.
  User: nasta
  Date: 12/16/2022
  Time: 4:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/views/header/header.jsp" %>
<div class="mt-4 d-flex flex-column">
  <div class="d-flex justify-content-center" style="font-size:25px;">My profile</div>
  <div class="mt-4 d-flex justify-content-center">
    <form:form method="post" modelAttribute="authUser">
      First name: <form:input path="firstName"/><br>
      <form:errors path="firstName"/><br>
      Last name: <form:input path="lastName"/><br>
      <form:errors path="lastName"/><br>
      Degree: <form:select path="degree"><br>
      <form:option value="-" label="choose degree"/>
      <form:options items="${degrees}"/>
      <form:errors path="degree"/><br>
    </form:select><br>
      Affiliation: <form:input path="affiliation"/><br>
      <form:errors path="affiliation"/><br>
      <input type="submit" class="btn btn-lg btn-primary" value="Save"/>
      <a class="btn btn-lg btn-secondary" href="<c:url value="${pageContext.request.contextPath}/last_task"/>">Cancel</a>
    </form:form>
  </div>
</div>
</body>
</html>
