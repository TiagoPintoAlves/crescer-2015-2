package br.com.cwi.crescer.lavanderia.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.lavanderia.dao.CidadeDAO;
import br.com.cwi.crescer.lavanderia.dao.ClienteDAO;
import br.com.cwi.crescer.lavanderia.domain.Cliente;
import br.com.cwi.crescer.lavanderia.domain.Cliente.SituacaoCliente;
import br.com.cwi.crescer.lavanderia.dto.ClienteResumoDTO;

@Service
public class ClienteService {


    private ClienteDAO clienteDAO;

    @Autowired
    public ClienteService(ClienteDAO clienteDAO, CidadeDAO cidadeDAO) {
        this.clienteDAO = clienteDAO;
    }

    public String buscarNome(Long id) {
        String nome = clienteDAO.findById(id).getNome();
        return nome.toUpperCase();
    }

    public List<ClienteResumoDTO> listarClientesAtivos() {
        List<Cliente> clientes = clienteDAO.findBySituacao(SituacaoCliente.ATIVO);

        List<ClienteResumoDTO> dtos = new ArrayList<>();

        for (Cliente cliente : clientes) {
            dtos.add(new ClienteResumoDTO(cliente));
        }

        return dtos;
    }
}
