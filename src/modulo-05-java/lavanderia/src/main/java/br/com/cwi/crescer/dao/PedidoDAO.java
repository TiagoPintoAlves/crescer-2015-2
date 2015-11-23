package br.com.cwi.crescer.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Pedido;

@Repository
public class PedidoDAO implements BaseDadosDAO<Pedido> {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Pedido findById(Long id) {
		return em.find(Pedido.class, id);
	}
}
