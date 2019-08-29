package com.intrasoftintl.CoffeeMaker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intrasoftintl.CoffeeMaker.dao.CoffeeMakerDAO;
import com.intrasoftintl.CoffeeMaker.domain.CoffeeMaker;

@Service
public class CoffeeMakerServiceimpl implements CoffeeMakerService {
	
	private CoffeeMakerDAO coffeemakerDAO;
	
	@Autowired
	public CoffeeMakerServiceimpl(CoffeeMakerDAO coffeemakerDAO) {
		this.coffeemakerDAO=coffeemakerDAO;
	}
	@Override
	public CoffeeMaker findById(int id) {
		return coffeemakerDAO.findById(id);
	}

	@Override
	public List<CoffeeMaker> findAll() {
		return coffeemakerDAO.findAll();
	}

	@Override
	public void deleteById(int id) {
		coffeemakerDAO.deleteById(id);

	}

	@Override
	public void save(CoffeeMaker coffeemaker) {
		coffeemakerDAO.save(coffeemaker);

	}

}
