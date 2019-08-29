package com.intrasoftintl.CoffeeMaker.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.intrasoftintl.CoffeeMaker.domain.CoffeeMaker;

@Repository
public class CoffeeMakerDAOimpl implements CoffeeMakerDAO{
	
	private EntityManager entityManager;
	
	@Autowired
	public CoffeeMakerDAOimpl(EntityManager entityManager) {
		this.entityManager=entityManager;
	}
	
	@Override
	@Transactional
	public CoffeeMaker findById(int id) {
		Session session=entityManager.unwrap(Session.class);
		CoffeeMaker coffeemaker=session.get(CoffeeMaker.class, id);
		return coffeemaker;
	}

	@Override
	@Transactional
	public List<CoffeeMaker> findAll() {
		Session session=entityManager.unwrap(Session.class);
		List<CoffeeMaker> coffeemaker = session.createQuery("from CoffeeMaker", CoffeeMaker.class).getResultList();
		return coffeemaker;
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		Session session = entityManager.unwrap(Session.class);
		CoffeeMaker coffeemaker = findById(id);
		if (coffeemaker == null) {
			throw new RuntimeException("Coffee Maker with id: " + id + "not found!");
		} else {
			Query query = session.createQuery("delete from CoffeeMaker where deviceid=:id").setParameter("id", id);
			query.executeUpdate();
		}
		
	}

	@Override
	@Transactional
	public void save(CoffeeMaker coffeemaker) {
		Session session = entityManager.unwrap(Session.class);
		session.save(coffeemaker);
		
	}

}
