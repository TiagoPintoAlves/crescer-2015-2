package br.com.cwi.crescer.lavanderia.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

public class ProdutoCadastraDTO {

	private Long idProduto;

	@NotNull
    private Long idServico;

    @NotNull
    private Long idMaterial;

    @NotNull
    @Range(max=999)
    private BigDecimal valor;

    @NotNull
    @Range(max=999)
    private Long prazo;
    
    private Integer situacao;

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}
	
	public Long getIdServico() {
		return idServico;
	}

	public void setIdServico(Long idServico) {
		this.idServico = idServico;
	}

	public Long getIdMaterial() {
		return idMaterial;
	}

	public void setIdMaterial(Long idMaterial) {
		this.idMaterial = idMaterial;
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
