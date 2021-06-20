package com.yaskovskyi.fanficcourse;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yaskovskyi.fanficcourse.model.User;
import com.yaskovskyi.fanficcourse.service.UserDataService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class FanficCourseApplication {

    public static void main(String[] args) {
        SpringApplication.run(FanficCourseApplication.class, args);
    }

//    @Bean
//    CommandLineRunner runner(UserDataService userService) {
//        return args -> {
//            // read json and write to db
//            User user;
//            ObjectMapper mapper = new ObjectMapper();
////            TypeReference<List<User>> typeReference = new TypeReference<List<User>>(){};
//            TypeReference<User> typeReference = new TypeReference<User>() {};
//            InputStream inputStream = TypeReference.class.getResourceAsStream("/json/registerUser.json");
//            try {
//                user = mapper.readValue(inputStream,typeReference);
//                userService.saveUser(user);
//                System.out.println("User Saved");
//            } catch (IOException e){
//                System.out.println("Unable to save users: " + e.getMessage());
//            }
//        };
//    }

}
