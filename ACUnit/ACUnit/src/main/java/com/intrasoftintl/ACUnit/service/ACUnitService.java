package com.intrasoftintl.ACUnit.service;

import java.util.List;

import com.intrasoftintl.ACUnit.domain.ACUnit;

public interface ACUnitService {
	
	 public ACUnit findById(int id);
	 
	 public List<ACUnit> findAll();
	 
	 public void deleteById(int id);
	 
	 public void save(ACUnit ac);
}
