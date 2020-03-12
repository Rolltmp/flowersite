package dao.postgre;

import dao.ProductDAO;
import dao.factory.PostgreSqlDAOFactory;
import entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostgreProductDAO implements ProductDAO{

    @Override
    public List<Product> showProducts(int price) {

        String condition1 = "1 = 1";
        if(price != 0) condition1 = "price <= ?";
        String sql = "SELECT * FROM product WHERE " + condition1 + " ORDER BY price";
        List<Product> products = new ArrayList<>();
        try (Connection connection = PostgreSqlDAOFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){
            if(price != 0) statement.setInt(1,price);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                products.add(new Product(rs.getString("flower_name"),
                        rs.getString("image_url"), rs.getString("description"),
                        rs.getString("full_image_url"),
                        rs.getInt("price"),rs.getString("consisting"),
                        rs.getInt("width"),rs.getInt("height"),rs.getInt("flower_num"),
                        rs.getInt("quantity")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public int[] priceMinMax() {

        String sql1 = "SELECT min(price) FROM product;";
        String sql2 = "SELECT max(price) FROM product";
        int prices[] = new int[2];
        Statement statement = null;
        ResultSet set = null;
        try (Connection connection = PostgreSqlDAOFactory.getConnection()){
            statement = connection.createStatement();
            set = statement.executeQuery(sql1);
            if(set.next()) prices[0] = set.getInt(1);
            set = statement.executeQuery(sql2);
            if(set.next()) prices[1] = set.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (set != null) {
                    set.close();
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return prices;
    }

    @Override
    public Product getProduct(int num) {

        String sql = "SELECT * FROM product WHERE flower_num = ?";

        try(Connection connection = PostgreSqlDAOFactory.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1,num);
            ResultSet set = statement.executeQuery();
            if(set.next()) return new Product(set.getString("flower_name"),
                    set.getString("image_url"),set.getString("full_image_url"),
                    set.getString("full_image_url"),set.getInt("price"),
                    set.getString("consisting"),set.getInt("width"),
                    set.getInt("height"),set.getInt("flower_num"),
                    set.getInt("quantity"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int quantityOfGoods(Product product) {

        String sql = "SELECT quantity FROM product WHERE flower_num = ?";

        try (Connection connection = PostgreSqlDAOFactory.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setInt(1,product.getFlowerNumber());
            ResultSet set = statement.executeQuery();
            if(set.next()) return set.getInt(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }
}
