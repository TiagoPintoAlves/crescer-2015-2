package br.com.cwi.crescer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.ProdutoDAO;

@Service
public class ProdutoService {

	private ProdutoDAO ProdutoDAO;

	@Autowired
	public ProdutoService(ProdutoDAO produtoDAO) {
		super();
		this.ProdutoDAO = produtoDAO;
	}
	
	public double buscarValor(Long id) {
		
		double valor = ProdutoDAO.findById(id).getValor();
		
		return valor;
	}
}
