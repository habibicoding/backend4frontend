package br.mil.fab.compraerapitreinamento.compraerapitreinamento.repository;

import br.mil.fab.compraerapitreinamento.compraerapitreinamento.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
