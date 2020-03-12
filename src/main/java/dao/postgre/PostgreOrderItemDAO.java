package dao.postgre;


import dao.OrderItemDAO;
import dao.factory.PostgreSqlDAOFactory;
import entity.OrderItem;
import entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PostgreOrderItemDAO implements OrderItemDAO{

    @Override
    public boolean createOrderItem(OrderItem oi) {

        String sql = "INSERT INTO \"orderitem\" VALUES(?,?,?,?)";
        try (Connection connection = PostgreSqlDAOFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setInt(1,oi.getOrderNum());
            statement.setInt(2,oi.getFlowerNum());
            statement.setInt(3,oi.getQuantity());
            statement.setInt(4,oi.getTotalPrice());
            statement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addOrderItems(Map<Product, Integer> oiList, int orderNum) {
        List<Product> products = new ArrayList<>(oiList.keySet());
        List<Integer> values = new ArrayList<>(oiList.values());
        String sql = "INSERT INTO \"orderitem\" VALUES(?,?,?,?)";
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = PostgreSqlDAOFactory.getConnection();
            statement = connection.prepareStatement(sql);
            connection.setAutoCommit(false);
            int q = 0;
            for (int i = 0; i < oiList.size(); i++) {
                q = values.get(i) * products.get(i).getPrice();
                statement.setInt(1,orderNum);
                statement.setInt(2,products.get(i).getFlowerNumber());
                statement.setInt(3,values.get(i));
                statement.setInt(4,q);
                statement.executeUpdate();
            }
            connection.commit();
            return true;
        } catch (SQLException e) {
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();

        }finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if(connection != null){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return false;
    }
}
