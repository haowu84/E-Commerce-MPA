package com.example.pa;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.util.HashMap;

@WebServlet(urlPatterns = {"/citystate"})
public class CityState extends HttpServlet {

    HashMap<String, String> map = new HashMap<String, String>();

    public void init (ServletConfig config) throws ServletException 
    {   
        super.init(config);

        ServletContext context = getServletContext();

        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(context.getResourceAsStream("./sources/zip_codes.csv"))))
        {
            String line;
            while ((line = buffer.readLine()) != null) 
            {
                String[] values = line.replaceAll("\"", "").split(",");  
                map.put(values[0], values[1] + "," + values[2]);
            }
        }
        catch (Exception e)
        {

        }
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException {

        String zipcode = request.getParameter("zipcode"); 
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            if (map.containsKey(zipcode)) 
            {
                out.write(map.get(zipcode));
            }
            else
            {
                out.write(" , ");
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
