package com.devinhouse.devinagro.service;

import com.devinhouse.devinagro.model.Grao;
import com.devinhouse.devinagro.repository.GraoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GraoService {

    final GraoRepository graorepository;

    public GraoService(GraoRepository repository){

        this.graorepository = repository;
    }
    public List<Grao> listaGrao(){

        return (List<Grao>) graorepository.findAll();
    }
    public Grao adicionaGrao(Grao grao) {

        return graorepository.save(grao);
    }
    public Grao atualizaGrao(Long id, Grao grao){
        Grao graoAtualizada = graorepository.findById(id).get();
        graoAtualizada.setId(id);
        graoAtualizada.setNome(grao.getNome());
        graoAtualizada.setTempoColheita(grao.getTempoColheita());
        graoAtualizada.setEmpresa(grao.getEmpresa());
        return graorepository.save(graoAtualizada);
    }
    public void deletaGrao(Long id){
        graorepository.deleteById(id);
    }

    //Endpoint 7

    public  List<Grao> seusgraos(Long id) {
        return graorepository.findAllById(id);
    }
    }

