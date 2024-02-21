package br.mil.fab.compraerapitreinamento.compraerapitreinamento.controller;

import br.mil.fab.compraerapitreinamento.compraerapitreinamento.entity.Estado;
import br.mil.fab.compraerapitreinamento.compraerapitreinamento.repository.EstadoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/estado")
public class EstadoController {

    private EstadoRepository estadoRepository;


    public EstadoController(EstadoRepository estadoRepository) {
        super();
        this.estadoRepository = estadoRepository;
    }

    @PostMapping("/criar")
    public ResponseEntity<List<Estado>> save(@RequestBody List<Estado> estados) {
        estados.forEach(t -> {
            estadoRepository.save(t);
        });
        return new ResponseEntity<>(estados, HttpStatus.OK);
    }

    @GetMapping("/buscar-todos")
    public ResponseEntity<List<Estado>> getAll() {
        List<Estado> estados = new ArrayList<>();
        estados = estadoRepository.findAll();
        return new ResponseEntity<>(estados, HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Optional<Estado>> getById(@PathVariable Integer id) {
        Optional<Estado> estado;
        try {
            estado = estadoRepository.findById(id.longValue());
            return new ResponseEntity<Optional<Estado>>(estado, HttpStatus.OK);
        } catch (NoSuchElementException exception) {
            return new ResponseEntity<Optional<Estado>>(HttpStatus.NOT_FOUND);
        }
    }

}
