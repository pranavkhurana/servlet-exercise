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
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/AddBlog")
public class AddBlog extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session=request.getSession(false);
        if(session!=null) {
            String blogContent = (String) request.getParameter("blogContent");
            if (blogContent!=null  && !blogContent.isEmpty() && BlogDao.saveBlog(blogContent) > 0) {
                out.print("<p style='color:green'>Saved Successfully.</p>");
            }
            else if(blogContent.isEmpty()||blogContent==null){
                out.print("<p style='color:red'>Blog content can't be empty.</p>");
            }
            else {
                out.print("<p style='color:red'>Some error occured.</p>");
            }
            List<Blog> blogList = BlogDao.getBlogs();
            request.setAttribute("blogList", blogList);
            request.getRequestDispatcher("blog.jsp").include(request, response);
        }
        else{
            out.print("<p style='color:red'>Please login first.</p>");
            request.getRequestDispatcher("login.jsp").include(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
