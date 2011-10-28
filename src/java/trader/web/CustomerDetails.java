package trader.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import trader.*;

@WebServlet("/CustomerDetails")
public class CustomerDetails extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /* Vars for storing form data */
        String name = "";
        String address = "";
        String id = "";
        Customer cust = (Customer) request.getAttribute("customer");

        if (cust != null) {
            name = cust.getName();
            address = cust.getAddr();
            id = cust.getId();
        }

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html><head><title>Customer Details</title></head>");
            out.println("<body>");
            out.println("<table border='1' cellpadding='4'>");
            out.println("<tbody><tr><td><a href='CustomerDetails'>Customer Details</a></td><td><a href='AllCustomers'>All Customers</a></td><td><a href='Stocks.xhtml'>Stocks</a></td></tr>");
            out.println("</tbody></table>");
            out.println("<br/>");

            out.println("<form action='CustomerController' method='GET'>");
            out.println("<table border='1' cellpadding='4'>");
            out.println("<tbody><tr><td>Customer Name</td><td><input name='customerName' value='" + name + "' type='text'/></td></tr>");
            out.println("<tr><td>Customer Identity</td><td><input name='customerIdentity' value='" + id + "' type='text'/></td></tr>");
            out.println("<tr><td>Customer Address</td><td><input name='customerAddress' value='" + address + "' type='text'/></td></tr>");
            out.println("<tr><td colspan='2' align='center'><input name='submit' value='Get Customer' type='submit'/><input name='submit' value='Update Customer' type='submit'/></td></tr>");
            out.println("<tr><td colspan='2' align='center'><input name='submit' value='Add Customer' type='submit'/><input name='submit' value='Delete Customer' type='submit'/></td></tr>");

            if (id.length() > 0) {
                out.println("<tr><td colspan='2' align='center'><a href='PortfolioController?customerIdentity=" + id + "'>View Portfolio</a></td></tr>");
            }

            out.println("</tbody></table>");
            out.println("</form>");
            out.println("<br/>");

            String message = (String) request.getAttribute("message");
            if (message != null) {
                out.println("<font color='red'>" + message + "</font>");
            }

            out.println("</body></html>");

        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
