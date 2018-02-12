package com.blog.app.service;

import com.blog.app.model.CommentChild;
import com.blog.app.repository.CommentChildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentChildServiceImpl implements CommentChildService {
    @Autowired
    CommentChildRepository commentChildRepository;
    @Override
    public Iterable<CommentChild> findAll() {
        return commentChildRepository.findAll();
    }

    @Override
    public List<CommentChild> search(String q) {
        return null;
    }

    @Override
    public CommentChild findOne(int id) {
        return commentChildRepository.findOne(id);
    }

    @Override
    public void save(CommentChild commentChild) {
        commentChildRepository.save(commentChild);
    }

    @Override
    public void delete(int id) {
        commentChildRepository.delete(id);
    }
}
