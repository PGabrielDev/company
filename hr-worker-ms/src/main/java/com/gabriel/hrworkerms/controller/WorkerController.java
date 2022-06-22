package com.gabriel.hrworkerms.controller;

import com.gabriel.hrworkerms.models.Worker;
import com.gabriel.hrworkerms.repository.WorkerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/workers")
public class WorkerController {

    private final WorkerRepository repository;

    private final Environment env;

    private static Logger log = LoggerFactory.getLogger(WorkerController.class);
    public WorkerController(WorkerRepository repository, Environment env) {
        this.repository = repository;
        this.env = env;
    }

    @GetMapping
    public ResponseEntity<List<Worker>> findAll(){
        return  ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id) throws Exception {
        try {
            log.info("PORTA: " + env.getProperty("local.serve.port"));
            System.out.println("PORTA: " + env.getProperty("local.serve.port"));
            Worker worker = repository.findById(id).orElseThrow(() -> new Exception("Worker not found"));
            return ResponseEntity.ok(worker);
        } catch (Exception e){
            if(e.getMessage().startsWith("Worker")){
                return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}