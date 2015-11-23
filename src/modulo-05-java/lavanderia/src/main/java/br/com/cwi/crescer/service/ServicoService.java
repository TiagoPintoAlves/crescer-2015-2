package br.com.cwi.crescer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.ServicoDAO;

@Service
public class ServicoService {

	private ServicoDAO ServicoDAO;

	@Autowired
	public ServicoService(ServicoDAO servicoDAO) {
		super();
		this.ServicoDAO = servicoDAO;
	}
	
	public String buscarDescricao(Long id) {
		
		String desc = ServicoDAO.findById(id).getDescricao();
		
		return desc;
	}
}
