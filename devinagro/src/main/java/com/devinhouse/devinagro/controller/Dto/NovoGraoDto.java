package com.devinhouse.devinagro.controller.Dto;


import com.devinhouse.devinagro.model.Empresa;
import com.devinhouse.devinagro.model.Grao;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class NovoGraoDto {

    private String nome;
    private String tempoColheita;
    private Empresa empresa;

    public Grao converter(){
        Grao grao = new Grao();
        grao.setNome(nome);
        grao.setTempoColheita(tempoColheita);
        grao.setEmpresa(empresa);
        return grao;
    }
}
