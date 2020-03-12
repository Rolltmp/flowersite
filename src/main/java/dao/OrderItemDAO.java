package dao;

import entity.OrderItem;
import entity.Product;

import java.util.List;
import java.util.Map;

public interface OrderItemDAO {

    boolean createOrderItem(OrderItem oi);
    boolean addOrderItems(Map<Product,Integer> oiList, int orderNum);

}
