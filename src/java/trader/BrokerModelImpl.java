package trader;

import java.util.*;

public class BrokerModelImpl implements BrokerModel {

    private List<Customer> customers = new ArrayList<Customer>();
    private List<CustomerShare> shares = new ArrayList<CustomerShare>();
    private List<Stock> stocks = new ArrayList<Stock>();
    private static BrokerModel instance = new BrokerModelImpl();

    public static BrokerModel getInstance() {
        return instance;
    }

    /** Creates a new instance of BrokerModelImpl */
    private BrokerModelImpl() {
        customers.add(new Customer("111-11-1111", "Test Customer", "2222 Easy Street, West Beach AZ"));
        customers.add(new Customer("123-45-6789", "Matthieu Heimer", "221B Baker Street, Houston TX"));
        customers.add(new Customer("999-45-9034", "Asok Perumainar", "1444 England Lane, Broomfield CO"));
        customers.add(new Customer("999-78-9012", "Anthony Orapallo", "123 Tea Street, Columbia MD"));
        customers.add(new Customer("999-90-9009", "Terri Cubeta", "636 Somewhere Rd, Rosslyn VA"));
        customers.add(new Customer("999-90-8765", "Bryan Basham", "3290 Course Way, Broomfield CO"));
        customers.add(new Customer("999-33-4444", "Georgianna DG Meagher", "1000 Mother Court, Columbia MD"));
        customers.add(new Customer("999-44-5555", "Tom McGinn", "1525 Educator Drive, Burlington MA"));

        shares.add(new CustomerShare("999-45-9034", "ORCL", 200));
        shares.add(new CustomerShare("999-45-9034", "DUKE", 1200));
        shares.add(new CustomerShare("123-45-6789", "JDK", 1));
        shares.add(new CustomerShare("999-78-9012", "JSVCo", 120));
        shares.add(new CustomerShare("999-90-9009", "BWInc", 35));
        shares.add(new CustomerShare("999-90-8765", "GMEnt", 200));
        shares.add(new CustomerShare("999-90-8765", "PMLtd", 109));
        shares.add(new CustomerShare("999-44-5555", "TMAs", 135));

        stocks.add(new Stock("ORCL", 135.0));
        stocks.add(new Stock("CyAs", 34.0));
        stocks.add(new Stock("DUKE", 12.75));
        stocks.add(new Stock("ABStk", 20.75));
        stocks.add(new Stock("JSVCo", 24.00));
        stocks.add(new Stock("TMAs", 80.25));
        stocks.add(new Stock("BWInc", 6.25));
        stocks.add(new Stock("GMEnt", 52.50));
        stocks.add(new Stock("PMLtd", 201.75));
        stocks.add(new Stock("JDK", 13.50));

    }

    // Customer segment state change methods
    /**----------------------------------------------------------
     * Adds the Customer to the broker model
     */
    public void addCustomer(Customer cust)
            throws BrokerException {
        try {
            getCustomer(cust.getId());
            throw new BrokerException("Duplicate Id : " + cust.getId());
        } catch (BrokerException be) {
            customers.add(cust);
        }
    }

    /**-------------------------------------------------------------
     * deletes the customer from the broker model
     */
    public void deleteCustomer(Customer cust)
            throws BrokerException {
        Customer cr = null;
        boolean custFound = false;
        int index = 0;
        for (; index < customers.size(); index++) {
            cr = customers.get(index);
            if (cr.getId().equals(cust.getId())) {
                custFound = true;
                break;
            }
        }

        if (custFound) {
            customers.remove(index);
        } else {
            throw new BrokerException("Record for " + cust.getId() + " not found");
        }
    }

    /**-------------------------------------------------------------
     * Updates the customer in the broker model
     */
    public void updateCustomer(Customer cust)
            throws BrokerException {
        Customer cr = getCustomer(cust.getId());
        cr.setAddr(cust.getAddr());
        cr.setName(cust.getName());
    }

    // Customer segment state query methods
    /**-------------------------------------------------------------
     * Given an id, returns the Customer from the model
     */
    public Customer getCustomer(String id)
            throws BrokerException {
        Customer cr = null;
        boolean custFound = false;
        for (int i = 0; i < customers.size(); i++) {
            cr = customers.get(i);
            if (cr.getId().equals(id)) {
                custFound = true;
                break;
            }
        }

        if (custFound) {
            return cr;
        } else {
            throw new BrokerException("Record for " + id + " not found");
        }
    }

    /**-------------------------------------------------------------
     * Returns all customers in the broker model
     */
    public Customer[] getAllCustomers()
            throws BrokerException {
        return customers.toArray(new Customer[0]);
    }

    public CustomerShare[] getAllCustomerShares(String customerId) throws BrokerException {
        List<CustomerShare> custShares = new ArrayList<CustomerShare>();
        for (int i = 0; i < shares.size(); i++) {
            CustomerShare cs = shares.get(i);
            if (cs.getCustomerId().equals(customerId)) {
                custShares.add(cs);
            }
        }

        if (custShares.size() > 0) {
            return custShares.toArray(new CustomerShare[0]);
        } else {
            throw new BrokerException("Shares for " + customerId + " not found");
        }
    }

    public void addCustomerShare(CustomerShare cs) throws BrokerException {
        for (int i = 0; i < shares.size(); i++) {
            CustomerShare tempShare = shares.get(i);
            if (cs.getCustomerId().equals(tempShare.getCustomerId()) && cs.getStockSymbol().equals(tempShare.getStockSymbol())) {
                throw new BrokerException("Duplicate Share : " + cs.getCustomerId() + " " + cs.getStockSymbol());
            }
        }
        shares.add(cs);
    }

    public void updateCustomerShare(CustomerShare cs) throws BrokerException {
        for (int i = 0; i < shares.size(); i++) {
            CustomerShare tempShare = shares.get(i);
            if (cs.getCustomerId().equals(tempShare.getCustomerId()) && cs.getStockSymbol().equals(tempShare.getStockSymbol())) {
                tempShare.setQuantity(tempShare.getQuantity() + cs.getQuantity());
                return;
            }
        }
        throw new BrokerException("Share : " + cs.getCustomerId() + " " + cs.getStockSymbol() + " not found.");
    }

    public Stock[] getAllStocks() throws BrokerException {
        return stocks.toArray(new Stock[0]);
    }

    public Stock getStock(String symbol) throws BrokerException {
        Stock stock = null;
        boolean stockFound = false;
        for (int i = 0; i < stocks.size(); i++) {
            stock = stocks.get(i);
            if (stock.getSymbol().equals(symbol)) {
                stockFound = true;
                break;
            }
        }

        if (stockFound) {
            return stock;
        } else {
            throw new BrokerException("Stock : " + symbol + " not found");
        }
    }

    public void addStock(Stock stock) throws BrokerException {
        try {
            getStock(stock.getSymbol());
            throw new BrokerException("Duplicate Stock : " + stock.getSymbol());
        } catch (BrokerException be) {
            stocks.add(stock);
        }
    }

    public void updateStock(Stock stock) throws BrokerException {
        Stock stk = getStock(stock.getSymbol());
        stk.setPrice(stock.getPrice());
    }

    public void deleteStock(Stock stock) throws BrokerException {
        Stock stk = null;
        boolean stockFound = false;
        int index = 0;
        for (; index < stocks.size(); index++) {
            stk = stocks.get(index);
            if (stk.getSymbol().equals(stock.getSymbol())) {
                stockFound = true;
                break;
            }
        }

        if (stockFound) {
            stocks.remove(index);
        } else {
            throw new BrokerException("Stock : " + stock.getSymbol() + " not found");
        }
    }
}
