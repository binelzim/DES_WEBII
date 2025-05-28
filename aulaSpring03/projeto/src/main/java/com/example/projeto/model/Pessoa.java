package com.example.projeto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.CascadeType;

import jakarta.persistence.OneToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.FetchType;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pessoas")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Integer idade;

    // 1:1 com Conta
    @JsonManagedReference
    @OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Conta conta;

    // Relacionamento 1:N com Consulta
    // lado “pai” da relação 1:N
    @JsonManagedReference
    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Consulta> consultas = new ArrayList<>();

    // N:M com Hospital
    @JsonManagedReference
    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
    @JoinTable(name = "pessoa_hospital", joinColumns = @JoinColumn(name = "pessoa_id"), inverseJoinColumns = @JoinColumn(name = "hospital_id"))
    private Set<Hospital> hospitais = new HashSet<>();

    public Pessoa() {
    }

    public Pessoa(String nome, Integer idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public Long getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Integer getIdade() {
        return idade;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
        // garante sincronização bidirecional
        if (conta != null) {
            conta.setPessoa(this);
        }
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    // Adiciona uma consulta à pessoa, mantendo o vínculo bidirecional.
    public void addConsulta(Consulta consulta) {
        consultas.add(consulta);
        consulta.setPessoa(this);
    }

    public Set<Hospital> getHospitais() {
        return hospitais;
    }

    /**
     * Adiciona um hospital à pessoa e mantém consistência bidirecional.
     */
    public void addHospital(Hospital hospital) {
        hospitais.add(hospital);
        hospital.getPessoas().add(this);
    }

    /**
     * Remove a associação de hospital e mantém consistência bidirecional.
     */
    public void removeHospital(Hospital hospital) {
        hospitais.remove(hospital);
        hospital.getPessoas().remove(this);
    }
}