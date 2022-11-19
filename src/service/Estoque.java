package service;

import java.util.List;

import model.Produto;

public interface Estoque {
	void adiciona(Produto produto);
	Produto obtem(String id);
	void altera(Produto produto);
	Produto remove(String id);
	
	List<Produto> obtemTodosOsProdutos();
	<T> List<T> obtemProdutos(Class<T> tipo);
	
	<T> Integer obtemQuantidade(Class<T> tipo);
}
