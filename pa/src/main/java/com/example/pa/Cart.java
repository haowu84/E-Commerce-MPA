package com.example.pa;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "cart", value = "/cart")
public class Cart extends HttpServlet{

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession session = request.getSession(true);
        
        String name = (String) session.getAttribute("product_name");
        Double price = (Double) session.getAttribute("product_price");
        Integer quantity = Integer.parseInt(request.getParameter("quantity"));

        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }

        boolean found = false;
        for (int i = 0; i < cart.size(); i++)
        {
            if (cart.get(i).getName().equals(name))
            {
                cart.get(i).addQuantity(quantity);
                found = true;
                break;
            }
        }

        if (!found)
        {
            cart.add(new CartItem(name, price, quantity));
        }
        
        session.setAttribute("cart", cart);

        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
    }
    
}
