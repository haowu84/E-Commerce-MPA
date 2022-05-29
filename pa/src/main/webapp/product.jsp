<%@ page import="javax.xml.crypto.Data" %>
<%@ page import="java.sql.*" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="com.example.pa.DBCredentials" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
    <link rel="stylesheet" href="products.css">
    <title>Product</title>
</head>
<body>
    <jsp:include page="navbar.html" />
    <h1 align="center">Product Detail</h1>
    <div class="container">
    <div class="row gy-4">

    <%
    DBCredentials db = new DBCredentials();
    Connection conn = db.getConnection();
    PreparedStatement ps = null;
    String pid = request.getParameter("pid");

    try {
        ps = conn.prepareStatement("SELECT title, category, color, price, rating, url " +
        "FROM products " +
        "WHERE id = ?");
        ps.setInt(1, Integer.parseInt(pid));
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String title = rs.getString("title");
            String category = rs.getString("category");
            String color = rs.getString("color");
            Double price = rs.getDouble("price");
            Integer rating = rs.getInt("rating");
            String url = "./sources" + rs.getString("url");
    %>
            <div class="container-fluid mt-5">
                <div class="row">
                    <div class="col-md-5">
                        <img class="w-100" src=<%=url%>>
                    </div>

                    <div class="col-md-7">
                        <h2> <%=title%> </h2>
                        <h3> <%=category%> </h3>
                        <h3> <%=color%> </h3>
                        <h3> $<%=price%> </h3>
                        <h3> <%=rating%> Stars</h3>
                        <div class="pb-2">
                            <jsp:include page="button.html" />
                        </div>
                    </div>
                </div>
            </div>
        <% 
        session.setAttribute("product_name", title);
        session.setAttribute("product_price", price);
        } 
        %>
    </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js
    integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
    <%
        rs.close();
        ps.close();
    } catch (SQLException se) {
        out.println(se);
    } catch (Exception e) {
        out.println(e);
    } finally {
        try {
            if (ps != null)
            ps.close();
        } catch (SQLException ignore) {
        }
    }
    %> 
