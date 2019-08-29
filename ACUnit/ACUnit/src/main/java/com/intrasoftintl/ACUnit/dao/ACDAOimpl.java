package com.intrasoftintl.ACUnit.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.intrasoftintl.ACUnit.domain.ACUnit;

@Repository
public class ACDAOimpl implements ACDAO{
	
	private EntityManager entityManager;
	
	@Autowired
	public ACDAOimpl(EntityManager entityManager) {
		this.entityManager=entityManager;
	}
	
	@Override
	@Transactional
	public ACUnit findById(int id) {
		Session session=entityManager.unwrap(Session.class);
		ACUnit ac=session.get(ACUnit.class, id);
		return ac;
	}

	@Override
	@Transactional
	public List<ACUnit> findAll() {
		Session session=entityManager.unwrap(Session.class);
		List<ACUnit> acs = session.createQuery("from ACUnit", ACUnit.class).getResultList();
		return acs;
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		Session session = entityManager.unwrap(Session.class);
		ACUnit ac = findById(id);
		if (ac == null) {
			throw new RuntimeException("AC with id: " + id + "not found!");
		} else {
			Query query = session.createQuery("delete from ACUnit where deviceid=:id").setParameter("id", id);
			query.executeUpdate();
		}
		
	}

	@Override
	@Transactional
	public void save(ACUnit ac) {
		Session session = entityManager.unwrap(Session.class);
		session.save(ac);
		
	}

}
