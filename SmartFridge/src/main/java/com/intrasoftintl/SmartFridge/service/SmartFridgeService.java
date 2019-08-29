package com.intrasoftintl.SmartFridge.service;

import java.util.List;

import com.intrasoftintl.SmartFridge.domain.SmartFridge;


public interface SmartFridgeService {
	public SmartFridge findById(int id);
	 
	 public List<SmartFridge> findAll();
	 
	 public void deleteById(int id);
	 
	 public void save(SmartFridge fridge);
}
