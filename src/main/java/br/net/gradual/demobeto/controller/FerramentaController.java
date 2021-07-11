package br.net.gradual.demobeto.controller;

import br.net.gradual.demobeto.repository.FerramentaRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("ferramentas")
public class FerramentaController {

    private static final String OBJECT_NOT_FOUND = "Object not found by id: ";

    @Autowired
    private FerramentaRepository repository;

    @GetMapping("/list")
    public ResponseEntity<List<br.net.gradual.demobeto.model.Ferramenta>> list() {
        List<br.net.gradual.demobeto.model.Ferramenta> lista = repository.findAll();
        return new ResponseEntity(lista, HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Integer id) throws Exception {
        Optional<br.net.gradual.demobeto.model.Ferramenta> opt = repository.findById(id);
        if (!opt.isPresent())
            new ResponseEntity(null , HttpStatus.NOT_FOUND);
        return new ResponseEntity(opt.get(), HttpStatus.OK);
    }

    @PostMapping("/insert")
    public ResponseEntity<br.net.gradual.demobeto.model.Ferramenta> insert(@RequestBody br.net.gradual.demobeto.model.Ferramenta ferramenta) {
        br.net.gradual.demobeto.model.Ferramenta ferramenta1 = repository.saveAndFlush(ferramenta);
        return new ResponseEntity(ferramenta1, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<br.net.gradual.demobeto.model.Ferramenta> update(@RequestBody br.net.gradual.demobeto.model.Ferramenta ferramenta) {
        br.net.gradual.demobeto.model.Ferramenta ferramenta1 = repository.getById(ferramenta.getId());
        if (ferramenta1 == null)
            return new ResponseEntity( HttpStatus.NOT_FOUND);
        ferramenta1 = repository.saveAndFlush(ferramenta);
        return new ResponseEntity(ferramenta1, HttpStatus.OK);
    }


}
