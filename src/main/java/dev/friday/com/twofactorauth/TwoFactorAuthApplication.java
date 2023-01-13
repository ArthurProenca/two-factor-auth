package dev.friday.com.twofactorauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TwoFactorAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(TwoFactorAuthApplication.class, args);
    }

}
