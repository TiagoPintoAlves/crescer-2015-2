package br.com.cwi.crescer.lavanderia.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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
    
    public List<Produto> findByMaterialServico(Long servico, Long material) {

    	String query = "FROM Produto p WHERE 1=1";
    	
		if(servico == 1 || servico == 2){
			query += " AND p.servico.idServico = :idServico";
		}
		if (material == 1 || material == 2 || material == 3) {
			query += " AND p.material.idMaterial = :idMaterial";
		}
		TypedQuery<Produto> sql = em.createQuery(query, Produto.class);
		
		if(servico == 1 || servico == 2){
			sql.setParameter("idServico", servico);
		}
		
		if(material == 1 || material == 2 || material == 3){
			sql.setParameter("idMaterial", material);
		}
		return sql.getResultList();
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