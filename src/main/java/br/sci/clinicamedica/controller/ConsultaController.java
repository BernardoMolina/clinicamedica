package br.sci.clinicamedica.controller;

import br.sci.clinicamedica.model.consulta.Consulta;
import br.sci.clinicamedica.model.consulta.ConsultaDTO;
import br.sci.clinicamedica.model.paciente.PacienteDTO;
import br.sci.clinicamedica.service.ConsultaService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {

    private final ConsultaService service;

    public ConsultaController(ConsultaService service){
        this.service=service;
    }

    @PostMapping("/print-json")
    public void printJson(@RequestBody String json){
        System.out.println(json);
    }

    @GetMapping("/{id}")
    public Consulta consulta(@PathVariable int id){
        return  this.service.findById(id);
    }

    @PostMapping
    @Transactional
    public ResponseEntity salvar(@RequestBody @Valid Consulta consulta, UriComponentsBuilder uriComponentsBuilder){

        this.service.salvar(consulta);
        URI uri = uriComponentsBuilder.path("/consulta/{id}").buildAndExpand(consulta.getId()).toUri();
        return ResponseEntity.created(uri).body(consulta);
    }

    //@GetMapping
    public ResponseEntity<List<Consulta>> listar(){
        return ResponseEntity.ok(this.service.listar());
    }

    @GetMapping
    public List<ConsultaDTO> listarConsultaDTO(){
        return this.service.listaConsultasDTO();
    }
    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody Consulta consulta){
        this.service.atualizar(consulta);
        return ResponseEntity.ok(consulta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable int id){
        this.service.excluir(id);
        return ResponseEntity.noContent().build();
    }

}
