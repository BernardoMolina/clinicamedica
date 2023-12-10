package br.sci.clinicamedica.service;

import br.sci.clinicamedica.model.consulta.ConsultaDTO;
import br.sci.clinicamedica.model.consulta.SalvarConsultaDTO;
import br.sci.clinicamedica.model.consulta.TodasConsultasDTO;
import br.sci.clinicamedica.model.exame.ExameDTO;
import br.sci.clinicamedica.model.exame.TodosExamesDTO;
import br.sci.clinicamedica.model.medico.Medico;
import br.sci.clinicamedica.model.medico.MedicoDTO;
import br.sci.clinicamedica.model.medico.MedicoRepository;
import br.sci.clinicamedica.model.medico.SalvarMedicoDTO;
import br.sci.clinicamedica.model.paciente.PacienteDTO;
import br.sci.clinicamedica.model.receita.ReceitaDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {

    private MedicoRepository repository;
    public MedicoService(MedicoRepository repository){
        this.repository = repository;
    }

    public void salvar(Medico medico){
        this.repository.save(medico);
    }

    public List<Medico> listar(){
        return  this.repository.findAll();
    }

    public List<MedicoDTO> listaMedicosDTO(){
        return  this.repository.findAllDTO();
    }

    public SalvarMedicoDTO salvarMedicoDTO(int id){return this.repository.salvarMedico(id);}

    public List<ConsultaDTO> findByConsultasPorMedico(int id){
        return  this.repository.findByConsultasPorMedico(id);
    }
    public List<TodasConsultasDTO> findByTodasConsultasPorMedico(int id){
        return  this.repository.findByTodasConsultasPorMedico(id);
    }
    public List<ReceitaDTO> findByReceitasPorMedico(int id){
        return  this.repository.findByReceitasPorMedico(id);
    }

    public List<ExameDTO> findByExamesPorMedico(int id){
        return  this.repository.findByExamesPorMedico(id);
    }
    public List<TodosExamesDTO> findByTodasExamesPorMedico(int id){
        return  this.repository.findByTodasExamesPorMedico(id);
    }

    public Medico findById(int id){
        return  this.repository.findById(id).get();
    }

    public void atualizar(Medico medico){
        Medico p = this.repository.getReferenceById(medico.getId());
        p.setNome(medico.getNome());
        p.setSobrenome(medico.getSobrenome());
        p.setEmail(medico.getEmail());
       // p.setCpf(medico.getCpf());
        p.setTelefone(medico.getTelefone());
        p.setRegistro_medico(medico.getRegistro_medico());
        p.setEspecializacao(medico.getEspecializacao());
        p.setEndereco(medico.getEndereco());
    }

    public void excluir(int id){
        this.repository.deleteById(id);
    }
}
