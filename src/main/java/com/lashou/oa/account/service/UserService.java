package com.lashou.oa.account.service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.lashou.oa.account.domain.Users;


@Service
public class UserService {
	@Autowired
	public SessionFactory sessionFactory;
	@Resource
	private JdbcTemplate jdbcTemplate;
	
	public UserService() {
	}
	
	public String getUser(String username, String password) {
		/*
		Session sess = sessionFactory.openSession();
		Transaction tx = sess.beginTransaction();
		Users user = (Users) sess.get(Users.class, 20L);
		tx.commit();
		sess.close();
		System.out.println(user);
		Object o = jdbcTemplate.queryForObject("select id from sp_users where id=20", String.class);
		return (String) o;
		*/
		return "";
	}
	
	public String getUser(Long id) {
		return "";
	}
	
}
