package br.mil.fab.compraerapitreinamento.compraerapitreinamento.repository;

import br.mil.fab.compraerapitreinamento.compraerapitreinamento.entity.Endereco;
import br.mil.fab.compraerapitreinamento.compraerapitreinamento.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
