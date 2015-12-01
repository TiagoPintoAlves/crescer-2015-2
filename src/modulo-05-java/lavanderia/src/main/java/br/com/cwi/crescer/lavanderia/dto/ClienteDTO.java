package br.com.cwi.crescer.lavanderia.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.br.CPF;

import br.com.cwi.crescer.lavanderia.domain.Cliente;

public class ClienteDTO {

    private Long id;

    @NotBlank
    @Length(max=70)
    private String nome;

    @CPF
    @NotBlank
    @Length(min=11, max=11)
    private String cpf;

    @Length(max=100)
    @Email
    @NotBlank
    private String email;

    @Length(max=50)
    private String endereco;

    @Length(max=50)
    private String bairro;

    private Long idCidade;

    @NotNull
    @Range(max=99999999)
    private Long cep;
    
    private Integer situacao;
    
    public ClienteDTO(){
    	
    }
    
    public ClienteDTO(Cliente entity){
    	this.id = entity.getIdCliente();
    	this.bairro = entity.getBairro();
    	this.cep = entity.getCep();
    	this.cpf = entity.getCpf();
    	this.email = entity.getEmail();
    	this.endereco = entity.getEndereco();
    	this.nome = entity.getNome();
    	this.idCidade = entity.getCidade().getIdCidade();
    	this.situacao = entity.getSituacao().ordinal();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Long idCidade) {
        this.idCidade = idCidade;
    }

    public Long getCep() {
        return cep;
    }

    public void setCep(Long cep) {
        this.cep = cep;
    }

	public Integer getSituacao() {
		return situacao;
	}

	public void setSituacao(Integer situacao) {
		this.situacao = situacao;
	}


}
