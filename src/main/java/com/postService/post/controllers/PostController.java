package com.postService.post.controllers;

import com.postService.post.VOs.PostAndUser;
import com.postService.post.VOs.UserVO;
import com.postService.post.clients.FeignClientProfile;
import com.postService.post.entities.Post;
import com.postService.post.service.PostService;
import com.postService.post.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private FeignClientProfile clientProfile;

    @GetMapping("/{postId}")
    public ResponseEntity<Response>getPost(@PathVariable String postId){
        Post post= postService.getPost(postId);
        ResponseEntity<Response> clientResponse=clientProfile.getProfile(post.getAuthorId());
        HashMap map = (HashMap) clientResponse.getBody().getData();
        UserVO user=new UserVO((String) map.get("userId"),(String) map.get("name"),(String) map.get("image"));
        PostAndUser response=new PostAndUser(post,user);
        Response<PostAndUser> apiResponse = new Response<>("Success", HttpStatus.OK.value(), response);
        return new ResponseEntity<Response>(apiResponse, HttpStatus.OK);

    }
}
