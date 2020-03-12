package dao;

import entity.Order;
import entity.Product;

import java.util.List;

public interface OrderDAO {

    int createOrder(Order order);
    List<Order> orders(String email);

}
