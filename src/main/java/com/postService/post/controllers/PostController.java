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
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostServiceImpl postService;

    @Autowired
    private UserIdFetcher userIdFetcher;

    @Autowired
    private MediaUploadService mediaUpload;

    @PostMapping("/create")
    public ResponseEntity<CreatePostResponse> createPost(HttpServletRequest httpServletRequest, @RequestBody PostVo post){
        String userId = userIdFetcher.getUserId(httpServletRequest);
        Post newPost = postService.createPost(userId,post.getContent(),post.getDescription());
        return ResponseEntity.ok(new CreatePostResponse("Post successful",200,post));
    }

    @PostMapping("/upload/{desc}")
    public ResponseEntity<CreatePostResponse> uploadMedia(HttpServletRequest httpServletRequest, @RequestBody MultipartFile file, @PathVariable("desc") String description){
        String userId = userIdFetcher.getUserId(httpServletRequest);
        String newPost = mediaUpload.uploadFile(file,userId,description);
        return ResponseEntity.ok(new CreatePostResponse("Post successful",200,newPost));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<DeletePostResponse> deletePost(@PathVariable("id") String postId){
        postService.deletePost(postId);
        return ResponseEntity.ok(new DeletePostResponse("Post deleted",200));
    }

    @PostMapping("edit/{id}")
    public ResponseEntity<CreatePostResponse> editPost(@PathVariable("id") String postId, @RequestBody PostVo postVo){
        Post post = postService.editPost(postId,postVo.getContent(),postVo.getDescription());
        return ResponseEntity.ok(new CreatePostResponse("Post updated",200,postVo));
    }

    @PostMapping("like/{id}")
    public ResponseEntity<CreatePostResponse> likePost(@PathVariable("id") String posId){
        postService.likePost(posId);
        return  ResponseEntity.ok(new CreatePostResponse("Post liked",200,posId));
    }


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
