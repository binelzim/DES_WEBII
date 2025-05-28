package com.example.projeto.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.projeto.repository.HospitalRepository;
import com.example.projeto.model.Hospital;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
public class HospitalService {

    private final HospitalRepository hospitalRepository;

    public HospitalService(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    public List<Hospital> listarTodos() {
        return hospitalRepository.findAll();
    }

    public Optional<Hospital> buscarPorId(Long id) {
        return hospitalRepository.findById(id);
    }

    @Transactional
    public Hospital salvar(Hospital hospital) {
        return hospitalRepository.save(hospital);
    }

    @Transactional
    public void deletar(Long id) {
        hospitalRepository.deleteById(id);
    }
}
