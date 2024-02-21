package br.mil.fab.compraerapitreinamento.compraerapitreinamento.service;

import br.mil.fab.compraerapitreinamento.compraerapitreinamento.entity.Pessoa;
import br.mil.fab.compraerapitreinamento.compraerapitreinamento.entity.Tipo;
import br.mil.fab.compraerapitreinamento.compraerapitreinamento.repository.TipoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;


@Service
public class TipoService {

    private final TipoRepository repository;

    public TipoService(TipoRepository repository) {
        this.repository = repository;
    }

    public Tipo buscaTipo(Long id) {
        return repository.findById(id).orElse(null);
    }

}
