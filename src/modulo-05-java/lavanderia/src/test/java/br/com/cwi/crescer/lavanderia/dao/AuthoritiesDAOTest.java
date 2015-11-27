package br.com.cwi.crescer.lavanderia.dao;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.lavanderia.domain.Authorities;

public class AuthoritiesDAOTest extends AbstractInfrastructureTest {

    @Autowired
    private AuthoritiesDAO authoritiesDAO;

    @Test
    public void deveBuscarPorAuthoritie() throws Exception {
        Authorities user = authoritiesDAO.findByAuthority("admin");
        Assert.assertNotNull(user);
    }
}
