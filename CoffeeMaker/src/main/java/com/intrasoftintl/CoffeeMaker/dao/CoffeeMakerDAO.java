package com.intrasoftintl.CoffeeMaker.dao;

import java.util.List;

import com.intrasoftintl.CoffeeMaker.domain.CoffeeMaker;

public interface CoffeeMakerDAO {
	
	 public CoffeeMaker findById(int id);
	 
	 public List<CoffeeMaker> findAll();
	 
	 public void deleteById(int id);
	 
	 public void save(CoffeeMaker ac);
}
