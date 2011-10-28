package trader;

public interface BrokerModel {

// Customer segment state change methods
    /**-------------------------------------------------------------
     * Adds the Customer to the broker model
     */
    public void addCustomer(Customer cust)
            throws BrokerException;

    /**-------------------------------------------------------------
     * Deletes the customer from the broker model
     */
    public void deleteCustomer(Customer cust)
            throws BrokerException;

    /**-------------------------------------------------------------
     * Updates the customer in the broker model
     */
    public void updateCustomer(Customer cust)
            throws BrokerException;

// Customer segment state query methods
    /**-------------------------------------------------------------
     * Given an id, returns the Customer from the model
     */
    public Customer getCustomer(String id)
            throws BrokerException;

    /**-------------------------------------------------------------
     * Returns all customers in the broker model
     */
    public Customer[] getAllCustomers()
            throws BrokerException;

// Portfolio segment - TBD in future iteration
// Add Portfolio segment state change methods
// Add Portfolio segment state query methods
    public CustomerShare[] getAllCustomerShares(String customerId)
            throws BrokerException;

    public void addCustomerShare(CustomerShare cs)
            throws BrokerException;

    public void updateCustomerShare(CustomerShare cs)
            throws BrokerException;

// Stock segment - TBD in future iteration
// Add Stock segment state change methods
// Add Stock segment state query methods
    public Stock[] getAllStocks()
            throws BrokerException;

    public Stock getStock(String symbol)
            throws BrokerException;

    public void addStock(Stock stock)
            throws BrokerException;

    public void updateStock(Stock stock)
            throws BrokerException;

    public void deleteStock(Stock stock)
            throws BrokerException;
}
