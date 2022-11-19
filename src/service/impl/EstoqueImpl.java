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
		System.out.println("Produto " + produto.getId() + " adicionado ao estoque");
		this.estoque.put(produto.getId(), produto);
	}

	@Override
	public Produto remove(String id) {
		if (this.estoque.containsKey(id)) {
			System.out.println("Produto " + id + " removido do estoque");
			return this.estoque.remove(id);
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
}
