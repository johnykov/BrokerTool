package trader;

import trader.Customer;
import trader.gui.*;

public class BrokerControllerImpl implements BrokerController{
    
    private BrokerModel brokerModel;
    private BrokerView brokerView;
    
    
    /** Creates new BrokerControllerImpl */
    public BrokerControllerImpl(BrokerModel model, BrokerView view) {
        try {
            //** 1 Assign model to brokerModel
            brokerModel = model;
            //** 2 Assign view to brokerView
            brokerView = view;
            //** 3 Register this object as a user gesture listener with
            //**   the brokerView object
            brokerView.addUserGestureListener(this);
        } catch(Exception e) {
            reportException(e);
        }
    }
    
    private void reportException(Object o) {
        // The responsibility of this method is to report exceptions
        // It class the brokerView's showDisplay method
        try {
            brokerView.showDisplay(o);
        } catch(Exception e) {
            System.out.println("BrokerControllerImpl reportException " + e);
        }
    }
    
    //user gesture call back methods
  /* ---------------------------------------------------------------
   * get customer user gesture handle method called by the broker
   * view in response to the get customer button click on the GUI or
   * equivalent user interface.
   * action - set customer display on the gui through the
   * showDisplay method of the broker view
   */
    public void handleGetCustomerGesture(String id) {
        System.out.println("handleGetCustomerGesture " + id);
        Customer cust = null;
        try {
            //** 1 Set cust to the object returned as a result of
            //**   invoking the getCustomer method on brokerModel
            cust = brokerModel.getCustomer(id);
            //** 2 Invoke showDisplay method of brokerView with cust
            //**   as parameter
            brokerView.showDisplay(cust);
        } catch(Exception e) {
            e.printStackTrace();
            reportException(e);
        }
    }
    
  /* ---------------------------------------------------------------
   * add new customer user gesture handle method called by the
   * broker view in response to the add customer button click on the
   * GUI or equivalent user interface.
   * action - add the (new) customer customer to the model
   */
    public void handleAddCustomerGesture(Customer c) {
        System.out.println("handleAddCustomerGesture " + c);
        try {
            //** 1 Invoke addCustomer method of brokerModel with c
            //**   as parameter
            brokerModel.addCustomer(c);
        } catch(Exception e) {
            reportException(e);
        }
    }
    
  /* ---------------------------------------------------------------
   * delete customer user gesture  handle method called by
   * the broker view in response to the delete customer
   * button click on the GUI or equivalent user interface
   * action  - delete the customer from the model
   */
    public void handleDeleteCustomerGesture(Customer c){
        System.out.println("handleDeleteCustomerGesture " + c);
        try {
            //** 1 Invoke deleteCustomer method of brokerModel with c
            //**   as parameter
            brokerModel.deleteCustomer(c);
        } catch(Exception e) {
            reportException(e);
        }
    }
    
  /* ---------------------------------------------------------------
   * update customer user gesture callback method called by
   * the broker view in response to the update customer
   * button click on the GUI or equivalent user interface
   * action  - update the customer in the model
   */
    public void handleUpdateCustomerGesture(Customer c){
        System.out.println("handleUpdateCustomerGesture " + c);
        try {
            //** 1 Invoke updateCustomer method of brokerModel with c
            //**   as parameter
            brokerModel.updateCustomer(c);
        } catch(Exception e) {
            reportException(e);
        }
    }
    
  /* ---------------------------------------------------------------
   * get all customers user gesture callback method called
   * the broker view in response to the get all customers
   * button click on the GUI or equivalent user interface
   * action - set all customers display on the gui through the
   * showDisplay method of the broker view
   */
    public void handleGetAllCustomersGesture(){
        System.out.println("handleGetAllCustomerGesture ");
        Customer custs[];
        try {
            //** 1 Invoke getAllCustomers method of brokerModel
            //**   Assign the return value from this method to custs
            custs = brokerModel.getAllCustomers();
            //** 2 Invoke showDisplay method of brokerView with custs
            //** as parameter
            brokerView.showDisplay(custs);
        } catch(Exception e) {
            reportException(e);
        }
    }
}
