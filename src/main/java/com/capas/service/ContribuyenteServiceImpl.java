package com.capas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.capas.dao.ContribuyenteDAO;
import com.capas.domain.Contribuyente;

@Service
public class ContribuyenteServiceImpl implements ContribuyenteService{
	
	@Autowired
	ContribuyenteDAO contriDAO;

	@Override
	public List<Contribuyente> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return contriDAO.findAll();
	}

	@Override
	public Contribuyente findOne(Integer code) throws DataAccessException {
		// TODO Auto-generated method stub
		return contriDAO.findOne(code);
	}

	@Override
	public void save(Contribuyente contri) throws DataAccessException {
		// TODO Auto-generated method stub
		contriDAO.save(contri);
	}

	@Override
	public void delete(Integer c_contribuyente) throws DataAccessException {
		// TODO Auto-generated method stub
		contriDAO.delete(c_contribuyente);
	}

}
