package dev.friday.com.twofactorauth.entity.dao;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDAO {
    private String username;
    private String password;
}
