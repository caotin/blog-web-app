package com.blog.app.service;

import com.blog.app.model.Category;

import java.util.List;

public interface CategoryService {
    Iterable<Category> findAll();
    List<Category> search(String q);
    Category findOne(int id);
    void save(Category Category);
    void delete(int id);
    long countAllByCid();
}
