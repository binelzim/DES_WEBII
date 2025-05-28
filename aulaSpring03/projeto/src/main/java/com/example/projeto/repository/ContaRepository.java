package com.example.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.projeto.model.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {
    // podemos adicionar métodos customizados, ex:
    // Optional<Conta> findByUsername(String username);
}
