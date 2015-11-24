package br.com.cwi.crescer.lavanderia.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.lavanderia.dao.PedidoDAO;

@Service
public class PedidoService {

	private PedidoDAO PedidoDAO;

	@Autowired
	public PedidoService(PedidoDAO pedidoDAO) {
		super();
		this.PedidoDAO = pedidoDAO;
	}
	
	public BigDecimal buscarValor(Long id) {
		
		BigDecimal valor = PedidoDAO.findById(id).getValor();
		
		return valor;
	}
}
