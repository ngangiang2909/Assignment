<%-- 
    Document   : viewmark
    Created on : Jun 27, 2022, 11:53:26 PM
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
        <title>FPT University Academic Portal</title>
        <link rel="icon" type="image/x-icon" href="assets/img/favicon.ico" />
        <!-- Font Awesome icons (free version)-->
        <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Saira+Extra+Condensed:500,700" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Muli:400,400i,800,800i" rel="stylesheet" type="text/css" />
        <!-- Core theme CSS (includes Bootstrap)-->
    </head>
    <style>
        .tenWeb{
            display: flex;
            margin-left: 10px;
            font-size: 25px;
        }
        .taskbarHome{
            background-color: pink;
            display: flex;
            padding-left: 10px ;
        }
        .gradeReport{
            font-size: 25px;
            font-family: serif;
            padding-left: 10px;
        }
        .selectTerm{
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
            width: 580px;
            text-align: left;
        }
        th{
            background-color: pink;
            display: table-cell;
        }
        .foot{
            background-color: pink;
        }
        .log{
            padding-left: 650px
        }
    </style>
    <body>
        <div class="tenWeb">
            <h2>FPT University Academic Portal</h2>
        </div>
        <div class="taskbarHome">
            <div>
                <p>
                    <a href="home">HOME</a>
                    <a> | </a>
                    <a>GRADE</a>
                    <a class="log">Thành Hữu Ngân Giang</a>
                    <a> | </a>
                    <a href="logout">Logout</a>
                </p>
            </div>

        </div>
        <div class="gradeReport">
            <p>Grade report for Thành Hữu Ngân Giang (HE153205)</p>
        </div>
        <div>
            <div class="marktable">
                <table>
                    <tr>
                        <td valign='top'>
                            <div class="selectTerm">
                                Select a term, course ...
                            </div>
                            <table>
                                <thead>
                                    <tr>
                                        <th>Term</th>
                                        <th>Course</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td class="a">
                                            <div>
                                                <table>
                                                    <tr>
                                                        <td>Summer 2022</td>
                                                    </tr>
                                                </table>
                                            </div>
                                        </td>
                                        <td class="b">
                                            <div>
                                                <table>
                                                    <tr>
                                                        <td>
                                                            <c:forEach items="${requestScope.subject}" var="s">                               
                                                                <a  href="assessment?sid=${requestScope.sid}&subid=${s.subid}">${s.subname}</a>(${s.subcode})</br>                                 
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
                        <td valign='top'>
                            <div>
                                <table>
                                    <caption class="thenReport">... then see report</caption>
                                    <tr>
                                        <th>Grade category</th>
                                        <th>Grade item</th>
                                        <th>Weight</th>
                                        <th>Value</th>
                                        <th>Comment</th>
                                    </tr>
                                    <tbody>
                                        <c:forEach items="${requestScope.assessment}" var="a">
                                            <tr>

                                                <td></td>
                                                <td>${a.aname}</td>
                                                <td>${a.weight}%</td>
                                                <c:forEach items="${requestScope.exam}" var= "e">
                                                    
                                                        <c:if test="${a.aname eq e.getAssessment().aname}">
                                                            <td>${e.score}</td>
                                                        </c:if>
                                                    
                                                </c:forEach>
                                                <td></td>

                                            </tr>
                                        </c:forEach>
                                    </tbody>

                                    <tfoot>
                                        <tr>
                                            <td rowspan="2">Course total</td>
                                            <td>Average</td>
                                            <td colspan="3">${requestScope.average}</td>
                                        </tr>

                                        <tr>
                                            <td>Status</td>
                                            <td colspan="3">
                                                <c:if test="${requestScope.average >= 5}">
                                                    <font color="Green">Pass</font>
                                                </c:if>
                                                <c:if test="${requestScope.average < 5}">
                                                    <font color="Red">Not Pass</font>
                                                </c:if>      
                                                <c:if test="${requestScope.average == 5}">
                                                    <font color="Green">Study</font>
                                                </c:if>    
                                            </td></tr>
                                    </tfoot>
                                </table>
                            </div>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </body>
</html>
