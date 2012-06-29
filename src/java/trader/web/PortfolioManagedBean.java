/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trader.web;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import trader.*;

/**
 *
 * @author Johnny
 */
@ManagedBean(name = "portfolio")
@RequestScoped
public class PortfolioManagedBean {

   private BrokerModel model = BrokerModelImpl.getInstance();

    private String message = "";
    private String customerId = "";
    
    /** Creates a new instance of PortfolioManagedBean */
    public PortfolioManagedBean() {
    }

    public String getMessage() {
        return message;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        String name = "";
        try {
            Customer customer = model.getCustomer(customerId);
            name = customer.getName();
        } catch (BrokerException be) {
            message = be.getMessage();
        }
        return name;
    }

    public CustomerShare[] getShares() {
        CustomerShare[] shares = null;
        try {
            shares = model.getAllCustomerShares(customerId);
        } catch (BrokerException be) {
            message = be.getMessage();
        }
        return shares;
    }

}
