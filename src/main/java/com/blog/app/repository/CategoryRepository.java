package com.blog.app.repository;

import com.blog.app.model.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category,Integer> {

    Iterable<Category> findAllByOrderByCidDesc();
    //int countAll();
}
