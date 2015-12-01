package br.com.cwi.crescer.lavanderia.mapper;

import java.util.ArrayList;
import java.util.List;

import br.com.cwi.crescer.lavanderia.domain.Item;
import br.com.cwi.crescer.lavanderia.domain.Pedido;
import br.com.cwi.crescer.lavanderia.dto.ItemDTO;
import br.com.cwi.crescer.lavanderia.dto.PedidoDTO;

public class PedidoMapper {

    

    public static PedidoDTO toDTO(Pedido entity) {
        PedidoDTO dto = new PedidoDTO();
        dto.setId(entity.getIdPedido());
        dto.setIdCliente(entity.getCliente().getIdCliente());
        dto.setValorBruto(entity.getValorBruto());
        dto.setValorDesconto(entity.getValorDesconto());
        dto.setValorFinal(entity.getValorFinal());
        dto.setDataInclusao(entity.getDataInclusao());
        dto.setDataEntrega(entity.getDataEntrega());
        dto.setSituacao(entity.getSituacao().toString());
        dto.setItens(convertItens(entity));
        return dto;
    }

	private static List<ItemDTO> convertItens(Pedido entity){
		List<ItemDTO> itensDTO = new ArrayList<>();
		for (Item item : entity.getItens()) {
			itensDTO.add(ItemMapper.toDTO(item));
		}
		return itensDTO;
	}
}
