package br.com.cwi.crescer.lavanderia.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.lavanderia.domain.Item;

@Repository
public class ItemDAO implements BaseDadosDAO<Item>{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Item findById(Long id) {
		return em.find(Item.class, id);
	}

}
