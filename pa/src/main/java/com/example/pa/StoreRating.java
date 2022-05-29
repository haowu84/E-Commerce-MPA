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
    
    public void init (ServletConfig config) throws ServletException {
        
        super.init(config);

        DBCredentials db = new DBCredentials();
        conn = db.getConnection(); 
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
            String sql = "UPDATE orderitems SET rating = ? WHERE item_id = ?";

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

        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
    }


    public void destroy () {
        if (conn != null)
            try {
                conn.close();
            } catch (SQLException ignore) {}
    }
}