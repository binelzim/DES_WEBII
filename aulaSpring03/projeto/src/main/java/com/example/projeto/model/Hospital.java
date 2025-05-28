package com.example.projeto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.FetchType;
import java.util.HashSet;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "hospitais")
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String endereco;

    @JsonBackReference
    @ManyToMany(
        mappedBy = "hospitais",
        fetch     = FetchType.LAZY
    )
    private Set<Pessoa> pessoas = new HashSet<>();

    public Hospital() {}

    public Hospital(String nome, String endereco) {
        this.nome     = nome;
        this.endereco = endereco;
    }

    // --- getters e setters ---

    public Set<Pessoa> getPessoas() {
        return pessoas;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
