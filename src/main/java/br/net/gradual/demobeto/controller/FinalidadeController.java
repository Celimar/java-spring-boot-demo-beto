package br.net.gradual.demobeto.controller;

import br.net.gradual.demobeto.model.Finalidade;
import br.net.gradual.demobeto.repository.FinalidadeRepository;
import br.net.gradual.demobeto.repository.FinalidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("finalidade")
public class FinalidadeController {

    private static final String OBJECT_NOT_FOUND = "Object not found by id: ";

    @Autowired
    private FinalidadeRepository repository;

    @GetMapping("/list")
    public ResponseEntity<List<Finalidade>> list() {
        List<br.net.gradual.demobeto.model.Finalidade> lista = repository.findAll();
        return new ResponseEntity(lista, HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Integer id) throws Exception {
        Optional<Finalidade> opt = repository.findById(id);
        if (!opt.isPresent())
            new ResponseEntity(null , HttpStatus.NOT_FOUND);
        return new ResponseEntity(opt.get(), HttpStatus.OK);
    }

    @PostMapping("/insert")
    public ResponseEntity<br.net.gradual.demobeto.model.Finalidade> insert(@RequestBody br.net.gradual.demobeto.model.Finalidade finalidade) {
        br.net.gradual.demobeto.model.Finalidade finalidade1 = repository.saveAndFlush(finalidade);
        return new ResponseEntity(finalidade1, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<br.net.gradual.demobeto.model.Finalidade> update(@RequestBody br.net.gradual.demobeto.model.Finalidade finalidade) {
        br.net.gradual.demobeto.model.Finalidade finalidade1 = repository.getById(finalidade.getId());
        if (finalidade1 == null)
            return new ResponseEntity( HttpStatus.NOT_FOUND);
        finalidade1 = repository.saveAndFlush(finalidade);
        return new ResponseEntity(finalidade1, HttpStatus.OK);
    }


}
