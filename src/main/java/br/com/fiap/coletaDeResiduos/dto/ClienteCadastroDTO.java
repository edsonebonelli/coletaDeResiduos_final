package br.com.fiap.coletaDeResiduos.dto;

import java.util.Date;

public record ClienteCadastroDTO(
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
}
