package com.yaskovskyi.fanficcourse.controller;

import com.yaskovskyi.fanficcourse.model.Post;
import com.yaskovskyi.fanficcourse.service.impl.PostServiceImpl;
import net.minidev.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostsController {

    private final PostServiceImpl postServiceImpl;

    public PostsController(PostServiceImpl postServiceImpl) {
        this.postServiceImpl = postServiceImpl;
    }
//    @GetMapping("/show")
//    public void getPosts() {
//
//    }


    @RequestMapping(value = "/show", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Post>> getAll() {
        List<Post> entityList = postServiceImpl.getPosts();
        System.out.println(entityList);
        return new ResponseEntity<>(entityList, HttpStatus.OK);
    }

}
