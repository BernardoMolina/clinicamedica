package br.sci.clinicamedica.controller;

import br.sci.clinicamedica.model.consulta.SalvarConsultaDTO;
import br.sci.clinicamedica.model.paciente.PacienteDTO;
import br.sci.clinicamedica.model.receita.Receita;
import br.sci.clinicamedica.model.receita.ReceitaDTO;
import br.sci.clinicamedica.model.receita.SalvarReceitaDTO;
import br.sci.clinicamedica.service.ReceitaService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/receita")
public class ReceitaController {

    private final ReceitaService service;

    public ReceitaController(ReceitaService service){
        this.service=service;
    }

    @PostMapping("/print-json")
    public void printJson(@RequestBody String json){
        System.out.println(json);
    }

    @GetMapping("/{id}")
    public Receita receita(@PathVariable int id){
        return  this.service.findById(id);
    }

    @PostMapping
    @Transactional
    public ResponseEntity salvar(@RequestBody @Valid Receita receita, UriComponentsBuilder uriComponentsBuilder){

        this.service.salvar(receita);
        URI uri = uriComponentsBuilder.path("/receita/{id}").buildAndExpand(receita.getId()).toUri();
        SalvarReceitaDTO receitadto = this.service.salvarReceitaDTO(receita.getId());
        return ResponseEntity.created(uri).body(receitadto);
    }

    @GetMapping
    public List<ReceitaDTO> listarReceitaDTO(){
        return this.service.listaReceitasDTO();
    }



    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody Receita receita){
        this.service.atualizar(receita);
        SalvarReceitaDTO receitadto = this.service.salvarReceitaDTO(receita.getId());
        return ResponseEntity.ok(receitadto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable int id){
        this.service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
