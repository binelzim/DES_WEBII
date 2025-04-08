package dominio;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Produto {
	private long Id;
	private String nome;
	private double preco;
	private List<Venda> vendas;
	
	public Produto(){
		this.nome = nome;
		this.preco = preco;
	}

	public void setId(Long Id){
		this.Id = Id;
	}

	public long getId(){
		return Id;
	}

	public void setPreco(Double preco){
		this.preco = preco;
	}

	public double getPreco(){
		return preco;
	}

	public void setVenda(List<Venda> vendas){
		this.vendas = vendas;
	}

	public List<venda> getVenda(){
		return this.vendas;
	}

	@Override
	public String toString(){
		return "Produto[nome= "+ nome + ", preco=" + preco + "]";
	}
}
