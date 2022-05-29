<%@ page import="javax.xml.crypto.Data" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.pa.CartItem" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Checkout</title>
</head>

<body>
    <jsp:include page="navbar.html" />
    <h1 align="center">Checkout</h1>
    <style>
        td, th {
            padding:15px 32px
        }
        table {
            border:1.5px solid black; 
            padding:19px;
            margin-top:0px;
        }
    </style>

    <table>
        <tr>
            <th>Product Name</th>
            <th>Quantity</th>
            <th>Item Price</th>
        </tr>

        <%
        if (session.getAttribute("cart") != null)
        {
            List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");

            Double total = 0.0;
            for (CartItem item : cart) {
        %>
                <tr align = center>
                    <td> <%=item.getName()%> </td>
                    <td> <%=item.getQuantity()%> </td>
                    <td> $<%=item.getPrice()%> </td>
                </tr>
            <%
                total += item.getPrice() * item.getQuantity();
            }

            session.setAttribute("total", total);
        }
        %>
    </table>

    <jsp:include page="form.html" />
</body>
</html>

