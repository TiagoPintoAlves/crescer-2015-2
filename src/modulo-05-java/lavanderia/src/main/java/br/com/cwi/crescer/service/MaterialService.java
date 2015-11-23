package br.com.cwi.crescer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.cwi.crescer.dao.MaterialDAO;

@Service
public class MaterialService {

	private MaterialDAO MaterialDAO;

	@Autowired
	public MaterialService(MaterialDAO materialDAO) {
		super();
		this.MaterialDAO = materialDAO;
	}
	
	public String buscarDescricao(Long id) {
		String desc = MaterialDAO.findById(id).getDescricao();
		return desc;
	}
}
