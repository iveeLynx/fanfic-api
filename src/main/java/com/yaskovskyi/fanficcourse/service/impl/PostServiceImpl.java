package com.yaskovskyi.fanficcourse.service.impl;

import com.yaskovskyi.fanficcourse.model.Post;
import com.yaskovskyi.fanficcourse.repository.PostRepository;
import com.yaskovskyi.fanficcourse.repository.UserRepository;
import com.yaskovskyi.fanficcourse.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepo;

//    public PostServiceImpl() {
//
//    }

    @Override
    public List<Post> getPosts() {
        List<Post> posts = new ArrayList<>(postRepo.findAll());
        System.out.println(posts);
        return posts;
    }

}
