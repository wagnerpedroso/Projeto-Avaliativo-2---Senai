package com.devinhouse.devinagro.controller;

import com.devinhouse.devinagro.controller.Dto.NovaEmpresaDto;
import com.devinhouse.devinagro.model.Empresa;
import com.devinhouse.devinagro.service.EmpresaService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/devagro")
public class EmpresasController {

    final EmpresaService empresaService;

    public EmpresasController(EmpresaService service){
        this.empresaService = service;
    }

    @GetMapping
    public String empresas(){
        return "Empresas está funcionando ";
    }

    //Endpoint 1  - Retorna a lista de todoas as empresas cadastradas.
    @GetMapping("/todos")
    public List<Empresa> listaempresa(){
        return empresaService.listaEmpresa();
    }

    @PostMapping
    public Empresa adicionarEmpresa(@RequestBody NovaEmpresaDto empresaDto) {
        return empresaService.adicionaEmpresa(empresaDto.converter());
    }
    @PutMapping("/{id}")
        public Empresa atualizaEmpresa(@PathVariable Long id,@RequestBody NovaEmpresaDto empresaDto){
        return empresaService.atualizaEmpresa(id, empresaDto.converter());
        }
    @DeleteMapping("/{id}")
    public void deletaaEmpresa(
            @PathVariable Long id){
        empresaService.deletaEmpresa(id);
    }
    }

