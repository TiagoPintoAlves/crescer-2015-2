package lavanderia.dao;

import java.sql.SQLException;
import java.util.List;

import lavanderia.model.Cliente;

public class Aplicacao {

    public static void main(String[] args) throws SQLException {
        /*
         * Cliente cliente = new Cliente();
         * cliente.setIdCliente(1L);
         * cliente.setNmCliente("Teste");
         * cliente.setNrCpf("123");
         * ClienteDao clienteDao = new ClienteDao();
         * clienteDao.insert(cliente);
         */

        ClienteDao clienteDao = new ClienteDao();

        List<Cliente> lista = clienteDao.listAll();
        for (Cliente cliente : lista) {
            System.out.println(cliente.getNmCliente());
        }
    }
}
