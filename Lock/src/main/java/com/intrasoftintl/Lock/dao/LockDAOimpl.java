package com.intrasoftintl.Lock.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.intrasoftintl.Lock.domain.Lock;

@Repository
public class LockDAOimpl implements LockDAO {
	private EntityManager entityManager;
	
	@Autowired
	public LockDAOimpl(EntityManager entityManager) {
		this.entityManager=entityManager;
	}
	
	@Override
	@Transactional
	public Lock findById(int id) {
		Session session=entityManager.unwrap(Session.class);
		Lock lock=session.get(Lock.class, id);
		return lock;
	}

	@Override
	@Transactional
	public List<Lock> findAll() {
		Session session=entityManager.unwrap(Session.class);
		List<Lock> lock = session.createQuery("from Lock", Lock.class).getResultList();
		return lock;
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		Session session = entityManager.unwrap(Session.class);
		Lock lock = findById(id);
		if (lock == null) {
			throw new RuntimeException("Lock with id: " + id + "not found!");
		} else {
			Query query = session.createQuery("delete from Lock where deviceid=:id").setParameter("id", id);
			query.executeUpdate();
		}
		
	}

	@Override
	@Transactional
	public void save(Lock lock) {
		Session session = entityManager.unwrap(Session.class);
		session.save(lock);
		
	}

}
