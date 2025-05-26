package com.example.projeto.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "veiculos")
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String modelo;
    private Integer ano;
    private BigDecimal valor;

    public Veiculo() {
    }

    public Veiculo(String modelo, Integer ano, BigDecimal valor) {
        this.modelo = modelo;
        this.ano = ano;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Integer getAno() {
        return ano;
    }
        public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
