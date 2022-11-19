package model;

import java.math.BigDecimal;

public abstract class Produto {
	private String nome;
	private String id;
	private BigDecimal preco;
	private Boolean publicoAdulto;
	
	public Produto(String nome, String id, BigDecimal preco) {
		super();
		this.nome = nome;
		this.id = id;
		this.preco = preco;
		this.publicoAdulto = Boolean.FALSE;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public BigDecimal getPreco() {
		return preco;
	}
	
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Boolean getPublicoAdulto() {
		return publicoAdulto;
	}

	public void setPublicoAdulto(Boolean publicoAdulto) {
		this.publicoAdulto = publicoAdulto;
	}
}
