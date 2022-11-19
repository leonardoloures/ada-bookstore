package service;

import java.math.BigDecimal;

public interface Caixa {
	void adiciona(BigDecimal valor);
	BigDecimal obtemSaldo();
}
