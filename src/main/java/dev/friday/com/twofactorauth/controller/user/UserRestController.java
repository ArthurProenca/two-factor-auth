package dev.friday.com.twofactorauth.controller.user;

import dev.friday.com.twofactorauth.controller.base.BaseRestController;
import dev.friday.com.twofactorauth.entity.user.impl.dto.UserDTO;
import dev.friday.com.twofactorauth.entity.user.impl.dto.UserValidatorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

public interface UserRestController extends BaseRestController {

    ResponseEntity<?> createUser(UserDTO userDTO);
    ResponseEntity<?> confirmUser(UserValidatorDTO userValidatorDTO);
}
