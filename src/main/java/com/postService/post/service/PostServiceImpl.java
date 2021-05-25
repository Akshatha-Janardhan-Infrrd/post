package com.postService.post.service;

import com.postService.post.entities.Comment;
import com.postService.post.entities.Post;
import com.postService.post.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService{
    @Autowired
    private PostRepository postRepository;
    @Override
    public void setComment(Comment comment) {
     Optional<Post> oldPost=postRepository.findById(comment.getPostId());
     Post post= oldPost.get();
     List<Comment> commentList=post.getComments();
     commentList.add(comment);
     post.setComments(commentList);
     postRepository.save(post);
    }

    @Override
    public Post getPost(String postId) {
        Optional<Post> post=postRepository.findById(postId);
        return post.get();
    }
}
