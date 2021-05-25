package com.postService.post.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;
@Document
public class Post {
    @Id
    private String id;
    private String content;
    private String description;
    private int noOfViews;
    private int likes;
    private String authorId;
    @DBRef
    private List<Comment> comments;
    private Date date;

    public Post() {
    }

    public Post(String content, String description) {
        this.content = content;
        this.description = description;
    }

    public Post(String id, String content, String description, int noOfViews, int likes, String authorId, List<Comment> comments, Date date) {
        this.id = id;
        this.content = content;
        this.description = description;
        this.noOfViews = noOfViews;
        this.likes = likes;
        this.authorId = authorId;
        this.comments = comments;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNoOfViews() {
        return noOfViews;
    }

    public void setNoOfViews(int noOfViews) {
        this.noOfViews = noOfViews;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                ", description='" + description + '\'' +
                ", noOfViews=" + noOfViews +
                ", likes=" + likes +
                ", authorId='" + authorId + '\'' +
                ", comments=" + comments +
                ", date=" + date +
                '}';
    }
}
