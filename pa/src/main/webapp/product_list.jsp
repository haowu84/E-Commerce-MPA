<%@ page import="javax.xml.crypto.Data" %>
<%@ page import="java.sql.*" %>
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
    <title>Products</title>
</head>
<body>
    <jsp:include page="navbar.html" />
    <h1 align="center">Products</h1>
    <div class="container">
    <div class="row gy-4">

    <%
    DBCredentials db = new DBCredentials();
    Connection conn = db.getConnection();
    Statement stmt = null;
    try {
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT product_id, name, price, color, url FROM product");
        
        while (rs.next()) {
            String id = "product.jsp?pid=" + rs.getInt("product_id");
            String name = rs.getString("name");
            String price = "$ " + rs.getDouble("price");
            String color = rs.getString("color");
            String url = "./sources" + rs.getString("url");
    %>
            <div class="col-md-6 col-lg-4 col-xl-3">
                <a href= <%=id%> class="prodCard card h-100" style="text-decoration: none; color: inherit;">
                    <img src= <%=url%> class="card-img-top" style="height: 35vh; object-fit: cover;">
                    <div class="card-body d-flex flex-column justify-content-between">
                        <div class="card-info-top">
                            <h5 class="card-title"> <%=name%> </h5>
                            <div class="card-text"> <%=price%> </div>
                        </div>
                        <div class="card-text pb-2"> <%=color%> </div>
                    </div>
                </a>
            </div>
        <% } %>
    </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js
    integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
    <%
        rs.close();
        stmt.close();
    } catch (SQLException se) {
        out.println(se);
    } catch (Exception e) {
        out.println(e);
    } finally {
        try {
            if (stmt != null)
                stmt.close();
        } catch (SQLException ignore) {
        }
    }
    %> 
