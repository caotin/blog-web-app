package com.blog.app.service;

import com.blog.app.model.Users;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
public interface UsersService  {
	Iterable<Users> findAll();
	List<Users> search(String q);
	Users findOne(String user);
	void save(Users user);
	void delete(String user);
	boolean find(String user,String pass);
	Iterable<Users> findAllByUsernameLike(String username);
	long count();
}
