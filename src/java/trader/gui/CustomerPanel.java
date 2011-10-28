
package trader.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import trader.*;
import trader.Customer;

public class CustomerPanel implements BrokerPanel{
    
    /** Creates a new instance of CustomerPanel */
    
    BrokerModel model;
    BrokerController controller;
    protected JPanel custPan = new JPanel();
    protected JLabel nameLb = new JLabel("Customer Name");
    protected JLabel idLb = new JLabel("Customer Identity");
    protected JLabel addrLb = new JLabel("Customer Address");
    protected JTextField nameTf = new JTextField(25);
    protected JTextField idTf = new JTextField(25);
    protected JTextField addrTf = new JTextField(25);
    protected JButton getBt = new JButton("Get Customer");
    protected JButton updBt = new JButton("Update Customer");
    protected JButton addBt = new JButton("Add Customer");
    protected JButton delBt = new JButton("Delete Customer");
    
    public CustomerPanel(BrokerModel model) {
        this.model = model;
        buildPanel();
        addCustomerPanelListeners(); 
    }
    
    public void registerController(BrokerController controller) {
        this.controller = controller;
    }
    
    public void refresh() {
        // get customer id from appropriate Textfield
        try{
            // (if not blank) get the corresponding customer object from the model
            // show the customer details on the panel
            if(idTf.getText().trim()!=""){
                Customer cust=model.getCustomer((idTf.getText()));
                addrTf.setText(cust.getAddr());
                nameTf.setText(cust.getName());
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    
    public void display(Object obj){
        Customer cust;
        if (obj instanceof Customer) {
            cust = (Customer) obj;
            // if cust.custId equals custId on the CustomerPanel
            // then display the customer object on the CustomerPanel
            if (getCustId().equals(cust.getId())){
                addrTf.setText(cust.getAddr());
                nameTf.setText(cust.getName());
            }
        }
    }
    
    
    public JPanel getPanel() {
        return custPan;
    }
    
    // helper methods
    protected String getCustId(){
        return idTf.getText().trim();
    }
    
    protected String getCustName(){
        return nameTf.getText().trim();
    }
    
    protected String getCustAddr(){
        return addrTf.getText().trim();
    }
    
    protected void buildPanel() {
        // essentially this builds the customer panel.
        custPan.setLayout(new GridLayout(5,2));
        custPan.add(nameLb);
        custPan.add(nameTf);
        custPan.add(idLb);
        custPan.add(idTf);
        custPan.add(addrLb);
        custPan.add(addrTf);
        custPan.add(getBt);
        custPan.add(updBt);
        custPan.add(addBt);
        custPan.add(delBt);
    }
    
    // Event handling 
    public void addCustomerPanelListeners() {
        // Register event listener instance with the Get button
        getBt.addActionListener(new GetCustomerButtonListener());
        // Register event listener instance with the Update button
        updBt.addActionListener(new UpdateCustomerButtonListener());
        // Register event listener instance with the Add button
        addBt.addActionListener(new AddCustomerButtonListener());
        // Register event listener instance with the Delete button
        delBt.addActionListener(new DeleteCustomerButtonListener());
    }
    
    // Inner class to handle get button push
    public class GetCustomerButtonListener implements ActionListener {
        String buttonName;
        String custId;
        Customer cust;
        public void actionPerformed(ActionEvent e) {
            buttonName = e.getActionCommand();
            custId = getCustId();
            cust = new Customer(getCustId(), getCustName(), getCustAddr());
            System.out.println("CustomerListener buttonName = " + buttonName);
            controller.handleGetCustomerGesture(custId);
        }
    }
    
    // Inner class to handle Update button push
    public class UpdateCustomerButtonListener implements ActionListener {
        String buttonName;
        String custId;
        Customer cust;
        public void actionPerformed(ActionEvent e) {
            buttonName = e.getActionCommand();
            custId = getCustId();
            cust = new Customer(getCustId(), getCustName(), getCustAddr());
            System.out.println("CustomerListener buttonName = " + buttonName);
            controller.handleUpdateCustomerGesture(cust);
        }
    }
    
    // Inner class to handle Add button push
    public class AddCustomerButtonListener implements ActionListener {
        String buttonName;
        String custId;
        Customer cust;
        public void actionPerformed(ActionEvent e) {
            buttonName = e.getActionCommand();
            custId = getCustId();
            cust = new Customer(getCustId(), getCustName(), getCustAddr());
            System.out.println("CustomerListener buttonName = " + buttonName);
            controller.handleAddCustomerGesture(cust);
        }
    }
    
    // Inner class to handle Delete button push
    public class DeleteCustomerButtonListener implements ActionListener {
        String buttonName;
        String custId;
        Customer cust;
        public void actionPerformed(ActionEvent e) {
            buttonName = e.getActionCommand();
            custId = getCustId();
            cust = new Customer(getCustId(), getCustName(), getCustAddr());
            System.out.println("CustomerListener buttonName = " + buttonName);
            controller.handleDeleteCustomerGesture(cust);
        }
    }    
}
