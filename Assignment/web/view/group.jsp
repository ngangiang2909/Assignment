<%-- 
    Document   : group
    Created on : Jun 18, 2022, 10:20:54 PM
    Author     : asus
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table>
    <thead>
        <tr>
            <th>Index</th>
            <th>Course</th>
        </tr>
    </thead>
    <c:forEach items="${requestScope.groups}" var="g">

        <tr>
            <td>${g.gid}</td>
            <td><a href="list?gid=${g.gid}">${g.gname}</a></td>
        </tr>

    </c:forEach>
        </table>
</body>
</html>
