package br.com.fiap.coletaDeResiduos.security;

import br.com.fiap.coletaDeResiduos.model.Cliente;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    @Value("minha.chave.secreta")
    private String secretKey;

    public String gerarToken(Cliente cliente){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretKey);

            String token = JWT.create()
                    .withIssuer("clientes")
                    .withSubject(cliente.getEmail())
                    .withExpiresAt(gerarDataDeExpiracao())
                    .sign(algorithm);

            return token;
        } catch (JWTCreationException e){
            throw new RuntimeException("Não foi possível gerar o token");
        }
    }
    public String validarToken(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256(secretKey);

            return JWT.require(algorithm)
                    .withIssuer("clientes")
                    .build()
                    .verify(token)
                    .getSubject();

        } catch (JWTVerificationException e){
            return "";
        }
    }

    private Instant gerarDataDeExpiracao(){
        return LocalDateTime
                .now()
                .plusHours(2)
                .toInstant(ZoneOffset.of("-03:00"));
    }
}

