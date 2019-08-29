package com.intrasoftintl.Lock.service;

import java.util.List;

import com.intrasoftintl.Lock.domain.Lock;

public interface LockService {
	
	public Lock findById(int id);
	 
	 public List<Lock> findAll();
	 
	 public void deleteById(int id);
	 
	 public void save(Lock lock);
}
