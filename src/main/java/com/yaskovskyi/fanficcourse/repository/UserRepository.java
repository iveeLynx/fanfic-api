package com.yaskovskyi.fanficcourse.repository;

import com.yaskovskyi.fanficcourse.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UserRepository extends CrudRepository<User, Integer> {

//    public User findAllByEmail();

    @Query("SELECT u FROM User u WHERE u.email = ?1")
    public User findByEmail(String email);
}
