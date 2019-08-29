package com.intrasoftintl.CoffeeMaker.service;

import java.util.List;

import com.intrasoftintl.CoffeeMaker.domain.CoffeeMaker;

public interface CoffeeMakerService {
	
	 public CoffeeMaker findById(int id);
	 
	 public List<CoffeeMaker> findAll();
	 
	 public void deleteById(int id);
	 
	 public void save(CoffeeMaker ac);
}
