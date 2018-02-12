package com.blog.app.repository;

import com.blog.app.model.CommentChild;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentChildRepository extends CrudRepository<CommentChild,Integer> {
}
