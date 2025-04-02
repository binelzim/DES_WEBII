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
public class Curso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column(name = "nomes")
	private String nome;
	
	@ManyToMany(mappedBy = "cursos")
	private List<Estudante> estudantes = new ArrayList<Estudante>();
	
	public Curso() {
		this("");
	}
	
	public Curso(String nome) {
		setNome(nome);
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Estudante> getEstudante() {
		return estudantes;
	}

	public void setEstudante(List<Estudante> estudante) {
		this.estudantes = estudante;
	}

	@Override
	public String toString() {
		return "Curso [Id=" + Id + ", nome=" + nome + "]";
	}
	
}
