package dev.friday.com.twofactorauth.service;

import dev.friday.com.twofactorauth.entity.user.User;
import dev.friday.com.twofactorauth.entity.user.impl.UserImpl;
import dev.friday.com.twofactorauth.entity.user.impl.dao.UserDAO;
import dev.friday.com.twofactorauth.entity.user.impl.dto.UserDTO;
import dev.friday.com.twofactorauth.entity.user.impl.dto.UserValidatorDTO;
import dev.friday.com.twofactorauth.exception.validation.ValidationException;
import dev.friday.com.twofactorauth.repository.user.UserRepository;
import dev.friday.com.twofactorauth.utils.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserDAO createUser(UserDTO userDTO) {
        if (UserUtil.isValidEmail(userDTO.getEmail())) {
            throw new ValidationException("Email must be valid (aka: loremipsum@email.com)");
        }

        if(userRepository.findByEmail(userDTO.getEmail()).isPresent()){
            throw new ValidationException("User already exists");
        }

        User userPersisted = userRepository.save(UserImpl.userFactory(userDTO));

        return UserDAO.of(userPersisted);
    }

    public Object confirmUser(UserValidatorDTO userValidatorDTO) {
        UserImpl userImpl = userRepository.findByEmail(userValidatorDTO.getEmail()).orElseThrow(() -> new RuntimeException("User not found"));

        if (userImpl.getIsVerified()) {
            throw new ValidationException("User already verified");
        }

        if(!userImpl.getVerificationCode().equals(userValidatorDTO.getActivationCode())) {
            throw new ValidationException("Activation code is not correct");
        }
        userImpl.setIsVerified(true);
        userImpl.setVerificationDate(Date.from(Instant.now()));

        return userRepository.save(userImpl);
    }
}
