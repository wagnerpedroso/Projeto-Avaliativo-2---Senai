package com.devinhouse.devinagro.controller;

import com.devinhouse.devinagro.controller.Dto.NovoFuncionarioDto;
import com.devinhouse.devinagro.model.Empresa;
import com.devinhouse.devinagro.model.Funcionarios;
import com.devinhouse.devinagro.service.EmpresaService;
import com.devinhouse.devinagro.service.FuncionariosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/funcionarios")
public class FuncionariosController {

    final FuncionariosService funcionariosService;
    final EmpresaService empresaService;

    public FuncionariosController(FuncionariosService funcionariosService, EmpresaService empresaService) {
        this.funcionariosService = funcionariosService;
        this.empresaService = empresaService;
}

    @GetMapping
    public String funcionarios() {
        return "Funcionarios está funcionando ";
    }


    @GetMapping("/todos")
    public List<Funcionarios> listafuncionarios() {
        return funcionariosService.listaFuncionario();
    }

    @PostMapping
    public Funcionarios adicionarFuncionarios(@RequestBody NovoFuncionarioDto funcionarioDto) {
        return funcionariosService.adicionaFuncionario(funcionarioDto.converter());
    }

    @PutMapping("/{id}")
    public Funcionarios atualizafuncionarios(
            @PathVariable Long id,
            @RequestBody NovoFuncionarioDto funcionarioDto) {
        return funcionariosService.atualizaFuncionarios(id, funcionarioDto.converter());
    }

    @DeleteMapping("/{id}")
    public void deletafuncionario(
            @PathVariable Long id) {
        funcionariosService.deletaFuncionario(id);
    }

    //Endpoint 10
    @GetMapping(value = "/quantidadeFuncionarios/{id}")
    public ResponseEntity<Long> countFuncionariosEmpresa(@PathVariable Long id) {
        Empresa empresa = empresaService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(funcionariosService.countFuncionariosEmpresa(empresa));
    }

    //Endpoint 9
    @GetMapping(value = "/funcionariosdaempresa/{id}")
    public ResponseEntity<List<Funcionarios>> findByEmpresa(@PathVariable Long id) {
        Empresa empresa = empresaService.findById(id);
        return ResponseEntity.ok().body(funcionariosService.funcionariosEmpresa(empresa));
    }
}
