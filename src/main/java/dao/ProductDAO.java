package dao;

import entity.Product;

import java.util.List;

public interface ProductDAO {

    List<Product> showProducts(int price);
    Product getProduct(int num);
    int[] priceMinMax();
    int quantityOfGoods(Product product);

}
