package br.com.cwi.crescer.lavanderia.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.lavanderia.domain.Item;
import br.com.cwi.crescer.lavanderia.domain.Item.SituacaoItem;

@Repository
public class ItemDAO {

	@PersistenceContext
	private EntityManager em;
	
	public Item findById(Long id) {
		return em.find(Item.class, id);
	}
	
	public List<Item> findBySituacao(SituacaoItem situacao) {
        return em.createQuery("FROM Item i WHERE i.situacao = :situacao", Item.class)
                .setParameter("situacao", situacao)
                .getResultList();
    }

	@Transactional
	public Item save(Item item){
		if(item.getIdItem() == null){
			em.persist(item);
			return item;
		}
		em.merge(item);
		return item;
	}
	
}
