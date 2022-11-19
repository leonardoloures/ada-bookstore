package service.impl;

import java.math.BigDecimal;

import service.Caixa;

public class CaixaImpl implements Caixa {
	
	private BigDecimal saldo;

	public CaixaImpl(BigDecimal saldoInicial) {
		this.saldo = saldoInicial;
	}
	
	public CaixaImpl() {
		this(new BigDecimal("0.00"));
	}

	@Override
	public void adiciona(BigDecimal valor) {
		System.out.println("Adicionando " + valor + " ao caixa");
		this.saldo = this.saldo.add(valor);

	}

	@Override
	public BigDecimal obtemSaldo() {
		return this.saldo;
	}

}
