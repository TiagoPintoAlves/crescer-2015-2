package br.com.cwi.crescer.lavanderia.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.lavanderia.dao.PedidoDAO;
import br.com.cwi.crescer.lavanderia.domain.Pedido;
import br.com.cwi.crescer.lavanderia.dto.PedidoDTO;
import br.com.cwi.crescer.lavanderia.dto.PedidoResumoDTO;

@Service
public class PedidoService {

    private PedidoDAO pedidoDAO;

    @Autowired
    public PedidoService(PedidoDAO pedidoDAO) {
        this.pedidoDAO = pedidoDAO;
    }

    public List<PedidoResumoDTO> listarPedidos() {
        List<Pedido> pedidos = pedidoDAO.listAll();

        List<PedidoResumoDTO> pedidosDTO = new ArrayList<PedidoResumoDTO>();

        for(Pedido pedido : pedidos){
            pedidosDTO.add(new PedidoResumoDTO(pedido));
        }
        return pedidosDTO;
    }

    public void incluir(PedidoDTO dto) {
        // TODO incluir

    }

}
