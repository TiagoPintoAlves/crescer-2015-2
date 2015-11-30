package br.com.cwi.crescer.lavanderia.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.lavanderia.dao.MaterialDAO;
import br.com.cwi.crescer.lavanderia.dao.ProdutoDAO;
import br.com.cwi.crescer.lavanderia.dao.ServicoDAO;
import br.com.cwi.crescer.lavanderia.domain.Produto;
import br.com.cwi.crescer.lavanderia.dto.ProdutoDTO;
import br.com.cwi.crescer.lavanderia.mapper.ProdutoMapper;

@Service
public class ProdutoService {

	private ProdutoDAO produtoDAO;
	private MaterialDAO materialDAO;
	private ServicoDAO servicoDAO;
	
	@Autowired
    public ProdutoService(ProdutoDAO produtoDAO) {
        this.produtoDAO = produtoDAO;
    }
	
	public List<ProdutoDTO> listarProdutos() {
        List<Produto> produtos = produtoDAO.listAll();
        List<ProdutoDTO> lista = new ArrayList<ProdutoDTO>();
        for (Produto produto : produtos) {
        	ProdutoDTO dto = ProdutoMapper.toDTO(produto);
			lista.add(dto);
        }
        return lista;
    }
	
	public ProdutoDTO buscarProdutoPorId(Long id) {
        return ProdutoMapper.toDTO(produtoDAO.findById(id));
	}
	
	public void atualizar(ProdutoDTO dto) {

        Produto entity = produtoDAO.findById(dto.getIdProduto());

        ProdutoMapper.merge(dto, entity);
        
        produtoDAO.save(entity);
    }
	
	public boolean incluir(ProdutoDTO dto){
        Produto entity = ProdutoMapper.getNewEntity(dto);
        entity.setMaterial(materialDAO.findById(dto.getIdMaterial()));
        entity.setServico(servicoDAO.findById(dto.getIdServico()));
		List<Produto> produtoExistente = produtoDAO.findByMaterialServico(entity.getServico().getIdServico(), entity.getMaterial().getIdMaterial());
		if (produtoExistente.isEmpty()) {
			produtoDAO.save(entity);
			return true;
		}
		return false;
    }
	
	public List<ProdutoDTO> buscar(Long idMaterial, Long idServico){
		List<Produto> produtos = produtoDAO.findByMaterialServico(idServico, idMaterial);
		List<ProdutoDTO> produtoDTO = new ArrayList<>();
		for (Produto produto : produtos) {
			ProdutoDTO dto = ProdutoMapper.toDTO(produto);
			
			produtoDTO.add(dto);
		}
		return produtoDTO;
	}
}
