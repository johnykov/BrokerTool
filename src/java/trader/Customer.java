package trader;

import java.io.Serializable;

public class Customer implements Serializable {

    private String id;
    private String name;
    private String addr;

    // Constructors
    public Customer(String id, String name, String addr) {
        this.id = id;
        this.name = name;
        this.addr = addr;
    }

    public Customer(String id) {
        this(id, null, null);
    }

    public Customer() {
        this(null, null, null);
    }

    // Accesser methods
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddr() {
        return addr;
    }

    // Mutator methods - note you cannot change the id
    public void setName(String newName) {
        name = newName;
    }

    public void setAddr(String newAddr) {
        addr = newAddr;
    }

    public String toString() {
        return "Customer:  " + id + "  " + name + "  " + addr;
    }
}

