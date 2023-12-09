package br.sci.clinicamedica.service;

import br.sci.clinicamedica.model.consulta.ConsultaDTO;
import br.sci.clinicamedica.model.consulta.SalvarConsultaDTO;
import br.sci.clinicamedica.model.receita.Receita;
import br.sci.clinicamedica.model.receita.ReceitaDTO;
import br.sci.clinicamedica.model.receita.ReceitaRepository;
import br.sci.clinicamedica.model.receita.SalvarReceitaDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceitaService {

    private ReceitaRepository repository;
    public ReceitaService(ReceitaRepository repository){
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

    public SalvarReceitaDTO salvarReceitaDTO(int id){return this.repository.salvarReceita(id);}

    public List<ReceitaDTO> listaReceitasDTO(){
        return  this.repository.findAllDTO();
    }

    public void atualizar(Receita receita){
        Receita p = this.repository.getReferenceById(receita.getId());
        p.setDataprescricao(receita.getDataprescricao());
        p.setDatavalidade(receita.getDatavalidade());
        p.setConsultas(receita.getConsultas());
    }

    public void excluir(int id){
        this.repository.deleteById(id);
    }
}
