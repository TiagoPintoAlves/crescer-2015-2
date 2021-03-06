package br.com.cwi.crescer.lavanderia.dao;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.lavanderia.domain.Cliente;

public class ClienteDAOTest extends AbstractInfrastructureTest {

    @Autowired
    private ClienteDAO clienteDAO;

    @Test
    public void buscaClientePorId() throws Exception {
        Cliente cliente = clienteDAO.findById(1L);
        
        Assert.assertNotNull(cliente);
        Assert.assertNotNull(cliente.getCidade());
    }
    
    @Test
    public void buscaClienteComPedidos() throws Exception {
        Cliente cliente = clienteDAO.findById(1L);
        
        Assert.assertNotNull(cliente.getPedidos());
    }
}
