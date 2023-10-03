package br.sci.clinicamedica.service;

import br.sci.clinicamedica.model.consulta.Consulta;
import br.sci.clinicamedica.model.consulta.ConsultaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService {


    private ConsultaRepository repository;
    public void ConsultaService(ConsultaRepository repository){
        this.repository = repository;
    }

    public void salvar(Consulta consulta){
        this.repository.save(consulta);
    }

    public List<Consulta> listar(){
        return  this.repository.findAll();
    }

    public Consulta findById(int id){
        return  this.repository.findById(id).get();
    }

    public void atualizar(Consulta consulta){
        Consulta p = this.repository.getReferenceById(consulta.getId());
        p.setMedico(consulta.getMedico());
        p.setPaciente(consulta.getPaciente());
        p.setData(consulta.getData());
        p.setHora(consulta.getHora());
        p.setStatus(consulta.getStatus());
    }

    public void excluir(int id){
        this.repository.deleteById(id);
    }
}
