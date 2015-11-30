package br.com.cwi.crescer.lavanderia.mapper;

import br.com.cwi.crescer.lavanderia.domain.Produto;
import br.com.cwi.crescer.lavanderia.domain.Produto.SituacaoProduto;
import br.com.cwi.crescer.lavanderia.dto.ProdutoDTO;

public class ProdutoMapper {

	 public static Produto getNewEntity(ProdutoDTO dto) {
	        Produto entity = new Produto();
	        entity.setIdProduto(dto.getIdProduto());
	        entity.setValor(dto.getValor());
	        entity.setPrazo(dto.getPrazo());
	        entity.setSituacao(toEnum(dto.getSituacao()));
	        return entity;
	 }

	 public static ProdutoDTO toDTO(Produto entity) {
	    	ProdutoDTO dto = new ProdutoDTO();
	    	dto.setIdProduto(entity.getIdProduto());
			dto.setIdMaterial(entity.getMaterial().getIdMaterial());
			dto.setDescricaoMaterial(entity.getMaterial().getDescricao());
			dto.setIdServico(entity.getServico().getIdServico());
			dto.setDescricaoServico(entity.getServico().getDescricao());
			dto.setValor(entity.getValor());
			dto.setSituacao(entity.getSituacao().ordinal());
			dto.setPrazo(entity.getPrazo());
	        return dto;
	 }

	 public static Produto merge(ProdutoDTO dto, Produto entity) {
	        entity.setValor(dto.getValor());
	        entity.setPrazo(dto.getPrazo());
			entity.setSituacao(toEnum(dto.getSituacao()));
	        return entity;
	    }
	 
	 public static SituacaoProduto toEnum(Integer situacaoValue){
		 	SituacaoProduto situacao = SituacaoProduto.ATIVO;
	        if(situacaoValue == 1){
	        	return situacao = SituacaoProduto.INATIVO;
	        }
	        return situacao;
	 }
}
