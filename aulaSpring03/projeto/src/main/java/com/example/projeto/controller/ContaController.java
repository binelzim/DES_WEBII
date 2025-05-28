package com.example.projeto.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.projeto.service.ContaService;
import com.example.projeto.model.Conta;

import java.util.List;

@RestController
@RequestMapping("/api/contas")
public class ContaController {

    private final ContaService contaService;

    public ContaController(ContaService contaService) {
        this.contaService = contaService;
    }

    // GET /api/contas
    @GetMapping
    public List<Conta> listar() {
        return contaService.listarContas();
    }

    // GET /api/contas/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Conta> buscar(@PathVariable Long id) {
        return contaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /api/contas
    @PostMapping
    public ResponseEntity<Conta> criar(@RequestBody Conta conta) {
        Conta criada = contaService.salvarConta(conta);
        return ResponseEntity.ok(criada);
    }

    // DELETE /api/contas/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        contaService.deletarConta(id);
        return ResponseEntity.noContent().build();
    }
}
