package br.com.cwi.crescer.lavanderia.dto;

import br.com.cwi.crescer.lavanderia.domain.Cliente;
import br.com.cwi.crescer.lavanderia.domain.Cliente.SituacaoCliente;
public class ClienteResumoDTO {

	private Long id;
	private String nome;
    private String cpf;
    private SituacaoCliente situacao;
    
    public ClienteResumoDTO() {
    }

    public ClienteResumoDTO(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public ClienteResumoDTO(Cliente entity) {
    	this.id = entity.getIdCliente();
        this.nome = entity.getNome();
        this.cpf = entity.getCpf();
        this.situacao = entity.getSituacao();
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

	public SituacaoCliente getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoCliente situacao) {
		this.situacao = situacao;
	}
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
