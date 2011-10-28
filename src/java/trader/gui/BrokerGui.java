package trader.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.logging.*;
import trader.*;
import trader.Customer;
import trader.CustomerShare;
import trader.Stock;

public class BrokerGui {
    private BrokerController brokerController;
    private BrokerModel model;
    private String logName = "Broker Tool";
    private Logger logger = Logger.getLogger(logName);
    
    protected JFrame frame;
    protected Container contentPane;
    protected PanelViewer viewDeck;
    private BrokerPanel[] panels= new BrokerPanel[10];
       
    /** Creates a new instance of BrokerGUI */
    public BrokerGui(BrokerModel model) {
        this.model=model;
        buildDisplay();
    }
    
    public void addController(BrokerController controller){
        brokerController=controller;
        for(int i=0;panels[i]!=null;i++)
            panels[i].registerController(controller);
    }
    
    protected void buildDisplay(){
        frame = new JFrame("BrokerTool");
        viewDeck = new TabPanelViewer();
        //* Code to create and add the customer panel to the panels array.
        //panels[0] = new MessagePanel(model, "Place Holder for CustomerPanel"); //temporary
        panels[0] = new CustomerPanel(model);
        viewDeck.addView(panels[0].getPanel(), "Customer Details");
        
        // Code to build AllCustomersPanel
        panels[1] = new AllCustomerTablePanel(model);
        viewDeck.addView(panels[1].getPanel(), "All Customers");
        
        //* Code to build the Stock Panel goes here
        panels[2] = new MessagePanel(model, "Place Holder for StockPanel"); //temporary
        viewDeck.addView(panels[2].getPanel(), "Stock");
        
        //* Code to Portfolio Paneli goes here
        panels[3] = new MessagePanel(model, "Place Holder for PortfolioPanel"); //temporary
        viewDeck.addView(panels[3].getPanel(), "Portfolio");
        
        // build and display frame
        contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(viewDeck.getPanel(), BorderLayout.CENTER);
        
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible( true );
        viewDeck.showView("All Customers");
    }
    
    public void displayObject(Object obj){
        if (obj instanceof Customer){
            panels[0].display(obj);
            panels[1].refresh();
        }
        
        if (obj instanceof Customer[]){
            panels[1].display(obj);
        }
        
        if (obj instanceof CustomerShare[]){
            //TBD
        }
        
        if (obj instanceof Stock[]){
            //TBD
        }
        if (obj instanceof Exception) {
            // log the exception
            logger.severe(obj.toString());
        }
    }
    
    
    public static void main(String args[]){
        BrokerGui gui = new BrokerGui(null);
    }
}
