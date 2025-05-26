package com.example.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projeto.model.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long>{

}