package com.blog.app.repository;

import com.blog.app.model.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends CrudRepository<Users, String> {
    @Query(nativeQuery = true,value = "SELECT * from users where username like '%?1%'")
    Iterable<Users> search(String username);
}
