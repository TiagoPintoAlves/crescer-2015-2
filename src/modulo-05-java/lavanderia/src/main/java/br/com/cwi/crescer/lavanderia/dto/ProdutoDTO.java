package br.com.cwi.crescer.lavanderia.dto;

import java.math.BigDecimal;

import br.com.cwi.crescer.lavanderia.domain.Servico;
import br.com.cwi.crescer.lavanderia.domain.Material;
import br.com.cwi.crescer.lavanderia.domain.Produto;


public class ProdutoDTO {
	
    private Long idProduto;

    private Servico Servico;

    private Material Material;

    private BigDecimal valor;

    private Long prazo;
    
    private Integer situacao;
    
    public ProdutoDTO() {
	}

	public ProdutoDTO(Produto entity) {
    	this.idProduto = entity.getIdProduto();
        this.Servico = entity.getServico();
        this.Material = entity.getMaterial();
        this.valor = entity.getValor();
        this.prazo = entity.getPrazo();
        this.situacao = entity.getSituacao().ordinal();
    }
    
	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public Servico getIdServico() {
		return Servico;
	}

	public void setIdServico(Servico idServico) {
		this.Servico = idServico;
	}

	public Material getIdMaterial() {
		return Material;
	}

	public void setIdMaterial(Material idMaterial) {
		this.Material = idMaterial;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Long getPrazo() {
		return prazo;
	}

	public void setPrazo(Long prazo) {
		this.prazo = prazo;
	}

	public Integer getSituacao() {
		return situacao;
	}

	public void setSituacao(Integer situacao) {
		this.situacao = situacao;
	}
	
	
}
