<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="AddCompanyServlet.do">
    <label for="name" wicket:id="nameLabel">Company Name:</label>
    <input name="name" type="text" wicket:id="nameInput"/>
    <input type="submit" value="Add"/>
</form>