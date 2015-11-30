package br.com.cwi.crescer.lavanderia.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.lavanderia.dao.ItemDAO;
import br.com.cwi.crescer.lavanderia.dao.PedidoDAO;
import br.com.cwi.crescer.lavanderia.domain.Pedido;
import br.com.cwi.crescer.lavanderia.dto.PedidoDTO;
import br.com.cwi.crescer.lavanderia.mapper.PedidoMapper;

@Service
public class PedidoService {

    private PedidoDAO pedidoDAO;
    private ItemDAO itemDAO;

    @Autowired
    public PedidoService(PedidoDAO pedidoDAO, ItemDAO itemDAO) {
        this.pedidoDAO = pedidoDAO;
        this.itemDAO = itemDAO;
    }

    public List<PedidoDTO> listarPedidos() {
        List<Pedido> pedidos = pedidoDAO.listAll();

        List<PedidoDTO> pedidosDTO = new ArrayList<PedidoDTO>();

        for(Pedido pedido : pedidos){
            pedidosDTO.add(PedidoMapper.toDTO(pedido));
        }
        return pedidosDTO;
    }

}
