package com.devinhouse.devinagro.controller;

import com.devinhouse.devinagro.controller.Dto.NovoGraoDto;
import com.devinhouse.devinagro.model.Grao;
import com.devinhouse.devinagro.service.GraoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grao")
public class GraoController {

        final GraoService graoService;

        public GraoController(GraoService service){
            this.graoService = service;
        }

        @GetMapping
        public String grao(){
            return "grão está funcionando";
        }

        @GetMapping("/todos")
        public List<Grao> listaGrao() {
            return graoService.listaGrao();
        }

        @PostMapping
        public Grao adicionaGrao(@RequestBody NovoGraoDto graoDto){
            return graoService.adicionaGrao(graoDto.converter());
        }
        @PutMapping("/{id}")
        public void deletargrao(@PathVariable Long id) {
            graoService.deletaGrao(id);
        }
        @DeleteMapping("/{id}")
        public void deletaaGrao(@PathVariable Long id){
        graoService.deletaGrao(id);
    }
       //Endpoint 7
        @GetMapping("/graosdaempresa/{id}")
        public List<Grao> graosdaempresa(@PathVariable Long id){
            return graoService.seusgraos(id);
    }
}
