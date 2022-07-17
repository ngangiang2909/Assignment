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
            <h2>FPT University For Student</h2>
        </div>
        <div class="taskbarhome">
            <div>
                <p>
                    <a href="subject">HOME</a>
                    <a> | </a>
                    <a>Group</a>
                    <a class="log">Student</a>
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
                                                            <c:forEach items="${requestScope.subject}" var="sub">
                                                                <a href="viewmark?sid=${requestScope.sid}&subid=${sub.subid}">${sub.subname}</a> (${sub.subcode}) <br/>
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
                                        <tr>
                                            <td rowspan="4">Progress Test</td>
                                            <td>PT 1</td>
                                            <td>3.3 %</td>
                                            <td>
                                                <c:if test="${requestScope.mark.pt1 == 0}">
                                                </c:if>  
                                                <c:if test="${requestScope.mark.pt1 != 0}">
                                                    ${requestScope.mark.pt1}
                                                </c:if>  
                                            </td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>PT 2</td>
                                            <td>3.3 %</td>
                                            <td>
                                                <c:if test="${requestScope.mark.pt2 == 0}">
                                                </c:if>  
                                                <c:if test="${requestScope.mark.pt2 != 0}">
                                                    ${requestScope.mark.pt2}
                                                </c:if>
                                            </td>
                                            <td></td>
                                        </tr>

                                        <tr>
                                            <td>PT 3</td>
                                            <td>3.3 %</td>
                                            <td>
                                                <c:if test="${requestScope.mark.pt3 == 0}">
                                                </c:if>  
                                                <c:if test="${requestScope.mark.pt3 != 0}">
                                                    ${requestScope.mark.pt3}
                                                </c:if>
                                            </td>
                                            <td></td>
                                        </tr>

                                        <tr>
                                            <td>Total</td>
                                            <td>10.0 %</td>
                                            <td></td>
                                            <td></td>
                                        </tr>

                                        <tr>
                                            <td rowspan="4">Workshop</td>
                                            <td>WS 1</td>
                                            <td>6.67 %</td>
                                            <td>
                                                <c:if test="${requestScope.mark.ws1 == 0}">
                                                </c:if>  
                                                <c:if test="${requestScope.mark.ws1 != 0}">
                                                    ${requestScope.mark.ws1}
                                                </c:if>
                                            </td>
                                            <td></td>
                                        </tr>

                                        <tr>
                                            <td>WS 2</td>
                                            <td>6.67 %</td>
                                            <td>
                                                <c:if test="${requestScope.mark.ws2 == 0}">
                                                </c:if>  
                                                <c:if test="${requestScope.mark.ws2 != 0}">
                                                    ${requestScope.mark.ws2}
                                                </c:if>
                                            </td>
                                            <td></td>
                                        </tr>

                                        <tr>
                                            <td>WS 3</td>
                                            <td>6.67 %</td>
                                            <td>
                                                <c:if test="${requestScope.mark.ws3 == 0}">
                                                </c:if>  
                                                <c:if test="${requestScope.mark.ws3 != 0}">
                                                    ${requestScope.mark.ws3}
                                                </c:if>
                                            </td>
                                            <td></td>
                                        </tr>

                                        <tr>
                                            <td>Total</td>
                                            <td>20.0 %</td>
                                            <td></td>
                                            <td></td>
                                        </tr>

                                        <tr>
                                            <td rowspan="2">Assignment</td>
                                            <td>ASS</td>
                                            <td>10.0 %</td>
                                            <td>
                                                <c:if test="${requestScope.mark.ass == 0}">
                                                </c:if>  
                                                <c:if test="${requestScope.mark.ass != 0}">
                                                    ${requestScope.mark.ass}
                                                </c:if>
                                            </td>
                                            <td></td>
                                        </tr>

                                        <tr>
                                            <td>Total</td>
                                            <td>10.0 %</td>
                                            <td></td>
                                            <td></td>
                                        </tr>

                                        <tr>
                                            <td rowspan="2">Practical Exam</td>
                                            <td>PE</td>
                                            <td>20.0 %</td>
                                            <td>
                                                <c:if test="${requestScope.mark.pe == 0}">
                                                </c:if>  
                                                <c:if test="${requestScope.mark.pe != 0}">
                                                    ${requestScope.mark.pe}
                                                </c:if>
                                            </td>
                                            <td></td>
                                        </tr>

                                        <tr>
                                            <td>Total</td>
                                            <td>20.0 %</td>
                                            <td></td>
                                            <td></td>
                                        </tr>


                                        <tr>
                                            <td rowspan="2">Final Exam</td>
                                            <td>FE</td>
                                            <td>20.0 %</td>
                                            <td>
                                                <c:if test="${requestScope.mark.fe == 0}">
                                                </c:if>  
                                                <c:if test="${requestScope.mark.fe != 0}">
                                                    ${requestScope.mark.fe}
                                                </c:if>
                                            </td>
                                            <td></td>
                                        </tr>

                                        <tr>
                                            <td>Total</td>
                                            <td>20.0 %</td>
                                            <td></td>
                                            <td></td>
                                        </tr>

                                    </tbody>
                                    <tfoot class="foot">
                                        <tr>
                                            <td rowspan="2">COURSE TOTAL</td>
                                            <td>AVG</td>
                                            <td colspan="3"></td>
                                        </tr>

                                        <tr>
                                            <td>STATUS</td>
                                            <td colspan="3">
                                                <font color="Green">Studying</font>
                                            </td>
                                        </tr>
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
