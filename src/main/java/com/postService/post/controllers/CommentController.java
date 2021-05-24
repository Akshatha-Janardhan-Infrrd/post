package com.postService.post.controllers;

import com.postService.post.VOs.CommentVO;
import com.postService.post.entities.Comment;
import com.postService.post.service.CommentService;
import com.postService.post.service.PostService;
import com.postService.post.utils.Response;
import com.postService.post.utils.UserIdFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private UserIdFetcher fetcher;

    @Autowired
    private CommentService commentService;

    @Autowired
    private PostService postService;

    @PostMapping("/add")
    public ResponseEntity<Response> addComment(HttpServletRequest httpServletRequest, @RequestBody CommentVO comment){
        String userId=fetcher.getUserId(httpServletRequest);
        Comment newComment =commentService.addComment(userId,comment.getComment(),comment.getPostId());
        postService.setComment(newComment);
        Response<String> apiResponse = new Response<>("Success", HttpStatus.OK.value(), "comment has been added to the post");
        return new ResponseEntity<Response>(apiResponse, HttpStatus.OK);

    }

    @PutMapping("/edit/{commentId}/{comment}")
    public ResponseEntity<Response> updateComment( @PathVariable String commentId,@PathVariable String comment){
        commentService.editComment(commentId,comment);
        Response<String> apiResponse = new Response<>("Success", HttpStatus.OK.value(), "comment has been edited");
        return new ResponseEntity<Response>(apiResponse, HttpStatus.OK);

    }

}
