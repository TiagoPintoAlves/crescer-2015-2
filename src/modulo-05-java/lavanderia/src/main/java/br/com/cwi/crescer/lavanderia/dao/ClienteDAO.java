package br.com.cwi.crescer.lavanderia.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.lavanderia.dao.BaseDadosDAO;
import br.com.cwi.crescer.lavanderia.domain.Cliente;

@Repository
public class ClienteDAO implements BaseDadosDAO<Cliente>{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Cliente findById(Long id) {
		return em.find(Cliente.class, id);
	}
	
}
