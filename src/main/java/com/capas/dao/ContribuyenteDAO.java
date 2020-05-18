package com.capas.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;

import com.capas.domain.Contribuyente;


public interface ContribuyenteDAO {

	public List<Contribuyente> findAll() throws DataAccessException;
	public Contribuyente findOne(Integer code) throws DataAccessException;
	
	public void insertar(Contribuyente contri) throws DataAccessException;
	
}
