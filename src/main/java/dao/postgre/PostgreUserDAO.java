package dao.postgre;

import dao.DAOException;
import dao.UserDAO;
import dao.factory.PostgreSqlDAOFactory;
import entity.User;

import java.sql.*;

public class PostgreUserDAO implements UserDAO {


    @Override
    public boolean createUser(User user) {
        String sql = "INSERT INTO \"user\" VALUES(?,?,?,?)";
        try (Connection connection = PostgreSqlDAOFactory.getConnection()){
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,user.getUserPass());
            statement.setString(2,user.getUserName());
            statement.setString(3,user.getUserPhone());
            statement.setString(4,user.getEmail());
            statement.execute();
            return true;
        } catch (SQLException e) {
            //e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean loginUser(String email, String password) {

        String sql = "SELECT \"user\".email,\"user\".user_pass FROM \"user\" WHERE EXISTS(SELECT 1 FROM user WHERE \"user\".email = ?\n" +
                "AND \"user\".user_pass = ?)";
        try (Connection connection = PostgreSqlDAOFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1,email);
            statement.setString(2,password);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public User getUser(String email) {

        String sql = "SELECT * FROM \"user\" WHERE \"user\".email = ?";
        try (Connection connection = PostgreSqlDAOFactory.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1,email);
            ResultSet set = statement.executeQuery();
            if(set.next()) return new User(set.getString("user_name"),
                    set.getString("user_pass"),set.getString("user_phone"),
                    set.getString("email"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateUser(User user) {

        String sql = "UPDATE \"user\" SET user_name = ?, user_phone = ? WHERE email = ?";
        try(Connection connection = PostgreSqlDAOFactory.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1,user.getUserName());
            statement.setString(2,user.getUserPhone());
            statement.setString(3,user.getEmail());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean changePassword(User user) {

        String sql = "UPDATE \"user\" SET user_pass = ? WHERE email = ?";

        try (Connection connection = PostgreSqlDAOFactory.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1,user.getUserPass());
            statement.setString(2,user.getEmail());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
