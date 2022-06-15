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
        <style>
            table, th, td {
                border: 1px solid black;
            }
            .anh{
                width: 100px;
                height: 100px;
            }
            .gender{
                width: 50px;
                height: 50px;
            }
            th{
                background: #6610f2;
            }
        </style>
    </head>
    <body>
        <form action="list" method="get">
            <table>
                <tr>
                    <th>Index</th>
                    <th>Img</th>
                    <th>Member</th>
                    <th>Code</th>
                    <th>Name</th>
                    <th>Gender</th>
                    <th>Dob</th>
                    <th>Address</th>
                </tr>
                <c:forEach items="${requestScope.student}" var="s">
                    <tr>
                        <td>${s.sid}</td>
                        <td><img class="anh" src="${s.simg}" alt=""/></td>
                        <td>${s.smember}</td>
                        <td>${s.scode}</td>
                        <td>${s.sname}</td>
                        <td><img class="gender" src="assets/img/${s.sgender?"male-icon.png":"female-icon.png"}" alt="" "/></td>
                        <td>${s.sdob}</td>
                        <td>${s.saddress}</td>
                    </tr>
                </c:forEach>
            </table>
        </form>
    </body>
</html>
