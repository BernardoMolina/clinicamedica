package br.sci.clinicamedica.service;

import br.sci.clinicamedica.model.medico.Medico;
import br.sci.clinicamedica.model.medico.MedicoDTO;
import br.sci.clinicamedica.model.medico.MedicoRepository;
import br.sci.clinicamedica.model.paciente.PacienteDTO;
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
