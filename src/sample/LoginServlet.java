package sample;

import bean.Blog;
import dao.BlogDao;
import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out= response.getWriter();

        List<Blog> blogList = BlogDao.getBlogs();
        request.setAttribute("blogList",blogList);

        HttpSession session=request.getSession(false);
        if(session!=null){
            request.getRequestDispatcher("blog.jsp").forward(request,response);
        }
        else{
            String username=request.getParameter("username");
            String password=request.getParameter("password");

            if(UserDao.isUser(username,password)){
                session=request.getSession();
                session.setAttribute("name",username);
                request.getRequestDispatcher("blog.jsp").forward(request,response);
            }
            else{
                out.print("<p style='color:red'>Invalid Login. Please try again!</p>");
                request.getRequestDispatcher("login.jsp").include(request,response);
            }

        }
        out.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}