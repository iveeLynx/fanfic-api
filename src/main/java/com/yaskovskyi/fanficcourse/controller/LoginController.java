package com.yaskovskyi.fanficcourse.controller;

import com.yaskovskyi.fanficcourse.model.User;
import com.yaskovskyi.fanficcourse.service.UserDataService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {


    private final UserDataService userService;
    private int count;

    public LoginController(UserDataService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/process_login",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public @ResponseBody String processLogin(@RequestBody User user) {
        System.out.println("USER " + user.getEmail() + user.getPassword());
        return userService.checkCredentials(user.getEmail(), user.getPassword());

    }
}
