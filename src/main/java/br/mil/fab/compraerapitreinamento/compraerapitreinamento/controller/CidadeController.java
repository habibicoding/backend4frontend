package br.mil.fab.compraerapitreinamento.compraerapitreinamento.controller;

import br.mil.fab.compraerapitreinamento.compraerapitreinamento.entity.Cidade;
import br.mil.fab.compraerapitreinamento.compraerapitreinamento.entity.Estado;
import br.mil.fab.compraerapitreinamento.compraerapitreinamento.repository.CidadeRepository;
import br.mil.fab.compraerapitreinamento.compraerapitreinamento.repository.EstadoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/cidade")
public class CidadeController {

    private CidadeRepository cidadeRepository;


    public CidadeController(CidadeRepository cidadeRepository) {
        super();
        this.cidadeRepository = cidadeRepository;
    }

    @PostMapping("/criar")
    public ResponseEntity<List<Cidade>> save(@RequestBody List<Cidade> cidades) {
        cidades.forEach(t -> {
            cidadeRepository.save(t);
        });
        return new ResponseEntity<>(cidades, HttpStatus.OK);
    }

    @GetMapping("/buscar-todos")
    public ResponseEntity<List<Cidade>> getAll() {
        List<Cidade> cidades = new ArrayList<>();
        cidades = cidadeRepository.findAll();
        return new ResponseEntity<>(cidades, HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Optional<Cidade>> getById(@PathVariable Integer id) {
        Optional<Cidade> cidade;
        try {
            cidade = cidadeRepository.findById(id.longValue());
            return new ResponseEntity<Optional<Cidade>>(cidade, HttpStatus.OK);
        } catch (NoSuchElementException exception) {
            return new ResponseEntity<Optional<Cidade>>(HttpStatus.NOT_FOUND);
        }
    }

}
