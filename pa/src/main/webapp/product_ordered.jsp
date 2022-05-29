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
    <link rel="stylesheet" href="stars.css">
    <title>Products Ordered</title>
</head>
<body>
    <h1 align="center">Products Ordered</h1>
    <div class="container">
    <div class="row gy-4">

    <%
    DBCredentials db = new DBCredentials();
    Connection conn = db.getConnection();
    Statement stmt = null;
    try {
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT item_id, product_name FROM orderitems ORDER BY item_id DESC LIMIT 5");
        
        while (rs.next()) {
            String id = "./storerating?id=" + rs.getInt("item_id");
            String product_name = rs.getString("product_name");

            int count = 1;
    %>
            <div class="col-md-6 col-lg-4 col-xl-3">
                <div class="card h-100" style="text-align:center; color: inherit;">
                    <h3> <%=product_name%> </h3>
                    <form method="post" action= <%=id%> >
                        <div class="starBtns">
                            <input type = "radio" id = "r5" name = "rating" value = "5"/>
                            <label for="r5"></label>
                            <input type = "radio" id = "r4" name = "rating" value = "4"/>
                            <label for="r4"></label>
                            <input type = "radio" id = "r3" name = "rating" value = "3"/>
                            <label for="r3"></label>
                            <input type = "radio" id = "r2" name = "rating" value = "2"/>
                            <label for="r2"></label>
                            <input type = "radio" id = "r1" name = "rating" value = "1"/>
                            <label for="r1"></label>
                        </div>
                        <input type="submit" value="Rate" />
                    </form>
                </div>
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
