package br.sci.clinicamedica.service;


import br.sci.clinicamedica.model.paciente.Paciente;
import br.sci.clinicamedica.model.paciente.PacienteDTO;
import br.sci.clinicamedica.model.paciente.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    private PacienteRepository repository;
    public PacienteService(PacienteRepository repository){
        this.repository = repository;
    }

    public void salvar(Paciente paciente){
        this.repository.save(paciente);
    }

    public List<Paciente> listar(){
        return  this.repository.findAll();
    }
    public List<PacienteDTO> listaPacientesDTO(){
        return  this.repository.findAllDTO();
    }

    public Paciente findById(int id){
        return  this.repository.findById(id).get();
    }

    public void atualizar(Paciente paciente){
        Paciente p = this.repository.getReferenceById(paciente.getId());
        p.setNome(paciente.getNome());
        p.setSobrenome(paciente.getSobrenome());
        p.setEmail(paciente.getEmail());
        p.setCpf(paciente.getCpf());
        p.setTelefone(paciente.getTelefone());
        p.setPlano_de_saude(paciente.getPlano_de_saude());
        p.setEndereco(paciente.getEndereco());
    }

    public void excluir(int id){
        this.repository.deleteById(id);
    }



}
