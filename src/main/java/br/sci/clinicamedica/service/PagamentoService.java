package br.sci.clinicamedica.service;

import br.sci.clinicamedica.model.pagamento.Pagamento;
import br.sci.clinicamedica.model.pagamento.PagamentoRepository;
import br.sci.clinicamedica.model.pagamento.SalvarPagamentoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagamentoService {


    private PagamentoRepository repository;
    public PagamentoService(PagamentoRepository repository){
        this.repository = repository;
    }

    public void salvar(Pagamento pagamento){
        this.repository.save(pagamento);
    }

    public List<Pagamento> listar(){
        return  this.repository.findAll();
    }



    public SalvarPagamentoDTO salvarPagamentoDTO(int id){return this.repository.salvarPagamento(id);}

    public Pagamento findById(int id){
        return  this.repository.findById(id).get();
    }

    public void atualizar(Pagamento pagamento){
        Pagamento p = this.repository.getReferenceById(pagamento.getId());
        p.setConsultas(pagamento.getConsultas());
        p.setExames(pagamento.getExames());
      //  p.setForma_de_pagamento(pagamento.getForma_de_pagamento());
        p.setValor(pagamento.getValor());

    }

    public void excluir(int id){
        this.repository.deleteById(id);
    }
}
