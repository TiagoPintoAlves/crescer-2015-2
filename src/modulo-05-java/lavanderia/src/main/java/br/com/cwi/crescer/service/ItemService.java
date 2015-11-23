package br.com.cwi.crescer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.cwi.crescer.dao.ItemDAO;

@Service
public class ItemService {

	private ItemDAO ItemDAO;

	@Autowired
	public ItemService(ItemDAO itemDAO) {
		super();
		this.ItemDAO = itemDAO;
	}
	
	public double buscarValorTotal(Long id) {
		double total = ItemDAO.findById(id).getValorTotal();
		return total;
	}
	
}
