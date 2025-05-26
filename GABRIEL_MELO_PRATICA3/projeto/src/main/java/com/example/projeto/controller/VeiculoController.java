package com.example.projeto.controller;

import java.util.List;  
import org.springframework.http.ResponseEntity;  
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.RequestBody;   

import com.example.projeto.service.VeiculoService;
import com.example.projeto.model.Veiculo;

@RestController
@RequestMapping("/api/veiculos")
public class VeiculoController{
    
    private final VeiculoService veiculoService;

    public VeiculoController(VeiculoService veiculoService){
        this.veiculoService = veiculoService;
    }

    @GetMapping
    public List<Veiculo> listarVeiculos(){
        return veiculoService.listarVeiculos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> buscarVeiculo(@PathVariable Long id){
        return veiculoService.buscarPorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Veiculo criarVeiculo(@RequestBody Veiculo veiculo){
        return veiculoService.salvarVeiculo(veiculo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarVeiculo(@PathVariable Long id){
        veiculoService.deletarVeiculo(id);
        return ResponseEntity.noContent().build();
    }
}