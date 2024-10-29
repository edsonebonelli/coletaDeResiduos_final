package br.com.fiap.coletaDeResiduos.service;

import br.com.fiap.coletaDeResiduos.dto.ClienteCadastroDTO;
import br.com.fiap.coletaDeResiduos.dto.ClienteExibicaoDTO;
import br.com.fiap.coletaDeResiduos.model.Cliente;
import br.com.fiap.coletaDeResiduos.repository.ClienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    public ClienteExibicaoDTO salvarCliente(ClienteCadastroDTO clienteCadastroDTO){

        String senhaCriptografada = new
                BCryptPasswordEncoder().encode(clienteCadastroDTO.senha());


        Cliente cliente = new Cliente();
        BeanUtils.copyProperties(clienteCadastroDTO, cliente);
        cliente.setSenha(senhaCriptografada);

        Cliente clienteSalvo = clienteRepository.save(cliente);

        return new ClienteExibicaoDTO(clienteSalvo);
    }
    public ClienteExibicaoDTO buscarClientePorId(Long id){
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if (clienteOptional.isPresent()){
            return new ClienteExibicaoDTO(clienteOptional.get());
        } else {
            throw new RuntimeException("Cliente não encontrado!");
        }
    }
    public List<ClienteExibicaoDTO> listarTodosClientes(){
        return clienteRepository
                .findAll()
                .stream()
                .map(ClienteExibicaoDTO::new)
                .toList();
    }
    public Cliente atualizarCliente(Cliente cliente){
        Optional<Cliente> clienteOptional = clienteRepository.findById(cliente.getClienteID());

        if (clienteOptional.isPresent()){
            return clienteRepository.save(cliente);
        } else {
            throw  new RuntimeException("Cliente não encontrado!");
        }
    }
    public void excluirCliente(Long id){
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if (clienteOptional.isPresent()){
            clienteRepository.delete(clienteOptional.get());
        } else {
            throw new RuntimeException("Cliente não encontrado!");
        }
    }
}
