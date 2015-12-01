package br.com.cwi.crescer.lavanderia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.lavanderia.dao.ItemDAO;
import br.com.cwi.crescer.lavanderia.dao.PedidoDAO;
import br.com.cwi.crescer.lavanderia.dao.ProdutoDAO;
import br.com.cwi.crescer.lavanderia.domain.Item;
import br.com.cwi.crescer.lavanderia.domain.Item.SituacaoItem;
import br.com.cwi.crescer.lavanderia.dto.ItemDTO;
import br.com.cwi.crescer.lavanderia.mapper.ItemMapper;

@Service
public class ItemService {

    private ItemDAO itemDAO;
    private PedidoDAO pedidoDAO;
    private ProdutoDAO produtoDAO;

    @Autowired
    public ItemService(ItemDAO itemDAO, PedidoDAO pedidoDAO, ProdutoDAO produtoDAO) {
        this.itemDAO = itemDAO;
        this.pedidoDAO = pedidoDAO;
        this.produtoDAO = produtoDAO;
    }

    public ItemDTO buscaPorId(Long id) {
        return ItemMapper.toDTO(itemDAO.findById(id));
    }

    public void incluir(ItemDTO itemDTO) {
        Item item = ItemMapper.getNewEntity(itemDTO);
        item.setPedido(pedidoDAO.findById(itemDTO.getIdPedido()));
        item.setValorUnitario(produtoDAO.findById(item.getProduto().getIdProduto()).getValor());
        item.setSituacao(SituacaoItem.PENDENTE);
        itemDAO.save(item);
    }

}
