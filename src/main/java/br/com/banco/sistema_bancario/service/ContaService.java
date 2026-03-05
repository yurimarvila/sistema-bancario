package br.com.banco.sistema_bancario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.banco.sistema_bancario.dto.ContaDTO;
import br.com.banco.sistema_bancario.model.Cliente;
import br.com.banco.sistema_bancario.model.Conta;
import br.com.banco.sistema_bancario.repository.ClienteRepository;
import br.com.banco.sistema_bancario.repository.ContaRepository;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;
    @Autowired
    private ClienteRepository clienteRepository;

    public Conta criar(ContaDTO dto) {
        Cliente cliente = clienteRepository.findById(dto.getClienteId()).orElse(null);
        if (cliente == null) {
            throw new RuntimeException("Cliente não encontrado"); // Lançando uma exceção
        }

        Conta conta = new Conta();
        conta.setCliente(cliente);
        conta.setSaldo(0);

        conta.setNumeroConta(String.valueOf(System.currentTimeMillis()));
        return contaRepository.save(conta);

    }

}