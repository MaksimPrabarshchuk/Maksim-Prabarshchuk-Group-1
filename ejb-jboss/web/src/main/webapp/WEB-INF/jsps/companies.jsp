<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello Companies</title>
</head>
<body>
<c:forEach items="${companies}" var="company">
    <c:out value="${company.name}"/><br/>
</c:forEach>
</body>
</html>