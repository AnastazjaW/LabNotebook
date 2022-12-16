<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <style>
        <%@include file="/WEB-INF/css/current_tasks.css" %>
    </style>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>LabNotebook</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="<c:url value="${pageContext.request.contextPath}/last_task"/>"
       style="font-size:30px;">LabNotebook</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="<c:url value="${pageContext.request.contextPath}/project/list"/>" style="font-size:20px;">Projects</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link"
                   href="<c:url value="${pageContext.request.contextPath}/protocols/list"/>" style="font-size:20px;">Protocols</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link"
                   href="<c:url value="${pageContext.request.contextPath}/reports/list"/>" style="font-size:20px;">Reports</a>
            </li>
                  <li class="nav-item active">
                    <a class="nav-link" href="<c:url value="${pageContext.request.contextPath}/profile"/>" style="font-size:20px;">My profile</a>
                  </li>
            <li class="nav-item active">
                <a class="nav-link" href="<c:url value="${pageContext.request.contextPath}/logout"/>" style="font-size:20px;">Logout</a>
            </li>
        </ul>
    </div>
</nav>
