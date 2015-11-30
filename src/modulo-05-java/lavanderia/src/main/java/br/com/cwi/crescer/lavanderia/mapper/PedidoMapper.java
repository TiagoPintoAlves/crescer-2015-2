package br.com.cwi.crescer.lavanderia.mapper;

import br.com.cwi.crescer.lavanderia.domain.Pedido;
import br.com.cwi.crescer.lavanderia.dto.PedidoDTO;

public class PedidoMapper {

    public static Pedido getNewEntity(PedidoDTO dto) {
        Pedido entity = new Pedido();
        entity.setIdPedido(dto.getId());
        return entity;
    }

    public static PedidoDTO toDTO(Pedido entity) {
        PedidoDTO dto = new PedidoDTO();
        dto.setId(entity.getIdPedido());
        dto.setIdCliente(entity.getCliente().getIdCliente());
        dto.setValorBruto(entity.getValorBruto());
        dto.setValorDesconto(entity.getValorDesconto());
        dto.setValorFinal(entity.getValorFinal());
        dto.setDataInclusao(entity.getDataInclusao());
        dto.setDataEntrega(entity.getDataEntrega());
        dto.setSituacao(entity.getSituacao().ordinal());
        return dto;
    }

    public static Pedido merge(PedidoDTO dto, Pedido entity) {

        return entity;
    }
}
