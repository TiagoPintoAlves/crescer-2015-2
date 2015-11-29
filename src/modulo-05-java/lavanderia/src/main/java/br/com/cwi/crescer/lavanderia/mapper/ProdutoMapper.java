package br.com.cwi.crescer.lavanderia.mapper;

import br.com.cwi.crescer.lavanderia.domain.Material;
import br.com.cwi.crescer.lavanderia.domain.Produto;
import br.com.cwi.crescer.lavanderia.domain.Produto.SituacaoProduto;
import br.com.cwi.crescer.lavanderia.domain.Servico;
import br.com.cwi.crescer.lavanderia.dto.ProdutoCadastraDTO;
import br.com.cwi.crescer.lavanderia.dto.ProdutoDTO;

public class ProdutoMapper {

	 public static Produto getNewEntity(ProdutoDTO dto) {
	        Produto entity = new Produto();
	        entity.setIdProduto(dto.getIdProduto());
	        entity.setMaterial(dto.getMaterial());
	        entity.setServico(dto.getServico());
	        entity.setValor(dto.getValor());
	        entity.setPrazo(dto.getPrazo());
	        return entity;
	 }
	 
	 public static Produto getNewEntity(ProdutoCadastraDTO cadastraDTO) {
		 	Produto entity = new Produto();
	        entity.setIdProduto(cadastraDTO.getIdProduto());
	        entity.setMaterial(criaMaterial(cadastraDTO));
	        entity.setServico(criaServico(cadastraDTO));
	        entity.setValor(cadastraDTO.getValor());
	        entity.setPrazo(cadastraDTO.getPrazo());
	        return entity;
	 }

	 public static ProdutoDTO toDTO(Produto entity) {
	    	ProdutoDTO dto = new ProdutoDTO();
	        dto.setIdProduto(entity.getIdProduto());
	        dto.setMaterial(entity.getMaterial());
	        dto.setServico(entity.getServico());
	        dto.setValor(entity.getValor());
	        dto.setPrazo(entity.getPrazo());
	        dto.setSituacao(entity.getSituacao().ordinal());
	        return dto;
	 }

	 public static Produto merge(ProdutoDTO dto, Produto entity) {
	        entity.setValor(dto.getValor());
	        entity.setPrazo(dto.getPrazo());
	        entity.setSituacao(toEnum(dto));
	        return entity;
	    }
	    
	 public static SituacaoProduto toEnum(ProdutoDTO dto){
	    	SituacaoProduto situacaoDTO = SituacaoProduto.INATIVO;
	        if(dto.getSituacao() == 0){
	        	return situacaoDTO = SituacaoProduto.ATIVO;
	        }
	        return  situacaoDTO;
	 }
	 
	 public static Servico criaServico(ProdutoCadastraDTO cadastraDTO){
		 Servico servico = new Servico();
		 servico.setIdServico(cadastraDTO.getIdServico());
		 return servico;
	 }
	 
	 public static Material criaMaterial(ProdutoCadastraDTO cadastraDTO){
		 Material material = new Material();
		 material.setIdMaterial(cadastraDTO.getIdMaterial());
		 return material;
	 }
}
