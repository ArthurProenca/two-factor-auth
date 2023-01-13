package dev.friday.com.twofactorauth.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class UserUtil {

    private String regexEmailPattern;

    public boolean isEmail(String username) {
        //regex to verify email
        return username.matches("^[a-z0-9.]+@[a-z0-9]+\\.[a-z]+\\.([a-z]+)?$");
    }

    //generate a random 6 digit code
    public static String generateCode() {
        return String.valueOf((int) (Math.random() * 900000) + 100000);
    }
}
