package dev.friday.com.twofactorauth.entity.user.impl.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserValidatorDTO {
    private String email;
    private String activationCode;
}
