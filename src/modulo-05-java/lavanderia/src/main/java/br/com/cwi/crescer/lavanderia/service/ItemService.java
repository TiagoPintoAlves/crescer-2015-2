package br.com.cwi.crescer.lavanderia.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.lavanderia.dao.ItemDAO;

@Service
public class ItemService {

    private ItemDAO ItemDAO;

    @Autowired
    public ItemService(ItemDAO itemDAO) {
        super();
        this.ItemDAO = itemDAO;
    }

    public BigDecimal buscarValorTotal(Long id) {
        BigDecimal total = ItemDAO.findById(id).getValorTotal();
        return total;
    }

}
