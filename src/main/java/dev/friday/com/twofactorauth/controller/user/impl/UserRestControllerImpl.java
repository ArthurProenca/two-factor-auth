package dev.friday.com.twofactorauth.controller.user.impl;

import dev.friday.com.twofactorauth.controller.user.UserRestController;
import dev.friday.com.twofactorauth.entity.user.impl.dto.UserDTO;
import dev.friday.com.twofactorauth.entity.user.impl.dto.UserValidatorDTO;
import dev.friday.com.twofactorauth.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserRestControllerImpl implements UserRestController {

    private final UserService userService;

    @Override
    @PostMapping("/v1/signup")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok().body(userService.createUser(userDTO));
    }

    @Override
    @PutMapping("/v1/confirm")
    public ResponseEntity<UserDTO> confirmUser(@RequestBody UserValidatorDTO userValidatorDTO) {
        return ResponseEntity.ok().body(userService.confirmUser(userValidatorDTO));
    }

}
