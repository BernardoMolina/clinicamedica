package br.sci.clinicamedica.controller;

import br.sci.clinicamedica.model.medicamento.Medicamento;
import br.sci.clinicamedica.model.medicamento.SalvarMedicamentoDTO;
import br.sci.clinicamedica.model.receita.SalvarReceitaDTO;
import br.sci.clinicamedica.service.MedicamentoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/medicamento")
public class MedicamentoController {

    private final MedicamentoService service;

    public MedicamentoController(MedicamentoService service){
        this.service=service;
    }

    @PostMapping("/print-json")
    public void printJson(@RequestBody String json){
        System.out.println(json);
    }

    @GetMapping("/{id}")
    public Medicamento medicamento(@PathVariable int id){
        return  this.service.findById(id);
    }

    @PostMapping
    @Transactional
    public ResponseEntity salvar(@RequestBody @Valid Medicamento medicamento, UriComponentsBuilder uriComponentsBuilder){

        this.service.salvar(medicamento);
        URI uri = uriComponentsBuilder.path("/medicamento/{id}").buildAndExpand(medicamento.getId()).toUri();
        SalvarMedicamentoDTO medicamentodto = this.service.salvarMedicamentoDTO(medicamento.getId());
        return ResponseEntity.created(uri).body(medicamentodto);
    }

    @GetMapping
    public ResponseEntity<List<Medicamento>> listar(){
        return ResponseEntity.ok(this.service.listar());
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody Medicamento medicamento){
        this.service.atualizar(medicamento);
        return ResponseEntity.ok(medicamento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable int id){
        this.service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
