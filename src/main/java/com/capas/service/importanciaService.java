package com.capas.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.capas.domain.Importancia;

public interface importanciaService {
	public List<Importancia> findAll() throws DataAccessException;
	public Importancia findOne(Integer code) throws DataAccessException;
}
