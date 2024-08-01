package com.demo.dao.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.interfaces.IUserDAO;
import com.demo.entity.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class UserDaoImplement implements IUserDAO{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(readOnly = true)
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return this.entityManager.createQuery("SELECT u FROM User u").getResultList();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<User> findById(Integer id) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(this.entityManager.find(User.class, id));
	}

	@Override
	@Transactional
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		this.entityManager.persist(user);
		this.entityManager.flush();
	}

	@Override
	@Transactional
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		this.entityManager.merge(user);
		 
	}

	@Override
	@Transactional
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		this.entityManager.remove(user);
	}

}
