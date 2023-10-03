package br.sci.clinicamedica.service;

import br.sci.clinicamedica.model.receita.Receita;
import br.sci.clinicamedica.model.receita.ReceitaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceitaService {

    private ReceitaRepository repository;
    public void ReceitaService(ReceitaRepository repository){
        this.repository = repository;
    }

    public void salvar(Receita receita){
        this.repository.save(receita);
    }

    public List<Receita> listar(){
        return  this.repository.findAll();
    }

    public Receita findById(int id){
        return  this.repository.findById(id).get();
    }

    public void atualizar(Receita receita){
        Receita p = this.repository.getReferenceById(receita.getId());
        p.setData_prescricao(receita.getData_prescricao());
        p.setData_validade(receita.getData_validade());
        p.setConsulta(receita.getConsulta());
    }

    public void excluir(int id){
        this.repository.deleteById(id);
    }
}
