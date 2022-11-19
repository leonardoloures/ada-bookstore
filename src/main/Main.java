package main;

import java.math.BigDecimal;
import java.util.List;

import model.AlbumDeMusica;
import model.Brinquedo;
import model.Filme;
import model.Jogo;
import model.Livro;
import service.Caixa;
import service.Estoque;
import service.impl.CaixaImpl;
import service.impl.EstoqueImpl;
import service.impl.Livraria;

public class Main {

	public static void main(String[] args) {
		AlbumDeMusica album = new AlbumDeMusica("Album 1", "album1", new BigDecimal("1.00"), List.of("Musico 1"), List.of(), List.of("Genero"), List.of("Selo"));
		
		Brinquedo brinquedo = new Brinquedo("Brinquedo 1", "brinquedo1", new BigDecimal("1.00"), "Tipo");
		
		Filme filme = new Filme("Filme 1", "filme1", new BigDecimal("5.00"), "Estudio", List.of("Diretor"), List.of("Genero"), List.of("Produtor"));
		
		Jogo jogo = new Jogo("Jogo 1", "jogo1", new BigDecimal("129.00"), "Distribuidora", "Genero", "Estudio");
		
		Livro livro1 = new Livro("Livro 1", "livro1", new BigDecimal("1.00"), "Genero", "Escritor", "Editora");
		Livro livro2 = new Livro("Livro 2", "livro2", new BigDecimal("2.00"), "Genero", "Escritor", "Editora");
		Livro livro3 = new Livro("Livro 3", "livro3", new BigDecimal("3.00"), "Genero", "Escritor", "Editora");
		Livro livro4 = new Livro("Livro 3", "livro4", new BigDecimal("4.00"), "Genero", "Escritor", "Editora");
				
		Caixa caixa = new CaixaImpl();
		Estoque estoque = new EstoqueImpl();
		estoque.adiciona(album);
		estoque.adiciona(brinquedo);
		estoque.adiciona(filme);
		estoque.adiciona(jogo);
		estoque.adiciona(livro1);
		estoque.adiciona(livro2);
		estoque.adiciona(livro3);
		try {
			estoque.adiciona(livro3);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		estoque.adiciona(livro4);
		livro4.setNome("Livro 4");
		estoque.altera(livro4);
		
		Livraria livraria = new Livraria(caixa, estoque);
		
		System.out.println();
		livraria.imprimeEstadoAtual();
		
		System.out.println();
		livraria.compra(List.of(album, livro2));
		System.out.println();
		livraria.compra(List.of(livro3));
		System.out.println();
		livraria.compra(List.of(livro3));
		
		System.out.println();
		livraria.imprimeEstadoAtual();
		
		System.out.println();
		livraria.imprimeEstoqueDoProduto(AlbumDeMusica.class);
		livraria.imprimeEstoqueDoProduto(Brinquedo.class);
		livraria.imprimeEstoqueDoProduto(Filme.class);
		livraria.imprimeEstoqueDoProduto(Jogo.class);
		livraria.imprimeEstoqueDoProduto(Livro.class);
	}
	
	

}
