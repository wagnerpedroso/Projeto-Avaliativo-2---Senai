package com.devinhouse.devinagro.service;

import com.devinhouse.devinagro.model.Empresa;
import com.devinhouse.devinagro.model.Fazendas;
import com.devinhouse.devinagro.repository.FazendasRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FazendasService {

    final FazendasRepository fazendasRepository;

    public FazendasService(FazendasRepository repository) {
        this.fazendasRepository = repository;
    }

    public List<Fazendas> listaFazendas() {
        return (List<Fazendas>) fazendasRepository.findAll();
    }

    public Fazendas adicionaFazendas(Fazendas fazendas) {
        return fazendasRepository.save(fazendas);
    }

    public Fazendas atualizaFazendas(Long id, Fazendas fazendas) {
        Fazendas fazendaAtualizada = fazendasRepository.findById(id).get();
        fazendaAtualizada.setId(id);
        fazendaAtualizada.setNome(fazendas.getNome());
        fazendaAtualizada.setEndereco(fazendas.getEndereco());
        fazendaAtualizada.setUltimaColheita(fazendaAtualizada.getUltimaColheita());
        return fazendasRepository.save(fazendaAtualizada);
    }
    public void deletaFazenda(Long id) {
        fazendasRepository.deleteById(id);
    }

    //Endpoint 2  - Retorna a lista de fazendas de uma empresa.
    public List<Fazendas> suasfazendas(Long id) {
        return fazendasRepository.findAllByempresa_id(id);
    }

    //Endpoint 3 - Retorna a quantidade de fazendas de uma empresa
    public Long countAllFazendas(Empresa empresa){
        return fazendasRepository.countByEmpresa(empresa);
    }

    public Fazendas findById(Long id){
        Optional<Fazendas> fazenda = fazendasRepository.findById(id);
        return fazenda.get();
    }

//    //Endpoint 4
//    public List<Fazendas> suasfazendasfiltradas(Long id) {
//        return fazendasRepository.findAllByempresafiltrada_id(id);
//    }

}