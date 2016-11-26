package com.managedbean;

import javax.annotation.PostConstruct;

public class Usuarios {
	private String login;
	private String senha;
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
			return "resultado";
		} else {
			return "login";
		}
	}
}
