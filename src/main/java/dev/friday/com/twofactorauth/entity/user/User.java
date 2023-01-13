package dev.friday.com.twofactorauth.entity.user;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TUSER")
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "USERNAME", nullable = false)
    private String username;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "IS_VERIFIED", nullable = false)
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
}
