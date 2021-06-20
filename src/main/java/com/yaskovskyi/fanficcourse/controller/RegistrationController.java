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
    private UserDataService userService;

    public RegistrationController(UserDataService userService) {
        this.userService = userService;
    }

//    private final

//    @GetMapping("/registration")
//    public String registration(Model model){
//        model.addAttribute("user", new User());
//        return "registration";
//    }

    @PostMapping (value = "/process_register",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<User> processRegister(@RequestBody User user) {
        System.out.println(user.getEmail() + "     " + user.getUserName() + "    " + user.getPassword());
        userService.saveUser(user);
        return ResponseEntity
                .created(URI
                        .create(String.format("/user/%s", user.getUserName())))
                .body(user);
//        java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
//        if (user.getEmail() != "" && user.getName() != "" && userRepo.findByEmail(user.getEmail()) == null) {
//            user.setRegistrationDate(date.toString());
//            user.setLastLoginDate(date.toString());
//            user.setStatus("Offline");
//            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
//            userRepo.save(user);
//            return "index";
//        }
//        return "index";
    }
}
