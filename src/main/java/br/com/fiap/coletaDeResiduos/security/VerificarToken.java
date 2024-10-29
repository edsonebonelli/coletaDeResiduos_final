package br.com.fiap.coletaDeResiduos.security;

import br.com.fiap.coletaDeResiduos.repository.ClienteRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Component
public class VerificarToken extends OncePerRequestFilter {
    @Autowired
    private TokenService tokenService;
    @Autowired
    private ClienteRepository clienteRepository;
    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {

        String authorizationHeader = request.getHeader("Authorization");
        String token = "";

        if (authorizationHeader == null){
            token = null;
        } else {
            token = authorizationHeader.replace("Bearer", "").trim();
            String login = tokenService.validarToken(token);
            UserDetails cliente = ClienteRepository.findByEmail(login);

            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(
                            cliente,
                            null,
                            cliente.getAuthorities()
                    );
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }
        filterChain.doFilter(request, response);
    }
}
