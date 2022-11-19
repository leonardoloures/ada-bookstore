package service;

import java.math.BigDecimal;
import java.util.List;

import model.Produto;

public interface Carrinho {
	void adicionaProduto(Produto produto);
	BigDecimal calculaDesconto();
	BigDecimal calculaTotal();
	List<Produto> listaProdutos();
}
