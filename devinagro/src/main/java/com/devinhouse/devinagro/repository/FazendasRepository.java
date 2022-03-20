package com.devinhouse.devinagro.repository;

import com.devinhouse.devinagro.model.Empresa;
import com.devinhouse.devinagro.model.Fazendas;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FazendasRepository extends JpaRepository<Fazendas, Long> {

    //Endpoint 2  - Retorna a lista de fazendas de uma empresa.
    List<Fazendas> findAllByempresa_id(Long id);

    //Endpoint 3 - Retorna a quantidade de fazendas de uma empresa
     Long countByEmpresa(Empresa empresa);



//    //Endpoint 4  - Retorna a lista de fazendas de uma empresa, onde deve ter 3 atributos id fazendas, nome fazenda, data proxima colheira
//    List<Fazendas> findAllByempresafiltrada_id(Long id);

    //criar a query end 8
}
