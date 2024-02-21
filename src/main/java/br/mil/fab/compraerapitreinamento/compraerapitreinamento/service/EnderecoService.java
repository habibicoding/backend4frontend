package br.mil.fab.compraerapitreinamento.compraerapitreinamento.service;

import br.mil.fab.compraerapitreinamento.compraerapitreinamento.entity.Endereco;
import br.mil.fab.compraerapitreinamento.compraerapitreinamento.entity.Tipo;
import br.mil.fab.compraerapitreinamento.compraerapitreinamento.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class EnderecoService {

    private final EnderecoRepository repository;

    private final TipoService tipoService;

    public EnderecoService(EnderecoRepository repository, TipoService tipoService) {
        this.repository = repository;
        this.tipoService = tipoService;
    }

    public Endereco buscaEndereco(Long id) {
        return repository.findById(id).orElse(null);
    }

}
