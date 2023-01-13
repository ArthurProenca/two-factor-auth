package dev.friday.com.twofactorauth.entity.user.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {
    private String username;
    private String password;
}
