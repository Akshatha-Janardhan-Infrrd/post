package com.postService.post.service;

import com.postService.post.entities.Comment;
import org.springframework.stereotype.Service;


public interface CommentService {

    public Comment addComment(String userId, String comment,String postId);
    public void editComment(String commentId,String comment);
    public void deleteComment(String commentId);
}
