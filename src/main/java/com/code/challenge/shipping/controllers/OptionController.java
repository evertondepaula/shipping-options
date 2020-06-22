package com.code.challenge.shipping.controllers;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.code.challenge.shipping.models.Option;
import com.code.challenge.responses.DeleteResponse;
import com.code.challenge.shipping.repositories.OptionRepository;
import com.code.challenge.shipping.excpetions.OptionNotFoundException;

@RestController
@RequestMapping(value = "/shipping")
public class OptionController {

    @Autowired
    private OptionRepository repository;

    @GetMapping(path = "/options")
    public ResponseEntity<Iterable<Option>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping(path = "/options/{id}")
    public ResponseEntity<Option> get(@PathVariable Long id) {
        var option = repository.findById(id).orElseThrow(() -> new OptionNotFoundException(id));
        return ResponseEntity.ok(option);
    }

    @PostMapping(path = "/options")
    public ResponseEntity<Option> create(@Valid @RequestBody Option option) {
        repository.save(option);
        return ResponseEntity.status(HttpStatus.CREATED).body(option);
    }

    @PutMapping(path = "/options/{id}")
    public ResponseEntity<Option> update(@Valid @RequestBody Option option, @PathVariable Long id) {
        repository.findById(id).orElseThrow(() -> new OptionNotFoundException(id));
        option.setId(id);
        repository.save(option);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(option);
    }

    @DeleteMapping(path = "/options/{id}")
    public ResponseEntity<DeleteResponse> delete(@PathVariable Long id) {
        var option = repository.findById(id).orElseThrow(() -> new OptionNotFoundException(id));
        repository.delete(option);
        return ResponseEntity.ok(
            new DeleteResponse("Delete shipping option successfully", HttpStatus.OK)
        );
    }

    @DeleteMapping(path = "/options")
    public ResponseEntity<DeleteResponse> deleteAll() {
        repository.deleteAll();
        return ResponseEntity.ok(
            new DeleteResponse("Delete all shipping options successfully", HttpStatus.OK)
        );
    }
}
