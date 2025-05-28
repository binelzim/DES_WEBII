package com.example.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.projeto.model.Consulta;
import java.util.List;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    // Busca todas as consultas de uma pessoa específica
    List<Consulta> findByPessoaId(Long pessoaId);
}
