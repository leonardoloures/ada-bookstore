package model;

import java.math.BigDecimal;
import java.util.List;

public class AlbumDeMusica extends Produto {
	private List<String> musicos;
	private List<String> bandas;
	private List<String> generos;
	private List<String> selos;
	
	public AlbumDeMusica(String nome, String id, BigDecimal preco, List<String> musicos, List<String> bandas,
			List<String> generos, List<String> selos) {
		super(nome, id, preco);
		this.musicos = musicos;
		this.bandas = bandas;
		this.generos = generos;
		this.selos = selos;
	}

	public List<String> getMusicos() {
		return musicos;
	}

	public void setMusicos(List<String> musicos) {
		this.musicos = musicos;
	}

	public List<String> getBandas() {
		return bandas;
	}

	public void setBandas(List<String> bandas) {
		this.bandas = bandas;
	}

	public List<String> getGeneros() {
		return generos;
	}

	public void setGeneros(List<String> generos) {
		this.generos = generos;
	}

	public List<String> getSelos() {
		return selos;
	}

	public void setSelos(List<String> selos) {
		this.selos = selos;
	}
}
