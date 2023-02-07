package dev.friday.com.twofactorauth.entity.user.impl.dao;

import dev.friday.com.twofactorauth.entity.user.User;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDAO implements User {
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

    public static UserDAO of(User user) {
        return UserDAO.builder()
                .email(user.getEmail())
                .isVerified(user.getIsVerified())
                .lastModified(user.getLastModified())
                .createdDate(user.getCreatedDate())
                .sendedConfirmation(user.getSendedConfirmation())
                .verificationDate(user.getVerificationDate())
                .build();
    }
}
