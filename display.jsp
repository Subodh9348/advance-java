<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Summary</title>
<style>
    table {
        border-collapse: collapse;
        width: 50%;
    }
    th, td {
        border: 1px solid #000;
        padding: 8px;
    }
    th {
        background-color: #f2f2f2;
    }
</style>
</head>
<body>
<%
String name = request.getParameter("name");
String deepCrust = request.getParameter("deep");
String toppings[] = request.getParameterValues("check");
String appetizer = request.getParameter("rd");
String address = request.getParameter("add");
String cardType = request.getParameter("card");
String ccno = request.getParameter("cardno");
String rccno = request.getParameter("rcardno");
%>

<h2>Order Summary</h2>
<table>
    <tr>
        <th>Field</th>
        <th>Value</th>
    </tr>
    <tr>
        <td>Name</td>
        <td><%= name %></td>
    </tr>
    <tr>
        <td>Deep Crust</td>
        <td><%= deepCrust %></td>
    </tr>
    <tr>
        <td>Toppings</td>
        <td>
            <ul>
            <%
                if (toppings != null) {
                    for (String top : toppings) {
            %>
                        <li><%= top %></li>
            <%
                    }
                } else {
            %>
                        None
            <%
                }
            %>
            </ul>
        </td>
    </tr>
    <tr>
        <td>Appetizer</td>
        <td><%= appetizer %></td>
    </tr>
    <tr>
        <td>Address</td>
        <td><%= address %></td>
    </tr>
    <tr>
        <td>Card Type</td>
        <td><%= cardType %></td>
    </tr>
    <tr>
        <td>Credit Card Number</td>
        <td><%= ccno %></td>
    </tr>
    <tr>
        <td>Repeated Credit Card Number</td>
        <td><%= rccno %></td>
    </tr>
</table>

</body>
</html>
