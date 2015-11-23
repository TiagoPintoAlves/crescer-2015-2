package br.com.cwi.crescer.lavanderia.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Cliente")
@SequenceGenerator(name = Cliente.SEQUENCE_NAME, sequenceName = Cliente.SEQUENCE_NAME)
public class Cliente {

    public static final String SEQUENCE_NAME = "SEQ_Cliente";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @Column(name = "IDCliente")
    private Long idCliente;

    @Column(name = "Nome")
    @Basic(optional = false)
    private String nome;

    @Column(name = "CPF")
    @Basic(optional = false)
    private String cpf;

    @Column(name = "Email")
    private String email;

    @Column(name = "Endereco")
    private String endereco;

    @Column(name = "Bairro")
    private String bairro;

    @Column(name = "IDCidade")
    private Long idCicade;

    @Column(name = "CEP")
    private int cep;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "Situacao")
    private SituacaoCliente situacao;

    public static enum SituacaoCliente {
        ATIVO, INATIVO;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Long getIdCicade() {
        return idCicade;
    }

    public void setIdCicade(Long idCicade) {
        this.idCicade = idCicade;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public SituacaoCliente getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoCliente situacao) {
        this.situacao = situacao;
    }

}
