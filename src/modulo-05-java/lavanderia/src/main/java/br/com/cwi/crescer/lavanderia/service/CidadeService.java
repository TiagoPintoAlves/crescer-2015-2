package br.com.cwi.crescer.lavanderia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.lavanderia.dao.CidadeDAO;

@Service
public class CidadeService {

	private CidadeDAO cidadoDAO;

	@Autowired
	public CidadeService(CidadeDAO cDAO) {
		super();
		this.cidadoDAO = cDAO;
	}
	
	public String buscarNome(Long id) {
		
		String nome = cidadoDAO.findById(id).getNome();
		
		return nome.toUpperCase();
	}
	
}
