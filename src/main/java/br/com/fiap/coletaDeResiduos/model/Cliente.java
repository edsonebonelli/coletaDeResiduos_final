package br.com.fiap.coletaDeResiduos.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "TB_CLIENTE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Cliente implements UserDetails {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_CLIENTES"
    )
    @SequenceGenerator(
            name = "SEQ_CLIENTES",
            sequenceName = "SEQ_CLIENTES",
            allocationSize = 50
    )
    @Column(name = "CLIENTE_ID")
    private Long clienteID;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "CPF")
    private String cpf;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "SENHA")
    private String senha;
    @Column(name = "TELEFONE")
    private String telefone;
    @Column(name = "DATA_DE_CADASTRO")
    private Date dataCadastro;
    @Column(name = "STATUS_CLIENTE")
    private String statusCliente;
    @Column(name = "TIPO_CLIENTE")
    private String tipoCliente;
    @Enumerated(EnumType.STRING)
    private ClienteRole role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == ClienteRole.ADMIN){
            return List.of(
                    new SimpleGrantedAuthority("ROLE_ADMIN"),
                    new SimpleGrantedAuthority("ROLE_USER")
            );
        } else{
            return List.of(new SimpleGrantedAuthority("ROLE_USER"));
        }
    }
    @Override
    public String getPassword() {
        return this.senha;
    }
    @Override
    public String getUsername() {
        return this.email;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }
}
