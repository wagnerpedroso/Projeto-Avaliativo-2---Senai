package com.devinhouse.devinagro.controller;

import com.devinhouse.devinagro.controller.Dto.NovaFazendaDto;
import com.devinhouse.devinagro.model.Empresa;
import com.devinhouse.devinagro.model.Fazendas;
import com.devinhouse.devinagro.model.Grao;
import com.devinhouse.devinagro.service.EmpresaService;
import com.devinhouse.devinagro.service.FazendasService;
import com.devinhouse.devinagro.service.FuncionariosService;
import com.devinhouse.devinagro.service.GraoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/fazendas")
public class FazendasController {

    //final GraoService graoService;
    final FazendasService fazendasService;
        final EmpresaService empresaService;

    //Endpoint 3
    public FazendasController(FazendasService fazendasService, EmpresaService empresaService) {
        this.fazendasService = fazendasService;
        this.empresaService = empresaService;
    }
    @GetMapping
    public String fazendas() {
        return "Fazendas está funcionando ";
    }

    @GetMapping("/todos")
    public List<Fazendas> listafazenda() {
        return fazendasService.listaFazendas();
    }

    @PostMapping
    public Fazendas adicionarFazenda(@RequestBody NovaFazendaDto fazendaDto) {
        return fazendasService.adicionaFazendas(fazendaDto.converter());
    }

    @PutMapping("/{id}")
    public Fazendas atualizafazendas(
            @PathVariable Long id,
            @RequestBody NovaFazendaDto fazendaDto) {
        return fazendasService.atualizaFazendas(id, fazendaDto.converter());
    }
    @DeleteMapping("/{id}")
    public void deletafazenda(
            @PathVariable Long id) {
        fazendasService.deletaFazenda(id);
    }
    //Endpoint 2  - Retorna a lista de fazendas de uma empresa.
    @GetMapping("/suasfazendas/{id}")
   public List<Fazendas> suasfazendas(@PathVariable Long id) {
        return fazendasService.suasfazendas(id);
    }

    //Endpoint 3 - Retorna a quantidade de fazendas de uma empresa
    @GetMapping("/contaempresa/{id}")
    public ResponseEntity<Long> countAllFazendas(@PathVariable Long id){
        Empresa empresa = empresaService.findById(id);
    return ResponseEntity.status(HttpStatus.OK).body(fazendasService.countAllFazendas(empresa));
}
    //  Endpoint 5 Registra colheira em fazenda, somando á Capacidade do Estoque
    @PutMapping("/novoestoque/{id}/{kg}")
    public ResponseEntity<Fazendas> novoestoque(@PathVariable @Valid Long id, @PathVariable Double kg){

        Fazendas fazenda = fazendasService.findById(id);
        Double estoqueAtual = fazenda.getCapacidadeEstoque();
        fazenda.setCapacidadeEstoque(estoqueAtual+kg);
        Fazendas atualizaEmpresa = fazendasService.atualizaFazendas(id, fazenda);
        return ResponseEntity.ok().body(atualizaEmpresa);
    }
   // Ex 6 Registra colheira em fazenda, subtrai á Capacidade do Estoque
    @PutMapping("/diminuiestoque/{id}/{kg}")
    public ResponseEntity<Fazendas> registravenda(@PathVariable @Valid Long id, @PathVariable Double kg){
        Fazendas fazendas = fazendasService.findById(id);
        Double estoqueAtual = fazendas.getCapacidadeEstoque();
        fazendas.setCapacidadeEstoque(estoqueAtual-kg);
        Fazendas atualizaEmpresa = fazendasService.atualizaFazendas(id, fazendas);
        return ResponseEntity.ok().body(atualizaEmpresa);
    }
// //Ex 8 Retorna a lista de grao associados a uma empresa, onde cada elemento da lista deve conter, nome G, Capacidade estoque ordem > por capacidade estoque.
//    @GetMapping("/todasempresord")
//    public List<Grao> listgrao(){
//        GraoController graoService;
//        return graoService.listaGrao();
//    }

//    //Endpoint 4  - Retorna a lista de fazendas de uma empresa, onde deve ter 3 atributos id fazendas, nome fazenda, data proxima colheira
//    @GetMapping("/suasfazendasfiltrada/{id}")
//    public List<Fazendas> suasfazendasfiltradas(@PathVariable Long id) {
//        return fazendasService.suasfazendasfiltradas(id);
//    }

}
