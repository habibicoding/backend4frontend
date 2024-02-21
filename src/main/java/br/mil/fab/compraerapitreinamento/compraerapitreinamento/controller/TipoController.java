package br.mil.fab.compraerapitreinamento.compraerapitreinamento.controller;

import br.mil.fab.compraerapitreinamento.compraerapitreinamento.entity.Pessoa;
import br.mil.fab.compraerapitreinamento.compraerapitreinamento.entity.Tipo;
import br.mil.fab.compraerapitreinamento.compraerapitreinamento.repository.TipoRepository;
import br.mil.fab.compraerapitreinamento.compraerapitreinamento.service.TipoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/tipo")
public class TipoController {

    private TipoRepository tipoRepository;

    private TipoService tipoService;

    public TipoController(TipoRepository tipoRepository, TipoService tipoService) {
        super();
        this.tipoRepository = tipoRepository;
        this.tipoService = tipoService;
    }

    @PostMapping("/criar")
    public ResponseEntity<List<Tipo>> save(@RequestBody List<Tipo> tipos) {
        tipos.forEach(t -> {
            tipoRepository.save(t);
        });
        return new ResponseEntity<>(tipos, HttpStatus.OK);
    }

    @GetMapping("/buscar-todos")
    public ResponseEntity<List<Tipo>> getAll() {
        List<Tipo> tipos = new ArrayList<>();
        tipoRepository.findAll().forEach((tipo -> {
            tipos.add(tipoService.buscaTipo(tipo.getId()));
        }));
        return new ResponseEntity<>(tipos, HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Tipo> getById(@PathVariable Integer id) {
        try {
            return new ResponseEntity<Tipo>(tipoService.buscaTipo(id.longValue()), HttpStatus.OK);
        } catch (NoSuchElementException exception) {
            return new ResponseEntity<Tipo>(HttpStatus.NOT_FOUND);
        }
    }

}
