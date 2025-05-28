package com.example.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.projeto.model.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long> {
    // Aqui podem ir métodos customizados, ex:
    // List<Hospital> findByNomeContaining(String nome);
}
