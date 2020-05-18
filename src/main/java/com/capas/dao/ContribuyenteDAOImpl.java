package com.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import com.capas.domain.Contribuyente;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public class ContribuyenteDAOImpl implements ContribuyenteDAO {
	
	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;
	
	@Override
	public List<Contribuyente> findAll() throws DataAccessException{
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.contribuyente");
		Query query = entityManager.createNativeQuery(sb.toString(), Contribuyente.class);
		List<Contribuyente> resulset = query.getResultList();
		return resulset;
		
	}

	@Override
	public Contribuyente findOne(Integer code) throws DataAccessException {
		Contribuyente contri = entityManager.find(Contribuyente.class, code);
		return contri;
	}

	@Override
	@Transactional
	public void insertar(Contribuyente contri) throws DataAccessException {
		entityManager.persist(contri);	
	}
	
	
}
