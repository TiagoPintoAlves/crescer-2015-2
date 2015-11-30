package br.com.cwi.crescer.lavanderia.mapper;

import br.com.cwi.crescer.lavanderia.domain.Item;
import br.com.cwi.crescer.lavanderia.dto.ItemDTO;

public class ItemMapper {

    public static Item getNewEntity(ItemDTO dto) {
        Item entity = new Item();
        entity.setIdItem(dto.getIdItem());
        return entity;
    }

    public static ItemDTO toDTO(Item entity) {
        ItemDTO dto = new ItemDTO();
        dto.setIdItem(entity.getIdItem());
        dto.setIdPedido(entity.getPedido().getIdPedido());
        dto.setIdProduto(entity.getProduto().getIdProduto());
        dto.setPeso(entity.getPeso());
        dto.setValorTotal(entity.getValorTotal());
        dto.setValorUnitario(entity.getValorUnitario());
        dto.setSituacao(entity.getSituacao().toString());
        return dto;
    }

    public static Item merge(ItemDTO dto, Item entity) {
        return entity;
    }
}
