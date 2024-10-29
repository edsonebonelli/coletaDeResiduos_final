package br.com.fiap.coletaDeResiduos.service;

import br.com.fiap.coletaDeResiduos.dto.RotaDeColetaCadastroDTO;
import br.com.fiap.coletaDeResiduos.dto.RotaDeColetaExibicaoDTO;
import br.com.fiap.coletaDeResiduos.model.RotaDeColeta;
import br.com.fiap.coletaDeResiduos.repository.RotaDeColetaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RotaDeColetaService {
    @Autowired
    private RotaDeColetaRepository rotaDeColetaRepository;

    public RotaDeColetaExibicaoDTO salvarRota(RotaDeColetaCadastroDTO rotasDTO) {
        RotaDeColeta rotas = new RotaDeColeta();
        BeanUtils.copyProperties(rotasDTO, rotas);

        RotaDeColeta rotasSalvo = rotaDeColetaRepository.save(rotas);
        return new RotaDeColetaExibicaoDTO(rotasSalvo);
    }

    public RotaDeColetaExibicaoDTO buscarRotaPorID(Long id) {
        Optional<RotaDeColeta> rotaDeColetaOptional = rotaDeColetaRepository.findById(id);

        if (rotaDeColetaOptional.isPresent()) {
            return new RotaDeColetaExibicaoDTO((rotaDeColetaOptional.get()));
        } else {
            throw new RuntimeException("Rota de Coleta não existe!");
        }
    }

    public List<RotaDeColetaExibicaoDTO> listarRotas() {
        return rotaDeColetaRepository
                .findAll()
                .stream()
                .map(RotaDeColetaExibicaoDTO::new)
                .toList();
    }
}
