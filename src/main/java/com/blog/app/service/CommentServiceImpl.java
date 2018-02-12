package com.blog.app.service;

import com.blog.app.model.Comment;
import com.blog.app.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Override
    public Iterable<Comment> findAll() {
        return commentRepository.findAll(new Sort(Sort.Direction.DESC,"id"));
    }

    @Override
    public List<Comment> search(String q) {
        return null;
    }

    @Override
    public Comment findOne(int id) {
        return commentRepository.findOne(id);
    }

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void delete(int id) {
        commentRepository.delete(id);
    }

    @Override
    public long count() {
        return commentRepository.count();
    }

    @Override
    public Iterable<Comment> findAllByPid(int id) {
        return commentRepository.findAllByPid(id);
    }
}
