package com.capas.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.capas.domain.Contribuyente;
import com.capas.domain.Importancia;

public interface ImportanciaDAO {

	public Importancia findOne(Integer code) throws DataAccessException;
	
	public List<Importancia> findAll() throws DataAccessException;
	
}
