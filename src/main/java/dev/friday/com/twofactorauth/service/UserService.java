package dev.friday.com.twofactorauth.service;

import dev.friday.com.twofactorauth.entity.User;
import dev.friday.com.twofactorauth.entity.dto.UserDTO;
import dev.friday.com.twofactorauth.repository.UserRepository;
import dev.friday.com.twofactorauth.util.UserUtils;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private UserUtils userUtils;

    private final UserRepository userRepository;
    public Object createUser(UserDTO userDTO) {
        User user = new User();
        if(userUtils.isUsernameEmail(userDTO.getUsername())) {
            BeanUtils.copyProperties(userDTO, user);
            return userRepository.save(user);
        }
        return false;
    }
}
