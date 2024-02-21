package br.mil.fab.compraerapitreinamento.compraerapitreinamento.service;

import br.mil.fab.compraerapitreinamento.compraerapitreinamento.entity.Endereco;
import br.mil.fab.compraerapitreinamento.compraerapitreinamento.entity.Pessoa;
import br.mil.fab.compraerapitreinamento.compraerapitreinamento.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PessoaService {

    private final PessoaRepository repository;

    private final EnderecoService enderecoService;

    public PessoaService(PessoaRepository repository, EnderecoService enderecoService) {
        this.repository = repository;
        this.enderecoService = enderecoService;
    }

    public Pessoa buscaPessoa(Long id) {
        return repository.findById(id).orElse(null);
    }

}
