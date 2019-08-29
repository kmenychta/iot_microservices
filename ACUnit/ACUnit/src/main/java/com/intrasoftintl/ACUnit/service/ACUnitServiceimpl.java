package com.intrasoftintl.ACUnit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intrasoftintl.ACUnit.dao.ACDAO;
import com.intrasoftintl.ACUnit.domain.ACUnit;

@Service
public class ACUnitServiceimpl implements ACUnitService {
	
	private ACDAO acDAO;
	
	@Autowired
	public ACUnitServiceimpl(ACDAO acDAO) {
		this.acDAO=acDAO;
	}
	@Override
	public ACUnit findById(int id) {
		return acDAO.findById(id);
	}

	@Override
	public List<ACUnit> findAll() {
		return acDAO.findAll();
	}

	@Override
	public void deleteById(int id) {
		acDAO.deleteById(id);

	}

	@Override
	public void save(ACUnit ac) {
		acDAO.save(ac);

	}

}
