package trader;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "STOCK")
public class Stock implements Serializable {

    @Id
    @Column(name = "SYMBOL")
    private String symbol;
    @Column(name = "PRICE")
    private double price;

    public Stock() {
    }

    public Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }

    // Methods to return the private values of this object
    public double getPrice() {
        return price;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setPrice(double newPrice) {
        price = newPrice;
    }

    public String toString() {
        return "Stock:  " + symbol + "  " + price;
    }
}
