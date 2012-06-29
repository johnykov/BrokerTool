/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trader.web;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import trader.BrokerModel;
import trader.BrokerModelImpl;
import trader.Stock;

/**
 *
 * @author Johnny
 */
@ManagedBean(name = "stocks")
@RequestScoped
public class StocksManagedBean {

    private BrokerModel model = BrokerModelImpl.getInstance();

    public Stock[] getAllStocks(){
        try {
            return model.getAllStocks();
        } catch (Exception e) {
            return null;
        }
    }
    /**
     * Creates a new instance of StocksManagedBean
     */
    public StocksManagedBean() {
    }
}
