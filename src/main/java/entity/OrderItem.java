package entity;

import java.io.Serializable;

public class OrderItem implements Serializable{

    private int orderNum;
    private int flowerNum;
    private int quantity;
    private int totalPrice;

    public OrderItem(int orderNum, int flowerNum, int quantity, int totalPrice) {
        this.orderNum = orderNum;
        this.flowerNum = flowerNum;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public int getFlowerNum() {
        return flowerNum;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getTotalPrice() {
        return totalPrice;
    }
}
