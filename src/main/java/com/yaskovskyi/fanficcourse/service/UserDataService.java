package com.yaskovskyi.fanficcourse.service;

import com.yaskovskyi.fanficcourse.model.User;
import com.yaskovskyi.fanficcourse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDataService implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(userName);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new UserData(user);
    }


    public String checkCredentials(String email, String password) {
        User user = userRepo.findByEmail(email);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if(user==null){
            return "fail";
        } else if(!passwordEncoder.matches(password,user.getPassword())){
            return "fail";
        }
        return "success";
    }

    public void saveUser(User user) {
        userRepo.save(user);
    }

}
