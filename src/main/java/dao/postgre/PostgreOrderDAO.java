package dao.postgre;

import dao.OrderDAO;
import dao.factory.PostgreSqlDAOFactory;
import entity.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostgreOrderDAO implements OrderDAO{


    @Override
    public int createOrder(Order order) {

        String sql = "INSERT INTO \"order\"(email,address,description) " +
                "VALUES(?,?,?)";
        try (Connection connection = PostgreSqlDAOFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            statement.setString(1,order.getEmail());
            statement.setString(2,order.getAddress());
            statement.setString(3,order.getDescription());
            statement.executeUpdate();
            ResultSet set = statement.getGeneratedKeys();
            if(set.next()) return set.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Order> orders(String email) {

        List<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM \"order\" WHERE email = ?";
        try (Connection connection = PostgreSqlDAOFactory.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setString(1,email);
            ResultSet set = statement.executeQuery();
            while (set.next()){

                orders.add(new Order(set.getInt("order_num"),set.getString("email"),
                        set.getString("address"),set.getString("description"),
                        set.getTimestamp("order_date")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }
}
