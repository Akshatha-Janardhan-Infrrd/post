package com.postService.post.repositories;

import com.postService.post.entities.Post;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PostRepository extends MongoRepository<Post,String> {

    @Query(sort="{date:-1}")
    public List<Post> findByAuthorId(String userId);
}
