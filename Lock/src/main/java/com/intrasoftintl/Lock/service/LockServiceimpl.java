package com.intrasoftintl.Lock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intrasoftintl.Lock.dao.LockDAO;
import com.intrasoftintl.Lock.domain.Lock;

@Service
public class LockServiceimpl implements LockService {

	private LockDAO lockDAO;
	
	@Autowired
	public LockServiceimpl(LockDAO lockDAO) {
		this.lockDAO=lockDAO;
	}
	
	@Override
	public Lock findById(int id) {
		return lockDAO.findById(id);
	}

	@Override
	public List<Lock> findAll() {
		return lockDAO.findAll();		
	}

	@Override
	public void deleteById(int id) {
		lockDAO.deleteById(id);

	}

	@Override
	public void save(Lock lock) {
		lockDAO.save(lock);

	}

}
