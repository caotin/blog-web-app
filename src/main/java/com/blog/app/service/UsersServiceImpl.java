package com.blog.app.service;

import com.blog.app.model.Users;
import com.blog.app.repository.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

@Service
public class UsersServiceImpl implements UsersService {
	@Autowired
	private UsersRepository usersRepository;

	@Override
	//@PreAuthorize("hasRole('ROLES_ADMIN')")
	public Iterable<Users> findAll() {
		return usersRepository.findAll();
	}

	@Override
	public List<Users> search(String q) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		//session.beginTransaction();
		String sql = String.format("from users u where u.name like '%:name%'");
		Query query = session.createQuery(sql);
		query.setParameter(":name", q);
		List<Users> list = query.list();
		return list;
	}

	@Override
	public Users findOne(String user) {
		// TODO Auto-generated method stub
		return usersRepository.findOne(user);
	}

	@Override
	public void save(Users user) {
		// TODO Auto-generated method stub
		usersRepository.save(user);
	}

	@Override
	public void delete(String user) {
		// TODO Auto-generated method stub
		usersRepository.delete(user);
	}

	@Override
	public boolean find(String user, String pass) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		//session.beginTransaction();
		String sql = String.format("from users u where u.name=:name and u.password=:pass");
		Query query = session.createQuery(sql);
		query.setParameter("name", user);
		query.setParameter("pass", pass);
		List<Users> list = query.list();
		if (list.size() > 0) {
			session.close();
			return true;
		}
		session.close();
		return false;
	}

	@Override
	public Iterable<Users> findAllByUsernameLike(String username) {
		return usersRepository.search(username);
	}

	@Override
	public long count() {
		return usersRepository.count();
	}

}
