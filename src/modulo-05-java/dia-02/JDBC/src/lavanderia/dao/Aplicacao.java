package lavanderia.dao;

import java.sql.SQLException;
import java.util.List;

import lavanderia.model.Cliente;
import lavanderia.model.Servico;

public class Aplicacao {

    public static void main(String[] args) throws SQLException {
        
    	//ClienteDao:
        ClienteDao clienteDao = new ClienteDao();
    	
        /*
        Cliente cliente = new Cliente();
        cliente.setIdCliente(2);
        cliente.setNmCliente("Outro");
        cliente.setNrCpf("321");
        clienteDao.insert(cliente);
        */
        
        //Select Cliente:
        List<Cliente> listaCliente = clienteDao.listAll();
        for (Cliente cliente : listaCliente) {
            System.out.println(cliente.getNmCliente());
        }
        
        //ServicoDao:
        //Insert Servico:
        ServicoDao servicoDao = new ServicoDao();
        
        /*
        Servico servico = new Servico();
        servico.setIdServico(1);
        servico.setDsServico("Lavar");
        servicoDao.insert(servico);
        */
        
        //Select Servico:
        List<Servico> listaServico = servicoDao.listAll();
        for(Servico servico : listaServico){
        	System.out.println(servico.getDsServico());
        }
        
    }
}
