package com.postService.post.VOs;

public class PostVo {
    private String content;
    private String description;

    public PostVo() {
    }

    public PostVo(String content, String description) {
        this.content = content;
        this.description = description;
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

    @Override
    public String toString() {
        return "PostVo{" +
                "content='" + content + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
