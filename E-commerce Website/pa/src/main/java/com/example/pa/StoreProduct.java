package com.example.pa;

import java.io.*;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;

@WebServlet(name = "storeproduct", value = "/storeproduct")
public class StoreProduct extends HttpServlet{

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

        HttpSession session = request.getSession(true);
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");

        PreparedStatement ps = null;
        try {

            String sql = "INSERT INTO orderitem (ship_method, quantity, product_name, user_name) " +
            "VALUES (?, ?, ?, ?);";

            ps = conn.prepareStatement(sql);
            for (CartItem item: cart)
            {
                ps.setString(1, request.getParameter("method"));
                ps.setInt(2, item.getQuantity());
                ps.setString(3, item.getName());
                ps.setString(4, request.getParameter("name"));

                ps.executeUpdate();
            }
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

            RequestDispatcher rd = request.getRequestDispatcher("orderdetail");
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
