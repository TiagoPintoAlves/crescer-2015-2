package br.com.cwi.crescer.lavanderia.dao;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.lavanderia.domain.Users;

public class UsersDAOTest extends AbstractInfrastructureTest{
	
    @Autowired
    private UsersDAO usersDAO;

    @Test
    public void buscaUserPorId() throws Exception {
        Users user = usersDAO.findById(1L);
        Assert.assertNotNull(user);
    }
}
