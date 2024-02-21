package br.mil.fab.compraerapitreinamento.compraerapitreinamento.repository;

import br.mil.fab.compraerapitreinamento.compraerapitreinamento.entity.Cidade;
import br.mil.fab.compraerapitreinamento.compraerapitreinamento.entity.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<Estado, Long> {

}
