package dev.friday.com.twofactorauth.util;

import dev.friday.com.twofactorauth.entity.dto.UserDTO;
import lombok.experimental.UtilityClass;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;

import java.util.Arrays;

@UtilityClass
public class UserUtils {

    private String regexEmailPattern;

    public boolean isUsernameEmail(String username) {
        return username.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    }
}
