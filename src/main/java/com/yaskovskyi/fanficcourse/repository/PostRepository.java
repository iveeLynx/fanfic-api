package com.yaskovskyi.fanficcourse.repository;

import com.yaskovskyi.fanficcourse.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {


//    @Query("SELECT u FROM Post u WHERE u.id = 1")
//    public Iterable<Post> findAll();
//
//    @Query("SELECT u FROM Post u")
//    Iterable<Post> findAll();


//    @Query("SELECT u FROM u test where u.id=1")
//    Iterable<Post> findAll();
//    @Query(value = "select * from test", nativeQuery = true)
//    Iterable<Post> findAll();

    @Query(value = "select * from test", nativeQuery = true)
    Iterable<Post> findAllByFanficName();
}
