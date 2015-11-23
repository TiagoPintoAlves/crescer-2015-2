package br.com.cwi.crescer.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Produto;

@Repository
public class ProdutoDAO implements BaseDadosDAO<Produto>{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Produto findById(Long id) {
		return em.find(Produto.class, id);
	}

	
}
