package br.com.fiap.coletaDeResiduos.dto;

import br.com.fiap.coletaDeResiduos.model.Cliente;

import java.util.Date;

public record ClienteExibicaoDTO(
        Long clienteID,
        String nome,
        String cpf,
        String email,
        String senha,
        String telefone,
        Date dataCadastro,
        String statusCliente,
        String tipoCliente
) {
    public ClienteExibicaoDTO(Cliente cliente){
        this(
                cliente.getClienteID(),
                cliente.getNome(),
                cliente.getCpf(),
                cliente.getEmail(),
                cliente.getSenha(),
                cliente.getTelefone(),
                cliente.getDataCadastro(),
                cliente.getStatusCliente(),
                cliente.getTipoCliente()
        );
    }
}
