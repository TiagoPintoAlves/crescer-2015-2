package br.com.cwi.crescer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.PedidoDAO;

@Service
public class PedidoService {

	private PedidoDAO PedidoDAO;

	@Autowired
	public PedidoService(PedidoDAO pedidoDAO) {
		super();
		this.PedidoDAO = pedidoDAO;
	}
	
	public double buscarValor(Long id) {
		
		double valor = PedidoDAO.findById(id).getValor();
		
		return valor;
	}
}
