package com.devinhouse.devinagro.service;

import com.devinhouse.devinagro.model.Empresa;
import com.devinhouse.devinagro.repository.EmpresaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

    final EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository repository){
        this.empresaRepository = repository;
    }
    //Endpoint 1
    public List<Empresa> listaEmpresa(){
        return (List<Empresa>) empresaRepository.findAll();
    }

    public Empresa adicionaEmpresa(Empresa empresa) {
        return empresaRepository.save(empresa);
    }
        public Empresa atualizaEmpresa(Long id, Empresa empresa){
        Empresa empresaAtualizada = empresaRepository.findById(id).get();
        empresaAtualizada.setId(id);
        empresaAtualizada.setNome(empresa.getNome());
        empresaAtualizada.setEndereco(empresa.getEndereco());
            return empresaRepository.save(empresaAtualizada);
    }
    public void deletaEmpresa(Long id){
        empresaRepository.deleteById(id);
    }

    //Endpoint 3 - Retorna a quantidade de fazendas de uma empresa
    public Empresa findById(Long id){
        Optional<Empresa> empresa = empresaRepository.findById(id);
        return empresa.get();
    }
}
