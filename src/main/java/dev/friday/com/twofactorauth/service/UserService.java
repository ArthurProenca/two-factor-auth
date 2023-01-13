package dev.friday.com.twofactorauth.service;

import dev.friday.com.twofactorauth.entity.user.User;
import dev.friday.com.twofactorauth.entity.user.dto.UserDTO;
import dev.friday.com.twofactorauth.entity.user.dto.UserValidatorDTO;
import dev.friday.com.twofactorauth.repository.user.UserRepository;
import dev.friday.com.twofactorauth.utils.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class UserService {

    private UserUtil userUtils;

    private final UserRepository userRepository;

    public Object createUser(UserDTO userDTO) {
        if (UserUtil.isEmail(userDTO.getUsername())) {
            throw new RuntimeException("Username must be email");
        }

        return userRepository.save(User.builder()
                .username(userDTO.getUsername())
                .password(userDTO.getPassword())
                .isVerified(false)
                .lastModified(Date.from(java.time.Instant.now()))
                .createdDate(Date.from(java.time.Instant.now()))
                .sendedConfirmation(false)
                .verificationDate(null)
                .verificationCode(null)
                .build());
    }

    public Object confirmUser(UserValidatorDTO userValidatorDTO) {
        User user = userRepository.findByUsername(userValidatorDTO.getEmail());
        if (user == null) {
            throw new RuntimeException("User not found");
        }

        if (user.getIsVerified()) {
            throw new RuntimeException("User already verified");
        }

        if(!user.getVerificationCode().equals(userValidatorDTO.getActivationCode())) {
            throw new RuntimeException("Activation code is not correct");
        }
        user.setIsVerified(true);
        user.setVerificationDate(Date.from(Instant.now()));

        return userRepository.save(user);
    }
}
