package com.postService.post.controllers;

import com.postService.post.clients.FeignClientProfile;
import com.postService.post.entities.Post;
import com.postService.post.service.PostService;
import com.postService.post.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private PostService postService;

    @Autowired
    private FeignClientProfile clientProfile;

    @GetMapping("/name/{name}")
    public ResponseEntity<Response>getUser(@PathVariable("name") String name){
        System.out.println(name);
        ResponseEntity<Response> clientResponse = clientProfile.getProfileFromName(name);
        HashMap map = (HashMap) clientResponse.getBody().getData();
        String authorId = (String)map.get("userId");
        Post post = postService.getPostFromUser(authorId);
        return ResponseEntity.ok(new Response("Search successful",200,clientResponse+post.getId()+post.getNoOfViews()));
    }
}