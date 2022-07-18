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
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>FPT University For Lecturer</title>
        <link rel="icon" type="image/x-icon" href="assets/img/favicon.ico" />
        <!-- Font Awesome icons (free version)-->
        <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Saira+Extra+Condensed:500,700" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Muli:400,400i,800,800i" rel="stylesheet" type="text/css" />
        <!-- Core theme CSS (includes Bootstrap)-->
    </head>
    <style>
        .tenweb{
            display: flex;
            margin-left: 10px;
            font-size: 25px;
        }
        .taskbarhome{
            background-color: #AD82D9;
            display: flex;
            padding-left: 10px;
        }
        .selectterm{
            font-size: 25px;
            text-align: center;
            margin: 15px;
        }
        .thenReport{
            font-size: 25px;
            text-align: center;
            margin: 15px;
        }
        .a{
            width: 110px;
            text-align: left;
        }
        .b{
            width: 500px;
            text-align: left;
        }
        .c{
            width: 500px;
            text-align: left;
        }
        .index{
            text-align: center;
        }
        .code, .name, .pt1, .ws1, .ass1{
            text-align: center;
        }
        .pe,.fe,.avg{
            text-align: center;
        }
        th{
            background-color: #AD82D9;
        }
        .log{
            padding-left: 480px
        }
    </style>
    <body>
        <div class="tenweb">
            <h2>FPT University For Lecturer</h2>
        </div>
        <div class="taskbarhome">
            <div>
                <p>
                    <a href="home">HOME</a>
                    <a> | </a>
                    <a>MARK</a>
                    <a class="log">Ngô Tùng Sơn</a>
                    <a> | </a>
                    <a href="logout">Logout</a>
                </p>
            </div>
        </div>
        <div>
            <div class="showlistclass">
                <table>
                    <tr>
                        <td valign='top'>
                            <div class="selectterm">
                                Select a term, course ...
                            </div>
                            <table>
                                <thead>
                                    <tr>
                                        <th>Course</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td class="b">
                                            <div>
                                                <table>
                                                    <tr>
                                                        <td>
                                                            <c:forEach items="${requestScope.lecsub}" var="ls">
                                                                <a href="grouplect?lid=${requestScope.lid}&subid=${ls.subid}">${ls.subname}</a> (${ls.subcode}) <br/>
                                                            </c:forEach>
                                                        </td>
                                                    </tr>
                                                </table>
                                            </div>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </body>

</html>
