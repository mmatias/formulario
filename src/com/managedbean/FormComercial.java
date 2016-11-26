package com.managedbean;

public class FormComercial extends Pessoas{
	private Produtos produto1 = new Produtos();
	private Produtos produto2 = new Produtos();
	private Produtos produto3 = new Produtos();
	
	public Produtos getProduto1() {
		return produto1;
	}
	public void setProduto1(Produtos produto1) {
		this.produto1 = produto1;
	}
	public Produtos getProduto2() {
		return produto2;
	}
	public void setProduto2(Produtos produto2) {
		this.produto2 = produto2;
	}
	public Produtos getProduto3() {
		return produto3;
	}
	public void setProduto3(Produtos produto3) {
		this.produto3 = produto3;
	}
}
