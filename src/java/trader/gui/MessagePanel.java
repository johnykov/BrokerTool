package trader.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import trader.*;

public class MessagePanel implements BrokerPanel{
    
    /** Creates a new instance of MessagePanel */
    
    BrokerModel model;
    BrokerController controller;
    protected JPanel msgPan = new JPanel();
    protected JLabel msgLabel;
    
    public MessagePanel(BrokerModel model, String msg) {
        this.model = model;
        msgLabel = new JLabel(msg);
        buildPanel();
    }
    
    public void registerController(BrokerController controller) {
        this.controller = controller;
    }
    
    public void refresh() {
        msgPan.validate();
    }
    
    
    public void display(Object obj){
        refresh();
    }
    
    
    public JPanel getPanel() {
        return msgPan;
    }
    
    // helper methods
    
    protected void buildPanel() {
        // essentially this builds the customer panel.
        msgPan.setLayout(new BorderLayout());
        msgPan.add(msgLabel, BorderLayout.CENTER);
        msgPan.setBackground(Color.yellow);
    }
    
    
}
