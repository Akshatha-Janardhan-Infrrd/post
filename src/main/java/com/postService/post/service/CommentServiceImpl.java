package com.postService.post.service;

import com.postService.post.entities.Comment;
import com.postService.post.repositories.CommentRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment addComment(String userId, String comment,String postId) {
        Comment newComment= new Comment();
        newComment.setCommentId(RandomStringUtils.randomAlphanumeric(10));
        newComment.setUserId(userId);
        newComment.setComment(comment);
        newComment.setPostId(postId);
        commentRepository.save(newComment);
        return newComment;

    }

    @Override
    public void editComment(String commentId, String comment) {
        Comment newComment=getComment(commentId);
        newComment.setComment(comment);
        commentRepository.save(newComment);
    }

    @Override
    public void deleteComment(String commentId) {
        commentRepository.existsById(commentId);
    }

    private Comment getComment(String commentId){
        Optional<Comment> comment= commentRepository.findById(commentId);
        return comment.get();
    }
}
