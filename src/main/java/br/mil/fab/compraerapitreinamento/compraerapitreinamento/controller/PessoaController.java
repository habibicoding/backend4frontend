package br.mil.fab.compraerapitreinamento.compraerapitreinamento.controller;

import br.mil.fab.compraerapitreinamento.compraerapitreinamento.entity.Endereco;
import br.mil.fab.compraerapitreinamento.compraerapitreinamento.entity.Pessoa;
import br.mil.fab.compraerapitreinamento.compraerapitreinamento.entity.Tipo;
import br.mil.fab.compraerapitreinamento.compraerapitreinamento.repository.PessoaRepository;
import br.mil.fab.compraerapitreinamento.compraerapitreinamento.repository.TipoRepository;
import br.mil.fab.compraerapitreinamento.compraerapitreinamento.service.PessoaService;
import br.mil.fab.compraerapitreinamento.compraerapitreinamento.service.TipoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    private PessoaRepository pessoaRepository;

    private TipoRepository tipoRepository;

    private PessoaService pessoaService;

    public PessoaController (PessoaRepository pessoaRepository, TipoRepository tipoRepository, PessoaService pessoaService) {
        super();
        this.pessoaRepository = pessoaRepository;
        this.tipoRepository = tipoRepository;
        this.pessoaService = pessoaService;
    }

    @PostMapping("/criar")
    public ResponseEntity<Pessoa> save(@RequestBody Pessoa pessoa) {
        pessoaRepository.save(pessoa);
        return new ResponseEntity<>(pessoa, HttpStatus.OK);
    }

    @GetMapping("/buscar-todos")
    public ResponseEntity<List<Pessoa>> getAll() {
        List<Pessoa> pessoas = new ArrayList<>();
        pessoaRepository.findAll().forEach((pessoa -> {
           pessoas.add(pessoaService.buscaPessoa(pessoa.getId()));
        }));
        return new ResponseEntity<>(pessoas, HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Pessoa> getById(@PathVariable Integer id) {
        try {
            return new ResponseEntity<Pessoa>(pessoaService.buscaPessoa(id.longValue()), HttpStatus.OK);
        } catch (NoSuchElementException exception) {
            return new ResponseEntity<Pessoa>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Optional<Pessoa>> deleteById(@PathVariable Integer id) {
        try {
            pessoaRepository.deleteById(id.longValue());
            return new ResponseEntity<Optional<Pessoa>>(HttpStatus.OK);
        } catch (NoSuchElementException exception) {
            return new ResponseEntity<Optional<Pessoa>>(HttpStatus.NOT_FOUND);
        }
    }
//
//    @PutMapping("/editar/{id}")
//    public ResponseEntity<Pessoa> update(@PathVariable Integer id, @RequestBody Pessoa newPessoa) {
//        return pessoaRepository.findById(id.longValue())
//                .map(pessoa -> {
//                    pessoa.setNome(newPessoa.getNome());
//                    pessoa.setNrIdade(newPessoa.getNrIdade());
//                    pessoa.setNrCpf(newPessoa.getNrCpf());
//                    pessoa.setNrTelefone(newPessoa.getNrTelefone());
//                    pessoa.setListEndereco(newPessoa.getListEndereco());
//                    Pessoa pessoaUpdate = pessoaRepository.save(pessoa);
//                    return ResponseEntity.ok().body(pessoaUpdate);
//                }).orElse(ResponseEntity.notFound().build());
//    }


}
