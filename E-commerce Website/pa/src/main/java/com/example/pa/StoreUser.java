package com.example.pa;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;

@WebServlet(name = "storeuser", value = "/storeuser")
public class StoreUser extends HttpServlet{

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

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        PreparedStatement ps = null;
        try {
            String sql = "INSERT INTO user (name, email, phone, address, city, state, zip_code, card_type, card_num, exp_date, cvc) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        
            ps = conn.prepareStatement(sql);
            ps.setString(1, request.getParameter("name"));
            ps.setString(2, request.getParameter("email"));
            ps.setString(3, request.getParameter("phone"));
            ps.setString(4, request.getParameter("address"));
            ps.setString(5, request.getParameter("city"));
            ps.setString(6, request.getParameter("state"));
            ps.setString(7, request.getParameter("zipcode"));
            ps.setString(8, request.getParameter("cards"));
            ps.setString(9, request.getParameter("cardnum"));
            ps.setString(10, request.getParameter("expdate"));
            ps.setString(11, request.getParameter("cvc"));
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

            RequestDispatcher rd = request.getRequestDispatcher("storeproduct");
            rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    public void destroy () {
        if (conn != null)
            try {
                conn.close();
            } catch (SQLException ignore) {}
    }
    
}
