package br.mil.fab.compraerapitreinamento.compraerapitreinamento.repository;

import br.mil.fab.compraerapitreinamento.compraerapitreinamento.entity.Cidade;
import br.mil.fab.compraerapitreinamento.compraerapitreinamento.entity.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

}
