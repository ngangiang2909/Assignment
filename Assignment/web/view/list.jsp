<%-- 
    Document   : list
    Created on : Jun 11, 2022, 6:30:57 PM
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
        <form action="list" method="get">
            <table>
                <tr>
                    <td>Id</td>
                    <td>Code</td>
                    <td>Member</td>
                    <td>Name</td>
                    <td>Gender</td>
                    <td>Dob</td>
                    <td>Img</td>
                    <td>Address</td>
                </tr>
                <c:forEach items="${requestScope.student}" var="s">
                    <tr>
                        <td>${s.sid}</td>
                        <td>${s.scode}</td>
                        <td>${s.smember}</td>
                        <td>${s.sname}</td>
                        <td>${s.sgender}</td>
                        <td>${s.sdob}</td>
                        <td><img src="${s.simg}" alt=""/></td>
                        <td>${s.saddress}</td>
                    </tr>
                </c:forEach>
            </table>
        </form>
    </body>
</html>
