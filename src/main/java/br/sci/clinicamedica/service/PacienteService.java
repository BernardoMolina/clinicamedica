package br.sci.clinicamedica.service;


import br.sci.clinicamedica.model.consulta.ConsultaDTO;
import br.sci.clinicamedica.model.consulta.TodasConsultasDTO;
import br.sci.clinicamedica.model.exame.ExameDTO;
import br.sci.clinicamedica.model.exame.TodosExamesDTO;
import br.sci.clinicamedica.model.medico.SalvarMedicoDTO;
import br.sci.clinicamedica.model.paciente.Paciente;
import br.sci.clinicamedica.model.paciente.PacienteDTO;
import br.sci.clinicamedica.model.paciente.PacienteRepository;
import br.sci.clinicamedica.model.paciente.SalvarPacienteDTO;
import br.sci.clinicamedica.model.receita.ReceitaDTO;
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

    public SalvarPacienteDTO salvarPacienteDTO(int id){return this.repository.salvarPaciente(id);}

    public List<ConsultaDTO> findByConsultasPorPaciente(int id){
        return  this.repository.findByConsultasPorPaciente(id);
    }
    public List<TodasConsultasDTO> findByTodasConsultasPorPaciente(int id){
        return  this.repository.findByTodasConsultasPorPaciente(id);
    }

    public List<ReceitaDTO> findByReceitasPorPaciente(int id){
        return  this.repository.findByReceitasPorPaciente(id);
    }


    public List<ExameDTO> findByExamesPorPaciente(int id){
        return  this.repository.findByExamesPorPaciente(id);
    }
    public List<TodosExamesDTO> findByTodasExamesPorPaciente(int id){
        return  this.repository.findByTodasExamesPorPaciente(id);
    }


    public Paciente findById(int id){
        return  this.repository.findById(id).get();
    }

    public void atualizar(Paciente paciente){
        Paciente p = this.repository.getReferenceById(paciente.getId());
        p.setNome(paciente.getNome());
        p.setSobrenome(paciente.getSobrenome());
        p.setEmail(paciente.getEmail());
       // p.setCpf(paciente.getCpf());
        p.setTelefone(paciente.getTelefone());
        p.setPlano_de_saude(paciente.getPlano_de_saude());
        p.setEndereco(paciente.getEndereco());
    }

    public void excluir(int id){
        this.repository.deleteById(id);
    }



}
