package com.postService.post.VOs;

import com.postService.post.entities.Post;

public class UserWithPost {
    private UserVO user;
    private Post post;

    public UserWithPost() {
    }

    public UserWithPost(UserVO user, Post post) {
        this.user = user;
        this.post = post;
    }

    public UserVO getUser() {
        return user;
    }

    public void setUser(UserVO user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
