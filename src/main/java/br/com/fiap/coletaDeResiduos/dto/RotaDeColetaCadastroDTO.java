package br.com.fiap.coletaDeResiduos.dto;

import jakarta.validation.constraints.NotBlank;

import javax.xml.crypto.Data;
public record RotaDeColetaCadastroDTO(
        Long rotaID,
        @NotBlank(message = "O nome do usuário é obrigatório!")
        String nomeDaRota,
        @NotBlank(message = "A data da coleta é obrigatória!")
        Data dataDaColeta,
        Data horaDeInicio,
        Data horaDeTermino,
        String distanciaRota,
        @NotBlank(message = "O tipo de rota de coleta é obrigatório!")
        String tipoDeRota,
        @NotBlank(message = "A frequencia da rota de coleta é obrigatória!")
        String frequenciaDaRota
) {
}
