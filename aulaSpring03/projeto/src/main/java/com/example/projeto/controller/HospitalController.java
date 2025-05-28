package com.example.projeto.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.projeto.service.HospitalService;
import com.example.projeto.model.Hospital;

import java.util.List;

@RestController
@RequestMapping("/api/hospitais")
public class HospitalController {

    private final HospitalService hospitalService;

    public HospitalController(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    // Listar todos os hospitais
    @GetMapping
    public List<Hospital> listar() {
        return hospitalService.listarTodos();
    }

    // Buscar hospital por ID
    @GetMapping("/{id}")
    public ResponseEntity<Hospital> buscar(@PathVariable Long id) {
        return hospitalService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Criar ou atualizar hospital
    @PostMapping
    public ResponseEntity<Hospital> criar(@RequestBody Hospital hospital) {
        Hospital criado = hospitalService.salvar(hospital);
        return ResponseEntity.ok(criado);
    }

    // Excluir hospital
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        hospitalService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
