package br.com.fiap.coletaDeResiduos.repository;

import br.com.fiap.coletaDeResiduos.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    static UserDetails findByEmail(String email) {
        return null;
    }
}
