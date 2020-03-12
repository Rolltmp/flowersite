package dao;

import entity.User;

public interface UserDAO {

    boolean createUser(User user);
    boolean loginUser(String email, String password);
    User getUser(String email);
    boolean updateUser(User user);
    boolean changePassword(User user);


}
