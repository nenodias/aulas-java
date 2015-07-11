package br.edu.fgp.model;

import java.math.BigDecimal;

public class MeuBean {

	private BigDecimal preco = BigDecimal.ONE;
	
	private BigDecimal valor = BigDecimal.ONE;

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	public void calcPreco(BigDecimal valor){
		this.preco = this.preco.add(valor);
	}
	
}
