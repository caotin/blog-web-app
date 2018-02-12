package com.blog.app.service;

import com.blog.app.model.Post;
import com.blog.app.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostRepository postRepository;
    @Override
    public Iterable<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public List<Post> search(String q) {
        return null;
    }

    @Override
    public Post findOne(int id) {
        return postRepository.findOne(id);
    }

    @Override
    public void save(Post post) {
        postRepository.save(post);
    }

    @Override
    public void delete(int id) {
        postRepository.delete(id);
    }

    @Override
    public Page<Post> findAll(Pageable page) {
        return postRepository.findAll(page);
    }


    @Override
    public Iterable<Post> findAllByCidOrderByCidDesc(int cid){
        return postRepository.findAllByCidOrderByPidDesc(cid);
    }

    @Override
    public long count() {
        return postRepository.count();
    }
    @Override
    public Iterable<Post> findAllByNameContaining(String name){
        return postRepository.findAllByNameContaining(name);
    }

}
