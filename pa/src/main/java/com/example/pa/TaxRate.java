package com.example.pa;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.util.HashMap;

@WebServlet(urlPatterns = {"/taxrate"})
public class TaxRate extends HttpServlet {

    HashMap<String, String> map = new HashMap<String, String>();

    public void init (ServletConfig config) throws ServletException 
    {
        super.init(config);

        ServletContext context = getServletContext();

        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(context.getResourceAsStream("./sources/tax_rates2.csv"))))
        {
            String line;
            while ((line = buffer.readLine()) != null) 
            {
                String[] values = line.split(",");  
                map.put(values[1], values[3]);
            }
        }
        catch (Exception e)
        {

        }
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException {

        HttpSession session = request.getSession(true);

        String zipcode = request.getParameter("zipcode"); 
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            if (map.containsKey(zipcode)) 
            {
                String tax = map.get(zipcode);
                Double subtotal = (Double) session.getAttribute("total");
                Double total = subtotal * (1 + Double.parseDouble(tax));
                total = Math.round(total * 100.0) / 100.0;

                out.write(subtotal + "," + tax + "," + total);
            }
            else 
            {
                out.write("0.00,0.00,0.00");
            }
        }
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
    
}
