/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trader.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import trader.*;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author jan
 */
@WebServlet(name = "CustomerController", urlPatterns = {"/AllCustomers"})
public class CustomerController extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BrokerModel model = BrokerModelImpl.getInstance();
        String path = request.getServletPath();

        if (path.equals("/CustomerController")) {

            String id = request.getParameter("customerIdentity");
            String name = request.getParameter("customerName");
            String adress = request.getParameter("customerAdress");
            String submit = request.getParameter("submit");

            try {
                if (submit.equals("Get Customer")) {
                    Customer cust = model.getCustomer(id);
                    request.setAttribute("customer", cust);
                } else if (submit.equals("Update Customer")) {
                    model.updateCustomer(new Customer(id, name, adress));
                    Customer cust = model.getCustomer(id);
                    request.setAttribute("customer", cust);
                } else if (submit.equals("Add Customer")) {
                    model.addCustomer(new Customer(id, name, adress));
                    Customer cust = model.getCustomer(id);
                    request.setAttribute("customer", cust);
                } else if (submit.equals("Delete Customer")) {
                    model.deleteCustomer(new Customer(id, name, adress));
                }
            } catch (BrokerException be) {
                request.setAttribute("message", be.getMessage());
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("CustomerDetails");
            dispatcher.forward(request, response);
        } else if (path.equals("/AllCustomers")) {
            try {
                Customer[] allCust = model.getAllCustomers();
                request.setAttribute("customers", allCust);
            } catch (BrokerException ex) {
                request.setAttribute("message", ex.getMessage());
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("AllCustomers.jsp");
            dispatcher.forward(request, response);
        }

//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
//        try {
//            /* TODO output your page here
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet CustomerController</title>");  
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet CustomerController at " + request.getContextPath () + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//             */
//        } finally {            
//            out.close();
//        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
