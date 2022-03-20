package com.devinhouse.devinagro.controller.Dto;


import com.devinhouse.devinagro.model.Empresa;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
    public class NovaEmpresaDto {
    private String nome;
    private String cnpj;
    private String endereco;

    public Empresa converter(){
        Empresa empresa = new Empresa();
        empresa.setNome(nome);
        empresa.setCnpj(cnpj);
        empresa.setEndereco(endereco);
        return empresa;
    }
}
