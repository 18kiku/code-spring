<%--
  Created by IntelliJ IDEA.
  User: hwangjeonghwan
  Date: 2022/09/06
  Time: 6:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h4><c:out value="${exception.getMessage()}"></c:out></h4>
    <ul>
        <c:forEach items="${exception.getStackTrace()}" var="stack">
            <li><c:out value="${stack}"></c:out> </li>
        </c:forEach>
    </ul>
</body>
</html>
