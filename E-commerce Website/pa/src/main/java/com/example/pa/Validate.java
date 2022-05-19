package com.example.pa;

import java.io.*;
import java.util.regex.Pattern;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "validate", value = "/validate")
public class Validate extends HttpServlet{

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zipcode = request.getParameter("zipcode");

        String cardnum = request.getParameter("cardnum");
        String expdate = request.getParameter("expdate");
        String cvc = request.getParameter("cvc");

        RequestDispatcher rd = request.getRequestDispatcher("checkout.jsp");

		if (name.isEmpty()) {
            rd.include(request, response);
            out.println("Missing Name");
        }
        else if (email.isEmpty()) {
            rd.include(request, response);
            out.println("Missing Email");
        }
        else if (!Pattern.matches("^[a-zA-z0-9]+@[a-zA-z0-9]+[.][a-zA-z0-9]+$", email)) {
            rd.include(request, response);
            out.println("Email has to follow the form: [local]@[domain].[extension]");
        } 
        else if (phone.isEmpty()) {
            rd.include(request, response);
            out.println("Missing Phone Number");
        }
        else if (!Pattern.matches("^[0-9]{3}-[0-9]{3}-[0-9]{4}$", phone)) {
            rd.include(request, response);
            out.println("Phone Number has to follow the form: XXX-XXX-XXXX, 10 digit number seperated by -");
        } 
        else if (address.isEmpty()) {
            rd.include(request, response);
            out.println("Missing Address");
        }
        else if (city.isEmpty()) {
            rd.include(request, response);
            out.println("Missing City");
        }
        else if (state.isEmpty()) {
            rd.include(request, response);
            out.println("Missing State");
        }
        else if (!Pattern.matches("^[A-Z]{2}$", state)) {
            rd.include(request, response);
            out.println("State Initial has to follow the form: 2 uppercase letters");
        } 
        else if (zipcode.isEmpty()) {
            rd.include(request, response);
            out.println("Missing Zip Code");
        }
        else if (!Pattern.matches("^[0-9]{5}$", zipcode)) {
            rd.include(request, response);
            out.println("Zip Code has to be a 5 digit number");
        } 
        else if (cardnum.isEmpty()) {
            rd.include(request, response);
            out.println("Missing Card Number");
        }
        else if (!Pattern.matches("^[0-9]{4}-[0-9]{4}-[0-9]{4}-[0-9]{4}$", cardnum)) {
            rd.include(request, response);
            out.println("Card Number has to follow the form: XXXX-XXXX-XXXX-XXXX, 16 digit number seperated by -");
        } 
        else if (expdate.isEmpty()) {
            rd.include(request, response);
            out.println("Missing Expiration Date");
        }
        else if (!Pattern.matches("^[0-9]{2}\\/[0-9]{2}$", expdate)) {
            rd.include(request, response);
            out.println("Expiration Date has to follow the form: MM/YY");
        } 
        else if (cvc.isEmpty()) {
            rd.include(request, response);
            out.println("Missing CVC");
        }
        else if (!Pattern.matches("^[0-9]{3}$", cvc)) {
            rd.include(request, response);
            out.println("CVC has to be a 3 digit number");
        }
        else {
            rd = request.getRequestDispatcher("storeuser");
            rd.forward(request, response);
        }
    }

}
