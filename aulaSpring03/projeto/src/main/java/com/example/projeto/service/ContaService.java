package com.example.projeto.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.projeto.repository.ContaRepository;
import com.example.projeto.model.Conta;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
public class ContaService {

    private final ContaRepository contaRepository;

    public ContaService(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    public List<Conta> listarContas() {
        return contaRepository.findAll();
    }

    public Optional<Conta> buscarPorId(Long id) {
        return contaRepository.findById(id);
    }

    @Transactional
    public Conta salvarConta(Conta conta) {
        // como Pessoa.cascade = ALL, se a conta trouxer a pessoa associada, ela será salva junto
        return contaRepository.save(conta);
    }

    @Transactional
    public void deletarConta(Long id) {
        contaRepository.deleteById(id);
    }
}
