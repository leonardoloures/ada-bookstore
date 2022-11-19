package model;

import java.time.LocalDate;
import java.time.Period;

public class Cliente {
	private String nome;
	private String rg;
	private String cpf;
	private LocalDate dataNascimento;

	public Cliente(String nome, String rg, String cpf, LocalDate dataNascimento) {
		super();
		this.nome = nome;
		this.rg = rg;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public int idade() {
		return Period.between(this.dataNascimento, LocalDate.now()).getYears();
	}

}
