package service;

import java.util.List;

import model.Produto;

public interface Estoque {
	void adiciona(Produto produto);
	Produto remove(String id);
	List<Produto> obtemTodosOsProdutos();
	<T> List<T> obtemProdutos(Class<T> tipo);
}
