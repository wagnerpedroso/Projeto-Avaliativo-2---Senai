package com.devinhouse.devinagro.controller.Dto;

import com.devinhouse.devinagro.model.Empresa;
import com.devinhouse.devinagro.model.Fazendas;
import com.devinhouse.devinagro.model.Grao;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class NovaFazendaDto {

    private String nome;
    private String endereco;
    private Double capacidadeEstoque;
    private Empresa empresa;
    private String ultimaColheita;
    private Grao grao;

    public Fazendas converter() {
        Fazendas fazendas = new Fazendas();
        fazendas.setNome(nome);
        fazendas.setEndereco(endereco);
        fazendas.setCapacidadeEstoque(capacidadeEstoque);
        fazendas.setEmpresa(empresa);
        fazendas.setUltimaColheita(ultimaColheita);
        fazendas.setGrao(grao);

        return fazendas;


    }

}







