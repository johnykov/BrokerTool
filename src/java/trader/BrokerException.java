package trader;

public class BrokerException extends Exception {

    /**
     * Creates new <code>BrokerException</code> without detail message.
     */
    public BrokerException() {
        this("BrokerException");
    }

    /**
     * Constructs an <code>BrokerException</code> with the specified
     * detail message.
     * @param msg the detail message.
     */
    public BrokerException(String msg) {
        super(msg);
    }
}
