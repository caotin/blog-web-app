package com.blog.app.service;

import com.blog.app.model.Category;
import com.blog.app.model.Users;
import com.blog.app.repository.CategoryRepository;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Iterable<Category> findAll() {
        return categoryRepository.findAllByOrderByCidDesc();
    }

    @Override
    public List<Category> search(String q) {

        return null;
    }

    @Override
    public Category findOne(int id) {
        return categoryRepository.findOne(id);
    }

    @Override
    public void save(Category Category) {
        categoryRepository.save(Category);
    }

    @Override
    public void delete(int id) {
        categoryRepository.delete(id);
    }

    @Override
    public long countAllByCid() {
        return categoryRepository.count();
    }
}
