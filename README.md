# E-Commerce (Customer) with JavaScript, Java Servlet, JSP, MySQL

## Structure
- pa/src/main/Cart.java: use servlet "session" to store the products in a shopping cart
- pa/src/main/CityState.java: obtain the corresponding city and state from the backend database
- pa/src/main/TaxRate.java: obtain the corresponding tax rate from the backend database
- pa/src/main/Validate.java: validate the form to prevent insertion of bad data in database
- pa/src/main/StoreProduct.java: store the products ordered in the database and use servlet "forward" to forward to the order details page

- pa/src/webapp/index.jsp: use servlet "include" feature to include the list of products and the last 5 products that the user has ordered
- pa/src/webapp/product_list.jsp: display the list of products obtained from the backend database
- pa/src/webapp/product_ordered.jsp: display the last 5 products that the user has ordered from the backend database
- pa/src/webapp/form.js: use Ajax to assist the user with filling the order forms

## Setup
### Apache Tomcat
Version 9.0.x \
[Website](https://tomcat.apache.org/download-10.cgi)

### MySQL 
Version 8.0.x \
[Website](https://www.mysql.com)

### VS Code
[Website](https://code.visualstudio.com/docs/java/java-tutorial)


## Summary
### Home Page
- Display a list of products available in a table with multiple rows and columns, where each product is shown within a separate cell
- Display an image for each product in each table cell
- Display the price and other key information associated with each product in the table cell
- Choose a product from this table by clicking on the corresponding image, which should lead to a new page that provides additional details about the product
- Display last 5 products that the user has ordered where the user can provide a rating for each of these orders

### Product Detail Page
- Display additional details about the product 
- Store the product (quantity) in a shopping cart

### Checkout Page
- Order a product by filling a form that allows the user to enter first name, last name, phone number, shipping address, shipping method, credit card information
- Check for proper formatting, including whether all fields are filled properly, whether the phone number, address, and credit card are properly formatted 
- Raise an alarm if a field is empty or not properly formatted to prevent submission of bad data
- Show all the products in the shopping cart and the total price
- Obtain tax rate to update the total price for the product 
- Obtain city and state as the user types zip code

### Order Confirmation Page
- Show all order information
