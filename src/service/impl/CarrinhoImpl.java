package service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import model.Livro;
import model.Produto;
import service.Carrinho;

public class CarrinhoImpl implements Carrinho {
	List<Produto> produtos = new ArrayList<>();

	@Override
	public void adicionaProduto(Produto produto) {
		System.out.println(String.format("Adicionando produto %s ao carrinho", produto.getId()));
		this.produtos.add(produto);
	}

	@Override
	public BigDecimal calculaDesconto() {
		BigDecimal totalLivros = this.produtos.stream()
				.filter(p -> p instanceof Livro)
				.map(Produto::getPreco)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
		System.out.println("Total de livros no carrinho: " + totalLivros);
		if (totalLivros.compareTo(new BigDecimal("200.00")) >= 0) {
			return new BigDecimal("0.15");
		}
		
		return BigDecimal.ZERO;
	}

	@Override
	public BigDecimal calculaTotal() {
		BigDecimal total = this.produtos.stream()
				.map(Produto::getPreco)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
		BigDecimal desconto = calculaDesconto();
		BigDecimal valorDesconto = total.multiply(calculaDesconto());
		BigDecimal totalComDesconto = total.subtract(valorDesconto);
		System.out.println("Total no carrinho: " + total);
		System.out.println("Desconto: " + desconto.multiply(new BigDecimal("100")) + "%");
		System.out.println("Desconto: " + valorDesconto);
		System.out.println("Total com desconto: " + totalComDesconto);
		return totalComDesconto;
	}

	@Override
	public List<Produto> listaProdutos() {
		return List.copyOf(this.produtos);
	}

}
