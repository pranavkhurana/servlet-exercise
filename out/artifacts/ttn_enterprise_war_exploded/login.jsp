<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page session="false" %>
<html>
<head>
    <style>
    </style>

    <title>Login|To the new blog</title>
</head>
<body>
<div align="center">
<h1>To The New Blog</h1>
<div>
    <table>
        <form action="login" method="post">
            <tr>
                <td>Username</td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="login"></td>
            </tr>
        </form>
    </table>
</div>
    Username:test | Password:pass
</div>
</body>
</html>
