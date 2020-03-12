package dao.factory;

import dao.*;

import java.sql.Connection;

public class MysqlDAOFactory extends DAOFactory {



    public static Connection getConnection() {
        return null;
    }

    @Override
    public UserDAO getUserDAO() {
        return null;
    }

    @Override
    public ProductDAO getProductDAO() {
        return null;
    }

    @Override
    public OrderItemDAO getOrderItemDAO() {
        return null;
    }

    @Override
    public OrderDAO getOrderDAO() {
        return null;
    }
}
