package dao;

import entity.Product;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    private Cart(){
        cart = new HashMap<>();
    }
    private static final Cart instance = new Cart();

    public static Cart getInstance() {
        return instance;
    }

    private Map<Product, Integer> cart;

    public Map<Product, Integer> getCart() {
        return cart;
    }

    public void putToCart(Product key, Integer value){

        cart.put(key,value);
    }

    public void deleteFromCart(Product key){
        cart.remove(key);
    }

    public void addQuantity(Product key){
        cart.put(key, cart.get(key)+1);
    }

    public void takeAwayQuantity(Product key){
        cart.put(key, cart.get(key)-1);
    }

    public void flushCart(){

        this.cart = new HashMap<>();

    }

}
