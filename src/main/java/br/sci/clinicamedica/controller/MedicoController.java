package br.sci.clinicamedica.controller;

import br.sci.clinicamedica.model.consulta.Consulta;
import br.sci.clinicamedica.model.consulta.ConsultaDTO;
import br.sci.clinicamedica.model.consulta.SalvarConsultaDTO;
import br.sci.clinicamedica.model.consulta.TodasConsultasDTO;
import br.sci.clinicamedica.model.medico.Medico;
import br.sci.clinicamedica.model.medico.MedicoDTO;
import br.sci.clinicamedica.model.medico.SalvarMedicoDTO;
import br.sci.clinicamedica.model.paciente.PacienteDTO;
import br.sci.clinicamedica.service.MedicoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/medico")
public class MedicoController {

    private final MedicoService service;

    public MedicoController(MedicoService service){
        this.service=service;
    }

    @PostMapping("/print-json")
    public void printJson(@RequestBody String json){
        System.out.println(json);
    }

    @GetMapping("/{id}")
    public Medico medico(@PathVariable int id){
        return  this.service.findById(id);
    }



    @PostMapping
    @Transactional
    public ResponseEntity salvar(@RequestBody @Valid Medico medico, UriComponentsBuilder uriComponentsBuilder){

        this.service.salvar(medico);
        URI uri = uriComponentsBuilder.path("/medico/{id}").buildAndExpand(medico.getId()).toUri();
        SalvarMedicoDTO medicodto = this.service.salvarMedicoDTO(medico.getId());
        return ResponseEntity.created(uri).body(medicodto);
    }



    //@GetMapping
    public ResponseEntity<List<Medico>> listar(){
        return ResponseEntity.ok(this.service.listar());
    }

    @GetMapping
    public List<MedicoDTO> listarMedicoDTO(){
        return this.service.listaMedicosDTO();
    }

    @GetMapping("/detalhes_consulta_medico/{id}")
    public List<ConsultaDTO> listarConsultasPorMedico(@PathVariable int id){
        return this.service.findByConsultasPorMedico(id);
    }
    @GetMapping("/todas_consultas_medico/{id}")
    public List<TodasConsultasDTO> listarTodasConsultasPorMedico(@PathVariable int id){
        return this.service.findByTodasConsultasPorMedico(id);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody Medico medico){
        this.service.atualizar(medico);
        return ResponseEntity.ok(medico);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable int id){
        this.service.excluir(id);
        return ResponseEntity.noContent().build();
    }

}
