package br.sci.clinicamedica.service;

import br.sci.clinicamedica.model.medicamento.Medicamento;
import br.sci.clinicamedica.model.medicamento.MedicamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicamentoService {

    private MedicamentoRepository repository;
    public MedicamentoService(MedicamentoRepository repository){
        this.repository = repository;
    }

    public void salvar(Medicamento medicamento){
        this.repository.save(medicamento);
    }

    public List<Medicamento> listar(){
        return  this.repository.findAll();
    }

    public Medicamento findById(int id){
        return  this.repository.findById(id).get();
    }

    public void atualizar(Medicamento medicamento){
        Medicamento p = this.repository.getReferenceById(medicamento.getId());
        p.setReceita(medicamento.getReceita());
        p.setMedicamento(medicamento.getMedicamento());
        p.setDosagem(medicamento.getDosagem());
        p.setInstrucoes(medicamento.getInstrucoes());
    }

    public void excluir(int id){
        this.repository.deleteById(id);
    }
}
