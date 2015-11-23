package br.com.cwi.crescer.lavanderia.dao;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.lavanderia.domain.Produto;

public class ProdutoDAOTest extends AbstractInfrastructureTest {

    @Autowired
    private ProdutoDAO produtoDAO;

    @Test
    public void buscaProdutoPorId() throws Exception {
        Produto material = produtoDAO.findById(1L);
        Assert.assertNotNull(material);
    }
}
