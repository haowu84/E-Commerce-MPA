package com.example.pa;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "orderdetail", value = "/orderdetail")
public class OrderDetail extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String title = "Order Detail";
        String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " +
                "transitional//en\">\n";
        out.println(docType +
                "<head>\n" +
                "<meta charset=\"utf-8\">\n" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +

                "<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\""
                +
                " integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\" crossorigin=\"anonymous\">\n"
                +

                "<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css\">\n"
                +
                "<link rel=\"stylesheet\" href=\"products.css\">\n" +
                "<title>" + title + "</title>\n" +
                "</head>" +

                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n");

        RequestDispatcher rd = request.getRequestDispatcher("navbar.html");
        rd.include(request, response);

        HttpSession session = request.getSession(true);
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        out.println("<div class=\"mt-3\" style=\"text-align: center;\">");
        out.println("<div style=\"display: inline-block; text-align: left;\">");

        out.println("<div >");
        out.println("<h4 class=\"mt-2\">Personal Info</h4>");
        out.println("Name: " + request.getParameter("name") + "<br>");
        out.println("Email: " + request.getParameter("email") + "<br>");
        out.println("Phone: " + request.getParameter("phone") + "<br>");
        out.println("</div>");

        out.println("<div >");
        out.println("<h4 class=\"mt-2\">Shipping Address</h4>");
        out.println("Address: " + request.getParameter("address") + "<br>");
        out.println("City: " + request.getParameter("city") + "<br>");
        out.println("State: " + request.getParameter("state") + "<br>");
        out.println("Zip Code: " + request.getParameter("zipcode") + "<br>");
        out.println("</div>");

        out.println("<div >");
        out.println("<h4 class=\"mt-2\">Payment Method</h4>");
        out.println("Card Type: " + request.getParameter("cards") + "<br>");
        out.println("Card Number: " + request.getParameter("cardnum") + "<br>");
        out.println("Expiration Date: " + request.getParameter("expdate") + "<br>");
        out.println("CVC: " + request.getParameter("cvc") + "<br>");
        out.println("</div>");

        out.println("<div >");
        out.println("<h4 class=\"mt-2\">Order Summary</h4>");
        out.println("Ship Method: " + request.getParameter("method") + "<br>");
        out.println("Total: $" + request.getParameter("total") + "<br>");

        out.println("</div>");

        out.println("<div >");
        out.write("<h4 class=\"mt-2\">Products Ordered</h4>");
        for (CartItem item : cart) {
            out.println("<div >");
            out.println("Name: " + item.getName() + "<br>");
            out.println("Quantity: " + item.getQuantity() + "<br>");
            out.println("</div>");
        }
        out.println("</div>");
        out.println("</div>");
        out.println("</div>");
        out.println(
                "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js\" " +
                        "integrity=\"sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM\" " +
                        "crossorigin=\"anonymous\"></script>");
        out.println("</body></html>");
        cart = new ArrayList<>();
        session.setAttribute("cart", cart);
    }

}