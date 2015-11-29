package br.com.cwi.crescer.lavanderia.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.lavanderia.dao.MaterialDAO;
import br.com.cwi.crescer.lavanderia.dao.ProdutoDAO;
import br.com.cwi.crescer.lavanderia.dao.ServicoDAO;
import br.com.cwi.crescer.lavanderia.domain.Produto;
import br.com.cwi.crescer.lavanderia.domain.Produto.SituacaoProduto;
import br.com.cwi.crescer.lavanderia.dto.ProdutoCadastraDTO;
import br.com.cwi.crescer.lavanderia.dto.ProdutoDTO;
import br.com.cwi.crescer.lavanderia.mapper.ProdutoMapper;

@Service
public class ProdutoService {

	private ProdutoDAO produtoDAO;
	private MaterialDAO materialService;
	private ServicoDAO servicoService;
	
	@Autowired
    public ProdutoService(ProdutoDAO produtoDAO) {
        this.produtoDAO = produtoDAO;
    }
	
	public void incluir(ProdutoCadastraDTO dto){
        Produto entity = ProdutoMapper.getNewEntity(dto);
        entity.setMaterial(materialService.findById(dto.getIdMaterial()));
        entity.setServico(servicoService.findById(dto.getIdServico()));
        
        entity.setSituacao(SituacaoProduto.ATIVO);
        produtoDAO.save(entity);
    }
	
	public List<ProdutoDTO> listarProdutos() {
        List<Produto> produtos = produtoDAO.listAll();

        List<ProdutoDTO> dtos = new ArrayList<ProdutoDTO>();

        for (Produto produto : produtos) {
            dtos.add(new ProdutoDTO(produto));
        }

        return dtos;
    }
	
	public ProdutoDTO buscarProdutoPorId(Long id) {
        return ProdutoMapper.toDTO(produtoDAO.findById(id));
	}
	
	public void atualizar(ProdutoDTO dto) {

        Produto entity = produtoDAO.findById(dto.getIdProduto());

        ProdutoMapper.merge(dto, entity);
        
        produtoDAO.save(entity);
    }
}
