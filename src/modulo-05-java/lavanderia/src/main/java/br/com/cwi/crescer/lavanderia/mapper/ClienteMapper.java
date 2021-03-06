package br.com.cwi.crescer.lavanderia.mapper;

import br.com.cwi.crescer.lavanderia.domain.Cliente;
import br.com.cwi.crescer.lavanderia.domain.Cliente.SituacaoCliente;
import br.com.cwi.crescer.lavanderia.dto.ClienteDTO;

public class ClienteMapper {

    public static Cliente getNewEntity(ClienteDTO dto) {
        Cliente entity = new Cliente();
        entity.setNome(dto.getNome());
        entity.setCpf(dto.getCpf());
        entity.setEmail(dto.getEmail());
        entity.setEndereco(dto.getEndereco());
        entity.setBairro(dto.getBairro());
        entity.setCep(dto.getCep());
        return entity;
    }

    public static ClienteDTO toDTO(Cliente entity) {
        ClienteDTO dto = new ClienteDTO();
        dto.setId(entity.getIdCliente());
        dto.setNome(entity.getNome());
        dto.setCpf(entity.getCpf());
        dto.setEmail(entity.getEmail());
        dto.setEndereco(entity.getEndereco());
        dto.setBairro(entity.getBairro());
        dto.setCep(entity.getCep());
        dto.setIdCidade(entity.getCidade().getIdCidade());
        dto.setSituacao(entity.getSituacao().ordinal());
        return dto;
    }

    public static Cliente merge(ClienteDTO dto, Cliente entity) {
        entity.setNome(dto.getNome());
        entity.setCpf(dto.getCpf());
        entity.setEmail(dto.getEmail());
        entity.setEndereco(dto.getEndereco());
        entity.setBairro(dto.getBairro());
        entity.setCep(dto.getCep());
        entity.setSituacao(toEnum(dto));
        return entity;
    }
    
    public static SituacaoCliente toEnum(ClienteDTO dto){
    	SituacaoCliente situacaoDTO = SituacaoCliente.INATIVO;
        if(dto.getSituacao() == 0){
        	return situacaoDTO = SituacaoCliente.ATIVO;
        }
        return situacaoDTO;
    }
}
