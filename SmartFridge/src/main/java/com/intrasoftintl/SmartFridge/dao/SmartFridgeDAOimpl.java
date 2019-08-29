package com.intrasoftintl.SmartFridge.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.intrasoftintl.SmartFridge.domain.SmartFridge;

@Repository
public class SmartFridgeDAOimpl implements SmartFridgeDAO {
	private EntityManager entityManager;
	
	@Autowired
	public SmartFridgeDAOimpl(EntityManager entityManager) {
		this.entityManager=entityManager;
	}
	
	@Override
	@Transactional
	public SmartFridge findById(int id) {
		Session session=entityManager.unwrap(Session.class);
		SmartFridge fridge=session.get(SmartFridge.class, id);
		return fridge;
	}

	@Override
	@Transactional
	public List<SmartFridge> findAll() {
		Session session=entityManager.unwrap(Session.class);
		List<SmartFridge> fridge = session.createQuery("from Lock", SmartFridge.class).getResultList();
		return fridge;
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		Session session = entityManager.unwrap(Session.class);
		SmartFridge fridge = findById(id);
		if (fridge == null) {
			throw new RuntimeException("Lock with id: " + id + "not found!");
		} else {
			Query query = session.createQuery("delete from Lock where deviceid=:id").setParameter("id", id);
			query.executeUpdate();
		}
		
	}

	@Override
	@Transactional
	public void save(SmartFridge fridge) {
		Session session = entityManager.unwrap(Session.class);
		session.save(fridge);
		
	}

}
