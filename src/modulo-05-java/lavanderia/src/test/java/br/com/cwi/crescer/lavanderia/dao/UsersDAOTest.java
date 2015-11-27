package br.com.cwi.crescer.lavanderia.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.lavanderia.domain.Users;
import br.com.cwi.crescer.lavanderia.domain.Users.EnableUser;

public class UsersDAOTest extends AbstractInfrastructureTest{

    @Autowired
    private UsersDAO usersDAO;

    @Test
    public void deveBuscarPorUsernameAdmin() throws Exception {
        Users user = usersDAO.findByUsername("admin");
        Assert.assertNotNull(user);
    }

    @Test
    public void deveBuscarPorUsernameUser() throws Exception {
        Users user = usersDAO.findByUsername("user");
        Assert.assertNotNull(user);
    }

    @Test
    public void deveBuscarPorUsuariosAtivos() throws Exception {
        List<Users> users = usersDAO.findByEnable(EnableUser.ATIVO);
        Assert.assertNotNull(users);
    }
}
