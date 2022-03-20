package com.devinhouse.devinagro.repository;

import com.devinhouse.devinagro.model.Empresa;
import com.devinhouse.devinagro.model.Funcionarios;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FuncionariosRepository extends JpaRepository<Funcionarios, Long> {

    //Endpoint 10
    Long countByEmpresa(Empresa empresa);

    //Endpoint 9
    List<Funcionarios> findByEmpresa(Empresa empresa);
}
