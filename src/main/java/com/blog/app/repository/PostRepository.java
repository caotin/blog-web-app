package com.blog.app.repository;

import com.blog.app.model.Post;
import javafx.geometry.Pos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.io.Serializable;

@Repository
public interface PostRepository extends CrudRepository<Post,Integer>,PagingAndSortingRepository<Post,Integer> {
    @Modifying
    @Query(nativeQuery = true,value = "SELECT p FROM post p order by p.pid desc limit 0,5")
//    Iterable<Post> findAllOrOrderByCidDesc();
    Iterable<Post> findAllPost();
    Iterable<Post> findAllByNameContaining(String name);
    Iterable<Post> findAllByCidOrderByPidDesc(int cid);
}
