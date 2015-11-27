package br.com.cwi.crescer.lavanderia.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Users")
public class Users {
	
	@Id
	@Basic(optional=false)
	@Column(name="username", length=100)
	private String username;

	@Basic(optional=false)
	@Column(name="password", length=32)
	private String password;
    
	@Basic(optional=false)
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "enabled", length=1)
	private EnableUser enabled;
	
	public static enum EnableUser {
		ATIVO, INATIVO;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public EnableUser getEnabled() {
		return enabled;
	}

	public void setEnabled(EnableUser enabled) {
		this.enabled = enabled;
	}
	
	
}
