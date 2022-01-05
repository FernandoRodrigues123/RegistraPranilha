package br.com.Sucos.Modulo;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "tbProduto")
public class Produto {
	@Id
	@Column (name ="codigo_produto")
	private String codigoProduto;
	
	private String descricao;
	private String embalagem;
	private Double preco;
	
	@Override
	public String toString() {
		return this.codigoProduto + " " + this.descricao  + " " + this.embalagem  + " " + this.preco;
	}
	
	public Produto() {
		
	}
	
	public Produto(String codigoProduto, String descricao, String embalagem, Double preco) {
		this.codigoProduto = codigoProduto;
		this.descricao = descricao;
		this.embalagem = embalagem;
		this.preco = preco;
		
	}

	public String getCodigoProduto() {
		return codigoProduto;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getEmbalagem() {
		return embalagem;
	}

	public Double getPreco() {
		return preco;
	}
	
}
