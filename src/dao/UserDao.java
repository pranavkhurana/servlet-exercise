package dao;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {
    public static Connection getConnection(){
        Connection con=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","");
        }catch(Exception e) {System.out.println(e);}
        return con;
    }
    public static boolean isUser(String username,String password){
        System.out.println(username+" "+password);
        boolean status=false;
        try{

            Connection con=UserDao.getConnection();
            PreparedStatement ps=con.prepareStatement("select * from user where exists(select userid from user where username=? and password=?)");

            ps.setString(1,username);
            ps.setString(2,password);

            ResultSet rs=ps.executeQuery();
            status=rs.next();
            System.out.println(status);

        }catch(Exception e){
            System.out.println(e);
        }
        return status;
    }
}
