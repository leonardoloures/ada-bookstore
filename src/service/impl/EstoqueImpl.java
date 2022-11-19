package service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import model.Produto;
import service.Estoque;

public class EstoqueImpl implements Estoque {
	private Map<String, Produto> estoque = new HashMap<>();

	@Override
	public void adiciona(Produto produto) {
		System.out.println("Adicionando produto " + produto.getId() + " ao estoque");
		if (this.estoque.containsKey(produto.getId())) {
			throw new RuntimeException("O produto " + produto.getId() + " ja existe no estoque");
		}
		this.estoque.put(produto.getId(), produto);
		System.out.println("Produto " + produto.getId() + " adicionado ao estoque");
	}

	@Override
	public Produto obtem(String id) {
		return this.estoque.get(id);
	}

	@Override
	public void altera(Produto produto) {
		System.out.println("Alterando produto " + produto.getId() + " no estoque");
		if (!this.estoque.containsKey(produto.getId())) {
			throw new RuntimeException("O produto " + produto.getId() + " nao existe no estoque");
		}
		this.estoque.put(produto.getId(), produto);
		System.out.println("Produto " + produto.getId() + " alterado no estoque");
	}
	
	@Override
	public Produto remove(String id) {
		System.out.println("Removendo produto " + id + " do estoque");
		if (this.estoque.containsKey(id)) {
			Produto produto = this.estoque.remove(id);
			System.out.println("Produto " + id + " removido do estoque");
			return produto;
		}
		throw new RuntimeException("Produto não existe em estoque");
	}

	@Override
	public List<Produto> obtemTodosOsProdutos() {
		return List.copyOf(this.estoque.values());
	}

	@Override
	public <T> List<T> obtemProdutos(Class<T> tipo) {
		return (List<T>)this.estoque.values().stream()
				.filter(p -> p.getClass() == tipo)
				.collect(Collectors.toList());
	}

	@Override
	public <T> Integer obtemQuantidade(Class<T> tipo) {
		return this.obtemProdutos(tipo).size();
	}
}
