package com.postService.post.service;

import com.postService.post.entities.Comment;
import com.postService.post.entities.Post;
import com.postService.post.repositories.PostRepository;
import com.postService.post.vos.PostVo;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private PostRepository postRepository;

    @Override
    public Post createPost(String userId, String content, String description) {
        Post post = new Post();
        post.setId(RandomStringUtils.randomAlphanumeric(10));
        post.setAuthorId(userId);
        post.setContent(content);
        post.setDescription(description);
        post.setDate(System.currentTimeMillis());
        postRepository.save(post);
        return post;
    }

    @Override
    public void deletePost(String postId) {
        postRepository.deleteById(postId);
    }

    @Override
    public Post editPost(String postId, String content, String description) {
        Optional<Post> post = postRepository.findById(postId);
        Post post1 = post.get();
        post1.setContent(content);
        post1.setDescription(description);
        postRepository.save(post1);
        return post1;
    }

    @Override
    public void likePost(String postId) {
        Optional<Post> post = postRepository.findById(postId);
        Post post1 = post.get();
        post1.setLikes(post1.getLikes()+1);
        postRepository.save(post1);
    }
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
