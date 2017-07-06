<%@ page import="bean.Blog" %>
<%@ page import="java.util.List" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page session="false" %>
<%
    response.setHeader("Cache-Control", "no-cache"); //Forces caches to obtain a new copy of the page 		from the origin server
    response.setHeader("Cache-Control", "no-store"); //Directs caches not to store the page under any 		circumstance
    response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
    response.setHeader("Pragma", "no-cache"); //HTTP 1.0 backward compatibility
%>
<html>
<head>
    <title>Blog|To The New</title>
</head>

<body>

<hr>
<a href="logout" style="float:left">
    <button type="button">Logout</button>
</a>
<h1 align="center">To The New Blog</h1>
<form action="AddBlog" method="post" style="float:left">
    <label for="blogcontent">Add new Blog here+</label><br>
    <textarea id="blogcontent" name="blogContent" cols="30" rows="15"></textarea><br>
    <input type="submit" value="Post">
</form>
<div style="float:right;margin-right:250px">
    <h3>Blog posts</h3>
    <%
        List<Blog> blogList = (List<Blog>) request.getAttribute("blogList");
        for (int i = 0; i < blogList.size(); i++) {
            out.print(blogList.get(i).getBlogid() + " " + blogList.get(i).getContent() + "<br>");
        }
    %>
</div>
</body>
</html>
