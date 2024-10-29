package br.com.fiap.coletaDeResiduos.controller;

import br.com.fiap.coletaDeResiduos.dto.RotaDeColetaCadastroDTO;
import br.com.fiap.coletaDeResiduos.dto.RotaDeColetaExibicaoDTO;
import br.com.fiap.coletaDeResiduos.service.RotaDeColetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class RotaDeColetaController {
    @Autowired
    private RotaDeColetaService rotaDeColetaService;
    @PostMapping("/rotas")
    @ResponseStatus(HttpStatus.CREATED)
    public RotaDeColetaExibicaoDTO salvarRota(@RequestBody RotaDeColetaCadastroDTO rotas){
        return rotaDeColetaService.salvarRota(rotas);
    }
    @GetMapping("/rotas/{rotasID}")
    public ResponseEntity<RotaDeColetaExibicaoDTO> buscarRotaPorID(@PathVariable Long rotasID){
        try {
            return ResponseEntity.ok(rotaDeColetaService.buscarRotaPorID(rotasID));
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/rotas")
    @ResponseStatus(HttpStatus.OK)
    public List<RotaDeColetaExibicaoDTO> listarRotas(){
        return rotaDeColetaService.listarRotas();
    }
}
