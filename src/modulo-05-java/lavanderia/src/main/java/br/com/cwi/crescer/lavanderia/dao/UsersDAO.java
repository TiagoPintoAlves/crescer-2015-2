package br.com.cwi.crescer.lavanderia.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.lavanderia.domain.Users;
import br.com.cwi.crescer.lavanderia.domain.Users.EnableUser;

@Repository
public class UsersDAO {

    @PersistenceContext
    EntityManager em;

    public Users findByUsername(String username) {
        Users persistedUser = em.find(Users.class, username);
        return persistedUser;
    }

    public List<Users> findByEnable(EnableUser enable) {
        return em.createQuery("FROM Users u WHERE u.enabled = :enabled", Users.class)
                .setParameter("enabled", enable)
                .getResultList();
    }

}
