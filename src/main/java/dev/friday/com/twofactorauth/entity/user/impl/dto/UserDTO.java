package dev.friday.com.twofactorauth.entity.user.impl.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import dev.friday.com.twofactorauth.entity.user.User;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class UserDTO implements User {
    private Long id;
    private String email;
    private String password;
    private UUID token;
    private Boolean isVerified;
    private Boolean sendedConfirmation;
    private String verificationCode;
    private Date createdDate;
    private Date lastModified;
    private Date verificationDate;

    public static UserDTO of(User user) {
        return UserDTO.builder()
                .email(user.getEmail())
                .isVerified(user.getIsVerified())
                .lastModified(user.getLastModified())
                .createdDate(user.getCreatedDate())
                .sendedConfirmation(user.getSendedConfirmation())
                .verificationDate(user.getVerificationDate())
                .build();
    }
}
