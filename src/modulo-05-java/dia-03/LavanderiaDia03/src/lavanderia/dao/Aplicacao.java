package lavanderia.dao;

import java.sql.SQLException;

import lavanderia.model.Cliente;

public class Aplicacao {

    public static void main(String[] args) throws SQLException {
        //ClienteDao:
        ClienteDao clienteDao = new ClienteDao();

        // Insert Cliente:
        Cliente cliente = new Cliente();
        cliente.setIdCliente(2);
        cliente.setNmCliente("Outro");
        cliente.setNrCpf("321");
        clienteDao.insert(cliente);

        //Select Cliente:
        /*
         * List<Cliente> listaCliente = clienteDao.listAll();
         * for (Cliente cliente : listaCliente) {
         * System.out.println(cliente.getNmCliente());
         * }
         */

        // Delete Cliente:
        // clienteDao.delete(2L);






        //ServicoDao:
        ServicoDao servicoDao = new ServicoDao();

        /*
         * //Insert Servico:
         * Servico servico = new Servico();
         * servico.setIdServico(1);
         * servico.setDsServico("Lavar");
         * servicoDao.insert(servico);
         */

        //Select Servico:
        /*
         * List<Servico> listaServico = servicoDao.listAll();
         * for(Servico servico : listaServico){
         * System.out.println(servico.getDsServico());
         * }
         */


    }
}
