package com.managedbean;

import javax.annotation.PostConstruct;

public class Usuarios {
	private String login;
	private String senha;
	private String erro;
	private Boolean logado;
	public String getErro() {
		return erro;
	}
	public void setErro(String erro) {
		this.erro = erro;
	}
	public Boolean getLogado() {
		return logado;
	}
	public void setLogado(Boolean logado) {
		this.logado = logado;
	}
	@PostConstruct
	public void init() {
		System.out.println(" Usuario instanciado! ");
	}
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String logar() {
		if (login.equals("123") && senha.equals("123")) {
			this.logado = true;
			this.erro = "";
			return "inicial";
		} else {
			this.erro = "Usuário e senha inválidos";
			this.logado = false;
			return "login";
		}
	}
}
