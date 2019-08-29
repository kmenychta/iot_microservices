package com.intrasoftintl.ACUnit.dao;

import java.util.List;

import com.intrasoftintl.ACUnit.domain.ACUnit;

public interface ACDAO {
	
	 public ACUnit findById(int id);
	 
	 public List<ACUnit> findAll();
	 
	 public void deleteById(int id);
	 
	 public void save(ACUnit ac);
}
