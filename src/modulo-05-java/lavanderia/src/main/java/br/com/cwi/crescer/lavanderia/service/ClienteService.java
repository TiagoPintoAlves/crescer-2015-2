package br.com.cwi.crescer.lavanderia.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.lavanderia.dao.CidadeDAO;
import br.com.cwi.crescer.lavanderia.dao.ClienteDAO;
import br.com.cwi.crescer.lavanderia.domain.Cliente;
import br.com.cwi.crescer.lavanderia.domain.Cliente.SituacaoCliente;
import br.com.cwi.crescer.lavanderia.dto.ClienteDTO;
import br.com.cwi.crescer.lavanderia.dto.ClienteResumoDTO;
import br.com.cwi.crescer.lavanderia.mapper.ClienteMapper;

@Service
public class ClienteService {

    private ClienteDAO clienteDAO;
    private CidadeDAO cidadeDAO;

    @Autowired
    public ClienteService(ClienteDAO clienteDAO, CidadeDAO cidadeDAO) {
        this.clienteDAO = clienteDAO;
        this.cidadeDAO = cidadeDAO;
    }

    public List<ClienteResumoDTO> listarClientesAtivos() {
        List<Cliente> clientes = clienteDAO.findBySituacao(SituacaoCliente.ATIVO);

        List<ClienteResumoDTO> dtos = new ArrayList<ClienteResumoDTO>();

        for (Cliente cliente : clientes) {
            dtos.add(new ClienteResumoDTO(cliente));
        }

        return dtos;
    }

    public List<ClienteResumoDTO> listarTodosClientes() {
        List<Cliente> clientes = clienteDAO.listAll();

        List<ClienteResumoDTO> dtos = new ArrayList<ClienteResumoDTO>();

        for (Cliente cliente : clientes) {
            dtos.add(new ClienteResumoDTO(cliente));
        }

        return dtos;
    }
    
    public List<ClienteResumoDTO> listarPorNome(String nome) {
        List<Cliente> clientes = clienteDAO.listByName(nome);

        List<ClienteResumoDTO> dtos = new ArrayList<ClienteResumoDTO>();

        for (Cliente cliente : clientes) {
            dtos.add(new ClienteResumoDTO(cliente));
        }

        return dtos;
    }

    public ClienteDTO buscarClientePorId(Long id) {
        return ClienteMapper.toDTO(clienteDAO.findById(id));
    }

    public void atualizar(ClienteDTO dto) {

        Cliente entity = clienteDAO.findById(dto.getId());

        ClienteMapper.merge(dto, entity);

        entity.setCidade(cidadeDAO.findById(dto.getIdCidade()));

        clienteDAO.save(entity);
    }

    public void incluir(ClienteDTO dto){
        Cliente entity = ClienteMapper.getNewEntity(dto);
        entity.setCidade(cidadeDAO.findById(dto.getIdCidade()));
        entity.setSituacao(SituacaoCliente.ATIVO);
        clienteDAO.save(entity);
    }

    public void excluir(Long id) {
        Cliente entity = clienteDAO.findById(id);
        entity.setSituacao(SituacaoCliente.INATIVO);
        clienteDAO.save(entity);
    }

}
