package br.com.banco.sistema_bancario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.banco.sistema_bancario.dto.ClienteDTO;
import br.com.banco.sistema_bancario.model.Cliente;
import br.com.banco.sistema_bancario.repository.ClienteRepository;

// Agora vamos para o ClienteService. Antes de codar, contexto completo:
// O que o ClienteService vai fazer:

// cadastrar(ClienteDTO dto) — cria um cliente novo
// buscarPorId(Long id) — retorna um cliente pelo id
// listarTodos() — retorna todos os clientes

@Service // isso faz com que o service seja injetado automaticamente na classe ClienteController
public class ClienteService {

    @Autowired // isso faz com que o repository seja injetado automaticamente na classe ClienteService
    private ClienteRepository clienteRepository; // Injeta o ClienteRepository e chama o repository

    public Cliente cadastrar(ClienteDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());
        cliente.setCpf(dto.getCpf());
        cliente.setEmail(dto.getEmail());
        cliente.setSenha(dto.getSenha());
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listarTodos() { // List<Cliente> retorna uma lista de clientes
        return clienteRepository.findAll(); // repository.findAll() retorna uma lista de clientes
    }

    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id).orElse(null); //
    }
}
