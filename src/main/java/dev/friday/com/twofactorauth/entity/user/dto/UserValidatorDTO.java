package dev.friday.com.twofactorauth.entity.user.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserValidatorDTO {
    private String email;
    private String activationCode;
}
