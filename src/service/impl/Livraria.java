package service.impl;

import java.util.List;
import java.util.stream.Collectors;

import model.Cliente;
import model.Produto;
import service.Caixa;
import service.Estoque;
import service.ValidadorDeCompra;

public class Livraria {
	private Caixa caixa;
	private Estoque estoque;
	
	public Livraria(Caixa caixa, Estoque estoque) {
		super();
		this.caixa = caixa;
		this.estoque = estoque;
	}
	
	public void imprimeEstadoAtual() {
		System.out.println("=== Estado atual da Livraria ===");
		System.out.println("Caixa: " + this.caixa.obtemSaldo());
		System.out.println("Estoque: " + this.estoque.obtemTodosOsProdutos().stream()
				.map(p -> p.getNome())
				.collect(Collectors.toList()));
	}
	
	public <T extends Produto> void imprimeEstoqueDoProduto(Class<T> tipo) {
		 List<T> estoqueDoProduto = this.estoque.obtemProdutos(tipo);
		 System.out.println("Estoque de " + tipo.getName() + ": " + estoqueDoProduto.stream()
		 	.map(p -> p.getNome())
		 	.collect(Collectors.toList()));
	}
	
	public void compra(List<Produto> produtos, Cliente cliente) {
		ValidadorDeCompra validador = new ValidadorDeCompraImpl();
		produtos.forEach(produto -> {
			try {
				System.out.println(String.format("Cliente %s comprando o produto %s", cliente.getNome(), produto.getId()));
				if (validador.podeComprar(cliente, produto)) {
					this.estoque.remove(produto.getId());
					this.caixa.adiciona(produto.getPreco());
				} else {
					throw new Exception("O cliente " + cliente.getNome() + " nao pode comprar o produto " + produto.getId());
				}
			} catch (Exception e) {
				System.out.println("Erro na compra do produto " + produto.getId() + ": " + e.getMessage());
			}
		});
	}
}
