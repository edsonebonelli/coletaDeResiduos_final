package br.com.fiap.coletaDeResiduos.controller;

import br.com.fiap.coletaDeResiduos.dto.ClienteCadastroDTO;
import br.com.fiap.coletaDeResiduos.dto.ClienteExibicaoDTO;
import br.com.fiap.coletaDeResiduos.dto.LoginDTO;
import br.com.fiap.coletaDeResiduos.model.Cliente;
import br.com.fiap.coletaDeResiduos.security.TokenService;
import br.com.fiap.coletaDeResiduos.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private TokenService tokenService;
    @PostMapping("/login")
    public ResponseEntity login(
            @RequestBody
            @Valid
            LoginDTO clienteDTO
    ){
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(
                        clienteDTO.email(),
                        clienteDTO.senha());

        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        String token = tokenService.gerarToken((Cliente) authentication.getPrincipal());

        return ResponseEntity.ok(token);
    }
    public ClienteExibicaoDTO registrar(
            @RequestBody
            @Valid
            ClienteCadastroDTO clienteCadastroDTO){

        ClienteExibicaoDTO clienteSalvo = null;
        clienteSalvo = clienteService.salvarCliente(clienteCadastroDTO);

        return clienteSalvo;
    }
}
