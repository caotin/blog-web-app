package com.blog.app.service;

import com.blog.app.model.Comment;

import java.util.List;

public interface CommentService {
    Iterable<Comment > findAll();
    List<Comment> search(String q);
    Comment findOne(int id);
    void save(Comment comment);
    void delete(int id);
    long count();
    Iterable<Comment> findAllByPid(int id);
}
