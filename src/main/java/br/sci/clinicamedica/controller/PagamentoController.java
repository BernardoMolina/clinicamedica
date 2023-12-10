package br.sci.clinicamedica.controller;

import br.sci.clinicamedica.model.pagamento.Pagamento;

import br.sci.clinicamedica.model.pagamento.SalvarPagamentoDTO;
import br.sci.clinicamedica.service.PagamentoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

    private final PagamentoService service;

    public PagamentoController(PagamentoService service){
        this.service=service;
    }

    @PostMapping("/print-json")
    public void printJson(@RequestBody String json){
        System.out.println(json);
    }

    @GetMapping("/{id}")
    public Pagamento pagamento(@PathVariable int id){
        return  this.service.findById(id);
    }

    @PostMapping
    @Transactional
    public ResponseEntity salvar(@RequestBody @Valid Pagamento pagamento, UriComponentsBuilder uriComponentsBuilder){

        this.service.salvar(pagamento);
        URI uri = uriComponentsBuilder.path("/pagamento/{id}").buildAndExpand(pagamento.getId()).toUri();
        SalvarPagamentoDTO pagamentodto = this.service.salvarPagamentoDTO(pagamento.getId());
        return ResponseEntity.created(uri).body(pagamentodto);
    }

    //@GetMapping
    public ResponseEntity<List<Pagamento>> listar(){
        return ResponseEntity.ok(this.service.listar());
    }




    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody Pagamento pagamento){
        this.service.atualizar(pagamento);
        SalvarPagamentoDTO pagamentodto = this.service.salvarPagamentoDTO(pagamento.getId());
        return ResponseEntity.ok(pagamentodto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable int id){
        this.service.excluir(id);
        return ResponseEntity.noContent().build();
    }

}
