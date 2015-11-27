package br.com.cwi.crescer.lavanderia.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.lavanderia.domain.Produto;

public class ProdutoDAOTest extends AbstractInfrastructureTest {

    @Autowired
    private ProdutoDAO produtoDAO;

    @Test
    public void buscaProdutoPorId() throws Exception {
        Produto produto = produtoDAO.findById(1L);
        Assert.assertNotNull(produto);
    }

    @Test
    public void buscaProdutoComMaterial() throws Exception {
        Produto produto = produtoDAO.findById(1L);

        Assert.assertNotNull(produto.getMaterial());
    }

    @Test
    public void buscaProdutoComServico() throws Exception {
        Produto produto = produtoDAO.findById(1L);

        Assert.assertNotNull(produto.getServico());
    }

    @Test
    public void deveListarTodosProdutos() throws Exception {
        List<Produto> produtos = produtoDAO.listAll();

        Assert.assertNotNull(produtos);
    }
}
