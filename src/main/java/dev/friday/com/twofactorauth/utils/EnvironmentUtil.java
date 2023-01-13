package dev.friday.com.twofactorauth.utils;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@Getter
public class EnvironmentUtil {
    private final Environment environment;

    public String getEnvironmentProperty(String key) {
        return environment.getProperty("smpt_email");
    }
}
