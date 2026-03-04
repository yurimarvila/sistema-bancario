package br.com.banco.sistema_bancario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.sistema_bancario.dto.ClienteDTO;
import br.com.banco.sistema_bancario.model.Cliente;
import br.com.banco.sistema_bancario.service.ClienteService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/clientes")

public class ClienteController {

    @Autowired
    private ClienteService service; // isso faz com que o ClienteService seja vinculado ao ClienteController

    // GET /clientes — listar todos
    @GetMapping
    public ResponseEntity<List<Cliente>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    // GET /clientes/{id} — buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {
        Cliente cliente = service.buscarPorId(id); {
            if (cliente == null)
                return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cliente);
    }

    // POST /clientes — cadastrar
    @PostMapping
    public ResponseEntity<Cliente> cadastrar(@RequestBody @Valid ClienteDTO dto) { // esses @RequestBody e @Valid fazem com que o corpo da requisição seja lido e validado
        Cliente cliente = service.cadastrar(dto); { //isso cria um novo cliente com base no dto feito na classe ClienteService
            return ResponseEntity.status(201).body(cliente); // esse 201 significa que o recurso foi criado e o .body(cliente) significa que o corpo da resposta vai conter o cliente
        }
    }
}
