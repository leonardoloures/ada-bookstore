package service;

import model.Cliente;
import model.Produto;

public interface ValidadorDeCompra {
	Boolean podeComprar(Cliente cliente, Produto produto);
}
