package br.com.cwi.crescer.lavanderia.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.lavanderia.domain.Produto;

@Repository
public class ProdutoDAO {

    @PersistenceContext
    private EntityManager em;

    public List<Produto> listAll() {
        return em.createQuery("FROM Produto", Produto.class)
                .getResultList();
    }

    public Produto findById(Long id) {
        return em.find(Produto.class, id);
    }
    
    public List<Produto> findByMaterialServico(Produto produto) {
    	return em.createQuery("FROM Produto p WHERE p.IDServico = :servico AND p.IDMaterial = :material", Produto.class)
                .setParameter("servico", produto.getServico().getIdServico())
                .setParameter("material", produto.getMaterial().getIdMaterial())
                .getResultList();
    }
    
    @Transactional
    public Produto save(Produto produto) {
        if (produto.getIdProduto() == null) {
            em.persist(produto);
            return produto;
        }
        return em.merge(produto);
    }

}