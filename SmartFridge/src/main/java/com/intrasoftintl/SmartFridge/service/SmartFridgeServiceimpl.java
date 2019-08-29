package com.intrasoftintl.SmartFridge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intrasoftintl.SmartFridge.dao.SmartFridgeDAO;
import com.intrasoftintl.SmartFridge.domain.SmartFridge;

@Service
public class SmartFridgeServiceimpl implements SmartFridgeService {

	private SmartFridgeDAO smartfridgeDAO;
	
	@Autowired
	public SmartFridgeServiceimpl(SmartFridgeDAO smartfridgeDAO) {
		this.smartfridgeDAO=smartfridgeDAO;
	}
	
	
	@Override
	public SmartFridge findById(int id) {
		return smartfridgeDAO.findById(id);
	}

	@Override
	public List<SmartFridge> findAll() {
		return smartfridgeDAO.findAll();
	}

	@Override
	public void deleteById(int id) {
		smartfridgeDAO.deleteById(id);

	}

	@Override
	public void save(SmartFridge fridge) {
		smartfridgeDAO.save(fridge);

	}

}
