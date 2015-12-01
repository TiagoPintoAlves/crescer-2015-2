package br.com.cwi.crescer.lavanderia.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.lavanderia.domain.Pedido;
import br.com.cwi.crescer.lavanderia.domain.Pedido.SituacaoPedido;

@Repository
public class PedidoDAO {

    @PersistenceContext
    private EntityManager em;

    public Pedido findById(Long id) {
        return em.find(Pedido.class, id);
    }
    
    public List<Pedido> findBySituacao(SituacaoPedido situacao) {
    	return em.createQuery("FROM Pedido p WHERE p.situacao = :situacao", Pedido.class)
                .setParameter("situacao", situacao.ordinal()).getResultList();
    }

    public List<Pedido> listAll() {
        return em.createQuery("FROM Pedido", Pedido.class)
                .getResultList();
    }
    
    @Transactional
    public Pedido save(Pedido pedido) {
        if (pedido.getIdPedido() == null) {
            em.persist(pedido);
            return pedido;
        }
        return em.merge(pedido);
    }

    @Transactional
    public void remove(Long id) {
        em.remove(em.getReference(Pedido.class, id));
    }

}
