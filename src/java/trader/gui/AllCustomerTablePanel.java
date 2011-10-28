package trader.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import trader.BrokerController;
import trader.BrokerModel;
import trader.Customer;

public class AllCustomerTablePanel implements BrokerPanel{
    BrokerModel model;
    BrokerController controller;
    Logger logger = Logger.getLogger("Broker Tool");
    
    // AllCustomersPanel components
    protected JPanel allCustPan = new JPanel();
    protected JLabel allCustLb =
            new JLabel("All Customers", SwingConstants.CENTER);
    protected JButton refreshButton = new JButton("Refresh");
    
    
    //** Students add the JTable related attributes here
    //** 1 Declare attribute tableHeaders of type String[]
    //**   and initialize to "Customer Id", "Name", "Address"
    String[] tableHeaders = {"Customer Id", "Name", "Address"};
    //** 2 Declare attribute table of type JTable
    JTable table;
    //** 3 Declare attribute tablePane of type JScrollPane
    JScrollPane tablePane;
    //** 4 Declare attribute tableModel of type DefaultTableModel
    DefaultTableModel tableModel;
    
    /** Creates a new instance of AllCustomerPanel */
    public AllCustomerTablePanel(BrokerModel model) {
        this.model = model;
        buildAllCustPanel();
        refreshButton.addActionListener(new RefreshButtonListener());
        refresh();
    }
    
    public void registerController(BrokerController controller) {
        this.controller = controller;
    }
    
    
    //build all customer panel
    void buildAllCustPanel() {
        // this method builds the customer panel.
        allCustPan.setLayout(new BorderLayout());
        allCustPan.add(allCustLb, BorderLayout.NORTH);
        //** 1 Create a DefaultTableModel and assign it to
        //**   tableModel. Hint - see TableExample class
        tableModel = new DefaultTableModel(tableHeaders, 10);
        //** 2 Create a JTable and assign it to
        //**   table. Hint - see TableExample class
        table = new JTable(tableModel);
        //** 3 Create a JScrollPane object to scroll the table
        //**   and assign it to tablePane;
        tablePane = new JScrollPane(table);
        //** 4 Add the tablePan to CENTER region of allCustPan
        allCustPan.add(tablePane, BorderLayout.CENTER);
        //set table view port properties
        Dimension dim = new Dimension(500, 150);
        table.setPreferredScrollableViewportSize(dim);
        allCustPan.add(refreshButton, BorderLayout.SOUTH);
        
    }
    
    public void refresh() {
        try {
            Customer[] customers = model.getAllCustomers();
            refreshAllCustPan(customers);
        } catch(Exception e) {
            if (model == null) {
                logger.info("AllCustomerPanel.refresh: null pointer exception");
            } else {
                logger.severe(e.toString());
            }
        }
        
    }
    
    public void display(Object obj){
        if(obj instanceof Customer[]) {
            Customer[] customers = (Customer[])obj;
            refreshAllCustPan(customers);
        }
    }
    
    public JPanel getPanel() {
        return allCustPan;
    }
    
    public void refreshAllCustPan(Customer[] custs){
        // Hint This method is similar to the updateTable method
        // of TableExample class
        String newData[][];
        //** 1 Create a 2-dimensional string array with no of rows
        //**   equal to custs.length and no of columns set to 3, i
        //**   and assign to newData.
        newData = new String[custs.length][3];
        //** 2 Write a for loop to populate the newData array with
        //**   customer id, name, and addr obtained from custs array
        for (int i=0; i<custs.length; i++) {
            newData[i][0] = custs[i].getId();
            newData[i][1] = custs[i].getName();
            newData[i][2] = custs[i].getAddr();
        }
        //** 3 Invoke the setDataVector method on the tableModel
        //**   passing it newData and tableHeaders arrays.
        tableModel.setDataVector(newData, tableHeaders);
    }
    
        // Inner class to handle Refresh button push
    public class RefreshButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            controller.handleGetAllCustomersGesture();
        }
    }  
    
}
