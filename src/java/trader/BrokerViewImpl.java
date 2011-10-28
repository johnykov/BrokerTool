package trader;

import java.util.*;
import java.io.Serializable;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import trader.*;
import trader.Customer;
import trader.gui.*;

public class BrokerViewImpl implements BrokerView ,Serializable{
    
    private transient BrokerGui gui;
    private BrokerModel brokerModel;
    private BrokerController brokerController;
    
    /** Creates a new instance of BrokerViewImpl */
    public BrokerViewImpl(BrokerModel model) {
        System.out.println("Creating BrokerViewImpl");
        try {
            //** 1 Assign model to the attribute brokerModel
            brokerModel = model;
        } catch (Exception e) {
            System.out.println("BrokerViewImpl constructor " + e);
        }
        //** 2  Create and assign a BrokerGui object to gui
        gui = new BrokerGui(brokerModel);
    }
    
    //user gesture listener registration methods
  /* ---------------------------------------------------------------
   * adds requester to the list of objects to be notified of user
   * gestures entered through a user interface such as a GUI.
   * User getsures for the customer segment are add, delete, update
   * get and getAll customers. There are similar user gestures for
   * portfolio and stock segments
   */
    public void addUserGestureListener(BrokerController b)
    throws BrokerException {
        System.out.println("BrokerViewImpl.addUserGestureListener " +b);
        //** 1 Assign b to the attribute brokerController
        brokerController = b;
        
        //** 2 Inform the gui of the controller b
        //     Hint: call the gui's addController method
        gui.addController(b);
    }
    
    //display selection request service methods
  /* ------------------------------------------------------------
   * shows the display page specified by the broker controller
   * Calls the displayObject(obj) in BrokerGUI to accomplish the task.
   */
    public void showDisplay(Object display) throws BrokerException {
        System.out.println("BrokerViewImpl.showDisplay " + display);
        //** 1 Forward the parameter display to the displayObject(obj)
        //     method of the gui
        gui.displayObject(display);
    }
    
   
}
