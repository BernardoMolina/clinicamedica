package br.sci.clinicamedica.controller;

import br.sci.clinicamedica.model.consulta.ConsultaDTO;
import br.sci.clinicamedica.model.consulta.TodasConsultasDTO;
import br.sci.clinicamedica.model.paciente.Paciente;
import br.sci.clinicamedica.model.paciente.PacienteDTO;
import br.sci.clinicamedica.service.PacienteService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/paciente")
public class PacienteController {

    private final PacienteService service;

    public PacienteController(PacienteService service){
        this.service=service;
    }

    @PostMapping("/print-json")
    public void printJson(@RequestBody String json){
        System.out.println(json);
    }

    @GetMapping("/{id}")
    public Paciente paciente(@PathVariable int id){
        return  this.service.findById(id);
    }

    @PostMapping
    @Transactional
    public ResponseEntity salvar(@RequestBody @Valid Paciente paciente, UriComponentsBuilder uriComponentsBuilder){

        this.service.salvar(paciente);
        URI uri = uriComponentsBuilder.path("/paciente/{id}").buildAndExpand(paciente.getId()).toUri();
        return ResponseEntity.created(uri).body(paciente);
    }

   // @GetMapping
    public ResponseEntity<List<Paciente>> listar(){
        return ResponseEntity.ok(this.service.listar());
    }

    @GetMapping
    public List<PacienteDTO> listarPacienteDTO(){
        return this.service.listaPacientesDTO();
    }

    @GetMapping("/detalhes_consulta/{id}")
    public List<ConsultaDTO> listarConsultasPorPaciente(@PathVariable int id){
        return this.service.findByConsultasPorPaciente(id);
    }
    @GetMapping("/todas_consultas/{id}")
    public List<TodasConsultasDTO> listarTodasConsultasPorPaciente(@PathVariable int id){
        return this.service.findByTodasConsultasPorPaciente(id);
    }
    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody Paciente paciente){
        this.service.atualizar(paciente);
        return ResponseEntity.ok(paciente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable int id){
        this.service.excluir(id);
        return ResponseEntity.noContent().build();
    }
    
    
}
