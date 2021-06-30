package com.yaskovskyi.fanficcourse;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yaskovskyi.fanficcourse.model.User;
import com.yaskovskyi.fanficcourse.service.UserDataService;
import org.apache.catalina.connector.Connector;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class FanficCourseApplication {

    @Value("${http.port}")
    private int httpPort;

    public static void main(String[] args) {
        SpringApplication.run(FanficCourseApplication.class, args);
    }


    // Let's configure additional connector to enable support for both HTTP and HTTPS
    @Bean
    public ServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        tomcat.addAdditionalTomcatConnectors(createStandardConnector());
        return tomcat;
    }

    private Connector createStandardConnector() {
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setPort(httpPort);
        return connector;
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
