package br.com.cwi.crescer.lavanderia.dto;

import java.math.BigDecimal;
import java.util.Date;

import br.com.cwi.crescer.lavanderia.domain.Pedido;

public class PedidoResumoDTO {

    private Long Id;
    private String nomeCliente;
    private String cpf;
    private Date dataInclusao;
    private BigDecimal valorTotal;
    private String situacao;

    public PedidoResumoDTO() {
    }

    public PedidoResumoDTO(Pedido entity) {
        this.Id = entity.getIdPedido();
        this.nomeCliente = entity.getCliente().getNome();
        this.cpf = entity.getCliente().getCpf();
        this.dataInclusao = entity.getDataInclusao();
        this.valorTotal = entity.getValorFinal();
        this.situacao = entity.getSituacao().toString();
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

}
