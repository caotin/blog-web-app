package com.blog.app.repository;

import com.blog.app.model.Comment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<Comment,Integer> , PagingAndSortingRepository<Comment,Integer>{
    Iterable<Comment> findAllByPid(int id);
}
