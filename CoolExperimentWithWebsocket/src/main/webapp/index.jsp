<%-- 
    Document   : index
    Created on : Jun 11, 2019, 7:06:01 PM
    Author     : Ray
--%>

<%@page import="com.mycompany.coolexperimentwithwebsocket.*"%>
<%@ page import="java.util.*" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <script type="text/javascript" language="javascript" src="cartWebsocket.js"></script>
    </head>    
    <body>
<div style="float: left; width: 500px">
<h2>Catalog</h2>
<table border="1">
    <%-- construct the title of table --%>
    <thead><th>Name</th><th>Description</th><th>Price</th><th>Add_To_Cart</th><th>Remove_To_Cart</th></thead>
  <tbody>
  <%-- obtain the item info --%> 
  <%
    for (Iterator<Item> I = new Catalog().getAllItems().iterator() ; I.hasNext() ; ) {
      Item item = I.next();
  %>
  <%-- construct one table --%>
    <tr>
        <td><%= item.getName() %></td>
        <td><%= item.getDescription() %></td>
        <td><%= item.getFormattedPrice() %></td>
        <td><button onclick="addToCart('<%= item.getCode() %>')">Add to Cart</button></td>
        <td><button onclick="removeToCart('<%= item.getCode() %>')">Remove to Cart</button></td>
    </tr>
    <% } %>
  </tbody>
</table>
<div style="position: absolute; top: 0px; right: 0px; width: 250px">
<h2>Cart Contents</h2>
<ul id="contents">
</ul>
Total cost: <span id="total">$0.00</span>
</div>
</body>
</html>

