package entity;

import java.io.Serializable;

public class Product implements Serializable {

    private int flowerNumber;
    private String flowerName;
    private String imageUrl;
    private String imageUrlBig;
    private String description;
    private int price;
    private String consisting;
    private int width;
    private int height;
    private int quantity;

    public Product(String flowerName, String imageUrl, String description,
                   String imageUrlBig,
                   int price, String consisting, int width, int height) {
        this.flowerName = flowerName;
        this.imageUrl = imageUrl;
        this.description = description;
        this.imageUrlBig = imageUrlBig;
        this.price = price;
        this.consisting = consisting;
        this.width = width;
        this.height = height;
    }

    public Product(String flowerName, String imageUrl,  String imageUrlBig,
                   String description,
                   int price, String consisting, int width, int height, int flowerNumber,
                    int quantity) {
        this(flowerName,imageUrl,imageUrlBig,description,price,consisting,width,height);
        this.flowerNumber = flowerNumber;
        this.quantity = quantity;
    }

    @Override
    public int hashCode() {
        return flowerNumber;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Product) && ((Product) obj).flowerNumber == flowerNumber;
    }

    public int getFlowerNumber() {
        return flowerNumber;
    }

    public void setConsisting(String consisting) {
        this.consisting = consisting;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFlowerName() {
        return flowerName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public String getConsisting() {
        return consisting;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getImageUrlBig() {
        return imageUrlBig;
    }

    public int getQuantity() {
        return quantity;
    }

}
