package br.com.cwi.crescer.lavanderia.dao;


import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.lavanderia.dao.CidadeDAO;
import br.com.cwi.crescer.lavanderia.domain.Cidade;

public class CidadeDAOTest extends AbstractInfrastructureTest {

    @Autowired
    private CidadeDAO cidadeDAO;

    @Test
    public void buscaCidadePorId() throws Exception {
        Cidade cidade = cidadeDAO.findById(1L);
        Assert.assertNotNull(cidade);
    }
}
