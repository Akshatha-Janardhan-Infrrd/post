package com.postService.post.service;

import com.postService.post.entities.Comment;
import com.postService.post.entities.Post;

public interface PostService {

    public void setComment(Comment comment);
    public Post getPost(String postId);
}
