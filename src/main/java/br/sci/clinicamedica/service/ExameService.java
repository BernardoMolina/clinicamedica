package br.sci.clinicamedica.service;

import br.sci.clinicamedica.model.consulta.ConsultaDTO;
import br.sci.clinicamedica.model.consulta.TodasConsultasDTO;
import br.sci.clinicamedica.model.exame.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExameService {


    private ExameRepository repository;
    public ExameService(ExameRepository repository){
        this.repository = repository;
    }

    public void salvar(Exame exame){
        this.repository.save(exame);
    }

    public List<Exame> listar(){
        return  this.repository.findAll();
    }

    public List<ExameDTO> listaExamesDTO(){
        return  this.repository.findAllDTO();
    }

    public SalvarExameDTO salvarExameDTO(int id){return this.repository.salvarExame(id);}



    public Exame findById(int id){
        return  this.repository.findById(id).get();
    }

    public void atualizar(Exame exame){
        Exame p = this.repository.getReferenceById(exame.getId());
        p.setMedico(exame.getMedico());
        p.setPaciente(exame.getPaciente());
        p.setDataexame(exame.getDataexame());
        p.setHoraexame(exame.getHoraexame());
        p.setStatus(exame.getStatus());
        p.setResultado(exame.getResultado());
    }

    public void excluir(int id){
        this.repository.deleteById(id);
    }
}
