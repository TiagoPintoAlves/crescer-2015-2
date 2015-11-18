package lavanderia.dao;

import java.sql.SQLException;

import org.junit.Test;

import lavanderia.model.Cliente;


public class ClienteDaoTest {

    @Test
    public void insert() throws SQLException {
        ClienteDao clienteDao = new ClienteDao();
        // Insert Cliente:
        Cliente cliente = new Cliente();
        cliente.setNmCliente("Outro");
        cliente.setNrCpf("321");
        clienteDao.insert(cliente);
    }

}
