package br.com.fiap.coletaDeResiduos.controller;

import br.com.fiap.coletaDeResiduos.dto.ClienteCadastroDTO;
import br.com.fiap.coletaDeResiduos.dto.ClienteExibicaoDTO;
import br.com.fiap.coletaDeResiduos.model.Cliente;
import br.com.fiap.coletaDeResiduos.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class clienteController {
    @Autowired
    private ClienteService clienteService;
    @PostMapping("/clientes")
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteExibicaoDTO salvarCliente(
            @RequestBody
            ClienteCadastroDTO cliente){
        return clienteService.salvarCliente(cliente);
    }
    @GetMapping("/clientes")
    @ResponseStatus(HttpStatus.OK)
    public List<ClienteExibicaoDTO> listarTodosClientes(){
        return clienteService.listarTodosClientes();
    }
    @GetMapping("/clientes/{clienteID}")
    public ResponseEntity<ClienteExibicaoDTO> buscarClientePorID(@PathVariable Long clienteID){
        try {
            return ResponseEntity.ok(clienteService.buscarClientePorId(clienteID));
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/clientes")
    @ResponseStatus(HttpStatus.OK)
    public Cliente atualizarCliente(
            @RequestBody
            Cliente cliente){
        return clienteService.atualizarCliente(cliente);
    }
    @DeleteMapping("/clientes/{clientesID}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirCliente(
            @PathVariable
            Long clienteID){
        clienteService.excluirCliente(clienteID);
    }
}
