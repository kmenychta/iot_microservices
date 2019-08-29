package com.intrasoftintl.SmartFridge.dao;

import java.util.List;

import com.intrasoftintl.SmartFridge.domain.SmartFridge;


public interface SmartFridgeDAO {
	public SmartFridge findById(int id);
	 
	 public List<SmartFridge> findAll();
	 
	 public void deleteById(int id);
	 
	 public void save(SmartFridge fridge);
}
