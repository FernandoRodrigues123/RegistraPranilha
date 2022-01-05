package br.com.Sucos.Main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import br.com.Sucos.DAO.*;
import br.com.Sucos.JPAUtil.JPAUtil;
import br.com.Sucos.LeituraDePlanilha.Leitura;
import br.com.Sucos.Modulo.Produto;

public class Main {

	public static void main(String[] args) throws IOException {
		Leitura leitura = new Leitura();
		List<Produto> listaProdutos = leitura.criar();

		EntityManager connection = JPAUtil.getEntityManager();
		connection.getTransaction().begin();

		for (Produto produto : listaProdutos) {
			ProdutoDAO produtodao = new ProdutoDAO(connection);

			produtodao.registraProduto(produto);

		}
		connection.getTransaction().commit();
		connection.close();

	}
}
