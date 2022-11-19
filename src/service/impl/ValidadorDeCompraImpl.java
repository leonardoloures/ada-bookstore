package service.impl;

import model.Cliente;
import model.Produto;
import service.ValidadorDeCompra;

public class ValidadorDeCompraImpl implements ValidadorDeCompra {

	@Override
	public Boolean podeComprar(Cliente cliente, Produto produto) {
		if (produto != null && produto.getPublicoAdulto() == Boolean.FALSE) {
			return Boolean.TRUE;
		}
		
		if (produto != null && cliente != null && produto.getPublicoAdulto() == Boolean.TRUE && cliente.idade() >= 18) {
			return Boolean.TRUE;
		}

		return Boolean.FALSE;
	}

}
