package trader;

import trader.Customer;
public interface BrokerController {
//user gesture call back methods
  /* ---------------------------------------------------------------
   * get customer user gesture handle method called by the broker
   * view in response to the get customer button click on the GUI or
   * equivalent user interface.
   * action - set customer display on the gui through the
   * showDisplay method of the broker view
   */
    void handleGetCustomerGesture(String id);
    
  /* ---------------------------------------------------------------
   * add new customer user gesture handle method called by the
   * broker view in response to the add customer button click on the
   * GUI or equivalent user interface.
   * action - add the (new) customer customer to the model
   */
    void handleAddCustomerGesture(Customer c);
    
  /* ---------------------------------------------------------------
   * delete customer user gesture  handle method called by
   * the broker view in response to the delete customer
   * button click on the GUI or equivalent user interface
   * action  - delete the customer from the model
   */
    void handleDeleteCustomerGesture(Customer c);
    
  /* ---------------------------------------------------------------
   * update customer user gesture callback method called by
   * the broker view in response to the update customer
   * button click on the GUI or equivalent user interface
   * action  - update the customer in the model
   */
    void handleUpdateCustomerGesture(Customer c);
    
  /* ---------------------------------------------------------------
   * get all customers user gesture callback method called
   * the broker view in response to the get all customers
   * button click on the GUI or equivalent user interface
   * action - set all customers display on the gui through the
   * showDisplay method of the broker view
   */
    void handleGetAllCustomersGesture();
    
// Portfolio segment - TBD in future iteration
// Add method to handle portfolio related user gesture
// notifications from the broker view
    
// Stock segment - TBD in future iteration
// Add method to handle stock related user gesture
// notifications from the broker view
}
