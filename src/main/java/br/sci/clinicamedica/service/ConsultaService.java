package br.sci.clinicamedica.service;

import br.sci.clinicamedica.model.consulta.Consulta;
import br.sci.clinicamedica.model.consulta.ConsultaDTO;
import br.sci.clinicamedica.model.consulta.ConsultaRepository;
import br.sci.clinicamedica.model.paciente.PacienteDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService {


    private ConsultaRepository repository;
    public ConsultaService(ConsultaRepository repository){
        this.repository = repository;
    }

    public void salvar(Consulta consulta){
        this.repository.save(consulta);
    }

    public List<Consulta> listar(){
        return  this.repository.findAll();
    }

    public List<ConsultaDTO> listaConsultasDTO(){
        return  this.repository.findAllDTO();
    }



    public Consulta findById(int id){
        return  this.repository.findById(id).get();
    }

    public void atualizar(Consulta consulta){
        Consulta p = this.repository.getReferenceById(consulta.getId());
        p.setIdmedico(consulta.getIdmedico());
        p.setIdpaciente(consulta.getIdpaciente());
        p.setDataconsulta(consulta.getDataconsulta());
        p.setHoraconsulta(consulta.getHoraconsulta());
        p.setStatus(consulta.getStatus());
    }

    public void excluir(int id){
        this.repository.deleteById(id);
    }
}
