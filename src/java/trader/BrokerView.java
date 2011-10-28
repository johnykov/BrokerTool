package trader;

import trader.Customer;
public interface BrokerView {
//user gesture listener registration methods
  /* ---------------------------------------------------------------
   * adds requester to the list of objects to be notified of user
   * gestures entered through a user interface such as a GUI.
   * User gestures for the customer segment are add, delete, update
   * get and getAll customers. There are similar user gestures for
   * portfolio and stock segments
   */
    void addUserGestureListener(BrokerController b)
    throws BrokerException;
    
//display selection request service methods
  /* ---------------------------------------------------------------
   * shows the display page specified by the broker controller
   */
    void showDisplay(Object display) throws BrokerException;
        
    
// Portfolio segment - TBD in future iteration
// Add method to handle portfolio change notification from the
// broker model
    
// Stock segment - TBD in future iteration
// Add method to handle stock change notification from broker model
}
