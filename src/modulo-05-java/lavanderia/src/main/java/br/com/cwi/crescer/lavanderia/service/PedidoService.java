package br.com.cwi.crescer.lavanderia.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.lavanderia.dao.ClienteDAO;
import br.com.cwi.crescer.lavanderia.dao.PedidoDAO;
import br.com.cwi.crescer.lavanderia.domain.Pedido;
import br.com.cwi.crescer.lavanderia.domain.Pedido.SituacaoPedido;
import br.com.cwi.crescer.lavanderia.dto.PedidoDTO;
import br.com.cwi.crescer.lavanderia.dto.PedidoResumoDTO;
import br.com.cwi.crescer.lavanderia.mapper.PedidoMapper;

@Service
public class PedidoService {

    private PedidoDAO pedidoDAO;
    private ClienteDAO clienteDAO;

    @Autowired
    public PedidoService(PedidoDAO pedidoDAO, ClienteDAO clienteDAO) {
        this.pedidoDAO = pedidoDAO;
        this.clienteDAO = clienteDAO;
    }
    
    public PedidoDTO findById(Long id){
    	return PedidoMapper.toDTO(pedidoDAO.findById(id));
    }

    public List<PedidoResumoDTO> listarPedidos() {
        List<Pedido> pedidos = pedidoDAO.listAll();

        List<PedidoResumoDTO> pedidosDTO = new ArrayList<PedidoResumoDTO>();

        for(Pedido pedido : pedidos){
            pedidosDTO.add(new PedidoResumoDTO(pedido));
        }
        return pedidosDTO;
    }
    
    public List<SituacaoPedido> listarSituacoes(){
    	List<SituacaoPedido> situacoes = new ArrayList<SituacaoPedido>();
    	situacoes.add(SituacaoPedido.PENDENTE);
    	situacoes.add(SituacaoPedido.PROCESSANDO);
    	situacoes.add(SituacaoPedido.PROCESSADO);
    	situacoes.add(SituacaoPedido.ENCERRADO);
    	situacoes.add(SituacaoPedido.CANCELADO);
    	return situacoes;
    }

    public Long incluir(PedidoDTO dto) {
    	Pedido entity = new Pedido();
    	entity.setValorBruto(new BigDecimal("0"));
    	entity.setSituacao(SituacaoPedido.PENDENTE);
    	entity.setDataInclusao(new Date());
    	entity.setCliente(clienteDAO.findById(dto.getIdCliente()));
    	return pedidoDAO.save(entity).getIdPedido();
    }
    
    public List<PedidoDTO> findByCpf(String cpf){
    	List<PedidoDTO> dto = new ArrayList<>();
    	Pedido entity = pedidoDAO.findById(clienteDAO.findByCpf(cpf).getIdCliente());
    	dto.add(PedidoMapper.toDTO(entity));
    	
    	return dto;
    }
    
    public void retirarPedido(Long id) throws Exception{
		Pedido entity = pedidoDAO.findById(id);
		if(entity.getSituacao() == SituacaoPedido.PROCESSADO){
			setSituacaoPedido(id, SituacaoPedido.ENCERRADO);
		}
	}
    
    public List<PedidoDTO> findBySituacao(String situacao){
    	List<Pedido> pedidos = pedidoDAO.findBySituacao(Enum.valueOf(SituacaoPedido.class, situacao));
    	List<PedidoDTO> dtos = new ArrayList<>();
		
    	for (Pedido pedido : pedidos) {
			dtos.add(PedidoMapper.toDTO(pedido));
		}
		return dtos;
    }
    
	private void setSituacaoPedido(Long idPedido, SituacaoPedido situacao){
		Pedido entity = pedidoDAO.findById(idPedido);
		entity.setSituacao(situacao);
		
		pedidoDAO.save(entity);
	}
	
	public void cancelarPedido(Long id){
		setSituacaoPedido(id, SituacaoPedido.CANCELADO);
	}
	

}
