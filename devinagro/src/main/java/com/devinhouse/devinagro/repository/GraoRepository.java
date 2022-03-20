package com.devinhouse.devinagro.repository;

import com.devinhouse.devinagro.model.Grao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface GraoRepository extends JpaRepository<Grao, Long> {
   // Object findAll();

  //endpint 7
    List<Grao> findAllById(Long id);

}

