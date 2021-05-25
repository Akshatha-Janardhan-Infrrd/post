package com.postService.post.VOs;

public class CommentVO {
    private String comment;
    private String postId;

    public CommentVO() {
    }

    public CommentVO(String comment, String postId) {
        this.comment = comment;
        this.postId = postId;
    }

    public CommentVO(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    @Override
    public String toString() {
        return "CommentVO{" +
                "comment='" + comment + '\'' +
                ", postId='" + postId + '\'' +
                '}';
    }
}
