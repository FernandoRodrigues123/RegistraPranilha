package br.com.Sucos.DAO;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.PersistenceException;
import javax.sql.DataSource;

import br.com.Sucos.Modulo.Produto;

public class ProdutoDAO {

	private EntityManager em;
	
	public ProdutoDAO(EntityManager connection) {

		this.em = connection;
	}
	
	public void registraProduto(Produto produto) {
			this.em.persist(produto);
		
	}
	
}
