package br.com.cwi.crescer.lavanderia.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.lavanderia.domain.Users;

@Repository
public class UsersDAO {
	
	@PersistenceContext
	EntityManager em;
			 
	public Users findById(Long id) {
		Users persistedUser = em.find(Users.class, id);
		return persistedUser;
    }
	
}
