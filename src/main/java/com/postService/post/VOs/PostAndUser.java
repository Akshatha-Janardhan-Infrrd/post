package com.postService.post.VOs;

import com.postService.post.entities.Post;

public class PostAndUser {
    private Post post;
    private UserVO userVO;

    public PostAndUser() {
    }

    public PostAndUser(Post post, UserVO userVO) {
        this.post = post;
        this.userVO = userVO;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public UserVO getUserVO() {
        return userVO;
    }

    public void setUserVO(UserVO userVO) {
        this.userVO = userVO;
    }

    @Override
    public String toString() {
        return "PostAndUser{" +
                "post=" + post +
                ", userVO=" + userVO +
                '}';
    }
}
