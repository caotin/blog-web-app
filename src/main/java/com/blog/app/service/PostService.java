package com.blog.app.service;

import com.blog.app.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostService {
    Iterable<Post> findAll();
    List<Post> search(String q);
    Post findOne(int id);
    void save(Post post);
    void delete(int id);
    Page<Post> findAll(Pageable page);
    Iterable<Post> findAllByCidOrderByCidDesc(int cid);
    long count();
    Iterable<Post> findAllByNameContaining(String name);
}
