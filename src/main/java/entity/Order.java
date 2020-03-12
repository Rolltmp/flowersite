package entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Order implements Serializable {

    private int orderNum;
    private String email;
    private Timestamp orderDate;
    private String address;
    private String description;

    public Order(String email,String address, String description) {
        this.email = email;
        this.address = address;
        this.description = description;
    }

    public Order(int orderNum, String email, String address, String description, Timestamp orderDate) {
        this(email,address,description);
        this.orderNum = orderNum;
        this.orderDate = orderDate;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public String getEmail() {
        return email;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public String getAddress() {
        return address;
    }

    public String getDescription() {
        return description;
    }
}
