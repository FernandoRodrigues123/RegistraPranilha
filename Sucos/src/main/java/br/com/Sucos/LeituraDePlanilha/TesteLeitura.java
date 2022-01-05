package br.com.Sucos.LeituraDePlanilha;

import java.io.IOException;
import java.util.List;

import br.com.Sucos.Modulo.Produto;

public class TesteLeitura {

	public static void main(String[] args) throws IOException {
		Leitura leitura = new Leitura();
		List<Produto> criar = leitura.criar();
		System.out.println(criar.size());
		for (Produto produto : criar) {
			System.out.println(produto);
		}
	}
		
	
}
