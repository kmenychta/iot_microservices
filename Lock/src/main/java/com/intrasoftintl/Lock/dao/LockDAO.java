package com.intrasoftintl.Lock.dao;

import java.util.List;

import com.intrasoftintl.Lock.domain.Lock;


public interface LockDAO {
	public Lock findById(int id);
	 
	 public List<Lock> findAll();
	 
	 public void deleteById(int id);
	 
	 public void save(Lock lock);
}
