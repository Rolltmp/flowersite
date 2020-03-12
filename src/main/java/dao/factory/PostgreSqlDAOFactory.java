package dao.factory;

import dao.*;
import dao.postgre.PostgreOrderDAO;
import dao.postgre.PostgreOrderItemDAO;
import dao.postgre.PostgreProductDAO;
import dao.postgre.PostgreUserDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreSqlDAOFactory extends DAOFactory{

    private static String NAME = "admin_flower";
    private static String PASSWORD = "610917";
    private static String URL = "jdbc:postgresql://localhost:1997/flower";

    public UserDAO getUserDAO(){
        return new PostgreUserDAO();
    }

    public ProductDAO getProductDAO(){
        return new PostgreProductDAO();
    }

    public OrderItemDAO getOrderItemDAO() {
        return new PostgreOrderItemDAO();
    }

    public OrderDAO getOrderDAO() {
        return new PostgreOrderDAO();
    }

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(URL, NAME, PASSWORD);
    }

}
