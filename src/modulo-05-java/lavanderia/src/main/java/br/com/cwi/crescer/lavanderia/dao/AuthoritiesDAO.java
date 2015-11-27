package br.com.cwi.crescer.lavanderia.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.lavanderia.domain.Authorities;

@Repository
public class AuthoritiesDAO {

    @PersistenceContext
    EntityManager em;

    public Authorities findByAuthority(String authority) {
        Authorities persistedUser = em.find(Authorities.class, authority);
        return persistedUser;
    }
}
