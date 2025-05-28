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

import com.example.projeto.service.ConsultaService;
import com.example.projeto.model.Consulta;

@RestController
@RequestMapping("/api/consultas")
public class ConsultaController{
    
    private final ConsultaService consultaService;

    public ConsultaController(ConsultaService consultaService){
        this.consultaService = consultaService;
    }

    @GetMapping
    public List<Consulta> listarConsultas(){
        return consultaService.listarConsultas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Consulta> buscarConsulta(@PathVariable Long id){
        return consultaService.buscarPorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Consulta criarConsulta(@RequestBody Consulta consulta){
        return consultaService.salvarConsulta(consulta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarConsulta(@PathVariable Long id){
        consultaService.deletarConsulta(id);
        return ResponseEntity.noContent().build();
    }
}