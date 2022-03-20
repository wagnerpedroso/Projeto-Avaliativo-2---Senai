package com.devinhouse.devinagro.controller.Dto;

import com.devinhouse.devinagro.model.Empresa;
import com.devinhouse.devinagro.model.Fazendas;
import com.devinhouse.devinagro.model.Funcionarios;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class NovoFuncionarioDto {

    private String nome;
    private String sobrenome;
    private String cpf;
    private String endereco;
    private String telefone;
    private String sexo;
    private String dataNascimento;
    private String dataContratacao;
    private Empresa empresa;

    public Funcionarios converter() {
        Funcionarios funcionarios = new Funcionarios();
        funcionarios.setNome(nome);
        funcionarios.setSobrenome(sobrenome);
        funcionarios.setCpf(cpf);
        funcionarios.setEndereco(endereco);
        funcionarios.setTelefone(telefone);
        funcionarios.setSexo(sexo);
        funcionarios.setDataNascimento(dataNascimento);
        funcionarios.setDataContratacao(dataContratacao);
        funcionarios.setEmpresa(empresa);
        return funcionarios;
}
}