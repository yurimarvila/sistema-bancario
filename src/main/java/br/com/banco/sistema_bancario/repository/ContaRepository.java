package br.com.banco.sistema_bancario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.banco.sistema_bancario.model.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long> {

}
