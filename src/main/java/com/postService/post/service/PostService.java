package com.postService.post.service;

import com.postService.post.entities.Post;
import org.springframework.web.multipart.MultipartFile;

public interface PostService {

    public Post createPost(String userId, String content, String description);
    public void deletePost(String postId);
    public Post editPost(String postId, String content, String description);
    public void likePost(String postId);



    public void setComment(Comment comment);
    public Post getPost(String postId);
}
