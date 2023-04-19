package dev.friday.com.twofactorauth.entity.user.impl;

import dev.friday.com.twofactorauth.entity.user.User;
import dev.friday.com.twofactorauth.entity.user.impl.dto.UserDTO;
import dev.friday.com.twofactorauth.utils.UserUtil;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "TUSER")
public class UserImpl implements User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Long id;
    @Column(name = "EMAIL", nullable = false)
    private String email;
    @Column(name = "PASSWORD", nullable = false)
    private String password;
    @Column(name = "GENERATED_TOKEN", nullable = false)
    private UUID token;
    @Column(name = "VERIFIED", nullable = false)
    private Boolean isVerified;
    @Column(name = "SENDED_CONFIRMATION", nullable = false)
    private Boolean sendedConfirmation;
    @Column(name = "VERIFICATION_CODE", nullable = true)
    private String verificationCode;
    @Column(name = "CREATED_DATE", nullable = false)
    private Date createdDate;
    @Column(name = "LAST_MODIFIED", nullable = false)
    private Date lastModified;
    @Column(name = "VERIFICATION_DATE", nullable = true)
    private Date verificationDate;

    @Transient
    public static UserImpl from(UserDTO userDTO) {
        return UserImpl.builder()
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .isVerified(false)
                .lastModified(Date.from(java.time.Instant.now()))
                .createdDate(Date.from(java.time.Instant.now()))
                .sendedConfirmation(false)
                .verificationDate(null)
                .verificationCode(UserUtil.generateCode())
                .token(UUID.randomUUID())
                .build();
    }
}
