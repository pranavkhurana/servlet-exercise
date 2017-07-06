package dao;

import bean.Blog;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BlogDao {
    public static Connection getConnection(){
        Connection con=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","");
        }catch(Exception e) {System.out.println(e);}
        return con;
    }
    public static int saveBlog(String blogContent){
        int status=0;
        try{

            Connection con=BlogDao.getConnection();
            PreparedStatement ps=con.prepareStatement("insert into blog(content) VALUES (?)");

            ps.setString(1,blogContent);
            status=ps.executeUpdate();

            con.close();

        }catch(Exception e){
            System.out.println(e);
        }
        return status;
    }
    public static List<Blog> getBlogs(){
        List<Blog> list=new ArrayList<>();
        try{
            Connection con=BlogDao.getConnection();
            PreparedStatement ps=con.prepareStatement("select * from blog");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                list.add(new Blog(rs.getInt(1),rs.getString(2)));
            }
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
