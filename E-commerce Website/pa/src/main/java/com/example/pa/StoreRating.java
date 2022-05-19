package com.example.pa;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;

@WebServlet(name="storerating", urlPatterns = "/storerating")
public class StoreRating extends HttpServlet
{
    Connection conn;
    final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    final String DB_URL="jdbc:mysql://localhost:3306/shop";
    
    public void init (ServletConfig config) throws ServletException {
        
        super.init(config);

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, DBCredentials.USER, DBCredentials.PASS);         
        } catch (ClassNotFoundException e) {
            throw new UnavailableException("JDBCDemoServlet.init() ClassNotFoundException: " + e.getMessage());
        } catch (SQLException e) {
            throw new UnavailableException("JDBCDemoServlet.init() SQLException: " + e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String id = request.getParameter("id");
        String rating = request.getParameter("rating");

        PreparedStatement ps = null;

        try {    
            String sql = "UPDATE orderitem SET rating = ? WHERE item_id = ?";

            ps = conn.prepareStatement(sql);

            ps.setInt(1, Integer.parseInt(rating));
            ps.setInt(2, Integer.parseInt(id));

            ps.executeUpdate();
            ps.close();
        } catch(SQLException se){
            out.println(se);
        } catch(Exception e){
            out.println(e);
        } finally{
            try{
                if(ps!=null)
                ps.close();
            } catch(SQLException ignore) {}
        }

        RequestDispatcher rd = request.getRequestDispatcher("productlist");
        rd.forward(request, response);
    }


    public void destroy () {
        if (conn != null)
            try {
                conn.close();
            } catch (SQLException ignore) {}
    }
}