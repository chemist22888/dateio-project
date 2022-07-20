package com.etnetera.hr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.etnetera.hr.data.JavaScriptFramework;
import com.etnetera.hr.repository.JavaScriptFrameworkRepository;
import org.springframework.web.server.ResponseStatusException;

import java.net.http.HttpResponse;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Simple REST controller for accessing application logic.
 *
 * @author Etnetera
 */
@RestController
public class JavaScriptFrameworkController {

    private final JavaScriptFrameworkRepository repository;

    @Autowired
    public JavaScriptFrameworkController(JavaScriptFrameworkRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/frameworks")
    public Iterable<JavaScriptFramework> frameworks() {
        return repository.findAll();
    }

    @GetMapping("/frameworks/{id}")
    public JavaScriptFramework frameworksWithId(@PathVariable("id") Long id) {
        Optional<JavaScriptFramework> framework = repository.findById(id);

        if (framework.isPresent())
            return framework.get();
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/frameworks/name/{name}")
    public Iterable<JavaScriptFramework> frameworksWithName(@PathVariable("name") String name) {

        return repository.findAllByName(name);
    }

    @GetMapping("/frameworks/version/{version}")
    public Iterable<JavaScriptFramework> frameworksWithVersion(@PathVariable("version") String version) {

        return repository.findAllByVersion(version);
    }

    @GetMapping("/frameworks/hype-level/{level}")
    public Iterable<JavaScriptFramework> frameworksWithHypeLevel(@PathVariable("level") Integer level) {

        return repository.findAllByHypeLevel(level);
    }


    @PostMapping(value = "frameworks/new", produces = MediaType.APPLICATION_JSON_VALUE)
    public JavaScriptFramework newFramework(@RequestBody JavaScriptFramework framework) {
        framework.setId(null);
        repository.save(framework);

        return framework;
    }

    @PostMapping("frameworks/{id}/update")
    public JavaScriptFramework updateFramework(@RequestBody JavaScriptFramework framework,
                                               @PathVariable("id") Long id) {
        if (id == null || repository.findById(id).isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Framework with this ID does not exist!");

        framework.setId(id);

        repository.save(framework);

        return framework;
    }

    @PostMapping("frameworks/delete")
    public void deleteFramework(@RequestParam("id") Long id) {
        if(repository.findById(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Not found");

        }
        repository.deleteById(id);
    }

}
