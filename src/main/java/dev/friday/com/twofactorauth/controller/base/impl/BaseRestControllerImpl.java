package dev.friday.com.twofactorauth.controller.base.impl;

import dev.friday.com.twofactorauth.controller.base.BaseRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseRestControllerImpl implements BaseRestController {

    @GetMapping("/v1/status")
    public ResponseEntity<?> platformStatus() {
        return ResponseEntity.ok("Platform up and running");
    }

}
