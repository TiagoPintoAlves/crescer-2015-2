package br.com.cwi.crescer.lavanderia.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.lavanderia.domain.Cidade;

@Repository
public class CidadeDAO implements BaseDadosDAO<Cidade>{

    @PersistenceContext
    private EntityManager em;

    @Override
    public Cidade findById(Long id) {
        return this.em.find(Cidade.class, id);
    }
    
    public List<Cidade> listAll() {
        return em.createQuery("FROM Cidade", Cidade.class)
                .getResultList();
    }

}
