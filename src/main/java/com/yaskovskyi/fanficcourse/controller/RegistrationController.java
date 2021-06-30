package com.yaskovskyi.fanficcourse.controller;

import com.yaskovskyi.fanficcourse.model.User;
import com.yaskovskyi.fanficcourse.service.UserDataService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/registration")
public class RegistrationController {
    private final UserDataService userService;
    private int count;

    public RegistrationController(UserDataService userService) {
        this.userService = userService;
    }

    @PostMapping (value = "/process_register",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<User> processRegister(@RequestBody User user) {
        System.out.println(user.getEmail() + "     " + user.getUserName() + "    " + user.getPassword());
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userService.saveUser(user);
        return ResponseEntity.created(URI.create(String.format("/user/%s", user.getUserName()))).body(user);
    }
}
