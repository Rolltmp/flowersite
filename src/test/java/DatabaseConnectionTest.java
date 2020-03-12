import dao.DAOFactory;
import dao.factory.PostgreSqlDAOFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseConnectionTest {

    public static void main(String[] args) {

        String sql = "select * from test where 2 > 1";
        DAOFactory dao = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
        try (Connection connection = PostgreSqlDAOFactory.getConnection();
             PreparedStatement pst = connection.prepareStatement(sql)){
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                System.out.println(rs.getInt("user_id") + " " + rs.getString("desc"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
