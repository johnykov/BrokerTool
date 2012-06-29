<%-- 
    Document   : AllCustomers
    Created on : 2012-06-29, 11:17:32
    Author     : Johnny
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="trader.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Customers</title>
    </head>
    <body>
        <table border='1' cellpadding='4'>
            <tbody>
                <tr><td><a href='CustomerDetails.jsp'>Customer Details</a></td><td><a href='AllCustomers'>All Customers</a></td><td><a href='Stocks.xhtml'>Stocks</a></td></tr>
            </tbody>
        </table>
        <br/>
        <table border='1' cellpadding='4'>
            <thead>
                <tr>
                    <td>Customer Id</td>
                    <td>Name</td>
                    <td>Address</td>
                    <td>Portfolio</td>
                </tr>
            </thead>
            <tbody>
                <%
                    Customer[] customers = (Customer[]) request.getAttribute("customers");

                    for (int i = 0; i < customers.length; i++) {
                %>
                <tr>
                    <td><a href="CustomerController?customerIdentity=<%= customers[i].getId()%>&submit=Get Customer"><%= customers[i].getId()%></a></td>
                    <td><%= customers[i].getName()%></td>
                    <td><%= customers[i].getAddr()%></td>
                    <td><a href='PortfolioController?customerIdentity=<%=customers[i].getId()%>'>View</a></td>                    
                </tr>                
                <%
                    }
                %>
            </tbody>
        </table>
        <%
            String message = (String) request.getAttribute("message");
            if (message != null) {
                out.println("<font color='red'>" + message + "</font>");
            }
        %>
    </body>
</html>
