package com.capas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.capas.dao.ImportanciaDAO;
import com.capas.domain.Importancia;


@Service
public class ImportanciaServiceImpl implements importanciaService {
	
	@Autowired
	ImportanciaDAO impDAO;

	@Override
	public List<Importancia> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return impDAO.findAll();
	}

	@Override
	public Importancia findOne(Integer code) throws DataAccessException {
		// TODO Auto-generated method stub
		return impDAO.findOne(code);
	}

}
