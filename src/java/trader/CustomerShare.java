package trader;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "SHARES")
public class CustomerShare implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    @Column(name = "SSN")
    private String customerId;
    @Column(name = "SYMBOL")
    private String stockSymbol;
    @Column(name = "QUANTITY")
    private int quantity;

    public CustomerShare() {
    }

    public CustomerShare(String customerId, String stockSymbol, int quantity) {
        this.customerId = customerId;
        this.stockSymbol = stockSymbol;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public void setStockSymbol(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
