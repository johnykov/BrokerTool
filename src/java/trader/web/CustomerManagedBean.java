/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trader.web;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import trader.BrokerException;
import trader.BrokerModel;
import trader.BrokerModelImpl;
import trader.Customer;

/**
 *
 * @author Johnny
 */
@ManagedBean(name = "customerDetails")
@RequestScoped
public class CustomerManagedBean {

    private BrokerModel model = BrokerModelImpl.getInstance();
    private String message = "";
    private String customerId = "";
    private String customerName = "";
    private String customerAddress = "";

   
    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getMessage() {
        return message;
    }

    public Customer[] getAllCustomers() {
        Customer[] customers = null;
        try {
            customers = model.getAllCustomers();
        } catch (BrokerException ex) {
            message = ex.getLocalizedMessage();
        }
        return customers;
    }

    public String retrieveCustomer() {
        try {
            Customer customer = model.getCustomer(customerId);
            customerId = customer.getId();
            customerAddress = customer.getAddr();
            customerName = customer.getName();
        } catch (BrokerException ex) {
            message = ex.getLocalizedMessage();
        }
        return "CustomerDetails";
    }

    public String updateCustomer() {
        try {
            Customer customer = new Customer(customerId);
            customer.setAddr(customerAddress);
            customer.setName(customerName);
            model.updateCustomer(customer);
        } catch (BrokerException ex) {
            message = ex.getLocalizedMessage();
        }
        return "CustomerDetails";
    }

    public String addCustomer() {
        try {
            Customer customer = new Customer(customerId);
            customer.setAddr(customerAddress);
            customer.setName(customerName);
            model.addCustomer(customer);
        } catch (BrokerException ex) {
            message = ex.getLocalizedMessage();
        }
        return "CustomerDetails";
    }

    public String deleteCustomer() {
        try {
            Customer customer = new Customer(customerId);
            model.deleteCustomer(customer);
            customerId = "";
            customerAddress = "";
            customerName = "";
        } catch (BrokerException ex) {
            message = ex.getLocalizedMessage();
        }
        return "CustomerDetails";
    }
}
