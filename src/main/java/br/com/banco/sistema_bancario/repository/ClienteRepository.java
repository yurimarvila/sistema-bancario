package br.com.banco.sistema_bancario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.banco.sistema_bancario.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
