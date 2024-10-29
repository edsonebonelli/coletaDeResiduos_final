package br.com.fiap.coletaDeResiduos.repository;

import br.com.fiap.coletaDeResiduos.model.RotaDeColeta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RotaDeColetaRepository extends JpaRepository<RotaDeColeta, Long> {
}
