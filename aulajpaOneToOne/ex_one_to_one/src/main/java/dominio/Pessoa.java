package dominio;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;	
	
	
	@OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL)
	private Passaporte passaporte;
	
	public Pessoa() {
		this("");
	}
	
	public Pessoa(String nome) {
		setNome(nome);
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Passaporte getPassaporte() {
		return passaporte;
	}

	public void setPassaporte(Passaporte passaporte) {
		this.passaporte = passaporte;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + "]";
	}
}
