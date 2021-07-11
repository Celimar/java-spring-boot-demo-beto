package br.net.gradual.demobeto.controller;

import br.net.gradual.demobeto.model.Ferramenta;
import br.net.gradual.demobeto.repository.FerrramentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController("/ferramentas")
public class FerramentaController {

    private static final String OBJECT_NOT_FOUND = "Object not found by id: ";

    @Autowired
    private FerrramentaRepository repository;

    @GetMapping("/list")
    public ResponseEntity<List<Ferramenta>> list() {
        List<Ferramenta> lista = repository.findAll();
        return new ResponseEntity(lista, HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Integer id) throws Exception {
        Optional<Ferramenta> opt = repository.findById(id);
        if (!opt.isPresent())
            new ResponseEntity(null , HttpStatus.NOT_FOUND);
        return new ResponseEntity(opt.get(), HttpStatus.OK);
    }

    @PostMapping("/insert")
    public ResponseEntity<Ferramenta> insert(@RequestBody Ferramenta ferramenta) {
        Ferramenta ferramenta1 = repository.saveAndFlush(ferramenta);
        return new ResponseEntity(ferramenta1, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<Ferramenta> update(@RequestBody Ferramenta ferramenta) {
        Ferramenta ferramenta1 = repository.getById(ferramenta.getId());
        if (ferramenta1 == null)
            return new ResponseEntity( HttpStatus.NOT_FOUND);
        ferramenta1 = repository.saveAndFlush(ferramenta);
        return new ResponseEntity(ferramenta1, HttpStatus.OK);
    }


}
