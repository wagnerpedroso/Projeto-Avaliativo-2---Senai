package com.devinhouse.devinagro.service;

import com.devinhouse.devinagro.model.Empresa;
import com.devinhouse.devinagro.model.Funcionarios;
import com.devinhouse.devinagro.repository.FuncionariosRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FuncionariosService {

    final FuncionariosRepository funcionariosRepository;

    public FuncionariosService(FuncionariosRepository repository) {
        this.funcionariosRepository = repository;
    }

    public List<Funcionarios> listaFuncionario() {
        return (List<Funcionarios>) funcionariosRepository.findAll();
    }

    public Funcionarios adicionaFuncionario(Funcionarios funcionarios) {
        return funcionariosRepository.save(funcionarios);
    }

    public Funcionarios atualizaFuncionarios(Long id, Funcionarios funcionarios) {
        Funcionarios FuncionariosAtualizada = funcionariosRepository.findById(id).get();
        FuncionariosAtualizada.setId(id);
        FuncionariosAtualizada.setNome(funcionarios.getNome());
        FuncionariosAtualizada.setSobrenome(funcionarios.getSobrenome());
        FuncionariosAtualizada.setCpf(funcionarios.getCpf());
        FuncionariosAtualizada.setEndereco(funcionarios.getEndereco());
        FuncionariosAtualizada.setTelefone(funcionarios.getTelefone());
        FuncionariosAtualizada.setSexo(funcionarios.getSexo());
        FuncionariosAtualizada.setDataNascimento(funcionarios.getDataNascimento());
        FuncionariosAtualizada.setDataContratacao(funcionarios.getDataContratacao());
        FuncionariosAtualizada.setEmpresa(funcionarios.getEmpresa());
        return funcionariosRepository.save(FuncionariosAtualizada);
    }

    public void deletaFuncionario(Long id) {
        funcionariosRepository.deleteById(id);
    }

    //Endpoint 10
    public Long countFuncionariosEmpresa(Empresa empresa) {
        return funcionariosRepository.countByEmpresa(empresa);
    }

    //Endpoint 9
    public List<Funcionarios> funcionariosEmpresa(Empresa empresa) {
        return funcionariosRepository.findByEmpresa(empresa);
    }
}




















//    //Endpoint 9
//    public List<Funcionarios> seussfuncioanrios(Empresa empresa) {
//      return funcionariosRepository.findByEmpresa(empresa);
//    }
//

//
////    //Endpoint ult
//    public Long countFuncionarios(Empresa empresa) {
//        return funcionariosRepository.countByFuncionarios(empresa);
////
////






//
//        //Endpoint ult
//        public Empresa findById(Long id){
//            Optional<Empresa> empresa = repository.findById(id);
//            return empresa.get();
//        }






































