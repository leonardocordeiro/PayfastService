package br.com.caelum.payfast.modelo;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlType;

@XmlType(name="produto")
public class Produto {
	private String nome;
	private BigDecimal preco;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
}
