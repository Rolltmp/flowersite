package servlet.valid;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Verification {

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    public static final Pattern VALID_PHONE_REGEX =
            Pattern.compile("^[0-9]{10,12}$");
    public static final Pattern VALID_PASSWORD_REGEX =
            Pattern.compile("^[A-z0-9_]+$");
    public static final Pattern VALID_NUMBER = Pattern.compile("^[0-9]+$");

    private Verification(){}

    public static boolean correctEmail(String email){
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        return matcher.find();
    }

    public static boolean correctPhone(String phone){
        Matcher matcher = VALID_PHONE_REGEX.matcher(phone);
        return matcher.find();
    }

    public static boolean correctPassword(String password){
        if(password.length() > 14){
            return false;
        }
        Matcher matcher = VALID_PASSWORD_REGEX.matcher(password);
        return matcher.find();
    }

    public static boolean isNumber(String numb, int n){

        if(numb.length() <= n){
            Matcher matcher = VALID_NUMBER.matcher(numb);
            return matcher.find();
        }
        return false;
    }

    public static boolean equalsPassword(String p1, String p2){
        return p1.equals(p2);
    }
}
