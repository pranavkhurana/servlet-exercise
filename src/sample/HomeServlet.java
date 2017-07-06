package sample;

import bean.Blog;
import dao.BlogDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/")
public class HomeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession(false);
        if(session!=null) {
            List<Blog> blogList = BlogDao.getBlogs();
            request.setAttribute("blogList",blogList);
            request.getRequestDispatcher("blog.jsp").forward(request,response);
        }
        else{
            request.getRequestDispatcher("login.jsp").include(request,response);
        }
    }
}