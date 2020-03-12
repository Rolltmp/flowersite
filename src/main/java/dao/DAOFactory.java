package dao;

import dao.factory.MysqlDAOFactory;
import dao.factory.PostgreSqlDAOFactory;

import java.sql.Connection;

public abstract class DAOFactory {

    public static final int MYSQL = 1;
    public static final int POSTGRESQL = 2;

    public abstract UserDAO getUserDAO();
    public abstract ProductDAO getProductDAO();
    public abstract OrderItemDAO getOrderItemDAO();
    public abstract OrderDAO getOrderDAO();

    public static DAOFactory getDAOFactory(int whichFactory){
        switch (whichFactory){
            case MYSQL:
                return new MysqlDAOFactory();
            case POSTGRESQL:
                return new PostgreSqlDAOFactory();
            default:
                return new PostgreSqlDAOFactory();
        }
    }
}
