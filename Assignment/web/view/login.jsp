<%-- 
    Document   : login
    Created on : Jun 11, 2022, 2:56:02 PM
    Author     : asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/login.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    </head>
    <body>
        <div class="wrapper fadeInDown">
            <div id="formContent">
<!--                 Tabs Titles -->

<!--                 Icon -->
                <div class="fadeIn first">
                    <img src="../assets/img/fptuniversity.png" id="icon" alt="User Icon"/>
                </div>

<!--                 Login Form -->
            <form action="login" method="POST">
                <input type="text" id="login" class="fadeIn second" name="username" placeholder="login">
                <input type="password" id="login" class="fadeIn third" name="password" placeholder="password">
                <input type="submit" class="fadeIn fourth" value="Log In">
            </form>
            </div>
        </div>
    </body>
</html>
