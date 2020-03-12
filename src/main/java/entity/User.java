package entity;

import java.io.Serializable;

public class User implements Serializable{

    private String userName;
    private String userPass;
    private String userPhone;
    private String email;

    public User(String userName, String userPass, String userPhone, String email) {
        this.userName = userName;
        this.userPass = userPass;
        this.userPhone = userPhone;
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
}
