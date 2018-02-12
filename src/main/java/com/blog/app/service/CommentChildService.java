package com.blog.app.service;

import com.blog.app.model.CommentChild;

import java.util.List;

public interface CommentChildService {
    Iterable<CommentChild> findAll();
    List<CommentChild> search(String q);
    CommentChild findOne(int id);
    void save(CommentChild commentChild);
    void delete(int id);
}
