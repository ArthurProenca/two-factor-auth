package dev.friday.com.twofactorauth.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class UserUtil {

    public static boolean isValidEmail(String email) {
        //regex to verify email
        return !email.matches("^([\\w\\.\\-]+)@([\\w\\-]+)((\\.(\\w){2,3})+)$");
    }

    //generate a random 6 digit code
    public static String generateCode() {
        return String.valueOf((int) (Math.random() * 900000) + 100000);
    }
}
