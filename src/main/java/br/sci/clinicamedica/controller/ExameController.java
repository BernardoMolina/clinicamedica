package br.sci.clinicamedica.controller;

import br.sci.clinicamedica.model.consulta.SalvarConsultaDTO;
import br.sci.clinicamedica.model.exame.Exame;
import br.sci.clinicamedica.model.exame.ExameDTO;
import br.sci.clinicamedica.model.exame.SalvarExameDTO;
import br.sci.clinicamedica.service.ExameService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/exame")
public class ExameController {

    private final ExameService service;

    public ExameController(ExameService service){
        this.service=service;
    }

    @PostMapping("/print-json")
    public void printJson(@RequestBody String json){
        System.out.println(json);
    }

    @GetMapping("/{id}")
    public Exame exame(@PathVariable int id){
        return  this.service.findById(id);
    }

    @PostMapping
    @Transactional
    public ResponseEntity salvar(@RequestBody @Valid Exame exame, UriComponentsBuilder uriComponentsBuilder){

        this.service.salvar(exame);
        URI uri = uriComponentsBuilder.path("/exame/{id}").buildAndExpand(exame.getId()).toUri();
        SalvarExameDTO examedto = this.service.salvarExameDTO(exame.getId());
        return ResponseEntity.created(uri).body(examedto);
    }

    //@GetMapping
    public ResponseEntity<List<Exame>> listar(){
        return ResponseEntity.ok(this.service.listar());
    }

    @GetMapping
    public List<ExameDTO> listarExameDTO(){
        return this.service.listaExamesDTO();
    }


    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody Exame exame){
        this.service.atualizar(exame);
        SalvarExameDTO examedto = this.service.salvarExameDTO(exame.getId());
        return ResponseEntity.ok(examedto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable int id){
        this.service.excluir(id);
        return ResponseEntity.noContent().build();
    }

}
